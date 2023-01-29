class RotationalCipher {

    private final int shiftKey;

    RotationalCipher(int shiftKey) {
        this.shiftKey = shiftKey;
    }

    String rotate(String data) {
        StringBuilder sb = new StringBuilder();

        for (char c : data.toCharArray()) {
            if (Character.isAlphabetic(c)) {
                c = rotateChar(c);
            }
            sb.append(c);
        }
        return sb.toString();
    }

    private char rotateChar(char c) {
        int alphabetSize = 26;
        char firstChar = Character.isLowerCase(c) ? 'a' : 'A';

        int currentIndex = c - firstChar;
        int proposedIndex = currentIndex + shiftKey;
        currentIndex = proposedIndex < alphabetSize ? proposedIndex : proposedIndex - alphabetSize;
        return (char) (currentIndex + firstChar);
    }

}
