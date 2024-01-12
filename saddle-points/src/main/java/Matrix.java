import java.util.HashSet;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;

class Matrix {

    private final List<List<Integer>> values;

    Matrix(List<List<Integer>> values) {
        this.values = values;
    }

    Set<MatrixCoordinate> getSaddlePoints() {
        Set<MatrixCoordinate> saddlePoints = new HashSet<>();

        for (int i = 0; i < values.size(); i++) {
            int maxInRow = maxInRow(i);

            for (int j = 0; j < values.get(i).size(); j++) {
                if (values.get(i).get(j) == maxInRow && values.get(i).get(j) == minInCol(j)) {
                    saddlePoints.add(new MatrixCoordinate(i + 1, j + 1));
                }
            }
        }

        return saddlePoints;
    }

    private int maxInRow(int row) {
        return values.get(row).parallelStream()
                .mapToInt(Integer::intValue)
                .max()
                .orElseThrow(NoSuchElementException::new);
    }

    private int minInCol(int column) {
        AtomicInteger minInCol = new AtomicInteger(Integer.MAX_VALUE);
        values.parallelStream().forEach(row -> {
            int value = row.get(column);
            if (minInCol.get() > value) minInCol.set(value);
        });
        return minInCol.get();
    }
}
