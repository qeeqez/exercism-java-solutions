class StateOfTicTacToe {

    public GameState determineState(String[] board) {
        String diagonal1 = "" + board[0].charAt(0) + board[1].charAt(1) + board[2].charAt(2);
        String diagonal2 = "" + board[0].charAt(2) + board[1].charAt(1) + board[2].charAt(0);

        if (isWin(diagonal1)) return GameState.WIN;
        if (isWin(diagonal2)) return GameState.WIN;

        boolean hasEmpty = false;
        for (int i = 0; i < 3; i++) {
            String row = board[i];
            String column = "" + board[0].charAt(i) + board[1].charAt(i) + board[2].charAt(i);

            if (isWin(row)) return GameState.WIN;
            if (isWin(column)) return GameState.WIN;

            hasEmpty = row.contains(" ") || hasEmpty;
        }
        return hasEmpty ? GameState.ONGOING : GameState.DRAW;
    }

    boolean isWin(String row) {
        return row.equals("XXX") || row.equals("OOO");
    }
}
