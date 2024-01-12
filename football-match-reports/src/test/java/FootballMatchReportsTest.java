import org.junit.jupiter.api.Test;

import org.assertj.core.api.Assertions;

public class FootballMatchReportsTest {

    @Test
    public void test_goal() {
        Assertions.assertThat(FootballMatchReports.onField(1)).isEqualTo("goalie");
    }

    @Test
    public void test_left_back() {
        Assertions.assertThat(FootballMatchReports.onField(2)).isEqualTo("left back");
    }

    @Test
    public void test_right_back() {
        Assertions.assertThat(FootballMatchReports.onField(5)).isEqualTo("right back");
    }

    @Test
    public void test_center_back() {
        Assertions.assertThat(FootballMatchReports.onField(3)).isEqualTo("center back");
        Assertions.assertThat(FootballMatchReports.onField(4)).isEqualTo("center back");
    }

    @Test
    public void test_midfielder() {
        Assertions.assertThat(FootballMatchReports.onField(6)).isEqualTo("midfielder");
        Assertions.assertThat(FootballMatchReports.onField(7)).isEqualTo("midfielder");
        Assertions.assertThat(FootballMatchReports.onField(8)).isEqualTo("midfielder");
    }

    @Test
    public void test_left_wing() {
        Assertions.assertThat(FootballMatchReports.onField(9)).isEqualTo("left wing");
    }

    @Test
    public void test_striker() {
        Assertions.assertThat(FootballMatchReports.onField(10)).isEqualTo("striker");
    }

    @Test
    public void test_right_wing() {
        Assertions.assertThat(FootballMatchReports.onField(11)).isEqualTo("right wing");
    }

    @Test
    public void test_exception() {
        Assertions.assertThatThrownBy(() -> FootballMatchReports.onField(13))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    public void test_exception_negative_number() {
        Assertions.assertThatThrownBy(() -> FootballMatchReports.onField(-1))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
