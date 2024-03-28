class Clock {

    private int hours;
    private int minutes;

    Clock(int hours, int minutes) {
        increaseHoursBy(hours);
        add(minutes);
    }

    void add(int minutes) {
        int updatedMinutes = this.minutes + minutes;
        int hours = updatedMinutes / 60;
        updatedMinutes %= 60;
        if (updatedMinutes < 0) {
            hours--;
            updatedMinutes = 60 + updatedMinutes;
        }
        increaseHoursBy(hours);
        this.minutes = updatedMinutes;
    }

    private void increaseHoursBy(int hours) {
        int updatedHours = (this.hours + hours) % 24;
        this.hours = updatedHours < 0
                ? 24 + updatedHours
                : updatedHours;
    }

    @Override
    public String toString() {
        return String.format("%02d:%02d", hours, minutes);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Clock clock = (Clock) o;
        return hours == clock.hours && minutes == clock.minutes;
    }

}