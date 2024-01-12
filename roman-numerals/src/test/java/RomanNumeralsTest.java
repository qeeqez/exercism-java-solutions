import org.junit.jupiter.api.Test;

import org.junit.jupiter.api.Assertions;

public class RomanNumeralsTest {

    private RomanNumerals romanNumerals;

    @Test
    public void test1ToRomanNumberI() {
        romanNumerals = new RomanNumerals(1);
        Assertions.assertEquals("I", romanNumerals.getRomanNumeral());
    }

    @Test
    public void test2ToRomanNumberII() {
        romanNumerals = new RomanNumerals(2);
        Assertions.assertEquals("II", romanNumerals.getRomanNumeral());
    }

    @Test
    public void test3ToRomanNumberIII() {
        romanNumerals = new RomanNumerals(3);
        Assertions.assertEquals("III", romanNumerals.getRomanNumeral());
    }

    @Test
    public void test4ToRomanNumberIV() {
        romanNumerals = new RomanNumerals(4);
        Assertions.assertEquals("IV", romanNumerals.getRomanNumeral());
    }

    @Test
    public void test5ToRomanNumberV() {
        romanNumerals = new RomanNumerals(5);
        Assertions.assertEquals("V", romanNumerals.getRomanNumeral());
    }

    @Test
    public void test6ToRomanNumberVI() {
        romanNumerals = new RomanNumerals(6);
        Assertions.assertEquals("VI", romanNumerals.getRomanNumeral());
    }

    @Test
    public void test9ToRomanNumberIX() {
        romanNumerals = new RomanNumerals(9);
        Assertions.assertEquals("IX", romanNumerals.getRomanNumeral());
    }

    @Test
    public void test27ToRomanNumberXXVII() {
        romanNumerals = new RomanNumerals(27);
        Assertions.assertEquals("XXVII", romanNumerals.getRomanNumeral());
    }

    @Test
    public void test48ToRomanNumberXLVIII() {
        romanNumerals = new RomanNumerals(48);
        Assertions.assertEquals("XLVIII", romanNumerals.getRomanNumeral());
    }

    @Test
    public void test49ToRomanNumberXLIX() {
        romanNumerals = new RomanNumerals(49);
        Assertions.assertEquals("XLIX", romanNumerals.getRomanNumeral());
    }

    @Test
    public void test59ToRomanNumberLIX() {
        romanNumerals = new RomanNumerals(59);
        Assertions.assertEquals("LIX", romanNumerals.getRomanNumeral());
    }

    @Test
    public void test93ToRomanNumberXCIII() {
        romanNumerals = new RomanNumerals(93);
        Assertions.assertEquals("XCIII", romanNumerals.getRomanNumeral());
    }

    @Test
    public void test141ToRomanNumberCXLI() {
        romanNumerals = new RomanNumerals(141);
        Assertions.assertEquals("CXLI", romanNumerals.getRomanNumeral());
    }

    @Test
    public void test163ToRomanNumberCLXIII() {
        romanNumerals = new RomanNumerals(163);
        Assertions.assertEquals("CLXIII", romanNumerals.getRomanNumeral());
    }

    @Test
    public void test402ToRomanNumberCDII() {
        romanNumerals = new RomanNumerals(402);
        Assertions.assertEquals("CDII", romanNumerals.getRomanNumeral());
    }

    @Test
    public void test575ToRomanNumberDLXXV() {
        romanNumerals = new RomanNumerals(575);
        Assertions.assertEquals("DLXXV", romanNumerals.getRomanNumeral());
    }

    @Test
    public void test911ToRomanNumberCMXI() {
        romanNumerals = new RomanNumerals(911);
        Assertions.assertEquals("CMXI", romanNumerals.getRomanNumeral());
    }

    @Test
    public void test1024ToRomanNumberMXXIV() {
        romanNumerals = new RomanNumerals(1024);
        Assertions.assertEquals("MXXIV", romanNumerals.getRomanNumeral());
    }

    @Test
    public void test3000ToRomanNumberMMM() {
        romanNumerals = new RomanNumerals(3000);
        Assertions.assertEquals("MMM", romanNumerals.getRomanNumeral());
    }

}
