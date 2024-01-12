import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import org.junit.jupiter.api.Assertions;

public class DifferenceOfSquaresCalculatorTest {

    private DifferenceOfSquaresCalculator calculator;

    @BeforeEach
    public void setUp() {
        calculator = new DifferenceOfSquaresCalculator();
    }

    @Test
    public void testSquareOfSumUpToOne() {
        int expected = 1;
        int actual = calculator.computeSquareOfSumTo(1);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void testSquareOfSumUpToFive() {
        int expected = 225;
        int actual = calculator.computeSquareOfSumTo(5);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void testSquareOfSumUpToHundred() {
        int expected = 25502500;
        int actual = calculator.computeSquareOfSumTo(100);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void testSumOfSquaresUpToOne() {
        int expected = 1;
        int actual = calculator.computeSumOfSquaresTo(1);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void testSumOfSquaresUpToFive() {
        int expected = 55;
        int actual = calculator.computeSumOfSquaresTo(5);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void testSumOfSquaresUpToHundred() {
        int expected = 338350;
        int actual = calculator.computeSumOfSquaresTo(100);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void testDifferenceOfSquaresUpToOne() {
        int expected = 0;
        int actual = calculator.computeDifferenceOfSquares(1);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void testDifferenceOfSquaresUpToFive() {
        int expected = 170;
        int actual = calculator.computeDifferenceOfSquares(5);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void testDifferenceOfSquaresUpToHundred() {
        int expected = 25164150;
        int actual = calculator.computeDifferenceOfSquares(100);
        Assertions.assertEquals(expected, actual);
    }

}
