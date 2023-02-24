import java.util.Arrays;

public class Robot {

    private GridPosition gridPosition;
    private Orientation orientation;

    public Robot(GridPosition initialPosition, Orientation initialOrientation) {
        gridPosition = initialPosition;
        orientation = initialOrientation;
    }

    public GridPosition getGridPosition() {
        return gridPosition;
    }

    public Orientation getOrientation() {
        return orientation;
    }

    public void turnRight() {
        orientation = switch (orientation) {
            case NORTH -> Orientation.EAST;
            case SOUTH -> Orientation.WEST;
            case EAST -> Orientation.SOUTH;
            case WEST -> Orientation.NORTH;
        };
    }

    public void turnLeft() {
        orientation = switch (orientation) {
            case NORTH -> Orientation.WEST;
            case SOUTH -> Orientation.EAST;
            case EAST -> Orientation.NORTH;
            case WEST -> Orientation.SOUTH;
        };
    }

    public void advance() {
        int x = gridPosition.x;
        int y = gridPosition.y;

        gridPosition = switch (orientation) {
            case NORTH -> new GridPosition(x, y + 1);
            case SOUTH -> new GridPosition(x, y - 1);
            case EAST -> new GridPosition(x + 1, y);
            case WEST -> new GridPosition(x - 1, y);
        };
    }

    public void simulate(String commands) {
        Arrays.stream(commands.split(""))
                .forEachOrdered(this::processCommand);
    }

    public void processCommand(String command) {
        switch (command) {
            case "R" -> turnRight();
            case "L" -> turnLeft();
            case "A" -> advance();
        }
    }
}
