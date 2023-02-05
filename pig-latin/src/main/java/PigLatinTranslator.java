import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class PigLatinTranslator {

    List<String> vowelSounds = Arrays.asList("a", "e", "i", "o", "u", "xr", "yt");

    PigLatinTranslator() {
    }

    public String translate(String phrase) {
        String delimiter = " ";
        return Arrays.stream(phrase.split(delimiter))
                .map(this::translateWord)
                .collect(Collectors.joining(delimiter));
    }

    public String translateWord(String word) {
        StringBuilder sb = new StringBuilder();

        if (!startsWithVowelSound(word)) {
            int countConsonant = countConsonantLetters(word);
            if (word.length() >= countConsonant + 1) {
                if (word.charAt(countConsonant - 1) == 'q' && word.charAt(countConsonant) == 'u') {
                    countConsonant++;
                }
            }
            sb.append(word.substring(countConsonant));
            sb.append(word, 0, countConsonant);
        } else {
            sb.append(word);
        }

        sb.append("ay");
        return sb.toString();
    }

    private boolean startsWithVowelSound(String word) {
        return vowelSounds.stream().anyMatch(word::startsWith);
    }

    private int countConsonantLetters(String word) {
        int countConsonant = 0;

        for (int i = 0; i < word.toCharArray().length; i++) {
            if (i != 0 && word.charAt(i) == 'y') break;

            if (isConsonantSound(String.valueOf(word.charAt(i)))) countConsonant++;
            else break;
        }

        return countConsonant;
    }

    private boolean isConsonantSound(String ch) {
        return !vowelSounds.contains(ch);
    }
}