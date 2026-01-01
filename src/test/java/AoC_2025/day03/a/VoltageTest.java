package AoC_2025.day03.a;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class VoltageTest {

    private final static String large_test = "987654321111111\n" +
            "811111111111119\n" +
            "234234234234278\n" +
            "818181911112111\n";

    @Test
    public void should_give_the_biggest_voltage() {
    assertThat(BatteryBuilder.with("987654321111111")).isEqualTo(98);
    assertThat(BatteryBuilder.with("81111111111119")).isEqualTo(89);
    assertThat(BatteryBuilder.with("234234234234278")).isEqualTo(78);
    assertThat(BatteryBuilder.with("818181911112111")).isEqualTo(92);
    assertThat(BatteryBuilder.with(large_test)).isEqualTo(357);
    }

}
