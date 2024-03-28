class Markdown {

    String parse(String markdown) {
        String[] lines = markdown.split("\n");
        StringBuilder result = new StringBuilder();
        boolean activeList = false;

        for (String line : lines) {

            boolean isList = isListItem(line);

            if (isHeader(line)) {
                line = parseHeader(line);
            } else if (isList) {
                line = parseListItem(line);
            } else {
                line = parseParagraph(line);
            }

            result.append(line);
        }

        return result.toString();
    }

    private String parseHeader(String markdown) {
        int count = 0;

        for (int i = 0; i < markdown.length() && markdown.charAt(i) == '#'; i++) {
            count++;
        }

        if (count > 6) {
            return "<p>" + markdown + "</p>";
        }
        if (count == 0) {
            return null;
        }

        return "<h" + count + ">" + markdown.substring(count + 1) + "</h" + count + ">";
    }

    private String parseListItem(String markdown) {
        String skipAsterisk = markdown.substring(2);
        String listItemString = parseBoldItalic(skipAsterisk);
        return "<li>" + listItemString + "</li>";
    }

    private boolean isHeader(String line) {
        return line.startsWith("#");
    }

    private boolean isListItem(String line) {
        return line.startsWith("*");
    }

    private String parseParagraph(String markdown) {
        return "<p>" + parseBoldItalic(markdown) + "</p>";
    }

    private String parseBoldItalic(String markdown) {
        String output = parseBold(markdown);
        output = parseItalic(output);
        return output;
    }

    private String parseBold(String markdown) {
        String lookingFor = "__(.+)__";
        String update = "<strong>$1</strong>";
        return markdown.replaceAll(lookingFor, update);
    }

    private String parseItalic(String markdown) {
        String lookingFor = "_(.+)_";
        String update = "<em>$1</em>";
        return markdown.replaceAll(lookingFor, update);
    }
}
