public class ElonsToyCar {

    private int distance = 0;
    private int battery = 100;

    public static ElonsToyCar buy() {
        return new ElonsToyCar();
    }

    public String distanceDisplay() {
        return "Driven " + distance + " meters";
    }

    public String batteryDisplay() {
        return battery > 0 ? "Battery at " + battery + "%" : "Battery empty";
    }

    public void drive() {
        if(battery > 0) {
            distance += 20;
            battery -= 1;
        }
    }
}
