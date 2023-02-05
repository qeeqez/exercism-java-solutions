import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class HandshakeCalculator {

    List<Signal> calculateHandshake(int number) {
        List<Signal> output = new ArrayList<>();

        int binaryNumber = numberToBinary(number);

        for (int i = 0; i < 5 || binaryNumber > 0; i++) {
            boolean hasOne = isLastDigit1(binaryNumber);
            binaryNumber /= 10;

            if (i == 4) {
                if (hasOne) Collections.reverse(output);
                break;
            } else if (hasOne) output.add(Signal.values()[i]);
        }

        return output;
    }

    private boolean isLastDigit1(int number) {
        return number % 10 == 1;
    }

    private int numberToBinary(int number) {
        return Integer.parseInt(Integer.toBinaryString(number));
    }


}
