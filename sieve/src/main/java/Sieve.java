import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.IntStream;

/**
 * Sieve of Eratosthenes algorithm
 *
 * @see <a href="https://en.wikipedia.org/wiki/Sieve_of_Eratosthenes">Wikipedia</a>
 */
class Sieve {

    private final List<Integer> possiblePrimes;
    private final List<Boolean> markedNonPrimes;

    Sieve(int maxPrime) {
        possiblePrimes = IntStream.rangeClosed(2, maxPrime).boxed().toList();
        markedNonPrimes = new ArrayList<>(Collections.nCopies(possiblePrimes.size(), false));
    }

    List<Integer> getPrimes() {
        List<Integer> output = new ArrayList<>();

        for (int i = 0; i < possiblePrimes.size(); i++) {
            if(markedNonPrimes.get(i)) continue;

            int prime = possiblePrimes.get(i);
            output.add(prime);
            for(int j = i; j < possiblePrimes.size(); j += prime) {
                markedNonPrimes.set(j, true);
            }
        }

        return output;
    }
}
