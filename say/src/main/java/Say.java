public class Say {

    public final String[] under_twenty = {"zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine", "ten",
            "eleven", "twelve", "thirteen", "fourteen", "fifteen", "sixteen", "seventeen",
            "eighteen", "nineteen"};
    public final String[] tens = {"twenty", "thirty", "forty", "fifty", "sixty", "seventy", "eighty", "ninety"};

    public String say(long number) {
        if (number < 0) throw new IllegalArgumentException("Number must be positive!");

        if (number < 20) return under_twenty[(int) number];
        if (number < 100 && number % 10 == 0) return tens[((int) number - 20) / 10];
        if (number < 100) return say(number / 10 * 10) + "-" + say(number % 10);

        if (number < 1_000) return suffix(number, 100, "hundred");
        if (number < 1_000_000) return suffix(number, 1_000, "thousand");
        if (number < 1_000_000_000) return suffix(number, 1_000_000, "million");
        if (number < 1_000_000_000_000L) return suffix(number, 1_000_000_000, "billion");

        throw new IllegalArgumentException("Large numbers not supported!");
    }

    private String suffix(long number, long modulo, String suffix) {
        var a = number / modulo;
        var b = number % modulo;
        if (b == 0) {
            return say(a) + " " + suffix;
        } else {
            return say(a) + " " + suffix + " " + say(b);
        }
    }
}
