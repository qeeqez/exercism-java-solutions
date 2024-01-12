import java.util.Random;

class CaptainsLog {

    private static final char[] PLANET_CLASSES = new char[]{'D', 'H', 'J', 'K', 'L', 'M', 'N', 'R', 'T', 'Y'};

    private final Random random;

    CaptainsLog(Random random) {
        this.random = random;
    }

    char randomPlanetClass() {
        int randomPlanet = random.nextInt(10);
        return PLANET_CLASSES[randomPlanet];
    }

    String randomShipRegistryNumber() {
        int shipNumber = 1000 + random.nextInt(9000);
        return "NCC-" + shipNumber;
    }

    double randomStardate() {
        int century = 40000;
        int season = 1000;
        double date = 1000 * random.nextDouble();
        return century + season + date;
    }
}
