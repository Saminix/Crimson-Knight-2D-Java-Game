package game;

import city.cs.engine.BoxShape;
import city.cs.engine.*;

import city.cs.engine.Shape;
import city.cs.engine.StaticBody;
import org.jbox2d.common.Vec2;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.io.IOException;
import java.util.ArrayList;


/**
 * Class Level2 is a subclass of GameLevel
 * Represent Level2 of the game.
 */

public class Level2 extends GameLevel{

    /**
     * Constructs the Level2 object.
     *
     * @param game The game object associated with this level.
     */

    public Level2(Game game, String playerStats){
        super(game);


        Rock Boulder1 = new Rock(this,4f,-34,-8f,20f);



        Obstacle Lastpoint = new Obstacle(this, new BoxShape(2,2), "data/box.png",-25,-9,5);
        Lastpoint.setPosition(new Vec2(-25,-9));
        Obstacle Lastpointstack = new Obstacle(this, new BoxShape(2,2), "data/box.png",-25,-5.2f,5);
        Lastpointstack.setPosition(new Vec2(-25,-5.2f));

        Rock skyBoulder = new Rock(this,1.5f,21,8.3f,5.5f);
        Skeleton skel = new Skeleton(this,new Vec2(170,-6.3f),50,0.08f);
        Rock Boulder = new Rock(this,1.5f,14,-8f,8f);

        Key key1 = new Key(this,2,165f,-6,3);

        Trap Cactus = new Trap(this, "data/CactusSpikes.gif", 8);
        Cactus.setPosition(new Vec2(210,-8));



        float startX = -13;
        float startY = -8;

        int numCoins = 4;
        for(int i = 0; i < numCoins; i++){
            Coins coins = new Coins(this,0.8f,startX,startY,6);
            startX+=7;

        }


        float RockstartX = 25;
        float RockstartY = -8f;
        int numofRocks = 5;
        for(int i = 0; i < numofRocks; i++){
            Rock boulders = new Rock(this, 2.8f,RockstartX, RockstartY,10 );
            boulders.setPosition(new Vec2(RockstartX, RockstartY));
            RockstartX+=27;

        }


        float Rock2startX = 35;
        float Rock2startY = -8f;
        int numofRocks2 = 5;
        for(int i = 0; i < numofRocks2; i++){
            Rock boulders = new Rock(this, 2.3f,Rock2startX, Rock2startY,8 );
            boulders.setPosition(new Vec2(Rock2startX, Rock2startY));
            Rock2startX+=16;

        }

        RockOre mines = new RockOre(this,2,62,-8,5);
        mines.setHealth(75);
        RockOre mines1 = new RockOre(this,2,195,-8,5);
        mines.setHealth(75);

        Mushrooms mushrooms = new Mushrooms(this,1.5f,26f,8.3f,3);
        Mushrooms mushrooms2 = new Mushrooms(this,1.5f,30f,8.3f,3);



        float gstartX = -35;
        float gstartY = -13f;
        int numPlatforms = 10;
        for(int i = 0; i < numPlatforms; i++){
            GroundPlatform groundPlatform = new GroundPlatform(this,
                    28,1.7f,gstartX, gstartY, "data/EarthFloor.png", 7 );
            groundPlatform.setPosition(new Vec2(gstartX, gstartY));
            gstartX+=56;

        }


        ArrayList<GroundPlatform> elevatedPlatforms = new ArrayList<>();

        GroundPlatform elevatedPlatform1 = new GroundPlatform(this,
                6f, 1f, 15, 5, "data/EarthFloor copy 3.png", 4);
        elevatedPlatforms.add(elevatedPlatform1);

        GroundPlatform elevatedPlatform2 = new GroundPlatform(this,
                6f, 1f, -2, -3, "data/EarthFloor copy 3.png", 4);
        elevatedPlatforms.add(elevatedPlatform2);



        Vec2 batPosition1 = new Vec2(57, 8.5f);
        Bat bat1 = new Bat(this,batPosition1,40,0.09f);

        GroundPlatform elevatedPlatform3 = new GroundPlatform(this,
                6f, 1f, 29, 4.7f, "data/EarthFloor copy 3.png", 4);
        elevatedPlatforms.add(elevatedPlatform3);

        GroundPlatform elevatedPlatform4 = new GroundPlatform(this,
                3f, 0.5f, 141, -2.5f, "data/EarthFloor copy 3.png", 2.5f);
        elevatedPlatforms.add(elevatedPlatform4);


        Vec2 trampolinePosition = new Vec2(150, 2f);
        Trampoline trampoline = new Trampoline(this, trampolinePosition, 3.5f,0.04f,"data/EarthFloor copy 3.png",3,0.5f,2.2f,0);

        GroundPlatform elevatedPlatform6 = new GroundPlatform(this,
                3f, 0.5f, 160, 5f, "data/EarthFloor copy 3.png", 2.5f);
        elevatedPlatforms.add(elevatedPlatform6);

        Potion potion = new Potion(this,1,165,-8,4);


        Vec2 batPosition = new Vec2(188, 5.8f);
        Bat bat = new Bat(this,batPosition,30,0.08f);


        GroundPlatform elevatedPlatform7 = new GroundPlatform(this,
                3f, 0.5f, 167, 5f, "data/EarthFloor copy 3.png", 2.5f);
        elevatedPlatforms.add(elevatedPlatform7);


        GroundPlatform elevatedPlatform8 = new GroundPlatform(this,
                3f, 0.5f, 185f, 3f, "data/EarthFloor copy 3.png", 2.5f);
        elevatedPlatforms.add(elevatedPlatform8);



        getWarrior().setPosition(new Vec2(0, 0)); // Set initial position of the warrior
        getWarrior().setLinearVelocity(new Vec2(0, 0));


        float start2X = 209;
        float start2Y = -8;

        int numCoins2 = 8;
        for(int i = 0; i < numCoins; i++){
            Coins coins = new Coins(this,0.8f,start2X,start2Y,6);
            start2X+=7;

        }






        Rock Boulder2 = new Rock(this,1.5f,280,-8f,8f);
        Rock Boulder3 = new Rock(this,1.5f,292,-8f,8f);
        Rock Boulder4 = new Rock(this,1.5f,307,-8f,8f);

        Skeleton skel2 = new Skeleton(this,new Vec2(250,-6.3f),50,0.08f);

        CheckPoint flag = (new CheckPoint(this));

        flag.setPosition(new Vec2(298, -7f));

        //TEST
        //flag.setPosition(new Vec2(20, -7f));


    }



    /**
     * Checks if the level2 is complete.
     *
     * @return true if the key is collected, indicating level completion, else false,
     */


    @Override
    public boolean isComplete() {
        boolean keyCollected = getWarrior().getKey() > 0;
        if (keyCollected) {
        }
        return keyCollected;

    }


    /**
     * Returns the name of the current level.
     *
     * @return A string representing the name of the current level.
     */
    @Override
    public String getLevelName() {
        return "Level2";
    }

    /**
     * Stops the background music for the level.
     * This method is responsible for stopping any ongoing background music
     * that may be playing during the level.
     */
    public void stopMusic() {

    }



    /**
     * Retrieves the statistics of the player (Warrior) for this level.
     *
     * @return A string containing the player's health, score, and coins.
     */
    @Override
    public String getPlayerStats() {
        Warrior warrior = getWarrior();

        return "Health:" + warrior.getHealth() + ",Score:" + warrior.getScore() + ",Coins:" + warrior.getCoins();
    }


    /**
     * Sets the statistics of the player (Warrior) for this level.
     *
     * @param playerStats A string containing the player's health, score, and coins.
     */

    @Override
    public void setPlayerStats(String playerStats) {
        getWarrior().setPlayerStats(playerStats);
    }

}

