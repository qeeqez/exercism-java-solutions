import java.util.List;

class LargestSeriesProductCalculator {

    private final List<Integer> digits;

    LargestSeriesProductCalculator(String inputNumber) {
        if (inputNumber.length() > 0 && !inputNumber.matches("[0-9]+"))
            throw new IllegalArgumentException("String to search may only contain digits.");
        digits = inputNumber.chars().mapToObj(Character::getNumericValue).toList();
    }

    long calculateLargestProductForSeriesLength(int numberOfDigits) {
        if (numberOfDigits < 0)
            throw new IllegalArgumentException("Series length must be non-negative.");
        if (numberOfDigits > digits.size())
            throw new IllegalArgumentException("Series length must be less than or equal to the length of the string to search.");

        long maxProduct = 0;
        for (int i = -1; i < digits.size() - numberOfDigits; i++) {
            long currentProduct = 1;
            for (int j = i + 1; j < i + 1 + numberOfDigits; j++) {
                currentProduct *= digits.get(j);
            }
            maxProduct = Math.max(currentProduct, maxProduct);
        }
        return maxProduct;
    }
}
