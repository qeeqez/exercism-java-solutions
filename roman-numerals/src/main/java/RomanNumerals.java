public class RomanNumerals {

    private final String romanNumeral;


    RomanNumerals(int number) {
        romanNumeral = createRomanNumeral(number);
    }

    public String getRomanNumeral() {
        return romanNumeral;
    }

    private String createRomanNumeral(int number) {
        if (number >= 1000) return "M" + createRomanNumeral(number - 1000);
        else if (number >= 900) return "CM" + createRomanNumeral(number - 900);
        else if (number >= 500) return "D" + createRomanNumeral(number - 500);
        else if (number >= 400) return "CD" + createRomanNumeral(number - 400);
        else if (number >= 100) return "C" + createRomanNumeral(number - 100);
        else if (number >= 90) return "XC" + createRomanNumeral(number - 90);
        else if (number >= 50) return "L" + createRomanNumeral(number - 50);
        else if (number >= 40) return "XL" + createRomanNumeral(number - 40);
        else if (number >= 10) return "X" + createRomanNumeral(number - 10);
        else if (number == 9) return "IX";
        else if (number >= 5) return "V" + createRomanNumeral(number - 5);
        else if (number == 4) return "IV";
        else if (number >= 1) return "I" + createRomanNumeral(number - 1);
        else return "";
    }

}