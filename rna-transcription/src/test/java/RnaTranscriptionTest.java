import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import org.assertj.core.api.Assertions;

public class RnaTranscriptionTest {

    private RnaTranscription rnaTranscription;

    @BeforeEach
    public void setUp() {
        rnaTranscription = new RnaTranscription();
    }

    @Test
    public void testEmptyRnaSequence() {
        Assertions.assertThat(rnaTranscription.transcribe("")).isEmpty();
    }

    @Test
    public void testRnaTranscriptionOfCytosineIsGuanine() {
        Assertions.assertThat(rnaTranscription.transcribe("C")).isEqualTo("G");
    }

    @Test
    public void testRnaTranscriptionOfGuanineIsCytosine() {
        Assertions.assertThat(rnaTranscription.transcribe("G")).isEqualTo("C");
    }

    @Test
    public void testRnaTranscriptionOfThymineIsAdenine() {
        Assertions.assertThat(rnaTranscription.transcribe("T")).isEqualTo("A");
    }

    @Test
    public void testRnaTranscriptionOfAdenineIsUracil() {
        Assertions.assertThat(rnaTranscription.transcribe("A")).isEqualTo("U");
    }

    @Test
    public void testRnaTranscription() {
        Assertions.assertThat(rnaTranscription.transcribe("ACGTGGTCTTAA")).isEqualTo("UGCACCAGAAUU");
    }
}
