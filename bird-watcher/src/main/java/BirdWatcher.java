import java.util.Arrays;

class BirdWatcher {
    private final int[] birdsPerDay;

    public BirdWatcher(int[] birdsPerDay) {
        this.birdsPerDay = birdsPerDay.clone();
    }

    public int[] getLastWeek() {
        return new int[]{0, 2, 5, 3, 7, 8, 4};
    }

    public int getToday() {
        if (birdsPerDay.length != 0) return birdsPerDay[birdsPerDay.length - 1];

        return 0;
    }

    public void incrementTodaysCount() {
        birdsPerDay[birdsPerDay.length - 1]++;
    }

    public boolean hasDayWithoutBirds() {
        return Arrays.stream(birdsPerDay).anyMatch(a -> a == 0);
    }

    public int getCountForFirstDays(int numberOfDays) {
        int count = 0;
        numberOfDays = Math.min(numberOfDays, birdsPerDay.length);
        for (int i = 0; i < numberOfDays; i++) {
            count += birdsPerDay[i];
        }
        return count;
    }

    public int getBusyDays() {
        int busyDays = 0;
        for (int current : birdsPerDay) {
            if (current >= 5) {
                busyDays++;
            }
        }
        return busyDays;
    }
}
