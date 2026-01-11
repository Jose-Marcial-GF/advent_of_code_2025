package AoC_2025.day10.a;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class GraphBuilder {
    private static final Pattern STATE_PATTERN = Pattern.compile("\\[([.#]+)]");
    private static final Pattern BUTTON_PATTERN = Pattern.compile("\\(([\\d,]+)\\)");
    public static Graph of(String line) {
        return new Graph(
                getOperators(line),
                getGoalState(line));
    }

    private static State getGoalState(String line) {
        Matcher m = STATE_PATTERN.matcher(line);
            m.find();
            List<Integer> bits = m.group(1).chars()
                    .mapToObj(c -> c == '#' ? 1 : 0)
                    .toList();

            return new State(bits);

    }


    private static List<Operator> getOperators(String line) {
        return BUTTON_PATTERN.matcher(line)
                .results()                                  // 1. Crea un Stream de coincidencias
                .map(matchResult -> matchResult.group(1))   // 2. Extrae el contenido: "1,3"
                .map(s -> Arrays.stream(s.split(","))       // 3. Procesa cada string numérico
                        .map(String::trim)                  // (Opcional) Por seguridad ante espacios
                        .map(Integer::parseInt)             // Convierte a Integer
                        .toList())                          // Recolecta a List<Integer>
                .map(Operator::new)                         // 4. Crea el objeto Operator
                .toList();                                  // 5. Retorna la lista final
    }
}
