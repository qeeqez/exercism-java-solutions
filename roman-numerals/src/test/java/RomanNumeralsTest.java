import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class RomanNumeralsTest {

    private RomanNumerals romanNumerals;

    @Test
    public void test1ToRomanNumberI() {
        romanNumerals = new RomanNumerals(1);
        assertEquals("I", romanNumerals.getRomanNumeral());
    }

    @Test
    public void test2ToRomanNumberII() {
        romanNumerals = new RomanNumerals(2);
        assertEquals("II", romanNumerals.getRomanNumeral());
    }

    @Test
    public void test3ToRomanNumberIII() {
        romanNumerals = new RomanNumerals(3);
        assertEquals("III", romanNumerals.getRomanNumeral());
    }

    @Test
    public void test4ToRomanNumberIV() {
        romanNumerals = new RomanNumerals(4);
        assertEquals("IV", romanNumerals.getRomanNumeral());
    }

    @Test
    public void test5ToRomanNumberV() {
        romanNumerals = new RomanNumerals(5);
        assertEquals("V", romanNumerals.getRomanNumeral());
    }

    @Test
    public void test6ToRomanNumberVI() {
        romanNumerals = new RomanNumerals(6);
        assertEquals("VI", romanNumerals.getRomanNumeral());
    }

    @Test
    public void test9ToRomanNumberIX() {
        romanNumerals = new RomanNumerals(9);
        assertEquals("IX", romanNumerals.getRomanNumeral());
    }

    @Test
    public void test27ToRomanNumberXXVII() {
        romanNumerals = new RomanNumerals(27);
        assertEquals("XXVII", romanNumerals.getRomanNumeral());
    }

    @Test
    public void test48ToRomanNumberXLVIII() {
        romanNumerals = new RomanNumerals(48);
        assertEquals("XLVIII", romanNumerals.getRomanNumeral());
    }

    @Test
    public void test49ToRomanNumberXLIX() {
        romanNumerals = new RomanNumerals(49);
        assertEquals("XLIX", romanNumerals.getRomanNumeral());
    }

    @Test
    public void test59ToRomanNumberLIX() {
        romanNumerals = new RomanNumerals(59);
        assertEquals("LIX", romanNumerals.getRomanNumeral());
    }

    @Test
    public void test93ToRomanNumberXCIII() {
        romanNumerals = new RomanNumerals(93);
        assertEquals("XCIII", romanNumerals.getRomanNumeral());
    }

    @Test
    public void test141ToRomanNumberCXLI() {
        romanNumerals = new RomanNumerals(141);
        assertEquals("CXLI", romanNumerals.getRomanNumeral());
    }

    @Test
    public void test163ToRomanNumberCLXIII() {
        romanNumerals = new RomanNumerals(163);
        assertEquals("CLXIII", romanNumerals.getRomanNumeral());
    }

    @Test
    public void test402ToRomanNumberCDII() {
        romanNumerals = new RomanNumerals(402);
        assertEquals("CDII", romanNumerals.getRomanNumeral());
    }

    @Test
    public void test575ToRomanNumberDLXXV() {
        romanNumerals = new RomanNumerals(575);
        assertEquals("DLXXV", romanNumerals.getRomanNumeral());
    }

    @Test
    public void test911ToRomanNumberCMXI() {
        romanNumerals = new RomanNumerals(911);
        assertEquals("CMXI", romanNumerals.getRomanNumeral());
    }

    @Test
    public void test1024ToRomanNumberMXXIV() {
        romanNumerals = new RomanNumerals(1024);
        assertEquals("MXXIV", romanNumerals.getRomanNumeral());
    }

    @Test
    public void test3000ToRomanNumberMMM() {
        romanNumerals = new RomanNumerals(3000);
        assertEquals("MMM", romanNumerals.getRomanNumeral());
    }

}
