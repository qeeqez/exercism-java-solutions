public class House {

    House() {
    }

    public String sing() {
        return verses(1, 12);
    }

    public String verses(int start, int end) {
        StringBuilder sb = new StringBuilder();
        for (int i = start; i <= end; i++) {
            sb.append(verse(i));
            if (i != end) sb.append("\n");
        }
        return sb.toString();
    }

    public String verse(int layer) {
        if (layer == 1) return "This is the house that Jack built.";

        StringBuilder sb = new StringBuilder();

        sb.append("This is the ");
        for (int i = layer; i >= 2; i--) {
            sb.append(getAnimal(i));

            if (i > 2) {
                sb.append(" that ")
                        .append(getAction(i))
                        .append(" the ");
            }
        }
        sb.append(" that lay in the house that Jack built.");
        return sb.toString();
    }

    private String getAnimal(int layer) {
        return switch (layer) {
            case 2 -> "malt";
            case 3 -> "rat";
            case 4 -> "cat";
            case 5 -> "dog";
            case 6 -> "cow with the crumpled horn";
            case 7 -> "maiden all forlorn";
            case 8 -> "man all tattered and torn";
            case 9 -> "priest all shaven and shorn";
            case 10 -> "rooster that crowed in the morn";
            case 11 -> "farmer sowing his corn";
            case 12 -> "horse and the hound and the horn";
            default -> "";
        };
    }

    private String getAction(int layer) {
        return switch (layer) {
            case 3 -> "ate";
            case 4 -> "killed";
            case 5 -> "worried";
            case 6 -> "tossed";
            case 7 -> "milked";
            case 8 -> "kissed";
            case 9 -> "married";
            case 10 -> "woke";
            case 11 -> "kept";
            case 12 -> "belonged to";
            default -> "";
        };
    }
}
