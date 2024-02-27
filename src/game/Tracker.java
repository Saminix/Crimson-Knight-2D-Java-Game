package game;

import city.cs.engine.StepListener;
import city.cs.engine.StepEvent;
import city.cs.engine.StepListener;
import game.GameView;
import game.Warrior;
import org.jbox2d.common.Vec2;

import java.awt.geom.Point2D;

public class Tracker implements StepListener {
    private GameView view;
    private Warrior warrior;

    public Tracker(GameView view, Warrior warrior){
        this.warrior = warrior;
        this.view = view;
    }

    public void preStep(StepEvent e) {}
    public void postStep(StepEvent e) {
        view.setCentre(warrior.getPosition());
    }

}


