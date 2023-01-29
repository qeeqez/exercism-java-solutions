import java.util.ArrayList;
import java.util.List;

class Matrix {

    List<List<Integer>> matrix;

    Matrix(String matrixAsString) {
        matrix = new ArrayList<>();
        List<Integer> row = new ArrayList<>();

        int number = 0;
        for (int i = 0; i < matrixAsString.length(); i++) {
            char c = matrixAsString.charAt(i);
            if (Character.isDigit(c)) {
                number *= 10;
                number += Character.getNumericValue(c);
            } else {
                row.add(number);
                number = 0;

                if (c == '\n') {
                    matrix.add(row);
                    row = new ArrayList<>();
                }
            }
        }
        row.add(number);
        matrix.add(row);
    }

    int[] getRow(int rowNumber) {
        return matrix.get(rowNumber - 1).stream().mapToInt(Integer::intValue).toArray();
    }

    int[] getColumn(int columnNumber) {
        int[] column = new int[matrix.size()];
        for (int i = 0; i < matrix.size(); i++) {
            column[i] = matrix.get(i).get(columnNumber - 1);
        }
        return column;
    }
}
