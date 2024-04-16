package game;
import city.cs.engine.SoundClip;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
/**
 * Represents a control panel displayed when the Warrior Dies, GameOver!
 * This class extends ControlPanel and provides a menu showing restart Game and
 * Quit Game Button.
 */
public class GameOver extends ControlPanel {
    private boolean isPressed;
    private Game game;
    private SoundClip gameMusic;

    /**
     * Constucts a GameOver Panel in the game.
     *
     * @param game the Game instance associated with this control panel.
     */

    public GameOver(Game game) {
        super(game);
        this.isPressed = false;
        this.game = game;

        try {
            gameMusic = new SoundClip("audio/lose.wav");
            gameMusic.play();
        }catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
            System.out.println(e);
        }
        JFrame menu = new JFrame("Menu");

        /**
         * A Protected Panel, Inherited by Subclasses to Paint the Background Game
         * Completed.
         * Panel Consists of Buttons, Positions and sizes.
         */

        // Main content panel with background image
        JPanel content = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                // Load and draw the background image
                ImageIcon backgroundImage = new ImageIcon("data/gameOver.jpg");
                g.drawImage(backgroundImage.getImage(), 0, 0, getWidth(), getHeight(), null);
            }
        };

        content.setLayout(new GridBagLayout());
        menu.add(content);

        menu.setSize(800, 600);
        menu.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        menu.setLocationRelativeTo(null);


        JButton restartButton = new JButton("Restart Game");
        JButton quitButton = new JButton("Quit Game");

        Dimension buttonSize = new Dimension(200, 40);
        restartButton.setPreferredSize(buttonSize);
        quitButton.setPreferredSize(buttonSize);

        restartButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Set isPressed to true when the play button is pressed
                isPressed = true;
                stopGameMusic();
                game.disposeCurrentLevelFrame();
                game.startGame();
                ((JFrame) SwingUtilities.getWindowAncestor(content)).dispose();

            }
        });

        quitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Quit the game when the quit button is pressed
                JFrame currentFrame = (JFrame) SwingUtilities.getWindowAncestor(content);
                currentFrame.dispose();
                System.exit(0);
            }
        });

        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(2, 1, 0, 10)); // GridLayout for vertical alignment
        buttonPanel.setOpaque(false); // Make the button panel transparent
        buttonPanel.add(restartButton);
        buttonPanel.add(quitButton);
        GridBagConstraints buttonConstraints = new GridBagConstraints();
        buttonConstraints.gridx = 0;
        buttonConstraints.gridy = 1;
        buttonConstraints.insets = new Insets(100, 0, 30, 0); // Add some spacing above the buttons
        content.add(buttonPanel, buttonConstraints);

        menu.setVisible(true);
    }

    public boolean IsButtonPressed() {
        return isPressed;
    }

    public void stopGameMusic() {
        if (gameMusic != null) {
            gameMusic.stop();
        }
    }



}


