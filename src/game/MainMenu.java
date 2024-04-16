package game;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

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

        JLabel titleLabel = new JLabel(" CRIMSON GHOST ");
        titleLabel.setFont(new Font("Kalam", Font.BOLD, 50));
        titleLabel.setForeground(Color.WHITE);
        titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
        GridBagConstraints titleConstraints = new GridBagConstraints();
        titleConstraints.gridx = 0;
        titleConstraints.gridy = 0;
        titleConstraints.insets = new Insets(0, 0, 50, 0); // Add some spacing below the title
        content.add(titleLabel, titleConstraints);

        // Set preferred size for the buttons
        Dimension buttonSize = new Dimension(200, 40); // Adjust the size as needed

        // Create buttons
        JButton playButton = new JButton("Play Game");
        JButton controlsButton = new JButton("Controls");
        JButton howToPlayButton = new JButton("How To Play?");
        JButton loadButton = new JButton("Load Game");
        JButton quitButton = new JButton("Quit Game");

        // Set preferred size for the buttons
        playButton.setPreferredSize(buttonSize);
        controlsButton.setPreferredSize(buttonSize);
        howToPlayButton.setPreferredSize(buttonSize);
        loadButton.setPreferredSize(buttonSize);
        quitButton.setPreferredSize(buttonSize);

        // Create a panel to contain the buttons
        JPanel buttonPanel = new JPanel(new GridBagLayout());
        buttonPanel.setOpaque(false); // Make the button panel transparent

        // Create constraints for centering the buttons
        GridBagConstraints buttonConstraints = new GridBagConstraints();
        buttonConstraints.gridx = 0;
        buttonConstraints.gridy = GridBagConstraints.RELATIVE;
        buttonConstraints.anchor = GridBagConstraints.CENTER;
        buttonConstraints.insets = new Insets(10, 0, 10, 0); // Add spacing between buttons

        // Add buttons to the button panel
        buttonPanel.add(playButton, buttonConstraints);
        buttonPanel.add(controlsButton, buttonConstraints);
        buttonPanel.add(howToPlayButton, buttonConstraints);
        buttonPanel.add(loadButton, buttonConstraints);
        buttonPanel.add(quitButton, buttonConstraints);

        // Add the button panel to the content panel
        GridBagConstraints contentConstraints = new GridBagConstraints();
        contentConstraints.gridx = 0;
        contentConstraints.gridy = 1;
        contentConstraints.anchor = GridBagConstraints.CENTER;
        contentConstraints.insets = new Insets(0, 0, 20, 0); // Add some spacing above the buttons
        content.add(buttonPanel, contentConstraints);

        playButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                isPressed = true;
                game.startGame();
                menu.dispose();
            }
        });

        controlsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                isControlsPressed = true;
                JOptionPane.showMessageDialog(content, "Controls: \n W - Jump \n A - Left \n D - Right \n Mouse click - Shoot");
            }
        });

        howToPlayButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                isControlsPressed = true;
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

        loadButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    GameLevel level = GameSaverLoader.load(game, "save_game.txt");
                    game.setLevel(level);
                    System.out.println("Game loaded successfully.");
                    menu.dispose(); // Close the menu after loading
                    game.startGame(); // Start the game
                } catch (IOException ex) {
                    System.out.println("Error loading game: " + ex.getMessage());
                }
            }
        });

        quitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

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
