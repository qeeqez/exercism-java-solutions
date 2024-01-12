import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class AcronymTest {

    @Test
    public void basic() {
        Assertions.assertThat(new Acronym("Portable Network Graphics").get())
                .isEqualTo("PNG");
    }

    @Test
    public void lowercaseWords() {
        Assertions.assertThat(new Acronym("Ruby on Rails").get())
                .isEqualTo("ROR");
    }

    @Test
    public void punctuation() {
        Assertions.assertThat(new Acronym("First In, First Out").get())
                .isEqualTo("FIFO");
    }

    @Test
    public void nonAcronymAllCapsWord() {
        Assertions.assertThat(new Acronym("GNU Image Manipulation Program").get())
                .isEqualTo("GIMP");
    }

    @Test
    public void punctuationWithoutWhitespace() {
        Assertions.assertThat(new Acronym("Complementary metal-oxide semiconductor").get())
                .isEqualTo("CMOS");
    }

    @Test
    public void veryLongAbbreviation() {
        Assertions.assertThat(new Acronym("Rolling On The Floor Laughing So Hard That My Dogs Came Over And Licked Me").get())
                .isEqualTo("ROTFLSHTMDCOALM");
    }

    @Test
    public void consecutiveDelimiters() {
        Assertions.assertThat(new Acronym("Something - I made up from thin air").get())
                .isEqualTo("SIMUFTA");
    }

    @Test
    public void apostrophes() {
        Assertions.assertThat(new Acronym("Halley's Comet").get())
                .isEqualTo("HC");
    }

    @Test
    public void underscoreEmphasis() {
        Assertions.assertThat(new Acronym("The Road _Not_ Taken").get())
                .isEqualTo("TRNT");
    }


}
