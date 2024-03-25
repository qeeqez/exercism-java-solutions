import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class KillerSudokuHelper {

    List<List<Integer>> combinationsInCage(Integer cageSum, Integer cageSize) {
        return combinationsInCage(cageSum, cageSize, new ArrayList<>());
    }

    List<List<Integer>> combinationsInCage(Integer cageSum, Integer cageSize, List<Integer> exclude) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> currentCombination = new ArrayList<>();
        findCombinations(cageSum, cageSize, 1, currentCombination, result, exclude);
        return result;
    }

    private void findCombinations(Integer cageSum, Integer cageSize, int start,
                                  List<Integer> currentCombination, List<List<Integer>> result, List<Integer> exclude) {
        if (cageSum == 0 && cageSize == 0) {
            result.add(new ArrayList<>(currentCombination));
        } else if (cageSum <= 0 || cageSize <= 0) {
            return;
        }

        IntStream
                .rangeClosed(start, 9)
                .filter(i -> !exclude.contains(i))
                .forEach(i -> {
                    currentCombination.add(i);
                    findCombinations(cageSum - i, cageSize - 1, i + 1, currentCombination, result, exclude);
                    currentCombination.removeLast();
                });
    }

}
