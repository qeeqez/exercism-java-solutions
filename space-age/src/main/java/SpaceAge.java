class SpaceAge {

    private static final int EARTH_YEAR_IN_SECONDS = 31_557_600;

    private final double earthSeconds;
    private final double earthYears;

    SpaceAge(double seconds) {
        earthSeconds = seconds;
        earthYears = earthSeconds / EARTH_YEAR_IN_SECONDS;
    }

    double getSeconds() {
        return earthSeconds;
    }

    double onEarth() {
        return getOrbitalAge(Planet.EARTH);
    }

    double onMercury() {
        return getOrbitalAge(Planet.MERCURY);
    }

    double onVenus() {
        return getOrbitalAge(Planet.VENUS);
    }

    double onMars() {
        return getOrbitalAge(Planet.MARS);
    }

    double onJupiter() {
        return getOrbitalAge(Planet.JUPITER);
    }

    double onSaturn() {
        return getOrbitalAge(Planet.SATURN);
    }

    double onUranus() {
        return getOrbitalAge(Planet.URANUS);
    }

    double onNeptune() {
        return getOrbitalAge(Planet.NEPTUNE);
    }

    private double getOrbitalAge(Planet planet) {
        return earthYears / planet.getOrbitalPeriodInEarthYears();
    }

}
