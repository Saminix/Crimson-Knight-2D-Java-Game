package game;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Represents a control panel displayed when the game is completed.
 * This class extends ControlPanel and provides a menu showing the total coins and score obtained in the game
 * and Quit Game Button.
 */
public class GameComplete extends ControlPanel {
    /**
     * Constucts a GameComplete Panel in the game.
     *
     * @param game  The Game instance associated with this control panel.
     * @param totalCoins  The total number of coins collected in the game.
     * @param totalScore  The total score accumulated in the game.
     */
    public GameComplete(Game game, int totalCoins, int totalScore) {
        super(game);

        // Create a JFrame for the menu
        JFrame menu = new JFrame("Game Complete");
        /**
         * A Protected Panel, Inherited by Subclasses to Paint the Background Game
         * Completed.
         * Panel Consists of Buttons, Positions and sizes.
         *
         */
        JPanel content = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                // Load and draw the background image
                ImageIcon backgroundImage = new ImageIcon("data/GameCompleted.png");
                g.drawImage(backgroundImage.getImage(), 0, 0, getWidth(), getHeight(), null);
            }
        };

        content.setLayout(new GridBagLayout());
        menu.add(content);

        menu.setSize(800, 600);
        menu.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        menu.setLocationRelativeTo(null);

        //display Total coins
        JLabel coinsLabel = new JLabel("Total Coins: " + totalCoins);
        coinsLabel.setFont(new Font("Kalam", Font.PLAIN, 20));
        coinsLabel.setForeground(Color.black);
        coinsLabel.setHorizontalAlignment(SwingConstants.CENTER);
        GridBagConstraints coinsConstraints = new GridBagConstraints();
        coinsConstraints.gridx = 0;
        coinsConstraints.gridy = 1;
        content.add(coinsLabel, coinsConstraints);

        //display Total score.
        JLabel scoreLabel = new JLabel("Total Score: " + totalScore);
        scoreLabel.setFont(new Font("Kalam", Font.PLAIN, 20));
        scoreLabel.setForeground(Color.black);
        scoreLabel.setHorizontalAlignment(SwingConstants.CENTER);
        GridBagConstraints scoreConstraints = new GridBagConstraints();
        scoreConstraints.gridx = 0;
        scoreConstraints.gridy = 2;
        scoreConstraints.insets = new Insets(10, 0, 10, 0); // Add some spacing between the labels
        content.add(scoreLabel, scoreConstraints);

        JButton quitButton = new JButton("Quit Game");
        Dimension buttonSize = new Dimension(200, 40);
        quitButton.setPreferredSize(buttonSize);
        quitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Quit the game when the quit button is pressed
                System.exit(0);
            }
        });

        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(2, 1, 0, 10)); // GridLayout for vertical alignment
        buttonPanel.setOpaque(false); // Make the button panel transparent
        buttonPanel.add(quitButton);
        GridBagConstraints buttonConstraints = new GridBagConstraints();
        buttonConstraints.gridx = 0;
        buttonConstraints.gridy = 5;
        content.add(buttonPanel, buttonConstraints);

        menu.setVisible(true);

    }
}
