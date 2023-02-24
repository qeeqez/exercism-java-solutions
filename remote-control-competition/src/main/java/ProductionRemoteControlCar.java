public class ProductionRemoteControlCar extends AbstractRemoteControlCar implements Comparable<ProductionRemoteControlCar> {
    int numberOfVictories = 0;

    public void drive() {
        distanceTravelled += 10;
    }

    public int getNumberOfVictories() {
        return numberOfVictories;
    }

    public void setNumberOfVictories(int numberOfVictories) {
        this.numberOfVictories = numberOfVictories;
    }

    @Override
    public int compareTo(ProductionRemoteControlCar otherCar) {
        return Integer.compare(this.numberOfVictories, otherCar.numberOfVictories);
    }
}
