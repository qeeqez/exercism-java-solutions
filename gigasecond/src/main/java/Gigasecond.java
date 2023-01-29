import java.time.LocalDate;
import java.time.LocalDateTime;

public class Gigasecond {

    public static final int GIGASECONDS = 1000000000;

    private LocalDateTime moment;

    public Gigasecond(LocalDate moment) {
        this.moment = moment.atStartOfDay();
        adjustTimeAfterGigasecond();
    }

    public Gigasecond(LocalDateTime moment) {
        this.moment = moment;
        adjustTimeAfterGigasecond();
    }

    public LocalDateTime getDateTime() {
        return moment;
    }

    private void adjustTimeAfterGigasecond() {
        moment = moment.plusSeconds(GIGASECONDS);
    }
}
