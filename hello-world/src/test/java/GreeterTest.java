import org.junit.jupiter.api.Test;

import org.assertj.core.api.Assertions;

public class GreeterTest {

    @Test
    public void testThatGreeterReturnsTheCorrectGreeting() {
        Assertions.assertThat(new Greeter().getGreeting()).isEqualTo("Hello, World!");
    }

}
