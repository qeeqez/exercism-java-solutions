import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class RotationalCipherTest {

    private RotationalCipher rotationalCipher;

    @Test
    public void rotateSingleCharacterBy0() {
        rotationalCipher = new RotationalCipher(0);
        Assertions.assertEquals("a", rotationalCipher.rotate("a"));
    }

    @Test
    public void rotateSingleCharacterBy1() {
        rotationalCipher = new RotationalCipher(1);
        Assertions.assertEquals("b", rotationalCipher.rotate("a"));
    }

    @Test
    public void rotateSingleCharacterBy26() {
        rotationalCipher = new RotationalCipher(26);
        Assertions.assertEquals("a", rotationalCipher.rotate("a"));
    }

    @Test
    public void rotateSingleCharacterBy13() {
        rotationalCipher = new RotationalCipher(13);
        Assertions.assertEquals("z", rotationalCipher.rotate("m"));
    }

    @Test
    public void rotateSingleCharacterWithWrapAround() {
        rotationalCipher = new RotationalCipher(13);
        Assertions.assertEquals("a", rotationalCipher.rotate("n"));
    }

    @Test
    public void rotateCapitalLetters() {
        rotationalCipher = new RotationalCipher(5);
        Assertions.assertEquals("TRL", rotationalCipher.rotate("OMG"));
    }

    @Test
    public void rotateSpaces() {
        rotationalCipher = new RotationalCipher(5);
        Assertions.assertEquals("T R L", rotationalCipher.rotate("O M G"));
    }

    @Test
    public void rotateNumbers() {
        rotationalCipher = new RotationalCipher(4);
        Assertions.assertEquals("Xiwxmrk 1 2 3 xiwxmrk", rotationalCipher.rotate("Testing 1 2 3 testing"));
    }

    @Test
    public void rotatePunctuation() {
        rotationalCipher = new RotationalCipher(21);
        Assertions.assertEquals("Gzo'n zvo, Bmviyhv!", rotationalCipher.rotate("Let's eat, Grandma!"));
    }

    @Test
    public void rotateAllLetters() {
        rotationalCipher = new RotationalCipher(13);
        Assertions.assertEquals("The quick brown fox jumps over the lazy dog.",
                rotationalCipher.rotate("Gur dhvpx oebja sbk whzcf bire gur ynml qbt."));
    }
}
