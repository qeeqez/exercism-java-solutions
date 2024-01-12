import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.Assertions.assertThatExceptionOfType;
import org.junit.jupiter.api.Assertions;

public class NaturalNumberTest {

    @Test
    public void testSmallPerfectNumberIsClassifiedCorrectly() {
        Assertions.assertEquals(Classification.PERFECT, new NaturalNumber(6).getClassification());
    }

    @Test
    public void testMediumPerfectNumberIsClassifiedCorrectly() {
        Assertions.assertEquals(Classification.PERFECT, new NaturalNumber(28).getClassification());
    }

    @Test
    public void testLargePerfectNumberIsClassifiedCorrectly() {
        Assertions.assertEquals(Classification.PERFECT, new NaturalNumber(33550336).getClassification());
    }

    @Test
    public void testSmallAbundantNumberIsClassifiedCorrectly() {
        Assertions.assertEquals(Classification.ABUNDANT, new NaturalNumber(12).getClassification());
    }

    @Test
    public void testMediumAbundantNumberIsClassifiedCorrectly() {
        Assertions.assertEquals(Classification.ABUNDANT, new NaturalNumber(30).getClassification());
    }

    @Test
    public void testLargeAbundantNumberIsClassifiedCorrectly() {
        Assertions.assertEquals(Classification.ABUNDANT, new NaturalNumber(33550335).getClassification());
    }

    @Test
    public void testSmallestPrimeDeficientNumberIsClassifiedCorrectly() {
        Assertions.assertEquals(Classification.DEFICIENT, new NaturalNumber(2).getClassification());
    }

    @Test
    public void testSmallestNonPrimeDeficientNumberIsClassifiedCorrectly() {
        Assertions.assertEquals(Classification.DEFICIENT, new NaturalNumber(4).getClassification());
    }

    @Test
    public void testMediumDeficientNumberIsClassifiedCorrectly() {
        Assertions.assertEquals(Classification.DEFICIENT, new NaturalNumber(32).getClassification());
    }

    @Test
    public void testLargeDeficientNumberIsClassifiedCorrectly() {
        Assertions.assertEquals(Classification.DEFICIENT, new NaturalNumber(33550337).getClassification());
    }

    @Test
    /*
     * The number 1 has no proper divisors (https://en.wikipedia.org/wiki/Divisor#Further_notions_and_facts), and the
     * additive identity is 0, so the aliquot sum of 1 should be 0. Hence 1 should be classified as deficient.
     */
    public void testThatOneIsCorrectlyClassifiedAsDeficient() {
        Assertions.assertEquals(Classification.DEFICIENT, new NaturalNumber(1).getClassification());
    }

    @Test
    public void testThatNonNegativeIntegerIsRejected() {
        Assertions.assertThatExceptionOfType(IllegalArgumentException.class)
            .isThrownBy(() -> new NaturalNumber(0))
            .withMessage("You must supply a natural number (positive integer)");
    }

    @Test
    public void testThatNegativeIntegerIsRejected() {
        Assertions.assertThatExceptionOfType(IllegalArgumentException.class)
            .isThrownBy(() -> new NaturalNumber(-1))
            .withMessage("You must supply a natural number (positive integer)");
    }

}
