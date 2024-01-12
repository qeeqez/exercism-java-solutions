import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import org.assertj.core.api.Assertions;

public class ResistorColorTest {

    private ResistorColor resistorColor;

    @BeforeEach
    public void setup() {
        resistorColor = new ResistorColor();
    }

    @Test
    public void testBlackColorCode() {
        Assertions.assertThat(resistorColor.colorCode("black")).isEqualTo(0);
    }

    @Test
    public void testWhiteColorCode() {
        Assertions.assertThat(resistorColor.colorCode("white")).isEqualTo(9);
    }

    @Test
    public void testOrangeColorCode() {
        Assertions.assertThat(resistorColor.colorCode("orange")).isEqualTo(3);
    }

    @Test
    public void testColors() {
        Assertions.assertThat(resistorColor.colors()).containsExactly(
                "black", "brown", "red", "orange", "yellow", "green", "blue", "violet", "grey", "white"
        );
    }
}
