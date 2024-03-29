package game;

import city.cs.engine.*;

import javax.swing.*;

import java.awt.*;


public class CheckPointEncounter  implements CollisionListener  {
    private GameLevel level;
    Game game;



    public CheckPointEncounter(GameLevel level, Game game){
        this.level = level;
        this. game = game;



    }

    @Override
    public void collide(CollisionEvent e){
        if (e.getOtherBody() instanceof CheckPoint){
            System.out.println("EndPoint Secured");

            if(level.isComplete()){
                game.isNextLevel();


            }

        }
    }



}
