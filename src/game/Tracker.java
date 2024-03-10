package game;

import city.cs.engine.StepListener;
import city.cs.engine.StepEvent;
import org.jbox2d.common.Vec2;

public class Tracker implements StepListener {
    private GameView view;
    private final Warrior warrior;
    public Tracker(GameView view, Warrior warrior){
        this.warrior = warrior;
        this.view = view;
    }

    public void preStep(StepEvent e) {}
    public void postStep(StepEvent e) {

        Vec2 currentCentre = view.getCentre();
        Vec2 newCentre = new Vec2(warrior.getPosition().x, currentCentre.y);
        view.setCentre(newCentre);
    }

}


