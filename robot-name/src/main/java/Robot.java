import java.util.HashSet;
import java.util.Random;
import java.util.Set;
import java.util.stream.Collectors;

@SuppressWarnings({"SameParameterValue", "StatementWithEmptyBody"})
public class Robot {

    private static final Set<String> registeredNames = new HashSet<>();
    private String name;

    Robot() {
        reset();
    }

    public String getName() {
        return name;
    }

    public void reset() {
        while (!registeredNames.add(name = generateName())) {
        }
    }

    private String generateName() {
        return getRandomString(2) + getRandomNumber(100, 1000);
    }

    private String getRandomString(int length) {
        int leftLimit = 'A';
        int rightLimit = 'Z';

        return new Random().ints(leftLimit, rightLimit + 1)
                .limit(length)
                .mapToObj(c -> String.valueOf((char) c))
                .collect(Collectors.joining(""));
    }

    private int getRandomNumber(int from, int to) {
        return new Random().nextInt(from, to);
    }
}
