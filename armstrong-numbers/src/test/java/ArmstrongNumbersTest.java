import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ArmstrongNumbersTest {

    private ArmstrongNumbers armstrongNumbers;

    @BeforeEach
    public void setup() {
        armstrongNumbers = new ArmstrongNumbers();
    }

    @Test
    public void zeroIsArmstrongNumber() {
        Assertions.assertThat(armstrongNumbers.isArmstrongNumber(0))
                .isTrue();
    }

    @Test
    public void singleDigitsAreArmstrongNumbers() {
        Assertions.assertThat(armstrongNumbers.isArmstrongNumber(5))
                .isTrue();
    }

    @Test
    public void noTwoDigitArmstrongNumbers() {
        Assertions.assertThat(armstrongNumbers.isArmstrongNumber(10))
                .isFalse();
    }

    @Test
    public void threeDigitNumberIsArmstrongNumber() {
        Assertions.assertThat(armstrongNumbers.isArmstrongNumber(153))
                .isTrue();
    }

    @Test
    public void threeDigitNumberIsNotArmstrongNumber() {
        Assertions.assertThat(armstrongNumbers.isArmstrongNumber(100))
                .isFalse();
    }

    @Test
    public void fourDigitNumberIsArmstrongNumber() {
        Assertions.assertThat(armstrongNumbers.isArmstrongNumber(9474))
                .isTrue();
    }

    @Test
    public void fourDigitNumberIsNotArmstrongNumber() {
        Assertions.assertThat(armstrongNumbers.isArmstrongNumber(9475))
                .isFalse();
    }

    @Test
    public void sevenDigitNumberIsArmstrongNumber() {
        Assertions.assertThat(armstrongNumbers.isArmstrongNumber(9926315))
                .isTrue();
    }

    @Test
    public void sevenDigitNumberIsNotArmstrongNumber() {
        Assertions.assertThat(armstrongNumbers.isArmstrongNumber(9926314))
                .isFalse();
    }

}
