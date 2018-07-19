package game.checkers;

public class GameImpl implements Game {

    private boolean gameInProgress;
    private int currentPlayer;
    private int selectedRow, selectedCol;
    private CheckersMove[] legalMoves;
    private GameData gameData = new GameData();

    @Override
    public void doNewGame() {

        gameData.setUpGame();
        currentPlayer = GameData.RED;
        legalMoves = gameData.getLegalMoves(GameData.RED);
        selectedRow = -1;
        gameInProgress = true;
    }

    @Override
    public void gameOver() {
        gameInProgress = false;
    }

    @Override
    public String doClickSquare(int row, int col) {

        for (CheckersMove legalMove : legalMoves) {
            if (legalMove.fromRow == row && legalMove.fromCol == col) {
                selectedRow = row;
                selectedCol = col;
                if (currentPlayer == GameData.RED)
                    return "Красные: делайте свой ход";
                else
                    return "ЧЕРНЫЕ: делайте свой ход";
            }
        }

        if (selectedRow < 0) {
            return "Нажми куда хочешь сходить";
        }

        for (CheckersMove legalMove : legalMoves) {
            if (legalMove.fromRow == selectedRow && legalMove.fromCol == selectedCol
                    && legalMove.toRow == row && legalMove.toCol == col) {
                return doMakeMove(legalMove);
            }
        }

        return "Нажми куда хочешь сходить";
    }

    @Override
    public boolean isGameInProgress() {
        return gameInProgress;
    }

    @Override
    public GameData getGameData() {
        return gameData;
    }

    @Override
    public int getCurrentPlayer() {
        return currentPlayer;
    }

    @Override
    public int getSelectedRow() {
        return selectedRow;
    }

    @Override
    public int getSelectedCol() {
        return selectedCol;
    }

    @Override
    public CheckersMove[] getLegalMoves() {
        return legalMoves;
    }

    private String doMakeMove(CheckersMove move) {

        String message = null;

        gameData.makeMove(move);

        if (move.isJump()) {
            legalMoves = gameData.getLegalJumpsFrom(currentPlayer, move.toRow, move.toCol);
            if (legalMoves != null) {

                if (currentPlayer == GameData.RED)
                    message = "КРАСНЫЕ: делайте свой ход.";
                else
                    message = "ЧЕРНЫЕ: делайте свой ход";
                selectedRow = move.toRow;
                selectedCol = move.toCol;

                return message;
            }
        }

        if (currentPlayer == GameData.RED) {
            currentPlayer = GameData.BLACK;
            legalMoves = gameData.getLegalMoves(currentPlayer);
            if (legalMoves == null) {
                gameOver();
                message = "BLACK has no moves.  RED wins.";
            }
            else if (legalMoves[0].isJump())
                message = "ЧЕРНЫЕ: вы обязаны съесть.";
            else
                message = "ЧЕРНЫЕ: делайте свой ход.";
        }
        else {
            currentPlayer = GameData.RED;
            legalMoves = gameData.getLegalMoves(currentPlayer);
            if (legalMoves == null) {
                gameOver();
                message = "RED has no moves.  BLACK wins.";
            }

            else if (legalMoves[0].isJump())
                message = "КРАСНЫЕ: вы обязаны съесть.";
            else
                message = "КРАСНЫЕ: делайте свой ход.";
        }

        selectedRow = -1;

        if (legalMoves != null) {
            boolean sameStartSquare = true;
            for (int i = 1; i < legalMoves.length; i++)
                if (legalMoves[i].fromRow != legalMoves[0].fromRow
                        || legalMoves[i].fromCol != legalMoves[0].fromCol) {
                    sameStartSquare = false;
                    break;
                }
            if (sameStartSquare) {
                selectedRow = legalMoves[0].fromRow;
                selectedCol = legalMoves[0].fromCol;
            }
        }

        return message;
    }
}
