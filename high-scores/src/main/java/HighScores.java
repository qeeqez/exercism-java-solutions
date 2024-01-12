import java.util.Comparator;
import java.util.List;
import java.util.NoSuchElementException;

class HighScores {

    private final List<Integer> scores;

    public HighScores(List<Integer> highScores) {
        this.scores = highScores;
    }

    List<Integer> scores() {
        return this.scores;
    }

    Integer latest() {
        return scores.getLast();
    }

    Integer personalBest() {
        return scores
                .stream()
                .mapToInt(i -> i)
                .max().orElseThrow(NoSuchElementException::new);
    }

    List<Integer> personalTopThree() {
        return scores
                .stream()
                .sorted(Comparator.reverseOrder())
                .limit(3)
                .toList();
    }

}
