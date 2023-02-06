import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class NucleotideCounter {

    private Map<Character, Integer> nucleotidesCount;

    private final List<Character> nucleotides = List.of('A', 'C', 'G', 'T');

    NucleotideCounter(String dna) {
        initNucleotides();
        fillNucleotides(dna);
    }

    public Map<Character, Integer> nucleotideCounts() {
        return nucleotidesCount;
    }

    private void initNucleotides() {
        nucleotidesCount = new HashMap<>();
        nucleotides.forEach(n -> nucleotidesCount.put(n, 0));
    }

    private void fillNucleotides(String dna) {
        dna = dna.trim();
        if (dna.length() == 0) return;

        String[] sequence = dna.trim().split("");

        for (String s : sequence) {
            Character c = s.charAt(0);
            if (!nucleotides.contains(c)) throw new IllegalArgumentException();
            else nucleotidesCount.put(c, nucleotidesCount.getOrDefault(c, 0) + 1);
        }
    }
}