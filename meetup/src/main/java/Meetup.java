import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.temporal.TemporalAdjusters;
import java.util.List;

public class Meetup {

    private LocalDate date;

    List<Integer> teenthDays = List.of(13, 14, 15, 16, 17, 18, 19);

    Meetup(int month, int year) {
        date = LocalDate.of(year, month, 1);
    }

    public LocalDate day(DayOfWeek dayOfWeek, MeetupSchedule meetupSchedule) {
        return switch (meetupSchedule) {
            case FIRST -> date.with(TemporalAdjusters.firstInMonth(dayOfWeek));
            case SECOND -> date.with(TemporalAdjusters.dayOfWeekInMonth(2, dayOfWeek));
            case THIRD -> date.with(TemporalAdjusters.dayOfWeekInMonth(3, dayOfWeek));
            case FOURTH -> date.with(TemporalAdjusters.dayOfWeekInMonth(4, dayOfWeek));
            case LAST -> date.with(TemporalAdjusters.lastInMonth(dayOfWeek));
            case TEENTH -> {
                while (true) {
                    date = date.with(TemporalAdjusters.next(dayOfWeek));
                    int day = date.getDayOfMonth();
                    if (teenthDays.contains(day)) {
                        date.withDayOfMonth(day);
                        break;
                    }
                }
                yield date;
            }
        };
    }
}