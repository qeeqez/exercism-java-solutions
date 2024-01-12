import org.junit.jupiter.api.Test;

import org.assertj.core.api.Assertions;

public class SayTest {

    private final Say say = new Say();
    
    @Test
    public void zero() {
        Assertions.assertThat(say.say(0)).isEqualTo("zero");
    }
    
    @Test
    public void one() {
        Assertions.assertThat(say.say(1)).isEqualTo("one");
    }

    @Test
    public void fourteen() {
        Assertions.assertThat(say.say(14)).isEqualTo("fourteen");
    }

    @Test
    public void twenty() {
        Assertions.assertThat(say.say(20)).isEqualTo("twenty");
    }

    @Test
    public void twentyTwo() {
        Assertions.assertThat(say.say(22)).isEqualTo("twenty-two");
    }

    @Test
    public void oneHundred() {
        Assertions.assertThat(say.say(100)).isEqualTo("one hundred");
    }

    @Test
    public void oneHundredTwentyThree() {
        Assertions.assertThat(say.say(123)).isEqualTo("one hundred twenty-three");
    }

    @Test
    public void oneThousand() {
        Assertions.assertThat(say.say(1_000)).isEqualTo("one thousand");
    }

    @Test
    public void oneThousandTwoHundredThirtyFour() {
        Assertions.assertThat(say.say(1_234)).isEqualTo("one thousand two hundred thirty-four");
    }

    @Test
    public void oneMillion() {
        Assertions.assertThat(say.say(1_000_000)).isEqualTo("one million");
    }
    
    @Test
    public void oneMillionTwoThousandThreeHundredFortyFive() {
        Assertions.assertThat(say.say(1_002_345)).isEqualTo("one million two thousand three hundred forty-five");
    }
    
    @Test
    public void oneBillion() {
        Assertions.assertThat(say.say(1_000_000_000)).isEqualTo("one billion");
    }
    
    @Test
    public void nineHundredEightySevenBillionSixHundredFiftyFourThreeHundredTwentyOneThousandOneHundredTwentyThree() {
        Assertions.assertThat(say.say(987_654_321_123L))
            .isEqualTo("nine hundred eighty-seven billion six hundred fifty-four million" + 
                       " three hundred twenty-one thousand one hundred twenty-three");
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void illegalNegativeNumber() {
        say.say(-1);
    }

    @Test(expected = IllegalArgumentException.class)
    public void illegalTooBigNumber() {
        say.say(1_000_000_000_000L);
    }    
}
