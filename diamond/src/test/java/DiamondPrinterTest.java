import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import org.assertj.core.api.Assertions;

public class DiamondPrinterTest {

    private DiamondPrinter diamondPrinter;

    @BeforeEach
    public void setUp() {
        diamondPrinter = new DiamondPrinter();
    }

    @Test
    public void testOneByOneDiamond() {
        Assertions.assertThat(diamondPrinter.printToList('A'))
            .containsExactly("A");
    }

    @Test
    public void testTwoByTwoDiamond() {
        Assertions.assertThat(diamondPrinter.printToList('B'))
            .containsExactly(
                " A ",
                "B B",
                " A ");
    }

    @Test
    public void testThreeByThreeDiamond() {
        Assertions.assertThat(diamondPrinter.printToList('C'))
            .containsExactly(
                "  A  ",
                " B B ",
                "C   C",
                " B B ",
                "  A  ");
    }

    @Test
    public void testFourByFourDiamond() {
        Assertions.assertThat(diamondPrinter.printToList('D'))
            .containsExactly(
                "   A   ",
                "  B B  ",
                " C   C ",
                "D     D",
                " C   C ",
                "  B B  ",
                "   A   ");
    }

    @Test
    public void testFullDiamond() {
        Assertions.assertThat(diamondPrinter.printToList('Z'))
            .containsExactly(
                "                         A                         ",
                "                        B B                        ",
                "                       C   C                       ",
                "                      D     D                      ",
                "                     E       E                     ",
                "                    F         F                    ",
                "                   G           G                   ",
                "                  H             H                  ",
                "                 I               I                 ",
                "                J                 J                ",
                "               K                   K               ",
                "              L                     L              ",
                "             M                       M             ",
                "            N                         N            ",
                "           O                           O           ",
                "          P                             P          ",
                "         Q                               Q         ",
                "        R                                 R        ",
                "       S                                   S       ",
                "      T                                     T      ",
                "     U                                       U     ",
                "    V                                         V    ",
                "   W                                           W   ",
                "  X                                             X  ",
                " Y                                               Y ",
                "Z                                                 Z",
                " Y                                               Y ",
                "  X                                             X  ",
                "   W                                           W   ",
                "    V                                         V    ",
                "     U                                       U     ",
                "      T                                     T      ",
                "       S                                   S       ",
                "        R                                 R        ",
                "         Q                               Q         ",
                "          P                             P          ",
                "           O                           O           ",
                "            N                         N            ",
                "             M                       M             ",
                "              L                     L              ",
                "               K                   K               ",
                "                J                 J                ",
                "                 I               I                 ",
                "                  H             H                  ",
                "                   G           G                   ",
                "                    F         F                    ",
                "                     E       E                     ",
                "                      D     D                      ",
                "                       C   C                       ",
                "                        B B                        ",
                "                         A                         ");
    }

}
