import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

class SumOfMultiples {

    private final int number;
    private final int[] itemValues;

    SumOfMultiples(int number, int[] set) {
        this.number = number;
        this.itemValues = set;
    }

    int getSum() {
        Set<Integer> points = new HashSet<>();

        Arrays.stream(itemValues).forEach(item -> {
            for(int i = item; i < number && i != 0; i += item) {
                points.add(i);
            }
        });

        return points.stream().reduce(0, Integer::sum);
    }

}
