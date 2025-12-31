package AoC_2025.day02.a;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class IdTest {
    @Test
    public void invalid_id_should_give_the_sum_of_the_wrong_id_codes() {
        assertThat(IdChecker.getInvalidCodesSum("11-12") == 11);
        assertThat(IdChecker.getInvalidCodesSum("11-22") == 33);
        assertThat(IdChecker.getInvalidCodesSum("998-1012") == 1010);
        assertThat(IdChecker.getInvalidCodesSum("1188511880-1188511890") == 1188511885);
        assertThat(IdChecker.getInvalidCodesSum("38593856-38593862") == 38593859);

    }

    @Test
    public void valid_id_should_give_zero() {
        assertThat(IdChecker.getInvalidCodesSum("12-19") == 0);
        assertThat(IdChecker.getInvalidCodesSum("12-21") == 0);
        assertThat(IdChecker.getInvalidCodesSum("1698522-1698528") == 0);
    }

}
