import java.util.HashSet;
import java.util.Set;

public class PangramChecker {

    public boolean isPangram(String sentence) {
        Set<Integer> letters = new HashSet<>();

        sentence.chars()
                .filter(Character::isLetter)
                .map(Character::toLowerCase)
                .forEach(letters::add);

        return letters.size() == 26;
    }

}
