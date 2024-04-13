package game;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainMenu extends ControlPanel {
    private boolean isPressed;
    private boolean isControlsPressed;
    private Game game;

    public MainMenu(Game game) {
        super(game);
        this.isPressed = false;
        this.game = game;
        this.isControlsPressed = false;

        // Create a Frame
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
        JButton quitButton = new JButton("Quit Game");

        Dimension buttonSize = new Dimension(200, 40);
        playButton.setPreferredSize(buttonSize);
        controlsButton.setPreferredSize(buttonSize);
        quitButton.setPreferredSize(buttonSize);

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
        buttonPanel.add(quitButton);
        GridBagConstraints buttonConstraints = new GridBagConstraints();
        buttonConstraints.gridx = 0;
        buttonConstraints.gridy = 1;
        buttonConstraints.insets = new Insets(0, 0, 20, 0); // Add some spacing above the buttons
        content.add(buttonPanel, buttonConstraints);

        menu.setVisible(true);
    }

    public boolean IsPlayButtonPressed() {
        return isPressed;
    }
    public boolean isControlsButtonPressed() {
        return isControlsPressed;
    }



}
