import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import org.assertj.core.api.Assertions;


public class BlackjackTest {

    private Blackjack blackjack;

    @BeforeEach
    public void setUp() {
        blackjack = new Blackjack();
    }

    @Test
    public void correctParsesAce () {
        Assertions.assertThat(blackjack.parseCard("ace")).isEqualTo(11);
    }

    @Test
    public void correctParsesTwo () {
        Assertions.assertThat(blackjack.parseCard("two")).isEqualTo(2);
    }

    @Test
    public void correctParsesThree () {
        Assertions.assertThat(blackjack.parseCard("three")).isEqualTo(3);
    }

    @Test
    public void correctParsesFour () {
        Assertions.assertThat(blackjack.parseCard("four")).isEqualTo(4);
    }

    @Test
    public void correctParsesFive () {
        Assertions.assertThat(blackjack.parseCard("five")).isEqualTo(5);
    }

    @Test
    public void correctParsesSix () {
        Assertions.assertThat(blackjack.parseCard("six")).isEqualTo(6);
    }

    @Test
    public void correctParsesSeven () {
        Assertions.assertThat(blackjack.parseCard("seven")).isEqualTo(7);
    }

    @Test
    public void correctParsesEight () {
        Assertions.assertThat(blackjack.parseCard("eight")).isEqualTo(8);
    }

    @Test
    public void correctParsesNine () {
        Assertions.assertThat(blackjack.parseCard("nine")).isEqualTo(9);
    }

    @Test
    public void correctParsesTen () {
        Assertions.assertThat(blackjack.parseCard("ten")).isEqualTo(10);
    }

    @Test
    public void correctParsesJack () {
        Assertions.assertThat(blackjack.parseCard("jack")).isEqualTo(10);
    }

    @Test
    public void correctParsesQueen () {
        Assertions.assertThat(blackjack.parseCard("queen")).isEqualTo(10);
    }

    @Test
    public void correctParsesKing () {
        Assertions.assertThat(blackjack.parseCard("king")).isEqualTo(10);
    }
    
    @Test
    public void blackjackWithTenAceSecond() {
        Assertions.assertThat(blackjack.isBlackjack("ten", "ace")).isEqualTo(true);
    }
    
    @Test
    public void blackjackWithJackAceSecond() {
        Assertions.assertThat(blackjack.isBlackjack("jack", "ace")).isEqualTo(true);
    }
    
    @Test
    public void blackjackWithQueenAceSecond() {
        Assertions.assertThat(blackjack.isBlackjack("queen", "ace")).isEqualTo(true);
    }
    
    @Test
    public void blackjackWithKingAceSecond() {
        Assertions.assertThat(blackjack.isBlackjack("king", "ace")).isEqualTo(true);
    }   
    
    
    @Test
    public void noBlackjackWithFive() {
        Assertions.assertThat(blackjack.isBlackjack("ace", "five")).isEqualTo(false);
    }
    
    @Test
    public void noBlackjackWithNine() {
        Assertions.assertThat(blackjack.isBlackjack("ace", "nine")).isEqualTo(false);
    }
    
    @Test
    public void noBlackjackWithTwoAces() {
        Assertions.assertThat(blackjack.isBlackjack("ace", "ace")).isEqualTo(false);
    }
    
    @Test
    public void noBlackjackWithTwoFigures() {
        Assertions.assertThat(blackjack.isBlackjack("queen", "jack")).isEqualTo(false);
    }
    
    @Test
    public void noBlackjackWithKingAndFive() {
        Assertions.assertThat(blackjack.isBlackjack("king", "five")).isEqualTo(false);
    }
    
    @Test
    public void noBlackjackWithEightAndFive() {
        Assertions.assertThat(blackjack.isBlackjack("eight", "five")).isEqualTo(false);
    }
    
    @Test
    public void firstTurnWithAceAceAndDealerAce () {
        Assertions.assertThat(blackjack.firstTurn("ace", "ace", "ace")).isEqualTo("P");
    }
    
    @Test
    public void firstTurnWithJackJackAndDealerAce () {
        Assertions.assertThat(blackjack.firstTurn("jack", "jack", "ace")).isEqualTo("S");
    }
    
    @Test
    public void firstTurnWithKingKingAndDealerAce () {
        Assertions.assertThat(blackjack.firstTurn("king", "king", "ace")).isEqualTo("S");
    }

    @Test
    public void firstTurnWithTwoTwoAndDealerAce () {
        Assertions.assertThat(blackjack.firstTurn("two", "two", "ace")).isEqualTo("H");
    }

    @Test
    public void firstTurnWithFiveFiveAndAce () {
        Assertions.assertThat(blackjack.firstTurn("five", "five", "ace")).isEqualTo("H");
    }

    @Test
    public void firstTurnWithJackAceAndDealerAce () {
        Assertions.assertThat(blackjack.firstTurn("jack", "ace", "ace")).isEqualTo("S");
    }

    @Test
    public void firstTurnWithAceKingAndDealerQueen () {
        Assertions.assertThat(blackjack.firstTurn("ace", "king", "queen")).isEqualTo("S");
    }

    @Test
    public void firstTurnWithTenAceAndDealerFive () {
        Assertions.assertThat(blackjack.firstTurn("ten", "ace", "five")).isEqualTo("W");
    }

    @Test
    public void firstTurnWithKingAceAndDealerNine () {
        Assertions.assertThat(blackjack.firstTurn("king", "ace", "nine")).isEqualTo("W");
    }

    @Test
    public void firstTurnWithKingTenAndDealerAce () {
        Assertions.assertThat(blackjack.firstTurn("king", "ten", "ace")).isEqualTo("S");
    }

    @Test
    public void firstTurnWithNineTenAndDealerAce () {
        Assertions.assertThat(blackjack.firstTurn("nine", "ten", "ace")).isEqualTo("S");
    }

    @Test
    public void firstTurnWithEightTenAndDealerAce () {
        Assertions.assertThat(blackjack.firstTurn("eight", "ten", "ace")).isEqualTo("S");
    }

    @Test
    public void firstTurnWithKingSevenAndDealerAce () {
        Assertions.assertThat(blackjack.firstTurn("king", "seven", "ace")).isEqualTo("S");
    }

    @Test
    public void firstTurnWithSixTenAndDealerSix () {
        Assertions.assertThat(blackjack.firstTurn("six", "ten", "six")).isEqualTo("S");
    }

    @Test
    public void firstTurnWithSixTenAndDealerSeven () {
        Assertions.assertThat(blackjack.firstTurn("six", "ten", "seven")).isEqualTo("H");
    }

    @Test
    public void firstTurnWithSixTenAndDealerAce () {
        Assertions.assertThat(blackjack.firstTurn("six", "ten", "ace")).isEqualTo("H");
    }

    @Test
    public void firstTurnWithFiveTenAndDealerSix () {
        Assertions.assertThat(blackjack.firstTurn("five", "ten", "six")).isEqualTo("S");
    }

    @Test
    public void firstTurnWithFiveTenAndDealerSeven () {
        Assertions.assertThat(blackjack.firstTurn("five", "ten", "seven")).isEqualTo("H");
    }

    @Test
    public void firstTurnWithFiveTenAndDealerKing () {
        Assertions.assertThat(blackjack.firstTurn("five", "ten", "king")).isEqualTo("H");
    }

    @Test
    public void firstTurnWithFourTenAndDealerSix () {
        Assertions.assertThat(blackjack.firstTurn("four", "ten", "six")).isEqualTo("S");
    }

    @Test
    public void firstTurnWithFourTenAndDealerSeven () {
        Assertions.assertThat(blackjack.firstTurn("four", "ten", "seven")).isEqualTo("H");
    }

    @Test
    public void firstTurnWithFourTenAndDealerQueen () {
        Assertions.assertThat(blackjack.firstTurn("four", "ten", "queen")).isEqualTo("H");
    }

    @Test
    public void firstTurnWithThreeTenAndDealerSix () {
        Assertions.assertThat(blackjack.firstTurn("three", "ten", "six")).isEqualTo("S");
    }

    @Test
    public void firstTurnWithThreeTenAndDealerSeven () {
        Assertions.assertThat(blackjack.firstTurn("three", "ten", "seven")).isEqualTo("H");
    }

    @Test
    public void firstTurnWithThreeTenAndDealerQueen () {
        Assertions.assertThat(blackjack.firstTurn("three", "ten", "queen")).isEqualTo("H");
    }

    @Test
    public void firstTurnWithTwoTenAndDealerSix () {
        Assertions.assertThat(blackjack.firstTurn("two", "ten", "six")).isEqualTo("S");
    }

    @Test
    public void firstTurnWithTwoTenAndDealerSeven () {
        Assertions.assertThat(blackjack.firstTurn("two", "ten", "seven")).isEqualTo("H");
    }

    @Test
    public void firstTurnWithTwoTenAndDealerQueen () {
        Assertions.assertThat(blackjack.firstTurn("two", "ten", "queen")).isEqualTo("H");
    }

    @Test
    public void firstTurnWithTwoNineAndDealerQueen () {
        Assertions.assertThat(blackjack.firstTurn("two", "nine", "queen")).isEqualTo("H");
    }

    @Test
    public void firstTurnWithTwoEightAndDealerTwo () {
        Assertions.assertThat(blackjack.firstTurn("two", "eight", "two")).isEqualTo("H");
    }

    @Test
    public void firstTurnWithTwoThreeAndDealerQueen () {
        Assertions.assertThat(blackjack.firstTurn("two", "three", "queen")).isEqualTo("H");
    }

    @Test
    public void firstTurnWithTwoTwoAndDealerFive () {
        Assertions.assertThat(blackjack.firstTurn("two", "two", "five")).isEqualTo("H");
    }

}
