import java.util.List;
import java.util.stream.Collectors;

public class Anagram {

    private final String originalWord;
    private final List<Character> sortedLowerCaseLetters;

    Anagram(String word) {
        originalWord = word.toLowerCase();
        sortedLowerCaseLetters = getSortedLowercaseLetters(originalWord);
    }

    public List<String> match(List<String> words) {
        return words.stream()
                .filter(this::isAnagram)
                .distinct()
                .collect(Collectors.toList());
    }

    public boolean isAnagram(String word) {
        return !word.equalsIgnoreCase(originalWord) &&
                getSortedLowercaseLetters(word).equals(sortedLowerCaseLetters);
    }

    private List<Character> getSortedLowercaseLetters(String toSort) {
        return toSort.chars()
                .mapToObj(c -> (char) c)
                .map(Character::toLowerCase)
                .sorted()
                .collect(Collectors.toList());
    }
}
