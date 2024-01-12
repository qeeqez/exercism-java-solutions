import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;

public class BobTest {
    private Bob bob;

    @BeforeEach
    public void setUp() {
        bob = new Bob();
    }

    @Test
    public void saySomething() {
        Assertions.assertThat(bob.hey("Tom-ay-to, tom-aaaah-to."))
                .isEqualTo("Whatever.");
    }

    @Test
    public void shouting() {
        Assertions.assertThat(bob.hey("WATCH OUT!"))
                .isEqualTo("Whoa, chill out!");
    }

    @Test
    public void shoutingGibberish() {
        Assertions.assertThat(bob.hey("FCECDFCAAB"))
                .isEqualTo("Whoa, chill out!");
    }

    @Test
    public void askingAQuestion() {
        Assertions.assertThat(bob.hey("Does this cryogenic chamber make me look fat?"))
                .isEqualTo("Sure.");
    }

    @Test
    public void askingANumericQuestion() {
        Assertions.assertThat(bob.hey("You are, what, like 15?"))
                .isEqualTo("Sure.");
    }

    @Test
    public void askingGibberish() {
        Assertions.assertThat(bob.hey("fffbbcbeab?"))
                .isEqualTo("Sure.");
    }

    @Test
    public void talkingForcefully() {
        Assertions.assertThat(bob.hey("Hi there!"))
                .isEqualTo("Whatever.");
    }

    @Test
    public void usingAcronymsInRegularSpeech() {
        Assertions.assertThat(bob.hey("It's OK if you don't want to go work for NASA."))
                .isEqualTo("Whatever.");
    }

    @Test
    public void forcefulQuestions() {
        Assertions.assertThat(bob.hey("WHAT'S GOING ON?"))
                .isEqualTo("Calm down, I know what I'm doing!");
    }

    @Test
    public void shoutingNumbers() {
        Assertions.assertThat(bob.hey("1, 2, 3 GO!"))
                .isEqualTo("Whoa, chill out!");
    }

    @Test
    public void onlyNumbers() {
        Assertions.assertThat(bob.hey("1, 2, 3"))
                .isEqualTo("Whatever.");
    }

    @Test
    public void questionWithOnlyNumbers() {
        Assertions.assertThat(bob.hey("4?"))
                .isEqualTo("Sure.");
    }

    @Test
    public void shoutingWithSpecialCharacters() {
        Assertions.assertThat(bob.hey("ZOMG THE %^*@#$(*^ ZOMBIES ARE COMING!!11!!1!"))
                .isEqualTo("Whoa, chill out!");
    }

    @Test
    public void shoutingWithNoExclamationMark() {
        Assertions.assertThat(bob.hey("I HATE THE DENTIST"))
                .isEqualTo("Whoa, chill out!");
    }

    @Test
    public void statementContainingQuestionMark() {
        Assertions.assertThat(bob.hey("Ending with ? means a question."))
                .isEqualTo("Whatever.");
    }

    @Test
    public void nonLettersWithQuestion() {
        Assertions.assertThat(bob.hey(":) ?"))
                .isEqualTo("Sure.");
    }

    @Test
    public void prattlingOn() {
        Assertions.assertThat(bob.hey("Wait! Hang on. Are you going to be OK?"))
                .isEqualTo("Sure.");
    }

    @Test
    public void silence() {
        Assertions.assertThat(bob.hey(""))
                .isEqualTo("Fine. Be that way!");
    }

    @Test
    public void prolongedSilence() {
        Assertions.assertThat(bob.hey("          "))
                .isEqualTo("Fine. Be that way!");
    }

    @Test
    public void alternateSilence() {
        Assertions.assertThat(bob.hey("\t\t\t\t\t\t\t\t\t\t"))
                .isEqualTo("Fine. Be that way!");
    }

    @Test
    public void multipleLineQuestion() {
        Assertions.assertThat(bob.hey("\nDoes this cryogenic chamber make me look fat?\nNo."))
                .isEqualTo("Whatever.");
    }

    @Test
    public void startingWithWhitespace() {
        Assertions.assertThat(bob.hey("         hmmmmmmm..."))
                .isEqualTo("Whatever.");
    }

    @Test
    public void endingWithWhiteSpace() {
        Assertions.assertThat(bob.hey("Okay if like my  spacebar  quite a bit?   "))
                .isEqualTo("Sure.");
    }

    @Test
    public void otherWhiteSpace() {
        Assertions.assertThat(bob.hey("\n\r \t"))
                .isEqualTo("Fine. Be that way!");
    }

    @Test
    public void nonQuestionEndingWithWhiteSpace() {
        Assertions.assertThat(bob.hey("This is a statement ending with whitespace      "))
                .isEqualTo("Whatever.");
    }

}
