import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import org.assertj.core.api.Assertions;

public class ResistorColorDuoTest {
    private ResistorColorDuo resistorColorDuo;

    @BeforeEach
    public void setup() {
        resistorColorDuo = new ResistorColorDuo();
    }

    @Test
    public void testBrownAndBlack() {
        Assertions.assertThat(
                resistorColorDuo.value(new String[]{"brown", "black"})
        ).isEqualTo(10);
    }

    @Test
    public void testBlueAndGrey() {
        Assertions.assertThat(
                resistorColorDuo.value(new String[]{ "blue", "grey" })
        ).isEqualTo(68);
    }

    @Test
    public void testYellowAndViolet() {
        Assertions.assertThat(resistorColorDuo.value(
                new String[]{ "yellow", "violet" })
        ).isEqualTo(47);
    }

    @Test
    public void testOrangeAndOrange() {
        Assertions.assertThat(
                resistorColorDuo.value(new String[]{ "orange", "orange" })
        ).isEqualTo(33);
    }

    @Test
    public void testIgnoreAdditionalColors() {
        Assertions.assertThat(
                resistorColorDuo.value(new String[]{ "green", "brown", "orange" })
        ).isEqualTo(51);
    }
}
