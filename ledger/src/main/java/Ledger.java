import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Locale;

public class Ledger {
    public LedgerEntry createLedgerEntry(String date, String description, int change) {
        return new LedgerEntry(date, description, change);
    }

    public String format(String currency, String locale, LedgerEntry[] entries) {
        LedgerLocale settings = new LedgerLocale(currency, locale);

        if (entries.length == 0) return settings.getHeader();

        StringBuilder output = new StringBuilder(settings.getHeader());

        Arrays.stream(entries)
                .sorted(Comparator
                        .comparing(LedgerEntry::getChange)
                        .thenComparing(LedgerEntry::getLocalDate)
                )
                .forEach(entry -> output.append(localizedEntry(entry, settings)));

        return output.toString();
    }

    private String localizedEntry(LedgerEntry entry, LedgerLocale settings) {
        String date = formattedDate(entry.getLocalDate(), settings);
        String description = formattedDescription(entry.getDescription());
        String change = formattedChange(entry.getChange(), settings);

        return String.format("\n%s | %-25s | %13s", date, description, change);
    }

    private String formattedDate(LocalDate date, LedgerLocale settings) {
        return date.format(DateTimeFormatter.ofPattern(settings.getDatePattern()));
    }

    private String formattedDescription(String desc) {
        if (desc.length() > 25) {
            desc = desc.substring(0, 22) + "...";
        }
        return desc;
    }

    private String formattedChange(double change, LedgerLocale settings) {
        DecimalFormat formatter = (DecimalFormat) NumberFormat.getCurrencyInstance(Locale.forLanguageTag(settings.getLocale()));
        if (settings.getLocale().equals("en-US")) {
            formatter.setNegativePrefix("(" + settings.getCurrencySymbol());
            formatter.setNegativeSuffix(")");
            formatter.setPositivePrefix(settings.getCurrencySymbol());
            formatter.setPositiveSuffix(" ");
        } else {
            formatter.setNegativePrefix(settings.getCurrencySymbol() + " -");
            formatter.setNegativeSuffix(" ");
            formatter.setPositivePrefix(settings.getCurrencySymbol() + " ");
            formatter.setPositiveSuffix(" ");
        }
        return formatter.format(change / 100.0);
    }

    public static class LedgerEntry {
        private final LocalDate localDate;
        private final String description;
        private final double change;

        public LedgerEntry(String date, String description, double change) {
            this.localDate = LocalDate.parse(date);
            this.description = description;
            this.change = change;
        }

        public LocalDate getLocalDate() {
            return localDate;
        }

        public String getDescription() {
            return description;
        }

        public double getChange() {
            return change;
        }
    }

}
