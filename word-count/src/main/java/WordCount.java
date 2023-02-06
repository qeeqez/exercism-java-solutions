import java.util.HashMap;
import java.util.Map;

class WordCount {
    public Map<String, Integer> phrase(String input) {
        Map<String, Integer> occurrences = new HashMap<>();

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < input.length(); i++) {
            Character c = Character.toLowerCase(input.charAt(i));

            boolean isLetterOrDigit = Character.isLetterOrDigit(c);
            boolean isApostropheInWord = c == '\'' &&
                    i != input.length() - 1 &&
                    i != 0 &&
                    Character.isAlphabetic(input.charAt(i + 1)) &&
                    Character.isAlphabetic(input.charAt(i - 1));

            if (isLetterOrDigit || isApostropheInWord) {
                sb.append(c);
            } else if (!sb.isEmpty()) {
                writeToMap(sb, occurrences);
            }
        }

        if (!sb.isEmpty()) {
            writeToMap(sb, occurrences);
        }

        return occurrences;
    }

    private void writeToMap(StringBuilder sb, Map<String, Integer> occurrences) {
        String word = sb.toString();
        sb.setLength(0);
        occurrences.put(word, occurrences.getOrDefault(word, 0) + 1);
    }
}
