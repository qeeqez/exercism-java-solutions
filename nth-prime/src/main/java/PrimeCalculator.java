import java.util.ArrayList;
import java.util.List;

class PrimeCalculator {

    private final List<Integer> primes = new ArrayList<>();

    int nth(int nth) {
        if (nth == 0) throw new IllegalArgumentException();

        int currentNumber = 1;
        while (nth > 0) {
            currentNumber++;
            if (isPrime(currentNumber)) {
                nth--;
                primes.add(currentNumber);
            }
        }

        return currentNumber;
    }

    private boolean isPrime(int number) {
        return primes.stream().noneMatch(p -> number % p == 0);
    }

}
