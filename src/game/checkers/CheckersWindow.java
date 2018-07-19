package game.checkers;

import javax.swing.*;
import java.awt.*;

public class CheckersWindow extends JFrame {

    private Game game;

    private Board board;
    private JButton newGameButton;
    private JButton resignButton;

    private JLabel messageLabel;

    public CheckersWindow(Game game) throws HeadlessException {
        super("Шашки");

        this.game = game;

        pack();
        setBounds(0, 0, 800, 800);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setVisible(true);
        setContentPane(createContent());
    }

    public JLabel getMessageLabel() {
        return messageLabel;
    }

    public Board getBoard() {
        return board;
    }

    private JPanel createContent() {

        JPanel content = new JPanel();
        content.setLayout(null);

        board = createBoard(300,300,164,164);
        newGameButton = createNewGameButton(510,320, 120, 30);
        resignButton = createResignButton(510, 420, 120, 30);
        messageLabel = createMessageLabel(210, 470, 350, 30);

        content.add(board);
        content.add(newGameButton);
        content.add(resignButton);
        content.add(messageLabel);

        return content;
    }

    private Board createBoard(int x, int y, int width, int height) {
        Board board = new Board(game);
        board.setBackground(Color.BLACK);
        board.addMouseListener(new CheckersMouseListener(this, game));
        board.setBounds(x, y, width, height);
        return board;
    }

    private JLabel createMessageLabel(int x, int y, int width, int height) {

        JLabel message = new JLabel("",JLabel.CENTER);
        message.setFont(new Font("Serif", Font.BOLD, 14));
        message.setForeground(Color.RED);
        message.setBounds(x, y, width, height);
        return message;
    }

    private JButton createNewGameButton(int x, int y, int width, int height) {

        JButton newGameButton = new JButton("Новая Игра");
        newGameButton.addActionListener(event -> {
            if (!game.isGameInProgress()) {
                JOptionPane.showMessageDialog(this, "Сначала закончи эту игру");
                return;
            }

            game.doNewGame();
            messageLabel.setText("Красные: делайте свой ход");
            resignButton.setEnabled(true);
            board.repaint();
        });
        newGameButton.setBounds(x, y, width, height);
        return newGameButton;
    }

    private JButton createResignButton(int x, int y, int width, int height) {

        JButton resignButton = new JButton("Cдаться");
        resignButton.addActionListener(event -> {
            if (!game.isGameInProgress()) {
                messageLabel.setText("Игра еще не запущена");
                return;
            }

            String text = (game.getCurrentPlayer() == GameData.RED)
                    ? "Красные проиграли. ЧЕРНЫЕ выиграли"
                    : "ЧЕРНЫЕ проиграли. Красные выиграли";

            messageLabel.setText(text);
            newGameButton.setEnabled(true);

            game.gameOver();
        });
        resignButton.setBounds(x, y, width, height);
        return resignButton;
    }
}
