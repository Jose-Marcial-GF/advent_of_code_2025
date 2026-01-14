package AoC_2025.day09.b;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class IntervalChain {
    private final LinkedList<Interval> chain = new LinkedList<>();

    public void add(Interval next) {
        if (chain.isEmpty()) {
            chain.add(next);
            return;
        }

        // Lógica puramente funcional: "Intenta fusionar con el último".
        // Sin ifs, sin variables temporales, sin índices.
        chain.getLast().absorb(next)
                .ifPresentOrElse(
                        this::replaceLast,      // Si se fusionó -> reemplaza el último
                        () -> chain.add(next)   // Si no -> añade al final
                );
    }

    private void replaceLast(Interval merged) {
        chain.removeLast();
        chain.add(merged);
    }

    // Método para combinar dos cadenas (necesario para el Collector, aunque sea secuencial)
    public IntervalChain merge(IntervalChain other) {
        other.chain.forEach(this::add);
        return this;
    }

    public List<Interval> toList() {
        return new ArrayList<>(chain);
    }
}
