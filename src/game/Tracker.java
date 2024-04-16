package game;

import city.cs.engine.StepListener;
import city.cs.engine.StepEvent;
import org.jbox2d.common.Vec2;


/**
 * A class that tracks the position of the warrior and adjusts the view  in the GameView.
 */
public class Tracker implements StepListener {
    private GameView view;
    private final Warrior warrior;

    /**
     * Constructs a Tracker object.
     * @param view The GameView to be tracked.
     * @param warrior The warrior whose position will be tracked.
     */
    public Tracker(GameView view, Warrior warrior){
        this.warrior = warrior;
        this.view = view;
    }

    /**
     * Method called before each step.
     * @param e Information about step event.
     */
    public void preStep(StepEvent e) {}


    /**
     * Method called for step.
     * Adjusts the view centre to follow the warrior's position;
     * @param e  the step event.
     */
    public void postStep(StepEvent e) {

        Vec2 currentCentre = view.getCentre();
        Vec2 newCentre = new Vec2(warrior.getPosition().x, currentCentre.y);
        view.setCentre(newCentre);
    }

}


