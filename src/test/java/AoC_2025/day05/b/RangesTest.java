package AoC_2025.day05.b;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class RangesTest {
    private final String input = """
            3-5
            10-14
            16-20
            12-18
            """;

    @Test
    public void should_give_true_by_given_the_same_range_by_different_ways() {
        RangeList rangeList1 = new RangeList();
        RangeList rangeList2 = new RangeList();
        assertThat(rangeList1.add("2-5").sort()).isEqualTo(rangeList2.add("2-3\n4-5").sort());
    }

    @Test
    public void should_merge_overlapping_ranges() {
        assertThat(new RangeList().add("1-5\n4-8").sort()).isEqualTo(new RangeList().add("1-8").sort());
        assertThat(new RangeList().add("2-10\n1-4\n8-9").sort()).isEqualTo(new RangeList().add("1-4\n3-10").sort());
    }

    @Test
    public void should_be_false_with_small_gap() {
        assertThat(new RangeList().add("1-5\n7-10").sort()).isNotEqualTo(new RangeList().add("1-10").sort());
        assertThat(new RangeList().add("1-9").sort()).isNotEqualTo(new RangeList().add("1-10").sort());
        assertThat(new RangeList().add("1-5").sort()).isNotEqualTo(new RangeList().add("2-6").sort());
    }

    @Test
    public void should_solve_example_case() {
        assertThat(InventorySystem.solve(input)).isEqualTo(14);
    }
}
