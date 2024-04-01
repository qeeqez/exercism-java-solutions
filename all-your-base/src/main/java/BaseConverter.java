import java.util.ArrayList;
import java.util.List;

class BaseConverter {

    private int number = 0;

    BaseConverter(int base, int[] digits) {
        if (base < 2) throw new IllegalArgumentException("Bases must be at least 2.");

        if (digits.length == 0) {
            number = 0;
            return;
        }

        for (int i = 0; i < digits.length; i++) {
            if (digits[i] < 0) throw new IllegalArgumentException("Digits may not be negative.");
            if (digits[i] >= base)
                throw new IllegalArgumentException("All digits must be strictly less than the base.");

            number += (int) (digits[i] * Math.pow(base, digits.length - i - 1));
        }
    }

    int[] convertToBase(int newBase) {
        if (newBase < 2) throw new IllegalArgumentException("Bases must be at least 2.");

        return convertToBaseList(newBase).stream().mapToInt(Integer::intValue).toArray();
    }

    private List<Integer> convertToBaseList(int newBase) {
        List<Integer> result = new ArrayList<>();

        if (number == 0) {
            result.add(0);
            return result;
        }

        while (number > 0) {
            result.addFirst(number % newBase);
            number /= newBase;
        }

        return result;
    }

}