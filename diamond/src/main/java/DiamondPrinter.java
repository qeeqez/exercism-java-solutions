import java.util.LinkedList;
import java.util.List;

class DiamondPrinter {

    private final char firstChar = 'A';

    List<String> printToList(char a) {
        a = Character.toUpperCase(a);
        if (a == firstChar) return List.of(String.valueOf(firstChar));

        LinkedList<String> output = new LinkedList<>();

        // print middle
        output.add(printString(a, a));

        // print others
        for (int i = a - firstChar - 1; i >= 0; i--) {
            char currentChar = (char) (i + firstChar);
            String currentString = printString(currentChar, a);

            output.addFirst(currentString);
            output.addLast(currentString);
        }

        return output;
    }


    private String printString(char currentChar, char maxChar) {
        boolean isOneLetter = currentChar == firstChar;
        int maxIndex = maxChar - firstChar;

        int spacesOutsideCount = maxChar - currentChar;
        int spacesInsideCount = isOneLetter ? 0 : maxIndex * 2 + 1 - spacesOutsideCount * 2 - 2;

        StringBuilder sb = new StringBuilder();
        String spacesOutside = printSpaces(spacesOutsideCount);

        sb.append(spacesOutside);

        sb.append(currentChar);
        if (!isOneLetter) {
            String spacesInside = printSpaces(spacesInsideCount);
            sb.append(spacesInside);
            sb.append(currentChar);
        }

        sb.append(spacesOutside);

        return sb.toString();
    }

    /**
     * Creates String of spaces
     *
     * @param spacesCount - count of spaces to be repeated
     * @return String with multiple spaces
     */
    private String printSpaces(int spacesCount) {
        char spaceChar = ' ';
        return String.valueOf(spaceChar).repeat(spacesCount);
    }
}
