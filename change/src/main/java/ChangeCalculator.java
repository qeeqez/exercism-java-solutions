import java.util.ArrayList;
import java.util.List;

class ChangeCalculator {

    private final List<Integer> coins;

    ChangeCalculator(List<Integer> currencyCoins) {
        coins = currencyCoins.stream().sorted().toList();
    }

    public List<Integer> computeMostEfficientChange(int grandTotal) {
        if (grandTotal < 0) throw new IllegalArgumentException("Negative totals are not allowed.");
        if (coins.isEmpty() || coins.getFirst() > grandTotal) {
            throw new IllegalArgumentException("The total " + grandTotal + " cannot be represented in the given currency.");
        }

        List<Integer> result = doComputeMostEfficientChange(grandTotal);
        if (result == null) {
            throw new IllegalArgumentException("The total " + grandTotal + " cannot be represented in the given currency.");
        }

        return result.stream().sorted().toList();
    }

    public List<Integer> doComputeMostEfficientChange(int grandTotal) {
        if (grandTotal == 0) return new ArrayList<>();

        List<Integer> bestChange = null;
        for (int coin : coins) {
            if (coin <= grandTotal) {
                List<Integer> remainingChange = doComputeMostEfficientChange(grandTotal - coin);
                if (remainingChange != null) {
                    remainingChange.add(coin);
                    if (bestChange == null || remainingChange.size() < bestChange.size()) {
                        bestChange = remainingChange;
                    }
                }
            }
        }
        return bestChange;
    }

}
