import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class Ledger {
    public LedgerEntry createLedgerEntry(String date, String description, int change) {
        return new LedgerEntry(date, description, change);
    }

    public String format(String currency, String locale, LedgerEntry[] entries) {
        LedgerLocale settings = new LedgerLocale(currency, locale);

        String output = settings.getHeader();

        if (entries.length > 0) {
            List<LedgerEntry> neg = new ArrayList<>();
            List<LedgerEntry> pos = new ArrayList<>();
            for (int i = 0; i < entries.length; i++) {
                LedgerEntry e = entries[i];
                if (e.getChange() >= 0) {
                    pos.add(e);
                } else {
                    neg.add(e);
                }
            }

            neg.sort((o1, o2) -> o1.getLocalDate().compareTo(o2.getLocalDate()));
            pos.sort((o1, o2) -> o1.getLocalDate().compareTo(o2.getLocalDate()));

            List<LedgerEntry> all = new ArrayList<>();
            all.addAll(neg);
            all.addAll(pos);

            for (int i = 0; i < all.size(); i++) {
                LedgerEntry e = all.get(i);

                String date = e.getLocalDate().format(DateTimeFormatter.ofPattern(settings.getDatePattern()));

                String desc = e.getDescription();
                if (desc.length() > 25) {
                    desc = desc.substring(0, 22);
                    desc = desc + "...";
                }

                String converted = null;
                if (e.getChange() < 0) {
                    converted = String.format("%.02f", (e.getChange() / 100) * -1);
                } else {
                    converted = String.format("%.02f", e.getChange() / 100);
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

                if (locale.equals("nl-NL")) {
                    amount = settings.getCurrencySymbol() + " " + amount + settings.getDecimalSeparator() + parts[1];
                } else {
                    amount = settings.getCurrencySymbol() + amount + settings.getDecimalSeparator() + parts[1];
                }


                if (e.getChange() < 0 && locale.equals("en-US")) {
                    amount = "(" + amount + ")";
                } else if (e.getChange() < 0 && locale.equals("nl-NL")) {
                    amount = settings.getCurrencySymbol() + " -" + amount.replace(settings.getCurrencySymbol(), "").trim() + " ";
                } else if (locale.equals("nl-NL")) {
                    amount = " " + amount + " ";
                } else {
                    amount = amount + " ";
                }

                output = output + "\n";
                output = output + String.format("%s | %-25s | %13s",
                        date,
                        desc,
                        amount);
            }

        }

        return output;
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
                    datePattern = "MM/dd/yyyy";
                    decimalSeparator = ".";
                    thousandSeparator = ",";
                    header = "Date       | Description               | Change       ";
                }
                case "nl-NL" -> {
                    datePattern = "dd/MM/yyyy";
                    decimalSeparator = ",";
                    thousandSeparator = ".";
                    header = "Datum      | Omschrijving              | Verandering  ";
                }
                default -> throw new IllegalArgumentException("Invalid locale");
            }
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
