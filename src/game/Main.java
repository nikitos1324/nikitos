package game;

import game.checkers.CheckersWindow;
import game.checkers.Game;
import game.checkers.GameImpl;

public class Main {

    public static void main(String[] args) {

        Game game = new GameImpl();
        game.doNewGame();

        new CheckersWindow(game);
    }
}
