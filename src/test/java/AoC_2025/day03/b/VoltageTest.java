package AoC_2025.day03.b;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class VoltageTest {

    private final static String large_test = "987654321111111\n" +
            "811111111111119\n" +
            "234234234234278\n" +
            "818181911112111\n";

    @Test
    public void should_give_the_biggest_voltage() {
    assertThat(BatteryBuilder.with("987654321111111")).isEqualTo(987654321111L);
    assertThat(BatteryBuilder.with("81111111111119")).isEqualTo(811111111119L);
    assertThat(BatteryBuilder.with("234234234234278")).isEqualTo(434234234278L);
    assertThat(BatteryBuilder.with("818181911112111")).isEqualTo(888911112111L);
    assertThat(BatteryBuilder.with(large_test)).isEqualTo(3121910778619L);
    }

}
