public enum ResistorColor {
    BLACK(0),

    BROWN(1),

    RED(2),

    ORANGE(3),

    YELLOW(4),

    GREEN(5),

    BLUE(6),

    VIOLET(7),

    GREY(8),

    WHITE(9);

    private final int value;

    ResistorColor(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
