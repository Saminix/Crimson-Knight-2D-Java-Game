package game;
import javax.swing.*;
/**
 * Class Control Panel is a subclass of JPanel
 * Represents a control panel in the game
 * used to display game controls and information.
 */
public class ControlPanel extends JPanel {
    private Game game;
    /**
     * Constructs a ControlPanel with the specified game instance.
     *
     * @param game The Game instance associated with this control panel.
     */
    public ControlPanel(Game game) {
        this.game = game;
    }
}
