import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.Comparator;

public class Ledger {
    public LedgerEntry createLedgerEntry(String date, String description, int change) {
        return new LedgerEntry(date, description, change);
    }

    public String format(String currency, String locale, LedgerEntry[] entries) {
        LedgerLocale settings = new LedgerLocale(currency, locale);

        if (entries.length == 0) return settings.getHeader();

        StringBuilder output = new StringBuilder(settings.getHeader());

        Arrays.stream(entries)
                .sorted(Comparator.comparing(LedgerEntry::getChange))
                .sorted(Comparator.comparing(LedgerEntry::getLocalDate))
                .forEach(entry -> {
                    String date = formattedDate(entry.getLocalDate(), settings);
                    String desc = formattedDescription(entry.getDescription());
                    String amount = formattedAmount(entry.getChange(), settings);

                    output
                            .append("\n")
                            .append(String.format("%s | %-25s | %13s",
                                    date,
                                    desc,
                                    amount));
                });

        return output.toString();
    }

    private String formattedDate(LocalDate date, LedgerLocale settings) {
        return date.format(DateTimeFormatter.ofPattern(settings.getDatePattern()));
    }

    private String formattedDescription(String desc) {
        if (desc.length() > 25) {
            desc = desc.substring(0, 22);
            desc = desc + "...";
        }
        return desc;
    }

    private String formattedAmount(double change, LedgerLocale settings) {
        String converted = null;
        if (change < 0) {
            converted = String.format("%.02f", (change / 100) * -1);
        } else {
            converted = String.format("%.02f", change / 100);
        }

        String[] parts = converted.split("\\.");
        String amount = "";
        int count = 1;
        for (int ind = parts[0].length() - 1; ind >= 0; ind--) {
            if (((count % 3) == 0) && ind > 0) {
                amount = settings.getThousandSeparator() + parts[0].charAt(ind) + amount;
            } else {
                amount = parts[0].charAt(ind) + amount;
            }
            count++;
        }

        if (settings.getLocale().equals("nl-NL")) {
            amount = settings.getCurrencySymbol() + " " + amount + settings.getDecimalSeparator() + parts[1];
        } else {
            amount = settings.getCurrencySymbol() + amount + settings.getDecimalSeparator() + parts[1];
        }


        if (change < 0 && settings.getLocale().equals("en-US")) {
            amount = "(" + amount + ")";
        } else if (change < 0 && settings.getLocale().equals("nl-NL")) {
            amount = settings.getCurrencySymbol() + " -" + amount.replace(settings.getCurrencySymbol(), "").trim() + " ";
        } else if (settings.getLocale().equals("nl-NL")) {
            amount = " " + amount + " ";
        } else {
            amount = amount + " ";
        }

        return amount;
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

    public static class LedgerLocale {
        private String currencySymbol = "$";
        private String locale = "en-US";
        private String datePattern = "MM/dd/yyyy";
        private String decimalSeparator = ".";
        private String thousandSeparator = ",";
        private String header = "Date       | Description               | Change       ";

        public LedgerLocale(String currency, String locale) {
            setCurrency(currency);
            setLocale(locale);
        }

        private void setCurrency(String currency) {
            currencySymbol = switch (currency) {
                case "USD" -> "$";
                case "EUR" -> "€";
                default -> throw new IllegalArgumentException("Invalid currency");
            };
        }

        private void setLocale(String locale) {
            switch (locale) {
                case "en-US" -> {
                    this.locale = "en-US";
                    datePattern = "MM/dd/yyyy";
                    decimalSeparator = ".";
                    thousandSeparator = ",";
                    header = "Date       | Description               | Change       ";
                }
                case "nl-NL" -> {
                    this.locale = "nl-NL";
                    datePattern = "dd/MM/yyyy";
                    decimalSeparator = ",";
                    thousandSeparator = ".";
                    header = "Datum      | Omschrijving              | Verandering  ";
                }
                default -> throw new IllegalArgumentException("Invalid locale");
            }
        }

        public String getLocale() {
            return locale;
        }

        public String getCurrencySymbol() {
            return currencySymbol;
        }

        public String getDatePattern() {
            return datePattern;
        }

        public String getDecimalSeparator() {
            return decimalSeparator;
        }

        public String getThousandSeparator() {
            return thousandSeparator;
        }

        public String getHeader() {
            return header;
        }
    }

}
