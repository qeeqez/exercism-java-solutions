import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import org.assertj.core.api.Assertions;

@SuppressWarnings("TextBlockMigration")
public class HouseTest {

    private House house;

    @BeforeEach
    public void setup() {
        house = new House();
    }

    @Test
    public void verseOne() {
        Assertions.assertThat(house.verse(1)).isEqualTo(
            "This is the house that Jack built.");
    }

    @Test
    public void verseTwo() {
        Assertions.assertThat(house.verse(2)).isEqualTo(
            "This is the malt " +
            "that lay in the house that Jack built."
        );
    }

    @Test
    public void verseThree() {
        Assertions.assertThat(house.verse(3)).isEqualTo(
            "This is the rat " +
            "that ate the malt " +
            "that lay in the house that Jack built.");
    }

    @Test
    public void verseFour() {
        Assertions.assertThat(house.verse(4)).isEqualTo(
            "This is the cat " +
            "that killed the rat " +
            "that ate the malt " +
            "that lay in the house that Jack built.");
    }

    @Test
    public void verseFive() {
        Assertions.assertThat(house.verse(5)).isEqualTo(
            "This is the dog " +
            "that worried the cat " +
            "that killed the rat " +
            "that ate the malt " +
            "that lay in the house that Jack built.");
    }

    @Test
    public void verseSix() {
        Assertions.assertThat(house.verse(6)).isEqualTo(
            "This is the cow with the crumpled horn " +
            "that tossed the dog " +
            "that worried the cat " +
            "that killed the rat " +
            "that ate the malt " +
            "that lay in the house that Jack built.");
    }

    @Test
    public void verseSeven() {
        Assertions.assertThat(house.verse(7)).isEqualTo(
            "This is the maiden all forlorn " +
            "that milked the cow with the crumpled horn " +
            "that tossed the dog " +
            "that worried the cat " +
            "that killed the rat " +
            "that ate the malt " +
            "that lay in the house that Jack built.");
    }

    @Test
    public void verseEight() {
        Assertions.assertThat(house.verse(8)).isEqualTo(
            "This is the man all tattered and torn " +
            "that kissed the maiden all forlorn " +
            "that milked the cow with the crumpled horn " +
            "that tossed the dog " +
            "that worried the cat " +
            "that killed the rat " +
            "that ate the malt " +
            "that lay in the house that Jack built.");
    }

    @Test
    public void verseNine() {
        Assertions.assertThat(house.verse(9)).isEqualTo(
            "This is the priest all shaven and shorn " +
            "that married the man all tattered and torn " +
            "that kissed the maiden all forlorn " +
            "that milked the cow with the crumpled horn " +
            "that tossed the dog " +
            "that worried the cat " +
            "that killed the rat " +
            "that ate the malt " +
            "that lay in the house that Jack built.");
    }

    @Test
    public void verse10() {
        Assertions.assertThat(house.verse(10)).isEqualTo(
            "This is the rooster that crowed in the morn " +
            "that woke the priest all shaven and shorn " +
            "that married the man all tattered and torn " +
            "that kissed the maiden all forlorn " +
            "that milked the cow with the crumpled horn " +
            "that tossed the dog " +
            "that worried the cat " +
            "that killed the rat " +
            "that ate the malt " +
            "that lay in the house that Jack built.");
    }

    @Test
    public void verse11() {
        Assertions.assertThat(house.verse(11)).isEqualTo(
            "This is the farmer sowing his corn " +
            "that kept the rooster that crowed in the morn " +
            "that woke the priest all shaven and shorn " +
            "that married the man all tattered and torn " +
            "that kissed the maiden all forlorn " +
            "that milked the cow with the crumpled horn " +
            "that tossed the dog " +
            "that worried the cat " +
            "that killed the rat " +
            "that ate the malt " +
            "that lay in the house that Jack built.");
    }

    @Test
    public void verse12() {
        Assertions.assertThat(house.verse(12)).isEqualTo(
            "This is the horse and the hound and the horn " +
            "that belonged to the farmer sowing his corn " +
            "that kept the rooster that crowed in the morn " +
            "that woke the priest all shaven and shorn " +
            "that married the man all tattered and torn " +
            "that kissed the maiden all forlorn " +
            "that milked the cow with the crumpled horn " +
            "that tossed the dog " +
            "that worried the cat " +
            "that killed the rat " +
            "that ate the malt " +
            "that lay in the house that Jack built.");
    }

    @Test
    public void multipleVerses() {
        int startVerse = 4;
        int endVerse = 8;

        Assertions.assertThat(house.verses(startVerse, endVerse)).isEqualTo(
            "This is the cat " +
            "that killed the rat " +
            "that ate the malt " +
            "that lay in the house that Jack built.\n" +
            "This is the dog " +
            "that worried the cat " +
            "that killed the rat " +
            "that ate the malt " +
            "that lay in the house that Jack built.\n" +
            "This is the cow with the crumpled horn " +
            "that tossed the dog " +
            "that worried the cat " +
            "that killed the rat " +
            "that ate the malt " +
            "that lay in the house that Jack built.\n" +
            "This is the maiden all forlorn " +
            "that milked the cow with the crumpled horn " +
            "that tossed the dog " +
            "that worried the cat " +
            "that killed the rat " +
            "that ate the malt " +
            "that lay in the house that Jack built.\n" +
            "This is the man all tattered and torn " +
            "that kissed the maiden all forlorn " +
            "that milked the cow with the crumpled horn " +
            "that tossed the dog " +
            "that worried the cat " +
            "that killed the rat " +
            "that ate the malt " +
            "that lay in the house that Jack built.");
    }

    @Test
    public void wholeRhyme() {
        Assertions.assertThat(house.sing()).isEqualTo(
            "This is the house that Jack built.\n" +
            "This is the malt " +
            "that lay in the house that Jack built.\n" +
            "This is the rat " +
            "that ate the malt " +
            "that lay in the house that Jack built.\n" +
            "This is the cat " +
            "that killed the rat " +
            "that ate the malt " +
            "that lay in the house that Jack built.\n" +
            "This is the dog " +
            "that worried the cat " +
            "that killed the rat " +
            "that ate the malt " +
            "that lay in the house that Jack built.\n" +
            "This is the cow with the crumpled horn " +
            "that tossed the dog " +
            "that worried the cat " +
            "that killed the rat " +
            "that ate the malt " +
            "that lay in the house that Jack built.\n" +
            "This is the maiden all forlorn " +
            "that milked the cow with the crumpled horn " +
            "that tossed the dog " +
            "that worried the cat " +
            "that killed the rat " +
            "that ate the malt " +
            "that lay in the house that Jack built.\n" +
            "This is the man all tattered and torn " +
            "that kissed the maiden all forlorn " +
            "that milked the cow with the crumpled horn " +
            "that tossed the dog " +
            "that worried the cat " +
            "that killed the rat " +
            "that ate the malt " +
            "that lay in the house that Jack built.\n" +
            "This is the priest all shaven and shorn " +
            "that married the man all tattered and torn " +
            "that kissed the maiden all forlorn " +
            "that milked the cow with the crumpled horn " +
            "that tossed the dog " +
            "that worried the cat " +
            "that killed the rat " +
            "that ate the malt " +
            "that lay in the house that Jack built.\n" +
            "This is the rooster that crowed in the morn " +
            "that woke the priest all shaven and shorn " +
            "that married the man all tattered and torn " +
            "that kissed the maiden all forlorn " +
            "that milked the cow with the crumpled horn " +
            "that tossed the dog " +
            "that worried the cat " +
            "that killed the rat " +
            "that ate the malt " +
            "that lay in the house that Jack built.\n" +
            "This is the farmer sowing his corn " +
            "that kept the rooster that crowed in the morn " +
            "that woke the priest all shaven and shorn " +
            "that married the man all tattered and torn " +
            "that kissed the maiden all forlorn " +
            "that milked the cow with the crumpled horn " +
            "that tossed the dog " +
            "that worried the cat " +
            "that killed the rat " +
            "that ate the malt " +
            "that lay in the house that Jack built.\n" +
            "This is the horse and the hound and the horn " +
            "that belonged to the farmer sowing his corn " +
            "that kept the rooster that crowed in the morn " +
            "that woke the priest all shaven and shorn " +
            "that married the man all tattered and torn " +
            "that kissed the maiden all forlorn " +
            "that milked the cow with the crumpled horn " +
            "that tossed the dog " +
            "that worried the cat " +
            "that killed the rat " +
            "that ate the malt " +
            "that lay in the house that Jack built.");
    }
}
