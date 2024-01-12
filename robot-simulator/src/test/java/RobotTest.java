import org.junit.jupiter.api.Test;

import org.junit.jupiter.api.Assertions;

public class RobotTest {

    /* Create robot */

    @Test
    public void atOriginFacingNorth() {
        Orientation initialOrientation = Orientation.NORTH;
        GridPosition initialGridPosition = new GridPosition(0, 0);
        Robot robot = new Robot(initialGridPosition, initialOrientation);

        Assertions.assertEquals(initialOrientation, robot.getOrientation());
        Assertions.assertEquals(initialGridPosition, robot.getGridPosition());
    }

    @Test
    public void atNegativePositionFacingSouth() {
        GridPosition initialGridPosition = new GridPosition(-1, -1);
        Orientation initialOrientation = Orientation.SOUTH;
        Robot robot = new Robot(initialGridPosition, initialOrientation);

        Assertions.assertEquals(initialOrientation, robot.getOrientation());
        Assertions.assertEquals(initialGridPosition, robot.getGridPosition());
    }

    /* Rotating clockwise */

    @Test
    public void changesNorthToEast() {
        GridPosition initialGridPosition = new GridPosition(0, 0);
        Robot robot = new Robot(initialGridPosition, Orientation.NORTH);

        robot.turnRight();

        Orientation expectedOrientation = Orientation.EAST;
        Assertions.assertEquals(initialGridPosition, robot.getGridPosition());
        Assertions.assertEquals(expectedOrientation, robot.getOrientation());
    }

    @Test
    public void changesEastToSouth() {
        GridPosition initialGridPosition = new GridPosition(0, 0);
        Robot robot = new Robot(initialGridPosition, Orientation.EAST);

        robot.turnRight();

        Orientation expectedOrientation = Orientation.SOUTH;
        Assertions.assertEquals(initialGridPosition, robot.getGridPosition());
        Assertions.assertEquals(expectedOrientation, robot.getOrientation());
    }

    @Test
    public void changesSouthToWest() {
        GridPosition initialGridPosition = new GridPosition(0, 0);
        Robot robot = new Robot(initialGridPosition, Orientation.SOUTH);

        robot.turnRight();

        Orientation expectedOrientation = Orientation.WEST;
        Assertions.assertEquals(initialGridPosition, robot.getGridPosition());
        Assertions.assertEquals(expectedOrientation, robot.getOrientation());
    }

    @Test
    public void changesWestToNorth() {
        GridPosition initialGridPosition = new GridPosition(0, 0);
        Robot robot = new Robot(initialGridPosition, Orientation.WEST);

        robot.turnRight();

        Orientation expectedOrientation = Orientation.NORTH;
        Assertions.assertEquals(initialGridPosition, robot.getGridPosition());
        Assertions.assertEquals(expectedOrientation, robot.getOrientation());
    }

    /* Rotating counter-clockwise */

    @Test
    public void changesNorthToWest() {
        GridPosition initialGridPosition = new GridPosition(0, 0);
        Robot robot = new Robot(initialGridPosition, Orientation.NORTH);

        robot.turnLeft();

        Orientation expectedOrientation = Orientation.WEST;
        Assertions.assertEquals(initialGridPosition, robot.getGridPosition());
        Assertions.assertEquals(expectedOrientation, robot.getOrientation());
    }

    @Test
    public void changesWestToSouth() {
        GridPosition initialGridPosition = new GridPosition(0, 0);
        Robot robot = new Robot(initialGridPosition, Orientation.WEST);

        robot.turnLeft();

        Orientation expectedOrientation = Orientation.SOUTH;
        Assertions.assertEquals(initialGridPosition, robot.getGridPosition());
        Assertions.assertEquals(expectedOrientation, robot.getOrientation());
    }

    @Test
    public void changesSouthToEast() {
        GridPosition initialGridPosition = new GridPosition(0, 0);
        Robot robot = new Robot(initialGridPosition, Orientation.SOUTH);

        robot.turnLeft();

        Orientation expectedOrientation = Orientation.EAST;
        Assertions.assertEquals(initialGridPosition, robot.getGridPosition());
        Assertions.assertEquals(expectedOrientation, robot.getOrientation());
    }

    @Test
    public void changesEastToNorth() {
        GridPosition initialGridPosition = new GridPosition(0, 0);
        Robot robot = new Robot(initialGridPosition, Orientation.EAST);

        robot.turnLeft();

        Orientation expectedOrientation = Orientation.NORTH;
        Assertions.assertEquals(initialGridPosition, robot.getGridPosition());
        Assertions.assertEquals(expectedOrientation, robot.getOrientation());
    }

    /* Moving forward one */

    @Test
    public void facingNorthIncrementsY() {
        Orientation initialOrientation = Orientation.NORTH;
        Robot robot = new Robot(new GridPosition(0, 0), initialOrientation);

        robot.advance();

        GridPosition expectedGridPosition = new GridPosition(0, 1);
        Assertions.assertEquals(expectedGridPosition, robot.getGridPosition());
        Assertions.assertEquals(initialOrientation, robot.getOrientation());
    }

    @Test
    public void facingSouthDecrementsY() {
        Orientation initialOrientation = Orientation.SOUTH;
        Robot robot = new Robot(new GridPosition(0, 0), initialOrientation);

        robot.advance();

        GridPosition expectedGridPosition = new GridPosition(0, -1);
        Assertions.assertEquals(expectedGridPosition, robot.getGridPosition());
        Assertions.assertEquals(initialOrientation, robot.getOrientation());
    }

    @Test
    public void facingEastIncrementsX() {
        Orientation initialOrientation = Orientation.EAST;
        Robot robot = new Robot(new GridPosition(0, 0), initialOrientation);

        robot.advance();

        GridPosition expectedGridPosition = new GridPosition(1, 0);
        Assertions.assertEquals(expectedGridPosition, robot.getGridPosition());
        Assertions.assertEquals(initialOrientation, robot.getOrientation());
    }

    @Test
    public void facingWestDecrementsX() {
        Orientation initialOrientation = Orientation.WEST;
        Robot robot = new Robot(new GridPosition(0, 0), initialOrientation);

        robot.advance();

        GridPosition expectedGridPosition = new GridPosition(-1, 0);
        Assertions.assertEquals(expectedGridPosition, robot.getGridPosition());
        Assertions.assertEquals(initialOrientation, robot.getOrientation());
    }

    /* Follow series of instructions */

    @Test
    public void movingEastAndNorthFromReadme() {
        Robot robot = new Robot(new GridPosition(7, 3), Orientation.NORTH);

        robot.simulate("RAALAL");

        GridPosition expectedGridPosition = new GridPosition(9, 4);
        Orientation expectedOrientation = Orientation.WEST;

        Assertions.assertEquals(expectedGridPosition, robot.getGridPosition());
        Assertions.assertEquals(expectedOrientation, robot.getOrientation());
    }

    @Test
    public void movingWestAndNorth() {
        Robot robot = new Robot(new GridPosition(0, 0), Orientation.NORTH);

        robot.simulate("LAAARALA");

        GridPosition expectedGridPosition = new GridPosition(-4, 1);
        Orientation expectedOrientation = Orientation.WEST;

        Assertions.assertEquals(expectedGridPosition, robot.getGridPosition());
        Assertions.assertEquals(expectedOrientation, robot.getOrientation());
    }

    @Test
    public void movingWestAndSouth() {
        Robot robot = new Robot(new GridPosition(2, -7), Orientation.EAST);

        robot.simulate("RRAAAAALA");

        GridPosition expectedGridPosition = new GridPosition(-3, -8);
        Orientation expectedOrientation = Orientation.SOUTH;

        Assertions.assertEquals(expectedGridPosition, robot.getGridPosition());
        Assertions.assertEquals(expectedOrientation, robot.getOrientation());
    }

    @Test
    public void movingEastAndNorth() {
        Robot robot = new Robot(new GridPosition(8, 4), Orientation.SOUTH);

        robot.simulate("LAAARRRALLLL");

        GridPosition expectedGridPosition = new GridPosition(11, 5);
        Orientation expectedOrientation = Orientation.NORTH;

        Assertions.assertEquals(expectedGridPosition, robot.getGridPosition());
        Assertions.assertEquals(expectedOrientation, robot.getOrientation());
    }

}
