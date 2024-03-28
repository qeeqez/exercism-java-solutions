class StateOfTicTacToe {

    public GameState determineState(String[] board) {
        String diagonal1 = "" + board[0].charAt(0) + board[1].charAt(1) + board[2].charAt(2);
        String diagonal2 = "" + board[0].charAt(2) + board[1].charAt(1) + board[2].charAt(0);

        if (isWin(diagonal1)) return GameState.WIN;
        if (isWin(diagonal2)) return GameState.WIN;

        for (int i = 0; i < 3; i++) {
            String row = board[i];
            String column = "" + board[0].charAt(i) + board[1].charAt(i) + board[2].charAt(i);

            if (isWin(row)) return GameState.WIN;
            if (isWin(column)) return GameState.WIN;
        }
        return GameState.ONGOING;
    }

    boolean isWin(String row) {
        return row.equals("XXX") || row.equals("OOO");
    }
//
//    boolean columnWin(String column) {
//
//    }
//
//    private boolean isWin(char a, char b, char c) {
//        return isTicTac(a) && a == b && b == c;
//    }
//
//    private boolean isTicTac(char c) {
//        return c == 'X' || c == '0';
//    }
}
