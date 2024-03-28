class Markdown {

    String parse(String markdown) {
        String[] lines = markdown.split("\n");
        StringBuilder result = new StringBuilder();
        boolean activeList = false;

        for (String line : lines) {

            boolean isList = isListItem(line);

            if (isList && !activeList) {
                activeList = true;
                result.append("<ul>");
            } else if (!isList && activeList) {
                activeList = false;
                result.append("</ul>");
            }

            if (isHeader(line)) {
                line = parseHeader(line);
            } else if (isList) {
                line = parseListItem(line);
            } else {
                line = parseParagraph(line);
            }

            result.append(line);
        }

        if (activeList) result.append("</ul>");

        return result.toString();
    }

    private String parseHeader(String markdown) {
        int count = markdown.lastIndexOf("#", 7) + 1;
        if (count > 6) return parseParagraph(markdown);
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
        return parseItalic(parseBold(markdown));
    }

    private String parseBold(String markdown) {
        return markdown.replaceAll("__(.+)__", "<strong>$1</strong>");
    }

    private String parseItalic(String markdown) {
        return markdown.replaceAll("_(.+)_", "<em>$1</em>");
    }
}
