public record Queen(int x, int y) {
    public Queen {
        if (x < 0) throw new IllegalArgumentException("Queen position must have positive row.");
        if (y < 0) throw new IllegalArgumentException("Queen position must have positive column.");
        if (x > 7) throw new IllegalArgumentException("Queen position must have row <= 7.");
        if (y > 7) throw new IllegalArgumentException("Queen position must have column <= 7.");
    }
}