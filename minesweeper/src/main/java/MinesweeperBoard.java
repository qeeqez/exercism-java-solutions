import java.util.ArrayList;
import java.util.List;

class MinesweeperBoard {

    private final List<String> input;

    private final char MINE = '*';

    MinesweeperBoard(List<String> input) {
        this.input = input;
    }

    public List<String> withNumbers() {
        List<String> output = new ArrayList<>();

        for (int i = 0; i < input.size(); i++) {
            StringBuilder row = new StringBuilder();
            for (int j = 0; j < input.get(i).length(); j++) {
                row.append(getMineCountPrintable(i, j));
            }
            output.add(row.toString());
        }

        return output;
    }

    private char getMineCountPrintable(int i, int j) {
        if (isMine(i, j)) {
            return MINE;
        } else {
            int mineCount = getMineCount(i, j);
            return mineCount == 0 ? ' ' : Character.forDigit(mineCount, 10);
        }
    }

    private int getMineCount(int i, int j) {
        int mineCount = 0;

        for (int x = -1; x <= 1; x++) {
            for (int y = -1; y <= 1; y++) {
                if (isMine(i + x, j + y)) mineCount++;
            }
        }

        return mineCount;
    }

    private boolean isMine(int i, int j) {
        return isValidIndex(i, j) && input.get(i).charAt(j) == MINE;
    }

    private boolean isValidIndex(int i, int j) {
        return i >= 0 && j >= 0 && i < input.size() && j < input.get(0).length();
    }

}