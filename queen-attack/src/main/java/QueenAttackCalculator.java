public class QueenAttackCalculator {
    private final Queen first;
    private final Queen second;

    public QueenAttackCalculator(Queen first, Queen second) {
        if (first == null || second == null) {
            throw new IllegalArgumentException("You must supply valid positions for both Queens.");
        }

        this.first = first;
        this.second = second;

        if (isSamePosition()) {
            throw new IllegalArgumentException("Queens cannot occupy the same position.");
        }
    }

    public boolean canQueensAttackOneAnother() {
        return isSameRow() || isSameColumn() || isOnDiagonal();
    }

    private boolean isSameRow() {
        return first.x() == second.x();
    }

    private boolean isSameColumn() {
        return first.y() == second.y();
    }

    private boolean isOnDiagonal() {
        return Math.abs(second.x() - first.x()) == Math.abs(second.y() - first.y());
    }

    private boolean isSamePosition() {
        return isSameRow() && isSameColumn();
    }

}
