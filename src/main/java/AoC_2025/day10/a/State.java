package AoC_2025.day10.a;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public record State(List<Integer> Lights) {

    public static State initial(int size) {
        return new State(Collections.nCopies(size, 0));
    }

    public int size() {
        return Lights.size();
    }

    public State apply(Operator op) {
        List<Integer> newLights = new ArrayList<>(this.Lights);

        // Iteramos sobre los índices que toca el operador
        for (Integer index : op.lights()) {
            if (index >= 0 && index < newLights.size()) {
                // Operación XOR: 1^1=0, 0^1=1 (Toggle)
                int currentVal = newLights.get(index);
                newLights.set(index, currentVal ^ 1);
            }
        }
        return new State(newLights);
    }
}
