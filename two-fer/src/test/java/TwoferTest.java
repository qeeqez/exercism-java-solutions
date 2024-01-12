import org.junit.jupiter.api.BeforeEach;
import org.junit.Ignore;
import org.junit.jupiter.api.Test;

import org.assertj.core.api.Assertions;

public class TwoferTest {

    private Twofer twofer;

    @BeforeEach
    public void setup() {
        twofer = new Twofer();
    }

    @Test
    public void noNameGiven() {
        Assertions.assertThat(twofer.twofer(null))
                .isEqualTo("One for you, one for me.");
    }

    @Test
    public void aNameGiven() {
        Assertions.assertThat(twofer.twofer("Alice"))
                .isEqualTo("One for Alice, one for me.");
    }

    @Test
    public void anotherNameGiven() {
        Assertions.assertThat(twofer.twofer("Bob"))
                .isEqualTo("One for Bob, one for me.");
    }

}
