import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class LuhnValidatorTest {
    private LuhnValidator luhnValidator;

    @BeforeEach
    public void setUp() {
        luhnValidator = new LuhnValidator();
    }

    @Test
    public void testSingleDigitStringInvalid() {
        Assertions.assertFalse(luhnValidator.isValid("1"));
    }

    @Test
    public void testSingleZeroIsInvalid() {
        Assertions.assertFalse(luhnValidator.isValid("0"));
    }

    @Test
    public void testSimpleValidSINReversedRemainsValid() {
        Assertions.assertTrue(luhnValidator.isValid("059"));
    }

    @Test
    public void testSimpleValidSINReversedBecomesInvalid() {
        Assertions.assertTrue(luhnValidator.isValid("59"));
    }

    @Test
    public void testValidCanadianSINValid() {
        Assertions.assertTrue(luhnValidator.isValid("055 444 285"));
    }

    @Test
    public void testInvalidCanadianSINInvalid() {
        Assertions.assertFalse(luhnValidator.isValid("055 444 286"));
    }

    @Test
    public void testInvalidCreditCardInvalid() {
        Assertions.assertFalse(luhnValidator.isValid("8273 1232 7352 0569"));
    }

    @Test
    public void testInvalidLongNumberWithAnEvenRemainder() {
        Assertions.assertFalse(luhnValidator.isValid("1 2345 6789 1234 5678 9012"));
    }

    @Test
    public void testValidNumberWithAnEvenNumberOfDigits() {
        Assertions.assertTrue(luhnValidator.isValid("095 245 88"));
    }

    @Test
    public void testValidNumberWithAnOddNumberOfSpaces() {
        Assertions.assertTrue(luhnValidator.isValid("234 567 891 234"));
    }

    @Test
    public void testValidStringsWithANonDigitAtEndInvalid() {
        Assertions.assertFalse(luhnValidator.isValid("059a"));
    }

    @Test
    public void testStringContainingPunctuationInvalid() {
        Assertions.assertFalse(luhnValidator.isValid("055-444-285"));
    }

    @Test
    public void testStringContainingSymbolsInvalid() {
        Assertions.assertFalse(luhnValidator.isValid("055# 444$ 285"));
    }

    @Test
    public void testSingleSpaceWithZeroInvalid() {
        Assertions.assertFalse(luhnValidator.isValid(" 0"));
    }

    @Test
    public void testMoreThanSingleZeroValid() {
        Assertions.assertTrue(luhnValidator.isValid("0000 0"));
    }

    @Test
    public void testDigitNineConvertedToOutputNine() {
        Assertions.assertTrue(luhnValidator.isValid("091"));
    }


    @Test
    public void testUsingASCIIValueForNonDoubledNonDigitNotAllowed() {
        Assertions.assertFalse(luhnValidator.isValid("055b 444 285"));
    }

    @Test
    public void testUsingASCIIValueForDoubledNonDigitNotAllowed() {
        Assertions.assertFalse(luhnValidator.isValid(":9"));
    }

    /* The following test diverges from the canonical test data. This is because the corresponding canonical test does
     * not account for Java specific functions (such as Character.getNumericValue()), which can be part of incorrect yet
     * passing implementations. For more detail, check out issue #972 here:
     * (https://github.com/exercism/java/issues/972).
    */
    @Test
    public void testStringContainingSymbolsInvalidJavaTrackSpecific() {
        Assertions.assertFalse(luhnValidator.isValid("85&"));
    }
}
