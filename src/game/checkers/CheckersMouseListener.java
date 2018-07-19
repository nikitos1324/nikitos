package game.checkers;

import javax.swing.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class CheckersMouseListener implements MouseListener {

    private Game game;
    private CheckersWindow frame;

    public CheckersMouseListener(CheckersWindow frame, Game game) {
        this.frame = frame;
        this.game = game;
    }


    @Override
    public void mousePressed(MouseEvent evt) {

        if (!game.isGameInProgress()) {
            JOptionPane.showMessageDialog(frame, "Нажми \"Новая Игра\" для начала игры.");

        } else {
            int col = (evt.getX() - 2) / 20;
            int row = (evt.getY() - 2) / 20;
            if (col >= 0 && col < 8 && row >= 0 && row < 8) {
                String text = game.doClickSquare(row,col);
                if (text != null && !text.isEmpty()) {
                    frame.getMessageLabel().setText(text);
                }
                frame.getBoard().repaint();
            }
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

}
