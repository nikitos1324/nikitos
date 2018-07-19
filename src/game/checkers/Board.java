package game.checkers;

import javax.swing.*;
import java.awt.*;

public class Board extends JPanel {

    private Game game;

    public Board(Game game) {
        this.game = game;
    }

    public void paintComponent(Graphics g) {

        g.setColor(Color.black);
        g.drawRect(0,0,getSize().width-3,getSize().height-3);
        g.drawRect(1,1,getSize().width-3,getSize().height-3);

        for (int row = 0; row < 8; row++) {
            for (int col = 0; col < 8; col++) {
                if ( row % 2 == col % 2 )
                    g.setColor(Color.WHITE);
                else
                    g.setColor(Color.GRAY);

                g.fillRect(2 + col*20, 2 + row*20, 20, 20);
                switch (game.getGameData().pieceAt(row,col)) {
                    case GameData.RED:
                        g.setColor(Color.RED);
                        g.fillOval(4 + col*20, 4 + row*20, 15, 15);
                        break;
                    case GameData.BLACK:
                        g.setColor(Color.BLACK);
                        g.fillOval(4 + col*20, 4 + row*20, 15, 15);
                        break;
                    case GameData.RED_KING:
                        g.setColor(Color.RED);
                        g.fillOval(4 + col*20, 4 + row*20, 15, 15);
                        g.setColor(Color.WHITE);
                        g.drawString("K", 7 + col*20, 16 + row*20);
                        break;
                    case GameData.BLACK_KING:
                        g.setColor(Color.BLACK);
                        g.fillOval(4 + col*20, 4 + row*20, 15, 15);
                        g.setColor(Color.WHITE);
                        g.drawString("K", 7 + col*20, 16 + row*20);
                        break;
                }
            }
        }

        if (game.isGameInProgress()) {

            final CheckersMove[] legalMoves = game.getLegalMoves();
            final int selectedRow = game.getSelectedRow();
            final int selectedCol = game.getSelectedCol();

            g.setColor(Color.blue);
            for (CheckersMove legalMove : legalMoves) {
                g.drawRect(2 + legalMove.fromCol * 20, 2 + legalMove.fromRow * 20, 19, 19);
                g.drawRect(3 + legalMove.fromCol * 20, 3 + legalMove.fromRow * 20, 17, 17);
            }

            if (selectedRow >= 0) {
                g.setColor(Color.white);
                g.drawRect(2 + selectedCol*20, 2 + selectedRow*20, 19, 19);
                g.drawRect(3 + selectedCol*20, 3 + selectedRow*20, 17, 17);
                g.setColor(Color.green);
                for (CheckersMove legalMove : legalMoves) {
                    if (legalMove.fromCol == selectedCol && legalMove.fromRow == selectedRow) {
                        g.drawRect(2 + legalMove.toCol * 20, 2 + legalMove.toRow * 20, 19, 19);
                        g.drawRect(3 + legalMove.toCol * 20, 3 + legalMove.toRow * 20, 17, 17);
                    }
                }
            }
        }

    }
}
