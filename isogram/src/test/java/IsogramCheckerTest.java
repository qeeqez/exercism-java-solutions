import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import org.assertj.core.api.Assertions;

public class IsogramCheckerTest {
    private IsogramChecker isogramChecker;
    
    @BeforeEach
    public void setUp() {
        isogramChecker = new IsogramChecker();
    }

    @Test
    public void testEmptyString() {
        Assertions.assertThat(isogramChecker.isIsogram("")).isTrue();
    }

    @Test
    public void testLowercaseIsogram() {
        Assertions.assertThat(isogramChecker.isIsogram("isogram")).isTrue();
    }

    @Test
    public void testNotIsogram() {
        Assertions.assertThat(isogramChecker.isIsogram("eleven")).isFalse();
    }

    @Test
    public void testDuplicateEndAlphabet() {
        Assertions.assertThat(isogramChecker.isIsogram("zzyzx")).isFalse();
    }

    @Test
    public void testMediumLongIsogram() {
        Assertions.assertThat(isogramChecker.isIsogram("subdermatoglyphic")).isTrue();
    }

    @Test
    public void testCaseInsensitive() {
        Assertions.assertThat(isogramChecker.isIsogram("Alphabet")).isFalse();
    }

    @Test
    public void testDuplicatMixedCase() {
        Assertions.assertThat(isogramChecker.isIsogram("alphAbet")).isFalse();
    }

    @Test
    public void testIsogramWithHyphen() {
        Assertions.assertThat(isogramChecker.isIsogram("thumbscrew-japingly")).isTrue();
    }

    @Test
    public void testIsogramWithDuplicatedCharAfterHyphen() {
        Assertions.assertThat(isogramChecker.isIsogram("thumbscrew-jappingly")).isFalse();
    }

    @Test
    public void testIsogramWithDuplicatedHyphen() {
        Assertions.assertThat(isogramChecker.isIsogram("six-year-old")).isTrue();
    }

    @Test
    public void testMadeUpNameThatIsAnIsogram() {
        Assertions.assertThat(isogramChecker.isIsogram("Emily Jung Schwartzkopf")).isTrue();
    }

    @Test
    public void testDuplicatedCharacterInTheMiddleIsNotIsogram() {
        Assertions.assertThat(isogramChecker.isIsogram("accentor")).isFalse();
    }

    @Test
    public void testSameFirstAndLast() {
        Assertions.assertThat(new IsogramChecker().isIsogram("angola")).isFalse();
    }

}
