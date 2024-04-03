import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;

public class TransposeTest {
    private Transpose transpose;

    @BeforeEach
    public void setup() {
        transpose = new Transpose();
    }

    @Test
    public void emptyString() {
        assertThat(transpose.transpose("")).isEqualTo("");
    }

    @Test
    public void twoCharactersInARow() {
        assertThat(transpose.transpose("A1"))
            .isEqualTo(
                    """
                            A
                            1""");
    }

    @Test
    public void twoCharactersInAColumn() {
        assertThat(
            transpose.transpose(
                    """
                            A
                            1"""))
            .isEqualTo("A1");
    }

    @Test
    public void simple() {
        assertThat(
            transpose.transpose(
                    """
                            ABC
                            123"""))
            .isEqualTo(
                    """
                            A1
                            B2
                            C3""");
    }

    @Test
    public void singleLine() {
        assertThat(transpose.transpose("Single line."))
            .isEqualTo(
                    """
                            S
                            i
                            n
                            g
                            l
                            e
                            \s
                            l
                            i
                            n
                            e
                            .""");
    }

    @Test
    public void firstLineLongerThanSecondLine() {
        assertThat(
            transpose.transpose(
                    """
                            The fourth line.
                            The fifth line."""))
            .isEqualTo(
                    """
                            TT
                            hh
                            ee
                             \s
                            ff
                            oi
                            uf
                            rt
                            th
                            h\s
                             l
                            li
                            in
                            ne
                            e.
                            .""");
    }

    @Test
    public void secondLineLongerThanFirstLine() {
        assertThat(
            transpose.transpose(
                    """
                            The first line.
                            The second line."""))
            .isEqualTo(
                    """
                            TT
                            hh
                            ee
                             \s
                            fs
                            ie
                            rc
                            so
                            tn
                             d
                            l\s
                            il
                            ni
                            en
                            .e
                             .""");
    }

    @Test
    public void mixedLineLength() {
        assertThat(
            transpose.transpose(
                    """
                            The longest line.
                            A long line.
                            A longer line.
                            A line."""))
            .isEqualTo(
                    """
                            TAAA
                            h  \s
                            elll
                             ooi
                            lnnn
                            ogge
                            n e.
                            glr
                            ei\s
                            snl
                            tei
                             .n
                            l e
                            i .
                            n
                            e
                            .""");
    }

    @Test
    public void square() {
        assertThat(
            transpose.transpose(
                    """
                            HEART
                            EMBER
                            ABUSE
                            RESIN
                            TREND"""))
            .isEqualTo(
                    """
                            HEART
                            EMBER
                            ABUSE
                            RESIN
                            TREND""");
    }

    @Test
    public void rectangle() {
        assertThat(
            transpose.transpose(
                    """
                            FRACTURE
                            OUTLINED
                            BLOOMING
                            SEPTETTE"""))
            .isEqualTo(
                    """
                            FOBS
                            RULE
                            ATOP
                            CLOT
                            TIME
                            UNIT
                            RENT
                            EDGE""");
    }

    @Test
    public void triangle() {
        assertThat(
            transpose.transpose(
                    """
                            T
                            EE
                            AAA
                            SSSS
                            EEEEE
                            RRRRRR"""))
            .isEqualTo(
                    """
                            TEASER
                             EASER
                              ASER
                               SER
                                ER
                                 R""");
    }
    
    @Test
    public void jaggedTriangle() {
        assertThat(
            transpose.transpose(
                    """
                            11
                            2
                            3333
                            444
                            555555
                            66666"""))
            .isEqualTo(
                    """
                            123456
                            1 3456
                              3456
                              3 56
                                56
                                5""");
    }
}
