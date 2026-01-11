package AoC_2025.day02.a;

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
        assertThat(IdChecker.getInvalidCodesSum("11-12")).isEqualTo(11);
        assertThat(IdChecker.getInvalidCodesSum("11-22")).isEqualTo(33);
        assertThat(IdChecker.getInvalidCodesSum("11-22,11-22")).isEqualTo(66);
        assertThat(IdChecker.getInvalidCodesSum("998-1012")).isEqualTo(1010);
        assertThat(IdChecker.getInvalidCodesSum("1188511880-1188511890")).isEqualTo(1188511885);
        assertThat(IdChecker.getInvalidCodesSum("38593856-38593862")).isEqualTo(38593859);
        assertThat(IdChecker.getInvalidCodesSum(long_id_list)).isEqualTo(1227775554);

    }

    @Test
    public void valid_id_should_give_zero() {
        assertThat(IdChecker.getInvalidCodesSum("12-19")).isEqualTo(0);
        assertThat(IdChecker.getInvalidCodesSum("12-21")).isEqualTo(0);
        assertThat(IdChecker.getInvalidCodesSum("1698522-1698528")).isEqualTo(0);
    }

}
