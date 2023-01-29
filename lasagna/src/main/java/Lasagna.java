public class Lasagna {

    public static final int EXPECTED_MINUTES_IN_OVEN = 40;
    public static final int TIME_TO_PREPARE_ONE_LAYER = 2;

    public int expectedMinutesInOven() {
        return EXPECTED_MINUTES_IN_OVEN;
    }

    public int remainingMinutesInOven(int minutesInTheOven) {
        return EXPECTED_MINUTES_IN_OVEN - minutesInTheOven;
    }

    public int preparationTimeInMinutes(int layersPrepared) {
        return layersPrepared * TIME_TO_PREPARE_ONE_LAYER;
    }

    public int totalTimeInMinutes(int layersPrepared, int minutesInTheOven) {
        return preparationTimeInMinutes(layersPrepared) + minutesInTheOven;
    }
}
