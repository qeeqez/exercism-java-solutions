import java.util.*;

class PrimeFactorsCalculator {

    List<Long> calculatePrimeFactorsOf(long number) {
        List<Long> factors = new ArrayList<>();

        long prime = 2;

        while (number > 1) {
            if (number % prime == 0) {
                number /= prime;
                factors.add(prime);
            } else {
                prime++;
            }
        }

        return factors;
    }
}