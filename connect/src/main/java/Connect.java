import java.util.ArrayList;
import java.util.List;

class Connect {

    private final List<String[]> board;

    private final List<List<Integer>> directions = List.of(
            List.of(-1, 0), // UP
            List.of(0, 1),  // RIGHT
            List.of(1, 0),  // DOWN
            List.of(0, -1),  // LEFT
            List.of(-1, 1), // UP-RIGHT
            List.of(1, -1)  // DOWN-LEFT
    );


    public Connect(String[] board) {
        this.board = new ArrayList<>();
        for (String rowStr : board) {
            rowStr = rowStr.trim();
            String[] row = rowStr.split(" ");
            this.board.add(row);
        }
    }

    public Winner computeWinner() {
        for (int i = 0; i < board.size(); i++) {
            if (couldWin("X", i, 0, -1, -1)) return Winner.PLAYER_X;
        }

        for (int j = 0; j < board.get(0).length; j++) {
            if (couldWin("O", 0, j, -1, -1)) return Winner.PLAYER_O;
        }

        return Winner.NONE;
    }

    private boolean couldWin(String player, int i, int j, int prevI, int prevJ) {
        if (!isInsideBoard(i, j)) return false;
        if (!board.get(i)[j].equals(player)) return false;
        if (isInWinPosition(player, i, j)) return true;
        return searchAllDirections(player, i, j, prevI, prevJ);
    }

    private boolean searchAllDirections(String player, int i, int j, int prevI, int prevJ) {
        for (List<Integer> direction : directions) {
            int nextI = i + direction.get(0);
            int nextJ = j + direction.get(1);

            boolean searchNext = prevI != nextI || prevJ != nextJ;
            searchNext = searchNext && isInsideBoard(i, j);
            searchNext = searchNext && board.get(i)[j].equals(player);

            if (searchNext) {
                if (couldWin(player, nextI, nextJ, i, j)) return true;
            }
        }

        return false;
    }

    private boolean isInWinPosition(String player, int i, int j) {
        return switch (player) {
            case "O" -> i == board.size() - 1;
            case "X" -> j == board.get(0).length - 1;
            default -> false;
        };
    }

    private boolean isInsideBoard(int i, int j) {
        return i >= 0 && i < board.size() && j >= 0 && j < board.get(i).length;
    }
}
