package game;
import javax.swing.*;

import java.awt.event.ActionEvent;
import java.io.IOException;

import java.awt.event.ActionListener;

/**
 * Class Control Panel is a subclass of JPanel
 * Represents a control panel in the game
 * used to display game controls and information.
 * The pause Button, QuitButton and the Next-level button
 */
public class ControlPanel extends JPanel {
    private Game game;
    private JButton pauseButton;


    private JButton quitButton;
    private JButton nextLevelButton;
    private JButton saveButton;

    /**
     * Constructs a ControlPanel with the specified game instance.
     *
     * @param game The Game instance associated with this control panel.
     */
    public ControlPanel(Game game) {
        this.game = game;
        pauseButton = new JButton("Pause");
        quitButton = new JButton("Quit");
        nextLevelButton = new JButton("Next Level->");
        saveButton = new JButton("Save");


        pauseButton.addActionListener(new PauseButtonListener());
        quitButton.addActionListener(new QuitButtonListener());
        nextLevelButton.addActionListener(new NextLevelButtonListener());
        saveButton.addActionListener(new SaveButtonListener());

        add(pauseButton);
        add(quitButton);
        add(nextLevelButton);
        add(saveButton);

    }

    private class PauseButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            game.togglePause();
        }
    }

    private class QuitButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            int choice = JOptionPane.showConfirmDialog(null, "Are you sure you want to quit the game?", "Quit Game", JOptionPane.YES_NO_OPTION);
            if (choice == JOptionPane.YES_OPTION) {
                System.exit(0);
            }
        }
    }

    private class NextLevelButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            game.goToNextLevel();
        }
    }

    private class SaveButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            GameLevel level = game.getCurrentLevel();
            try {
                GameSaverLoader.save(level, "save_game.txt");
                System.out.println("Game saved successfully.");
            } catch (IOException ex) {
                System.out.println("Error saving game: " + ex.getMessage());
            }
        }

}

}