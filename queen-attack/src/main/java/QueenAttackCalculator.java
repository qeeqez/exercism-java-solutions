public class QueenAttackCalculator {
    private final Queen first;
    private final Queen second;

    public QueenAttackCalculator(Queen first, Queen second) {
        this.first = first;
        this.second = second;
    }

    public boolean canQueensAttackOneAnother() {
        return rowIsSame() || columnIsSame() || queensOnDiagonal();
    }

    private boolean rowIsSame() {
        return first.x() == second.x();
    }

    private boolean columnIsSame() {
        return first.y() == second.y();
    }

    private boolean queensOnDiagonal() {
        return Math.abs(second.x() - first.x()) == Math.abs(second.y() - first.y());
    }


}
