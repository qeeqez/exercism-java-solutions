class Proverb {

    private final String[] words;

    Proverb(String[] words) {
        this.words = words;
    }

    String recite() {
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < words.length - 1; i++) {
            sb.append("For want of a ")
                    .append(words[i])
                    .append(" the ")
                    .append(words[i + 1])
                    .append(" was lost.\n");
        }

        if (words.length > 0) {
            sb.append("And all for the want of a ").append(words[0]).append(".");
        }

        return sb.toString();
    }

}
