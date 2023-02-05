import java.util.Arrays;

class ResistorColorDuo {

    int value(String[] colors) {
        return Arrays.stream(colors)
                .limit(2)
                .map(this::colorCode)
                .reduce((a, b) -> a * 10 + b)
                .orElse(0);
    }

    int colorCode(String color) {
        return Arrays.asList(colors()).indexOf(color);
    }

    String[] colors() {
        return new String[]{"black", "brown", "red", "orange", "yellow", "green", "blue", "violet", "grey", "white"};
    }
}
