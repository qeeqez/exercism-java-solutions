import java.util.Arrays;
import java.util.List;

class TwelveDays {

    List<String> gifts = Arrays.asList(
            "a Partridge in a Pear Tree",
            "two Turtle Doves",
            "three French Hens",
            "four Calling Birds",
            "five Gold Rings",
            "six Geese-a-Laying",
            "seven Swans-a-Swimming",
            "eight Maids-a-Milking",
            "nine Ladies Dancing",
            "ten Lords-a-Leaping",
            "eleven Pipers Piping",
            "twelve Drummers Drumming"
    );

    String verse(int verseNumber) {
        StringBuilder sb = new StringBuilder();

        sb.append("On the ")
                .append(getDayWord(verseNumber))
                .append(" day of Christmas my true love gave to me: ");

        for (int i = verseNumber - 1; i >= 0; i--) {
            if (i == 0 && verseNumber > 1) sb.append(", and ");
            else if (i != verseNumber - 1) sb.append(", ");
            sb.append(gifts.get(i));
        }
        sb.append(".\n");

        return sb.toString();
    }

    private String getDayWord(int verseNumber) {
        return switch (verseNumber) {
            case 1 -> "first";
            case 2 -> "second";
            case 3 -> "third";
            case 4 -> "fourth";
            case 5 -> "fifth";
            case 6 -> "sixth";
            case 7 -> "seventh";
            case 8 -> "eighth";
            case 9 -> "ninth";
            case 10 -> "tenth";
            case 11 -> "eleventh";
            case 12 -> "twelfth";
            default -> "";
        };
    }

    String verses(int startVerse, int endVerse) {
        StringBuilder sb = new StringBuilder();

        for (int i = startVerse; i <= endVerse; i++) {
            sb.append(verse(i));
            if (i != endVerse) sb.append("\n");
        }
        return sb.toString();
    }

    String sing() {
        return verses(1, 12);
    }
}
