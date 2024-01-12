import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import org.junit.jupiter.api.Assertions;

public class PigLatinTranslatorTest {

    private PigLatinTranslator pigLatinTranslator;

    @BeforeEach
    public void setup() {
        pigLatinTranslator = new PigLatinTranslator();
    }

    @Test
    public void testWordBeginningWithA() {
        Assertions.assertEquals("appleay", pigLatinTranslator.translate("apple"));
    }

    @Test
    public void testWordBeginningWithE() {
        Assertions.assertEquals("earay", pigLatinTranslator.translate("ear"));
    }

    @Test
    public void testWordBeginningWithI() {
        Assertions.assertEquals("iglooay", pigLatinTranslator.translate("igloo"));
    }

    @Test
    public void testWordBeginningWithO() {
        Assertions.assertEquals("objectay", pigLatinTranslator.translate("object"));
    }

    @Test
    public void testWordBeginningWithU() {
        Assertions.assertEquals("underay", pigLatinTranslator.translate("under"));
    }

    @Test
    public void testWordBeginningWithVowelAndFollowedByQu() {
        Assertions.assertEquals("equalay", pigLatinTranslator.translate("equal"));
    }

    @Test
    public void testWordBeginningWithP() {
        Assertions.assertEquals("igpay", pigLatinTranslator.translate("pig"));
    }

    @Test
    public void testWordBeginningWithK() {
        Assertions.assertEquals("oalakay", pigLatinTranslator.translate("koala"));
    }

    @Test
    public void testWordBeginningWithX() {
        Assertions.assertEquals("enonxay", pigLatinTranslator.translate("xenon"));
    }

    @Test
    public void testWordBeginningWithQWithoutAFollowingU() {
        Assertions.assertEquals("atqay", pigLatinTranslator.translate("qat"));
    }

    @Test
    public void testChTreatedLikeAConsonantAtTheBeginningOfAWord() {
        Assertions.assertEquals("airchay", pigLatinTranslator.translate("chair"));
    }

    @Test
    public void testQuTreatedLikeAConsonantAtTheBeginningOfAWord() {
        Assertions.assertEquals("eenquay", pigLatinTranslator.translate("queen"));
    }

    @Test
    public void testQuAndAPrecedingConsonantTreatedLikeAConsonantAtTheBeginningOfAWord() {
        Assertions.assertEquals("aresquay", pigLatinTranslator.translate("square"));
    }

    @Test
    public void testThTreatedLikeAConsonantAtTheBeginningOfAWord() {
        Assertions.assertEquals("erapythay", pigLatinTranslator.translate("therapy"));
    }

    @Test
    public void testThrTreatedLikeAConsonantAtTheBeginningOfAWord() {
        Assertions.assertEquals("ushthray", pigLatinTranslator.translate("thrush"));
    }

    @Test
    public void testSchTreatedLikeAConsonantAtTheBeginningOfAWord() {
        Assertions.assertEquals("oolschay", pigLatinTranslator.translate("school"));
    }

    @Test
    public void testYtTreatedLikeAVowelAtTheBeginningOfAWord() {
        Assertions.assertEquals("yttriaay", pigLatinTranslator.translate("yttria"));
    }

    @Test
    public void testXrTreatedLikeAVowelAtTheBeginningOfAWord() {
        Assertions.assertEquals("xrayay", pigLatinTranslator.translate("xray"));
    }

    @Test
    public void testYTreatedLikeAConsonantAtTheBeginningOfAWord() {
        Assertions.assertEquals("ellowyay", pigLatinTranslator.translate("yellow"));
    }

    @Test
    public void testYTreatedLikeAVowelAtTheEndOfAConsonantCluster() {
        Assertions.assertEquals("ythmrhay", pigLatinTranslator.translate("rhythm"));
    }

    @Test
    public void testYAsSecondLetterInTwoLetterWord() {
        Assertions.assertEquals("ymay", pigLatinTranslator.translate("my"));
    }

    @Test
    public void testAWholePhrase() {
        Assertions.assertEquals("ickquay astfay unray", pigLatinTranslator.translate("quick fast run"));
    }
}
