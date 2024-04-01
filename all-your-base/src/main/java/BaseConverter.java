import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class BaseConverter {

    private int number = 0;

    BaseConverter(int originalBase, int[] originalDigits) {
        if (originalDigits.length == 0) {
            number = 0;
        } else {
            for (int i = 0; i < originalDigits.length; i++) {
                number += (int) (originalDigits[i] * Math.pow(originalBase, originalDigits.length - i - 1));
            }
        }
    }

    int[] convertToBase(int newBase) {
        return convertToBaseList(newBase).stream()
                .mapToInt(Integer::intValue)
                .toArray();
    }


    List<Integer> convertToBaseList(int newBase) {
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

//    int convertToAnotherBase(int newBase) {
//
//    }

    int convertToBase10(int base, int[] digits) {
        int size = digits.length;
        int result = 0;
        for (int i = 0; i < size; i++) {
            result += (int) (Math.pow(base, i) * digits[size - i - 1]);
        }
        return result;
    }
//
//    int findHighPow(int number, int base) {
//
//    }

}