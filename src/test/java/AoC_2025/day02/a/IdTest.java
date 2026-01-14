package AoC_2025.day02.a;

import AoC_2025.day02.architecture.IdChecker;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class IdTest {
    private static final String long_id_list = "11-22,95-115,998-1012,1188511880-1188511890,222220-222224,1698522-1698528,446443-446449,38593856-38593862";

    @Test
    public void main_test() {
        assertThat(Main.main()).isEqualTo(23039913998L);
    }

    @Test
    public void invalid_id_should_give_the_sum_of_the_wrong_id_codes() {
        assertThat(IdChecker.with(long_id_list.lines()).solveA()).isEqualTo(1227775554);

    }


}
