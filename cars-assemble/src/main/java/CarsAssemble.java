public class CarsAssemble {

    public double productionRatePerHour(int speed) {
        int carsPerHour = 221;
        return carsPerHour * speed * getSuccessRate(speed);
    }

    public int workingItemsPerMinute(int speed) {
        return (int) (productionRatePerHour(speed) / 60);
    }

    private double getSuccessRate(int speed) {
        if(speed < 5) {
            return 1;
        } else if(speed < 9) {
            return 0.9;
        } else if(speed == 9) {
            return 0.8;
        } else {
            return 0.77;
        }
    }
}
