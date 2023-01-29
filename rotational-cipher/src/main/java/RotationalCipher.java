class RotationalCipher {

    private final int shiftKey;

    RotationalCipher(int shiftKey) {
        this.shiftKey = shiftKey;
    }

    String rotate(String data) {
        return data.codePoints()
                .mapToObj(this::rotateChar)
                .collect(
                        StringBuilder::new,
                        StringBuilder::appendCodePoint,
                        StringBuilder::append
                )
                .toString();
    }

    int rotateChar(int c) {
        if(!Character.isLetter(c)) return c;

        int alphabetSize = 26;
        char firstChar = Character.isLowerCase(c) ? 'a' : 'A';
        return firstChar + (c + shiftKey - firstChar) % alphabetSize;
    }

}
