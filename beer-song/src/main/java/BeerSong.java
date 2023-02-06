public class BeerSong {

    BeerSong() {
    }

    public String singSong() {
        return sing(99, 100);
    }

    public String sing(int bottles, int lines) {
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < lines; i++) {
            sb.append(singOneVerse(bottles - i));
            sb.append("\n");
        }

        return sb.toString();
    }

    private String singOneVerse(int bottles) {
        return getVerseFirstLine(bottles) + getVerseSecondLine(bottles - 1);
    }

    private String getVerseFirstLine(int bottles) {
        if (bottles > 0) {
            return bottles + " " + getBottlesWord(bottles) + " of beer on the wall, " +
                    bottles + " " + getBottlesWord(bottles) + " of beer.\n";
        } else {
            return "No more bottles of beer on the wall, no more bottles of beer.\n";
        }
    }

    private String getVerseSecondLine(int bottles) {
        if (bottles > 0) {
            return "Take one down and pass it around, " +
                    bottles + " " + getBottlesWord(bottles) + " of beer on the wall.\n";
        } else if (bottles == 0) {
            return "Take it down and pass it around, no more bottles of beer on the wall.\n";
        } else {
            bottles = 99;
            return "Go to the store and buy some more, " +
                    bottles + " " + getBottlesWord(bottles) + " of beer on the wall.\n";
        }
    }

    private String getBottlesWord(int bottles) {
        return bottles == 1 ? "bottle" : "bottles";
    }
}