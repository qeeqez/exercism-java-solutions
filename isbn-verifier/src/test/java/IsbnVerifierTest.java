import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import org.assertj.core.api.Assertions;

public class IsbnVerifierTest {
    private IsbnVerifier isbnVerifier;

    @BeforeEach
    public void setUp() {
        isbnVerifier = new IsbnVerifier();
    }

    @Test
    public void validIsbnNumber() {
        Assertions.assertThat(isbnVerifier.isValid("3-598-21508-8")).isTrue();
    }

    @Test
    public void invalidIsbnCheckDigit() {
        Assertions.assertThat(isbnVerifier.isValid("3-598-21508-9")).isFalse();
    }

    @Test
    public void validIsbnNumberWithCheckDigitOfTen() {
        Assertions.assertThat(isbnVerifier.isValid("3-598-21507-X")).isTrue();
    }

    @Test
    public void validIsbnNumberWithCheckDigitPaddedWithLettersIsInvalid() {
        Assertions.assertThat(isbnVerifier.isValid("ABCDEFG3-598-21507-XQWERTYUI")).isFalse();
    }

    @Test
    public void checkDigitIsACharacterOtherThanX() {
        Assertions.assertThat(isbnVerifier.isValid("3-598-21507-A")).isFalse();
    }

    @Test
    public void invalidCharacterInIsbn() {
        Assertions.assertThat(isbnVerifier.isValid("3-598-P1581-X")).isFalse();
    }

    @Test
    public void xIsOnlyValidAsACheckDigit() {
        Assertions.assertThat(isbnVerifier.isValid("3-598-2X507-9")).isFalse();
    }

    @Test
    public void validIsbnWithoutSeparatingDashes() {
        Assertions.assertThat(isbnVerifier.isValid("3598215088")).isTrue();
    }

    @Test
    public void isbnWithoutSeparatingDashesAndXAsCheckDigit() {
        Assertions.assertThat(isbnVerifier.isValid("359821507X")).isTrue();
    }

    @Test
    public void isbnWithoutCheckDigitAndDashes() {
        Assertions.assertThat(isbnVerifier.isValid("359821507")).isFalse();
    }

    @Test
    public void tooLongIsbnAndNoDashes() {
        Assertions.assertThat(isbnVerifier.isValid("3598215078X")).isFalse();
    }

    @Test
    public void tooShortIsbn() {
        Assertions.assertThat(isbnVerifier.isValid("00")).isFalse();
    }

    @Test
    public void isbnWithoutCheckDigit() {
        Assertions.assertThat(isbnVerifier.isValid("3-598-21507")).isFalse();
    }

    @Test
    public void checkDigitOfXShouldNotBeUsedForZero() {
        Assertions.assertThat(isbnVerifier.isValid("3-598-21515-X")).isFalse();
    }

    @Test
    public void emptyIsbn() {
        Assertions.assertThat(isbnVerifier.isValid("")).isFalse();
    }

    @Test
    public void inputIsNineCharacters() {
        Assertions.assertThat(isbnVerifier.isValid("134456729")).isFalse();
    }

    @Test
    public void invalidCharactersAreNotIgnored() {
        Assertions.assertThat(isbnVerifier.isValid("3132P34035")).isFalse();
    }

    @Test
    public void inputIsTooLongButContainsAValidIsbn() {
        Assertions.assertThat(isbnVerifier.isValid("98245726788")).isFalse();
    }
}
