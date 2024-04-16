package game;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


/**
 * Represents the main menu panel displayed at the start of the game.
 */

public class MainMenu extends ControlPanel {
    private boolean isPressed;
    private boolean isControlsPressed;
    private Game game;

    /**
     * Constructs a new MainMenu.
     *
     * @param game The game instance.
     */

    public MainMenu(Game game) {
        super(game);
        this.isPressed = false;
        this.game = game;
        this.isControlsPressed = false;

        // Create a frame
        JFrame menu = new JFrame("Menu");

        // Main content panel with background image

        /**
         * A Protected Panel, Inherited by Subclasses to Paint the Background
         * Main menu.
         * Panel Consists of Buttons, Positions and sizes.
         *
         */
        JPanel content = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                // Load and draw the background image
                ImageIcon backgroundImage = new ImageIcon("data/GameMenu.jpg");
                g.drawImage(backgroundImage.getImage(), 0, 0, getWidth(), getHeight(), null);
            }
        };

        content.setLayout(new GridBagLayout());
        menu.add(content);

        menu.setSize(800, 600);
        menu.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        menu.setLocationRelativeTo(null);

        JLabel titleLabel = new JLabel("Crimson Knight");
        titleLabel.setFont(new Font("Kalam", Font.BOLD, 40));
        titleLabel.setForeground(Color.WHITE);
        titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
        GridBagConstraints titleConstraints = new GridBagConstraints();
        titleConstraints.gridx = 0;
        titleConstraints.gridy = 0;
        titleConstraints.insets = new Insets(0, 0, 100, 0); // Add some spacing below the title
        content.add(titleLabel, titleConstraints);

        JButton playButton = new JButton("Play Game");
        JButton controlsButton = new JButton("Controls");
        JButton howToPlayButton = new JButton("How To Play?");
        JButton quitButton = new JButton("Quit Game");

        Dimension buttonSize = new Dimension(200, 40);
        playButton.setPreferredSize(buttonSize);
        controlsButton.setPreferredSize(buttonSize);
        quitButton.setPreferredSize(buttonSize);
        howToPlayButton.setPreferredSize(buttonSize);

        playButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Set isPressed to true when the play button is pressed
                isPressed = true;
                game.startGame();
                ((JFrame) SwingUtilities.getWindowAncestor(content)).dispose();

            }
        });

        controlsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Set isControlsPressed to true when the controls button is pressed
                isControlsPressed = true;
                // Show controls instructions (e.g., in a dialog box)
                JOptionPane.showMessageDialog(content, "Controls: \n W - Jump \n A - Left \n D - Right \n Mouse click - Shoot");
            }
        });

        howToPlayButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Set isControlsPressed to true when the controls button is pressed
                isControlsPressed = true;
                // Show controls instructions (e.g., in a dialog box)
                JOptionPane.showMessageDialog(content, "How to play?\n" +
                        "The Goal Is To Complete The Levels By Finding The Magic Key To Unlock The Door\n" +
                        "Hidden Somewhere Within The Game. The Only Way To Go To The Next Level Is To Find It.\n" +
                        "However In Your Path Will Lie Obstacles, Traps And Enemies,\n" +
                        "That Will Patrol The Area, So Be Careful Of Your Surroundings.\n" +
                        "Be Weary Of Zombies, They Will Chase You!\n" +
                        "Potions Will Help You Heal And Treasure Is Ever Lurking.\n" +
                        "Tip - Find The Mushrooms To Unlock Your Hidden Power!");
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
        buttonPanel.add(playButton);
        buttonPanel.add(controlsButton);
        buttonPanel.add(howToPlayButton);
        buttonPanel.add(quitButton);
        GridBagConstraints buttonConstraints = new GridBagConstraints();
        buttonConstraints.gridx = 0;
        buttonConstraints.gridy = 1;
        buttonConstraints.insets = new Insets(0, 0, 20, 0); // Add some spacing above the buttons
        content.add(buttonPanel, buttonConstraints);

        menu.setVisible(true);
    }

    /**
     * Returns whether the play button is pressed.
     *
     * @return true if the play button is pressed, else false.
     */
    public boolean IsPlayButtonPressed() {
        return isPressed;
    }

    /**
     * Returns whether the controls button is pressed.
     *
     * @return true if the controls button is pressed, else false.
     */
    public boolean isControlsButtonPressed() {
        return isControlsPressed;
    }



}
