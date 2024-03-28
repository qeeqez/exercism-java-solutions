class Markdown {

    String parse(String markdown) {
        String[] lines = markdown.split("\n");
        StringBuilder result = new StringBuilder();
        boolean activeList = false;

        for (String line : lines) {

            String currentLine = parseHeader(line);

            if (currentLine == null) {
                currentLine = parseListItem(line);
            }

            if (currentLine == null) {
                currentLine = parseParagraph(line);
            }

            if (currentLine.matches("(<li>).*") && !currentLine.matches("(<h).*") && !currentLine.matches("(<p>).*") && !activeList) {
                activeList = true;
                result.append("<ul>");
                result.append(currentLine);
            } else if (!currentLine.matches("(<li>).*") && activeList) {
                activeList = false;
                result.append("</ul>");
                result.append(currentLine);
            } else {
                result.append(currentLine);
            }
        }

        if (activeList) {
            result.append("</ul>");
        }

        return result.toString();
    }

    private String parseHeader(String markdown) {
        int count = 0;

        for (int i = 0; i < markdown.length() && markdown.charAt(i) == '#'; i++) 
        {
            count++;
        }
        
        if (count > 6) { return "<p>" + markdown + "</p>"; }
        if (count == 0) { return null; }

        return "<h" + count + ">" + markdown.substring(count + 1) + "</h" + Integer.toString(count)+ ">";
    }

    private String parseListItem(String markdown) {
        if (markdown.startsWith("*")) {
            String skipAsterisk = markdown.substring(2);
            String listItemString = parseSomeSymbols(skipAsterisk);
            return "<li>" + listItemString + "</li>";
        }

        return null;
    }

    private String parseParagraph(String markdown) {
        return "<p>" + parseSomeSymbols(markdown) + "</p>";
    }

    private String parseSomeSymbols(String markdown) {

        String lookingFor = "__(.+)__";
        String update = "<strong>$1</strong>";
        String workingOn = markdown.replaceAll(lookingFor, update);

        lookingFor = "_(.+)_";
        update = "<em>$1</em>";
        return workingOn.replaceAll(lookingFor, update);
    }
}
