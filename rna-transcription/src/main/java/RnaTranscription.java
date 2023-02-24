import java.util.stream.Collectors;

class RnaTranscription {

    String transcribe(String dnaStrand) {
        return dnaStrand
                .chars()
                .map(c -> switch (c) {
                    case 'G' -> 'C';
                    case 'C' -> 'G';
                    case 'T' -> 'A';
                    case 'A' -> 'U';
                    default -> c;
                })
                .mapToObj(Character::toString)
                .collect(Collectors.joining());
    }

}
