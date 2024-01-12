import org.junit.jupiter.api.Test;

import java.util.Map;

import org.assertj.core.api.Assertions;
import static org.junit.Assert.assertThrows;

public class NucleotideCounterTest {

    @Test
    public void testEmptyDnaStringHasNoNucleotides() {
        NucleotideCounter nucleotideCounter = new NucleotideCounter("");

        Assertions.assertThat(nucleotideCounter.nucleotideCounts())
            .containsExactlyInAnyOrderEntriesOf(
                Map.of('A', 0, 'C', 0, 'G', 0, 'T', 0));
    }

    @Test
    public void testDnaStringHasOneNucleotide() {
        NucleotideCounter nucleotideCounter = new NucleotideCounter("G");

        Assertions.assertThat(nucleotideCounter.nucleotideCounts())
            .containsExactlyInAnyOrderEntriesOf(
                Map.of('A', 0, 'C', 0, 'G', 1, 'T', 0));
    }

    @Test
    public void testRepetitiveSequenceWithOnlyGuanine() {
        NucleotideCounter nucleotideCounter = new NucleotideCounter("GGGGGGG");

        Assertions.assertThat(nucleotideCounter.nucleotideCounts())
            .containsExactlyInAnyOrderEntriesOf(
                Map.of('A', 0, 'C', 0, 'G', 7, 'T', 0));
    }

    @Test
    public void testDnaStringHasMultipleNucleotide() {
        NucleotideCounter nucleotideCounter
            = new NucleotideCounter("AGCTTTTCATTCTGACTGCAACGGGCAATATGTCTCTGTGTGGATTAAAAAAAGAGTGTCTGATAGCAGC");

        Assertions.assertThat(nucleotideCounter.nucleotideCounts())
            .containsExactlyInAnyOrderEntriesOf(
                Map.of('A', 20, 'C', 12, 'G', 17, 'T', 21));
    }

    @Test
    public void testDnaStringHasInvalidNucleotides() {
        assertThrows(
            IllegalArgumentException.class,
            () -> new NucleotideCounter("AGXXACT"));
    }
}
