import org.junit.jupiter.api.Test;

import org.assertj.core.api.Assertions;

public class ProverbTest {

    @Test
    public void zeroWordsAreGiven() {
        String[] words  = new String[0];

        Assertions.assertThat(new Proverb(words).recite()).isEqualTo("");
    }

    @Test
    public void singlePieceOfProverb() {
        String[] words  = new String[]{"nail"};

        Assertions.assertThat(new Proverb(words).recite())
            .isEqualTo("And all for the want of a nail.");
    }

    @Test
    public void twoPiecesOfProverb() {
        String[] words  = new String[]{"nail", "shoe"};

        Assertions.assertThat(new Proverb(words).recite())
            .isEqualTo(
                "For want of a nail the shoe was lost.\n" +
                "And all for the want of a nail.");
    }

    @Test
    public void shortChainOfConsequences() {
        String[] words  = new String[]{"nail", "shoe", "horse"};

        Assertions.assertThat(new Proverb(words).recite())
            .isEqualTo(
                    """
                            For want of a nail the shoe was lost.
                            For want of a shoe the horse was lost.
                            And all for the want of a nail.""");
    }

    @Test
    public void fullProverb() {
        String[] words  = new String[]{"nail", "shoe", "horse", "rider", "message", "battle", "kingdom"};

        Assertions.assertThat(new Proverb(words).recite())
            .isEqualTo(
                    """
                            For want of a nail the shoe was lost.
                            For want of a shoe the horse was lost.
                            For want of a horse the rider was lost.
                            For want of a rider the message was lost.
                            For want of a message the battle was lost.
                            For want of a battle the kingdom was lost.
                            And all for the want of a nail.""");
    }

    @Test
    public void fourPiecesModernizedProverb() {
        String[] words  = new String[]{"pin", "gun", "soldier", "battle"};

        Assertions.assertThat(new Proverb(words).recite())
            .isEqualTo(
                    """
                            For want of a pin the gun was lost.
                            For want of a gun the soldier was lost.
                            For want of a soldier the battle was lost.
                            And all for the want of a pin.""");
    }

}
