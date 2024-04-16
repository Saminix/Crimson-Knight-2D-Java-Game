package game;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;


/**
 * Listens for mouse events and gives focus to a GameView when the mouse enters it.
 */
public class GiveFocus implements MouseListener {
    private GameView view;


    /**
     * Constructs a GiveFocus object with specified GameView.
     *
     * @param v The GameView to give focus on.
     */

    public GiveFocus(GameView v){
        this.view = v;
    }
    @Override
    public void mouseClicked(MouseEvent e) {

    }
    @Override
    public void mousePressed(MouseEvent e) {

    }
    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {
        view.requestFocus();
    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}
