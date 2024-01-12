import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.time.format.FormatStyle;
import java.util.Locale;

class AppointmentScheduler {
    public LocalDateTime schedule(String appointmentDateDescription) {
        DateTimeFormatter parser = DateTimeFormatter.ofPattern("MM/dd/yyyy HH:mm:ss");
        return LocalDateTime.parse(appointmentDateDescription, parser);
    }

    public boolean hasPassed(LocalDateTime appointmentDate) {
        return appointmentDate.isBefore(LocalDateTime.now());
    }

    public boolean isAfternoonAppointment(LocalDateTime appointmentDate) {
        int hour = appointmentDate.getHour();
        return hour >= 12 && hour < 18;
    }

    // return "You have an appointment on Friday, March 29, 2019, at 3:00 PM."
    public String getDescription(LocalDateTime appointmentDate) {
        LocalDate date = appointmentDate.toLocalDate();
        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("EEEE, MMMM d, yyyy");

        LocalTime time = appointmentDate.toLocalTime();
        DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("h:mm a");

        return "You have an appointment on " +
                date.format(dateFormatter) +
                ", at " +
                time.format(timeFormatter) +
                ".";
    }

    public LocalDate getAnniversaryDate() {
        return LocalDate.of(LocalDate.now().getYear(), Month.SEPTEMBER, 15);
    }
}
