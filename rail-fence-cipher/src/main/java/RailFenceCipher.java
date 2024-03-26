import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

class RailFenceCipher {

    private final int rows;

    RailFenceCipher(int rows) {
        this.rows = rows;
    }

    String getEncryptedData(String message) {
        List<String> lines = new ArrayList<>(Stream.generate(String::new)
                .limit(rows)
                .toList());
        boolean directionUp = true;
        int i = 0;
        for (char c : message.toCharArray()) {
            lines.set(i, lines.get(i) + c);
            i = directionUp ? i + 1 : i - 1;

            if (i == rows - 1) directionUp = false;
            else if (i == 0) directionUp = true;
        }

        return String.join("", lines);
    }

    String getDecryptedData(String message) {
        return Stream.iterate(
                        this.getEncryptedData(message),
                        s -> !s.equals(message),
                        this::getEncryptedData
                )
                .reduce((a, b) -> b)
                .orElse("");
    }

}