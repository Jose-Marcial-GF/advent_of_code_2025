package AoC_2025.day01.a;

import java.util.Arrays;
import java.util.stream.Stream;

public class DialBuilder {

    private final Stream<String> orders;

    private DialBuilder(Stream<String> orders) {
        this.orders = orders;
    }

    public static DialBuilder with(String orders){
        return new DialBuilder(Arrays.stream(orders.split("\n")));
    }

    public Dial build(){
        return orders.reduce(Dial.create(), Dial::move, (a, b) -> b);
    }

}
