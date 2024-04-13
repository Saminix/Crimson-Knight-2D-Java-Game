package game;

import city.cs.engine.SoundClip;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class LevelPanel extends ControlPanel {
    private boolean isPressed;
    private Game game;
    private int coinsEarned;
    private int scoreEarned;

    private SoundClip gameMusic;

    public LevelPanel(Game game, int coinsEarned, int scoreEarned) {
        super(game);
        this.isPressed = false;
        this.game = game;
        this.coinsEarned = coinsEarned;
        this.scoreEarned = scoreEarned;

        try {
            gameMusic = new SoundClip("audio/LevelComplete.wav");
            gameMusic.play();
        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
            System.out.println(e);
        }

        // Create a Frame
        JFrame menu = new JFrame("Menu");

        // Main content panel with background image
        JPanel content = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                // Load and draw the background image
                ImageIcon backgroundImage = new ImageIcon("data/levelComplete.png");
                g.drawImage(backgroundImage.getImage(), 0, 0, getWidth(), getHeight(), null);
            }
        };

        content.setLayout(new GridBagLayout());
        menu.add(content);

        menu.setSize(800, 600);
        menu.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        menu.setLocationRelativeTo(null);



        JLabel coinsLabel = new JLabel("Coins Earned: " + coinsEarned);
        coinsLabel.setFont(new Font("Kalam", Font.PLAIN, 20));
        coinsLabel.setForeground(Color.white);
        coinsLabel.setHorizontalAlignment(SwingConstants.CENTER);
        GridBagConstraints coinsConstraints = new GridBagConstraints();
        coinsConstraints.gridx = 0;
        coinsConstraints.gridy = 1;
        content.add(coinsLabel, coinsConstraints);

        JLabel scoreLabel = new JLabel("Score Earned: " + scoreEarned);
        scoreLabel.setFont(new Font("Kalam", Font.PLAIN, 20));
        scoreLabel.setForeground(Color.white);
        scoreLabel.setHorizontalAlignment(SwingConstants.CENTER);
        GridBagConstraints scoreConstraints = new GridBagConstraints();
        scoreConstraints.gridx = 0;
        scoreConstraints.gridy = 2;
        scoreConstraints.insets = new Insets(10, 0, 10, 0); // Add some spacing between the labels
        content.add(scoreLabel, scoreConstraints);

        JButton nextLevelButton = new JButton("Next Level");
        JButton quitButton = new JButton("Quit Game");

        Dimension buttonSize = new Dimension(200, 40);
        nextLevelButton.setPreferredSize(buttonSize);
        quitButton.setPreferredSize(buttonSize);

        nextLevelButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Set isPressed to true when the next level button is pressed
                isPressed = true;
                game.goToNextLevel();
                ((JFrame) SwingUtilities.getWindowAncestor(content)).dispose();
            }
        });

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
        buttonPanel.add(nextLevelButton);
        buttonPanel.add(quitButton);
        GridBagConstraints buttonConstraints = new GridBagConstraints();
        buttonConstraints.gridx = 0;
        buttonConstraints.gridy = 5;
        content.add(buttonPanel, buttonConstraints);

        menu.setVisible(true);
    }

    public boolean IsButtonPressed() {
        return isPressed;
    }
}
