class Atbash {

    String encode(String input) {
        input = clearString(input);

        StringBuilder output = new StringBuilder();
        for (int i = 0; i < input.length(); i++) {
            if (i > 0 && i % 5 == 0) output.append(" ");
            output.append(encodeDecode(input.charAt(i)));
        }

        return output.toString();
    }

    String decode(String input) {
        input = clearString(input);

        StringBuilder output = new StringBuilder();
        for (int i = 0; i < input.length(); i++) {
            output.append(encodeDecode(input.charAt(i)));
        }

        return output.toString();
    }

    private String clearString(String input) {
        return input
                .replaceAll("[^A-Za-z1-9]+", "")
                .toLowerCase();
    }

    private char encodeDecode(char c) {
        if (isNumber(c)) return c;
        return (char) ('z' - c + 'a');
    }

    private boolean isNumber(char c) {
        return c >= 48 && c <= 57;
    }
}
