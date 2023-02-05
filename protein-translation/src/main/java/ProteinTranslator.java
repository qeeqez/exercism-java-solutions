import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

class ProteinTranslator {

    List<String> translate(String rnaSequence) {
        String regexSplitEvery3Chars = "(?<=\\G.{3})";
        return Arrays.stream(rnaSequence.split(regexSplitEvery3Chars))
                .map(this::getProtein)
                .takeWhile(Objects::nonNull)
                .collect(Collectors.toList());
    }

    String getProtein(String codon) {
        return switch (codon) {
            case "AUG" -> "Methionine";
            case "UUU", "UUC" -> "Phenylalanine";
            case "UUA", "UUG" -> "Leucine";
            case "UCU", "UCC", "UCA", "UCG" -> "Serine";
            case "UAU", "UAC" -> "Tyrosine";
            case "UGU", "UGC" -> "Cysteine";
            case "UGG" -> "Tryptophan";
            default -> null;
        };
    }

}
