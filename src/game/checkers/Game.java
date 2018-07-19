package game.checkers;

public interface Game {

    void doNewGame();
    void gameOver();
    String doClickSquare(int row, int col);
    boolean isGameInProgress();
    GameData getGameData();
    int getCurrentPlayer();
    int getSelectedRow();
    int getSelectedCol();
    CheckersMove[] getLegalMoves();
}
