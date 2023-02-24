public enum Planet {
    EARTH(1.0),
    MERCURY(0.2408467),
    VENUS(0.61519726),
    MARS(1.8808158),
    JUPITER(11.862615),
    SATURN(29.447498),
    URANUS(84.016846),
    NEPTUNE(164.79132);

    private final double orbitalPeriodInEarthYears;

    Planet(double orbitalPeriodInYears) {
        this.orbitalPeriodInEarthYears = orbitalPeriodInYears;
    }

    public double getOrbitalPeriodInEarthYears() {
        return orbitalPeriodInEarthYears;
    }
}