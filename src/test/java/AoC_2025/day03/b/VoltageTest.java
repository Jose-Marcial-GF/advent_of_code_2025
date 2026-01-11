package AoC_2025.day03.b;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class VoltageTest {

    private final static String large_test = "987654321111111\n" +
            "811111111111119\n" +
            "234234234234278\n" +
            "818181911112111\n";


    @Test
    public void main_test() {
        assertThat(Main.main()).isEqualTo(173065202451341L);
    }

    @Test
    public void should_give_the_biggest_voltage() {
    assertThat(BatteryBuilder.lookingFor(12).from(large_test).sum()).isEqualTo(3121910778619L);
    }

}
