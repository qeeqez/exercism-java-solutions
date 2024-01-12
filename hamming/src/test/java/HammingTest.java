import org.junit.jupiter.api.Test;

import org.assertj.core.api.Assertions;
import static org.assertj.core.api.Assertions.Assertions.assertThatExceptionOfType;

public class HammingTest {

    @Test
    public void testNoDistanceBetweenEmptyStrands() {
        Assertions.assertThat(new Hamming("", "").getHammingDistance()).isEqualTo(0);
    }

    @Test
    public void testNoDistanceBetweenShortIdenticalStrands() {
        Assertions.assertThat(new Hamming("A", "A").getHammingDistance()).isEqualTo(0);
    }

    @Test
    public void testCompleteDistanceInSingleLetterDifferentStrands() {
        Assertions.assertThat(new Hamming("G", "T").getHammingDistance()).isEqualTo(1);
    }

    @Test
    public void testDistanceInLongIdenticalStrands() {
        Assertions.assertThat(new Hamming("GGACTGAAATCTG", "GGACTGAAATCTG").getHammingDistance()).isEqualTo(0);
    }

    @Test
    public void testDistanceInLongDifferentStrands() {
        Assertions.assertThat(new Hamming("GGACGGATTCTG", "AGGACGGATTCT").getHammingDistance()).isEqualTo(9);
    }

    @Test
    public void testValidatesFirstStrandNotLonger() {
        Assertions.assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> new Hamming("AATG", "AAA"))
                .withMessage("leftStrand and rightStrand must be of equal length.");
    }

    @Test
    public void testValidatesSecondStrandNotLonger() {
        Assertions.assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> new Hamming("ATA", "AGTG"))
                .withMessage("leftStrand and rightStrand must be of equal length.");
    }

    @Test
    public void testDisallowLeftEmptyStrand() {
        Assertions.assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> new Hamming("", "G"))
                .withMessage("left strand must not be empty.");
    }

    @Test
    public void testDisallowRightEmptyStrand() {
        Assertions.assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> new Hamming("G", ""))
                .withMessage("right strand must not be empty.");
    }

}
