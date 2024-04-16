package game;
import city.cs.engine.*;
import org.jbox2d.common.Vec2;

import java.util.ArrayList;

/**
 * Class Level4 is a subclass of GameLevel
 * Represent Level4 of the game.
 */

public class Level4 extends GameLevel{

    /**
     * Constructs the Level4 object.
     *
     * @param game The game object associated with this level.
     */

    public Level4(Game game){
        super(game);




        getWarrior().setPosition(new Vec2(-10, 1));
        getWarrior().setLinearVelocity(new Vec2(0, 0));

        Obstacle Pumpkin = new Obstacle(this,new CircleShape(5),"data/Pumpkin.png",-27,-4,9);

        PumpkinMan pumpkinMan = new PumpkinMan(this, new Vec2(67,-5),60,0.08f);
        PumpkinMan pumpkinMan1 = new PumpkinMan(this, new Vec2(190,-5),60,0.08f);

        Obstacle Pumpkin2 = new Obstacle(this,new CircleShape(1.5f),"data/Pumpkin.png",10,-7.5f,4);

        Obstacle Pumpkin3 = new Obstacle(this, new CircleShape(1.5f),"data/Pumpkin.png",35,-7.5f,4);

        Obstacle Pumpkin4 = new Obstacle(this, new CircleShape(1.5f),"data/Pumpkin.png",160,-7.5f,4);
        Obstacle Pumpkin5 = new Obstacle(this, new CircleShape(1.5f),"data/Pumpkin.png",145,7.5f,4);
        PumpkinMan pumpkinMan3 = new PumpkinMan(this, new Vec2(220,-5),60,0.09f);


        PumpkinMan pumpkinMan4 = new PumpkinMan(this, new Vec2(260,-5),60,0.09f);

        Key key1 = new Key(this,2,165f,-6,3);



        RockOre mines = new RockOre(this,2,93,-8,5);
        mines.setHealth(75);



        Mushrooms mushrooms = new Mushrooms(this,1.5f,6f,-7f,3);
        Mushrooms mushrooms2 = new Mushrooms(this,1.5f,85f,-7f,3);

        Mushrooms mushrooms3 = new Mushrooms(this,1.5f,200f,8f,3);


        float gstartX = -20;
        float gstartY = -12.5f;
        int numPlatforms = 13;
        for(int i = 0; i < numPlatforms; i++) {
            GroundPlatform groundPlatform = new GroundPlatform(this,
                    19f, 2.7f, gstartX, gstartY, "data/FarmGround.jpg", 7f);
            groundPlatform.setPosition(new Vec2(gstartX, gstartY));
            gstartX += 36f;
        }


        float startX = -13;
        float startY = -7;

        int numCoins = 7;
        for(int i = 0; i < numCoins; i++){
            Coins coins = new Coins(this,0.8f,startX,startY,6);
            startX+=6;

        }


        float start2X = 280;
        float start2Y = -7;

        int numCoins2 = 10;
        for(int i = 0; i < numCoins2; i++){
            Coins coins = new Coins(this,0.8f,start2X,start2Y,6);
            start2X+=6;

        }
        ArrayList<GroundPlatform> elevatedPlatforms = new ArrayList<>();


        GroundPlatform elevatedPlatform4 = new GroundPlatform(this,
                4.5f, 1f, 118, -2.5f, "data/SoilGround.png", 3.4f);
        elevatedPlatforms.add(elevatedPlatform4);


        Vec2 trampolinePosition = new Vec2(130, 2f);
        Trampoline trampoline = new Trampoline(this, trampolinePosition, 3.5f,0.04f,"data/SoilGround.png",3,0.5f,2.2f,0);

        GroundPlatform elevatedPlatform6 = new GroundPlatform(this,
                4.5f, 1f, 145, 5f, "data/SoilGround.png", 3.4f);
        elevatedPlatforms.add(elevatedPlatform6);

        Potion potion = new Potion(this,1,165,88,4);


        GroundPlatform elevatedPlatform3 = new GroundPlatform(this,
                4.5f, 1f, 150, 5f, "data/SoilGround.png", 3.4f);
        elevatedPlatforms.add(elevatedPlatform3);


        Trap snail = new Trap(this,"data/snail.gif", 10);
        snail.setPosition(new Vec2(167,8.2f));
        Trap snail2 = new Trap(this,"data/snail.gif", 10);
        snail2.setPosition(new Vec2(26,-7.5f));


        GroundPlatform elevatedPlatform7 = new GroundPlatform(this,
                4.5f, 1f, 167, 5f, "data/SoilGround.png", 3.4f);
        elevatedPlatforms.add(elevatedPlatform7);


        GroundPlatform elevatedPlatform8 = new GroundPlatform(this,
                4.5f, 1f, 185f, 3f, "data/SoilGround.png", 3.4f);
        elevatedPlatforms.add(elevatedPlatform8);


        Vec2 trampolinePosition1 = new Vec2(222, 2f);
        Trampoline trampoline1 = new Trampoline(this, trampolinePosition1, 3.5f,0.06f,"data/SoilGround.png",3,0.5f,2.6f,25);


        GroundPlatform elevatedPlatform9 = new GroundPlatform(this,
                4.5f, 1f, 260f, 3f, "data/SoilGround.png", 3.4f);
        elevatedPlatforms.add(elevatedPlatform8);


        float start3X = 118;
        float start3Y = -8;

        int numCoins3 = 13;
        for(int i = 0; i < numCoins3; i++){
            Coins coins = new Coins(this,0.8f,start3X,start3Y,6);
            start2X+=7;

        }
        //JumpPad pad = new JumpPad(this, new Vec2(20,-6),5,10, 10);

        CheckPoint flag = (new CheckPoint(this));

        flag.setPosition(new Vec2(340, -6.5f));

    }

    /**
     * Checks if the level4 is complete.
     *
     * @return true if the key is collected, indicating level completion, else false,
     */


    @Override
    public String getLevelName() {
        return "Level4";
    }

    @Override
    public boolean isComplete() {
        boolean keyCollected = getWarrior().getKey() > 0;
        if (keyCollected) {
        }
        return keyCollected;

    }

    /**
     * Stops the background music for the level.
     */

    public void stopMusic() {


    }

    @Override
    public String getPlayerStats() {
        // Implement the logic to get player stats for Level1
        // For example:
        return getWarriorStats();
    }

    @Override
    public void setPlayerStats(String playerStats) {
        // Implement the logic to set player stats for Level1
        // For example:
        getWarrior().setPlayerStats(playerStats);
    }

}

