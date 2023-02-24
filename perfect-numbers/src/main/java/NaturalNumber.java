public class NaturalNumber {

    private final Classification classification;

    public NaturalNumber(int number) {
        if (number == 0) throw new IllegalArgumentException("You must supply a natural number (positive integer)");
        if (number < 0) throw new IllegalArgumentException("You must supply a natural number (positive integer)");

        int aliquotSum = aliquotSum(number);
        if (aliquotSum == number) classification = Classification.PERFECT;
        else if (aliquotSum > number) classification = Classification.ABUNDANT;
        else classification = Classification.DEFICIENT;
    }

    public Classification getClassification() {
        return classification;
    }

    private int aliquotSum(int number) {
        int sum = 0;
        for (int i = 1; i < number; i++) {
            if (number % i == 0) sum += i;
        }
        return sum;
    }
}
