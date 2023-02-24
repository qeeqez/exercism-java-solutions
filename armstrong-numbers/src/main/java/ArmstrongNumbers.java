import java.util.List;

class ArmstrongNumbers {

    boolean isArmstrongNumber(int numberToCheck) {

        List<Integer> digitsList = String.valueOf(numberToCheck).chars()
                .map(Character::getNumericValue)
                .boxed()
                .toList();

        int sum = digitsList.stream()
                .mapToInt(digit -> (int) Math.pow(digit, digitsList.size()))
                .sum();

        return sum == numberToCheck;
    }

}
