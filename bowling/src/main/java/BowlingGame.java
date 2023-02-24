class BowlingGame {

    private static final int LAST_FRAME = 10;
    private static final int TOTAL_PINS = 10;

    private int score = 0;
    private int pinsStanding = TOTAL_PINS;
    private int currentFrame = 1;
    private final int[] previousStrikes = {0, 0};
    private GameStatus gameStatus = GameStatus.START_GAME;

    public void roll(int pin) {
        if (pin < 0) throw new IllegalStateException("Negative roll is invalid");

        score += pin;
        pinsStanding -= pin;

        if (pinsStanding < 0) throw new IllegalStateException("Pin count exceeds pins on the lane");

        int frameSum = previousStrikes[0] + previousStrikes[1];

        switch (gameStatus) {
            case START_GAME, THROWING_AFTER_OPEN_FRAME -> {
                if (currentFrame <= LAST_FRAME) score += pin * frameSum;
                gameStatus = pinsStanding == 0 ? GameStatus.THROWING_AFTER_STRIKE : GameStatus.SECOND_THROW;
            }
            case SECOND_THROW -> {
                if (currentFrame <= LAST_FRAME) score += pin * frameSum;
                if (pinsStanding == 0) {
                    gameStatus = currentFrame <= LAST_FRAME ? GameStatus.THROWING_AFTER_SPARE_FRAME : GameStatus.END_GAME;
                } else {
                    gameStatus = currentFrame < LAST_FRAME ? GameStatus.THROWING_AFTER_OPEN_FRAME : GameStatus.END_GAME;
                }
                pinsStanding = TOTAL_PINS;
            }
            case THROWING_AFTER_SPARE_FRAME -> {
                if (currentFrame <= LAST_FRAME) {
                    score += pin;
                    gameStatus = pinsStanding == 0 ? GameStatus.THROWING_AFTER_STRIKE : GameStatus.SECOND_THROW;
                } else {
                    gameStatus = GameStatus.END_GAME;
                }
            }
            case THROWING_AFTER_STRIKE -> {
                score += pin * frameSum;
                if (currentFrame < LAST_FRAME + 2) {
                    gameStatus = pinsStanding == 0 ? GameStatus.THROWING_AFTER_STRIKE : GameStatus.SECOND_THROW;
                } else {
                    gameStatus = GameStatus.END_GAME;
                }
            }
            case END_GAME -> throw new IllegalStateException("Cannot roll after game is over");
        }

        previousStrikes[0] = previousStrikes[1];
        previousStrikes[1] = pin == TOTAL_PINS && currentFrame < LAST_FRAME ? 1 : 0;

        if (pinsStanding == 0) pinsStanding = TOTAL_PINS;

        if (gameStatus != GameStatus.SECOND_THROW && gameStatus != GameStatus.END_GAME) {
            currentFrame++;
        }
    }

    int score() {
        if (gameStatus != GameStatus.END_GAME) {
            throw new IllegalStateException("Score cannot be taken until the end of the game");
        }
        return score;
    }

}