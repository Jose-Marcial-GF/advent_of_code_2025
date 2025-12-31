package AoC_2025.day02.a;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class IdTest {
    @Test
    public void invalid_id_should_give_false() {
        assertThat(IdChecker.check("11-12") == false);
        assertThat(IdChecker.check("11-22") == false);
        assertThat(IdChecker.check("1188511880-1188511890") == false);

    }

    @Test
    public void valid_id_should_give_true() {
        assertThat(IdChecker.check("12-19") == true);
        assertThat(IdChecker.check("12-21") == true);
    }

}
