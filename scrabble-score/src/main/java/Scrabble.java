class Scrabble {

    String word;

    Scrabble(String word) {
        this.word = word;
    }

    int getScore() {
        int score = 0;
        for (char c : word.toCharArray()) {
            score += getCharScore(c);
        }
        return score;
    }

    private int getCharScore(char c) {
        return switch (Character.toUpperCase(c)) {
            case 'A', 'E', 'I', 'O', 'U', 'L', 'N', 'R', 'S', 'T' -> 1;
            case 'D', 'G' -> 2;
            case 'B', 'C', 'M', 'P' -> 3;
            case 'F', 'H', 'V', 'W', 'Y' -> 4;
            case 'K' -> 5;
            case 'J', 'X' -> 8;
            case 'Q', 'Z' -> 10;
            default -> 0;
        };
    }

}
