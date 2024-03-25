import java.util.stream.Collectors;

class Atbash {

    String encode(String input) {
        return transform(input).replaceAll(".{5}(?=.)", "$0 ");
    }

    String decode(String input) {
        return transform(input);
    }

    private String transform(String input) {
        return input
                .toLowerCase()
                .chars()
                .mapToObj(ch -> (char) ch)
                .filter(Character::isLetterOrDigit)
                .map(this::encodeDecode)
                .map(String::valueOf)
                .collect(Collectors.joining());
    }

    private char encodeDecode(char c) {
        if (isNumber(c)) return c;
        return (char) ('z' - c + 'a');
    }

    private boolean isNumber(char c) {
        return c >= 48 && c <= 57;
    }
}
