import java.util.*;

public class Transpose {
    public String transpose(String toTranspose) {
        List<String> input = Arrays.stream(toTranspose.split("\n")).toList();
        int rows = input.stream().mapToInt(String::length).max().orElse(0);

        StringBuilder output = new StringBuilder();
        StringBuilder emptyChars = new StringBuilder();

        for (int i = 0; i < rows; i++) {
            if (i > 0) output.append("\n");
            emptyChars.setLength(0);
            for (String row : input) {
                if (i < row.length()) {
                    output.append(emptyChars).append(row.charAt(i));
                    emptyChars.setLength(0);
                } else {
                    emptyChars.append(" ");
                }
            }
        }

        return output.toString();
    }
}
