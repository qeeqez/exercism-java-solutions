import java.util.Arrays;
import java.util.stream.Collectors;

class Acronym {

    private final String acronym;

    public Acronym(String phrase) {
        acronym = Arrays.stream(
                        phrase
                                .replaceAll("[-,_]", " ")
                                .split(" ")
                )
                .filter(word -> word.length() > 0)
                .map(word -> word.substring(0, 1))
                .map(String::toUpperCase)
                .collect(Collectors.joining());
    }

    public String get() {
        return acronym;
    }

}
