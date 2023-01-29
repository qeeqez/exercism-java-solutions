import java.util.regex.Pattern;

class SqueakyClean {
    static String clean(String identifier) {
        return Pattern
                .compile("-(\\p{all})")
                .matcher(identifier)
                .replaceAll(matchResult -> matchResult.group().toUpperCase())
                .replace("-", "")
                .replace(" ", "_")
                .replaceAll("\\p{Cntrl}", "CTRL")
                .replaceAll("[^\\u0000-\\uFFFF]", "")
                .replaceAll("[0-9]", "")
                .replaceAll("[α-ω]", "");
    }
}
