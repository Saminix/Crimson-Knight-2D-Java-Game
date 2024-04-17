package game;
import city.cs.engine.*;

import javax.swing.*;

import java.awt.*;
/**
 This Class Represents an active CollisionListener that detects if the warrior collides with
 * the Checkpoint(which is the door), it triggers an action event that proceeds to the next Level if
 * certain conditions are met.
 *
 */
public class CheckPointEncounter  implements CollisionListener  {
    private GameLevel level;
    Game game;
    /**
     * CheckpointEncounter class with specified GameLevel and Game
     *
     * @param level The GameLevel Associated with the CheckPointEncounter.
     * @param game The Game Associated with the CheckPointEncounter.
     */
    public CheckPointEncounter(GameLevel level, Game game){
        this.level = level;
        this. game = game;
    }
    /**
     * This Method responds to the Collision event involving the warrior and Checkpoint.
     * If the Collision instance of the CheckPoint is met and the condition of the level is complete,
     * then the current level is halted, current frame is disposed and the game will proceed to next level.
     *
     * @param e The CollisionEvent called e represents the Collision.
     */
    @Override
    public void collide(CollisionEvent e){
        if (e.getOtherBody() instanceof CheckPoint){
            System.out.println("EndPoint Secured");
            if(level.isComplete()){

                game.disposeCurrentLevelFrame();
                game.isNextLevel();
            }
        }
    }
}
