import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatExceptionOfType;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;


public class QueenAttackCalculatorTest {

    @Test
    public void testCreateQueenWithAValidPosition() {
        new Queen(2, 2);
    }

    @Test
    public void testCreateQueenMustHavePositiveRow() {
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> new Queen(-2, 2))
                .withMessage("Queen position must have positive row.");
    }

    @Test
    public void testCreateQueenMustHaveRowOnBoard() {
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> new Queen(8, 4))
                .withMessage("Queen position must have row <= 7.");
    }

    @Test
    public void testCreateQueenMustHavePositiveColumn() {
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> new Queen(2, -2))
                .withMessage("Queen position must have positive column.");
    }

    @Test
    public void testCreateQueenMustHaveColumnOnBoard() {
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> new Queen(4, 8))
                .withMessage("Queen position must have column <= 7.");
    }

    @Test
    public void testQueensCannotAttack() {
        QueenAttackCalculator calculator
                = new QueenAttackCalculator(new Queen(2, 4), new Queen(6, 6));

        assertFalse(calculator.canQueensAttackOneAnother());
    }

    @Test
    public void testQueensCanAttackOnTheSameRow() {
        QueenAttackCalculator calculator
                = new QueenAttackCalculator(new Queen(2, 4), new Queen(2, 6));

        assertTrue(calculator.canQueensAttackOneAnother());
    }

    @Test
    public void testQueensCanAttackOnTheSameColumn() {
        QueenAttackCalculator calculator
                = new QueenAttackCalculator(new Queen(4, 5), new Queen(2, 5));

        assertTrue(calculator.canQueensAttackOneAnother());
    }

    @Test
    public void testQueensCanAttackOnFirstDiagonal() {
        QueenAttackCalculator calculator
                = new QueenAttackCalculator(new Queen(2, 2), new Queen(0, 4));

        assertTrue(calculator.canQueensAttackOneAnother());
    }

    @Test
    public void testQueensCanAttackOnSecondDiagonal() {
        QueenAttackCalculator calculator
                = new QueenAttackCalculator(new Queen(2, 2), new Queen(3, 1));

        assertTrue(calculator.canQueensAttackOneAnother());
    }

    @Test
    public void testQueensCanAttackOnThirdDiagonal() {
        QueenAttackCalculator calculator
                = new QueenAttackCalculator(new Queen(2, 2), new Queen(1, 1));

        assertTrue(calculator.canQueensAttackOneAnother());
    }

    @Test
    public void testQueensCanAttackOnFourthDiagonal() {
        QueenAttackCalculator calculator
                = new QueenAttackCalculator(new Queen(1, 7), new Queen(0, 6));

        assertTrue(calculator.canQueensAttackOneAnother());
    }

    @Disabled("Remove to run test")
    @Test
    public void testNullPositionsNotAllowed() {
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> new QueenAttackCalculator(null, new Queen(0, 7)))
                .withMessage("You must supply valid positions for both Queens.");
    }

    @Disabled("Remove to run test")
    @Test
    public void testQueensMustNotOccupyTheSameSquare() {
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> new QueenAttackCalculator(new Queen(2, 2), new Queen(2, 2)))
                .withMessage("Queens cannot occupy the same position.");
    }

}
