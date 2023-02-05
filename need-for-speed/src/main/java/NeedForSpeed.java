class NeedForSpeed {
    private final int speed;
    private final int batteryDrain;

    private int battery = 100;
    private int distanceDriven = 0;


    public NeedForSpeed(int speed, int batteryDrain) {
        this.speed = speed;
        this.batteryDrain = batteryDrain;
    }

    public boolean batteryDrained() {
        return battery <= 0;
    }

    public int distanceDriven() {
        return distanceDriven;
    }

    private boolean couldDrive() {
        return !batteryDrained() && battery >= batteryDrain;
    }

    public void drive() {
        if (couldDrive()) {
            distanceDriven += speed;
            battery -= batteryDrain;
        }
    }

    public static NeedForSpeed nitro() {
        return new NeedForSpeed(50, 4);
    }
}

class RaceTrack {
    private final int distance;

    public RaceTrack(int distance) {
        this.distance = distance;
    }

    public boolean tryFinishTrack(NeedForSpeed car) {
        while(!car.batteryDrained() && car.distanceDriven() < distance) {
            car.drive();
        }
        return car.distanceDriven() >= distance;
    }
}
