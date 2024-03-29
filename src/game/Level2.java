package game;

import city.cs.engine.BoxShape;
import city.cs.engine.*;

import city.cs.engine.Shape;
import city.cs.engine.StaticBody;
import org.jbox2d.common.Vec2;

public class Level2 extends GameLevel{
    public Level2(Game game){
        super(game);



        // make a platform

        float gstartX = 0;
        float gstartY = -13f;
        int numPlatforms = 10;
        for(int i = 0; i < numPlatforms; i++){
            GroundPlatform groundPlatform = new GroundPlatform(this,
                    28,1.7f,gstartX, gstartY, "data/EarthFloor.png", 7 );
            groundPlatform.setPosition(new Vec2(gstartX, gstartY));
            gstartX+=56;

        }

        GroundPlatform elevatedPlatform = new GroundPlatform(this,
                5f,1.7f,0,4,  "data/EarthFloor copy 4.png", 6 );



        getWarrior().setPosition(new Vec2(0, 0)); // Set initial position of the warrior
        getWarrior().setLinearVelocity(new Vec2(0, 0));

    }

    @Override
    public boolean isComplete() {
        return getWarrior().getCoins()> 100;
    }
}

