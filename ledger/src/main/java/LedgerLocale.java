public class LedgerLocale {
    private String currencySymbol = "$";
    private String locale = "en-US";
    private String datePattern = "MM/dd/yyyy";
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
                header = "Date       | Description               | Change       ";
            }
            case "nl-NL" -> {
                this.locale = "nl-NL";
                datePattern = "dd/MM/yyyy";
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

    public String getHeader() {
        return header;
    }
}