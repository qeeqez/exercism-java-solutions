import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Yacht {

    private final List<Integer> dice;
    private final YachtCategory yachtCategory;

    Yacht(int[] dice, YachtCategory yachtCategory) {
        this.dice = new ArrayList<>();
        for (int d : dice) {
            this.dice.add(d);
        }

        this.yachtCategory = yachtCategory;
    }

    int score() {

        return switch (yachtCategory) {
            case YACHT -> dice.stream().distinct().count() == 1 ? 50 : 0;
            case CHOICE -> dice.stream().reduce(0, Integer::sum);
            case BIG_STRAIGHT -> dice.stream().distinct().reduce(0, Integer::sum) == (2 + 3 + 4 + 5 + 6) ? 30 : 0;
            case LITTLE_STRAIGHT -> dice.stream().distinct().reduce(0, Integer::sum) == (1 + 2 + 3 + 4 + 5) ? 30 : 0;
            case FOUR_OF_A_KIND -> dice.stream()
                    .filter(i -> Collections.frequency(dice, i) >= 4)
                    .limit(4)
                    .reduce(0, Integer::sum);
            case FULL_HOUSE -> dice.stream().distinct().count() == 2
                    && dice.stream().allMatch(i -> Collections.frequency(this.dice, i) >= 2)
                    ? dice.stream().reduce(0, Integer::sum) : 0;
            case SIXES -> dice.stream().filter(a -> a == 6).reduce(0, Integer::sum);
            case FIVES -> dice.stream().filter(a -> a == 5).reduce(0, Integer::sum);
            case FOURS -> dice.stream().filter(a -> a == 4).reduce(0, Integer::sum);
            case THREES -> dice.stream().filter(a -> a == 3).reduce(0, Integer::sum);
            case TWOS -> dice.stream().filter(a -> a == 2).reduce(0, Integer::sum);
            case ONES -> dice.stream().filter(a -> a == 1).reduce(0, Integer::sum);
        };
    }

}
