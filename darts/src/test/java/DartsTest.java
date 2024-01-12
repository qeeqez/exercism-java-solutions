import org.junit.jupiter.api.Test;

import org.junit.jupiter.api.Assertions;

public class DartsTest {

    Darts darts = new Darts();
    @Test
    public void missedTarget() {
        Assertions.assertEquals(0, darts.score(-9, 9));
    }

    @Test
    public void onTheOuterCircle() {
        Assertions.assertEquals(1, darts.score(0, 10));
    }

    @Test
    public void onTheMiddleCircle() {
        Assertions.assertEquals(5, darts.score(-5, 0));
    }

    @Test
    public void onTheInnerCircle() {
        Assertions.assertEquals(10, darts.score(0, -1));
    }

    @Test
    public void exactlyOnCentre() {
        Assertions.assertEquals(10, darts.score(0, 0));
    }

    @Test
    public void nearTheCentre() {
        Assertions.assertEquals(10, darts.score(-0.1, -0.1));
    }

    @Test
    public void justWithinTheInnerCircle() {
        Assertions.assertEquals(10, darts.score(0.7, 0.7));
    }

    @Test
    public void justOutsideTheInnerCircle() {
        Assertions.assertEquals(5, darts.score(0.8, -0.8));
    }

    @Test
    public void justWithinTheMiddleCircle() {
        Assertions.assertEquals(5, darts.score(-3.5, 3.5));
    }

    @Test
    public void justOutsideTheMiddleCircle() {
        Assertions.assertEquals(1, darts.score(-3.6, -3.6));
    }


    @Test
    public void justWithinTheOuterCircle() {
        Assertions.assertEquals(1, darts.score(-7.0, 7.0));
    }

    @Test
    public void justOutsideTheOuterCircle() {
        Assertions.assertEquals(0, darts.score(7.1, -7.1));
    }

    @Test
    public void asymmetricPositionBetweenTheInnerAndMiddleCircles() {
        Assertions.assertEquals(5, darts.score(0.5, -4));
    }

}
