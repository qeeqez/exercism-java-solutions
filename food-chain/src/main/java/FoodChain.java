public class FoodChain {
    FoodChain() {
    }

    public String verses(int start, int end) {
        StringBuilder sb = new StringBuilder();
        for (int i = start; i <= end; i++) {
            sb.append(verse(i));
            if (i != end) sb.append("\n\n");
        }
        return sb.toString();
    }

    public String verse(int layer) {
        if (layer == 1)
            return "I know an old lady who swallowed a fly.\n" +
                    "I don't know why she swallowed the fly. Perhaps she'll die.";

        if (layer == 8)
            return "I know an old lady who swallowed a horse.\n" +
                    "She's dead, of course!";

        StringBuilder sb = new StringBuilder();

        sb.append("I know an old lady who swallowed a ")
                .append(getAnimal(layer))
                .append(".\n")
                .append(getSecondSentence(layer))
                .append("\n");

        for (int i = layer; i > 1; i--) {
            sb.append("She swallowed the ")
                    .append(getAnimal(i))
                    .append(" to catch the ")
                    .append(getAnimal(i - 1));

            if (i == 3)
                sb.append(" that wriggled and jiggled and tickled inside her");

            sb.append(".\n");
        }

        sb.append("I don't know why she swallowed the fly. Perhaps she'll die.");

        return sb.toString();
    }

    private String getAnimal(int layer) {
        return switch (layer) {
            case 1 -> "fly";
            case 2 -> "spider";
            case 3 -> "bird";
            case 4 -> "cat";
            case 5 -> "dog";
            case 6 -> "goat";
            case 7 -> "cow";
            default -> "";
        };
    }

    private String getSecondSentence(int layer) {
        return switch (layer) {
            case 2 -> "It wriggled and jiggled and tickled inside her.";
            case 3 -> "How absurd to swallow a bird!";
            case 4 -> "Imagine that, to swallow a cat!";
            case 5 -> "What a hog, to swallow a dog!";
            case 6 -> "Just opened her throat and swallowed a goat!";
            case 7 -> "I don't know how she swallowed a cow!";
            default -> "";
        };
    }
}