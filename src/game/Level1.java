package game;
import city.cs.engine.BoxShape;
import city.cs.engine.SoundClip;
import org.jbox2d.common.Vec2;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Class Level1 is a subclass of GameLevel
 * Represent Level1 of the game.
 */

public class Level1 extends GameLevel{

    private SoundClip gameMusic;

    /**
     * Constructs the Level1 object.
     *
     * @param game The game object associated with this level.
     */


    public Level1(Game game, SoundClip gameMusic){
        super(game);
        this.gameMusic = gameMusic;


        Vec2 monsterPosition = new Vec2(-15, -18.5f);
        Monster monster = new Monster(this, monsterPosition,45,0.12f);

        Vec2 monsterPosition1 = new Vec2(65, -18.5f);
        Monster monster1 = new Monster(this, monsterPosition1,45,0.12f);

        Vec2 batPosition = new Vec2(50, 2f);
        Bat bat = new Bat(this,batPosition,30,0.08f);


        Key key = new Key(this,2,55,2,3);


        Obstacle wall = new Obstacle(this,new BoxShape(2,2),"data/box.png",-200,-18.5f,5);
        wall.setPosition(new Vec2(-200,-18.5f));

        Mushrooms mushrooms = new Mushrooms(this,1.5f,132.5f,-15.6f,3);

        //Using a ForLoop to create 4 box crates at different x coordinate intervals
        float boxX = -165;
        float boxY = -18.5f;

        int BoxS = 4;
        for(int i = 0; i < BoxS; i++){
            Obstacle box = new Obstacle(this,new BoxShape(2,2),"data/box.png",boxX,boxY,5);
            box.setPosition(new Vec2(boxX, boxY));
            boxX+=37;

        }

        ArrayList<Obstacle> boxsList = new ArrayList<>();


        Obstacle box1 = new Obstacle(this,new BoxShape(2,2),"data/box.png",-124.1f, -18.5f,5);
        box1.setPosition(new Vec2(-124.1f, -18.5f));
        boxsList.add(box1);

        Obstacle box2 = new Obstacle(this,new BoxShape(2,2),"data/box.png",-124.1f, -14.5f,5);
        box2.setPosition(new Vec2(-124.1f, -14.5f));
        boxsList.add(box2);

        Obstacle box3 = new Obstacle(this,new BoxShape(2,2),"data/box.png",-124.1f, -14.5f,5);
        box3.setPosition(new Vec2(-124.1f, -14.5f));
        boxsList.add(box3);


        float box2X = -83;
        float box2Y = -18.5f;
        // Add the three-layered box obstacle


        int BoxxS = 3;
        for(int i = 0; i < BoxxS; i++){
            Obstacle box4 = new Obstacle(this,new BoxShape(2,2),"data/box.png",box2X, box2Y,5);
            box4.setPosition(new Vec2(box2X, box2Y));
            box2Y+=4.5;

        }


        Obstacle box5 = new Obstacle(this,new BoxShape(2,2),"data/box.png",-87, -18.5f,5);
        box5.setPosition(new Vec2(-87, -18.5f));
        boxsList.add(box5);

        Obstacle box6 = new Obstacle(this,new BoxShape(2,2),"data/box.png",-87, -14.5f,5);
        box6.setPosition(new Vec2(-87, -14.5f));
        boxsList.add(box6);

        Obstacle box7 = new Obstacle(this,new BoxShape(2,2),"data/box.png",-78.5f, -18.5f,5);
        box7.setPosition(new Vec2(-78.5f, -18.5f));
        boxsList.add(box7);

        Obstacle box8 = new Obstacle(this,new BoxShape(2,2),"data/box.png",103.9f, -17.5f,5);
        box8.setPosition(new Vec2(103.9f, -17.5f));
        boxsList.add(box8);



        //Using a ForLoop to create coins for collection at cohesive x coordinate intervals
        float startCoinX = -161;
        float startCoinY = -17.9f;

        int numCoins2 = 15;
        for(int i = 0; i < numCoins2; i++){
            Coins coins = new Coins(this,0.8f,startCoinX,startCoinY,6);
            startCoinX+=9;

        }

        //Using a ForLoop to create 2 Traps(turtles)  at different x coordinate intervals


        float startTurtleX = -110;
        float startTurtleY = -19.5f;

        int numTurtle = 2;
        for(int i = 0; i < numTurtle; i++){
            Trap turtle = new Trap(this, "data/obstacle1.gif", 7);
            turtle.setPosition(new Vec2(startTurtleX, startTurtleY));
            startTurtleX+=44;

        }

        //create Platforms using for loop that extend for the duration of the game;

        float gstartX = -205;
        float gstartY = -22.9f;
        int numPlatforms = 6;
        for(int i = 0; i < numPlatforms; i++){
            GroundPlatform groundPlatform = new GroundPlatform(this,
                    28,2.2f,gstartX, gstartY, "data/grassfloor.png", 7 );
            groundPlatform.setPosition(new Vec2(gstartX, gstartY));
            gstartX+=56;

        }
        // Make a suspended platform
        GroundPlatform elevatedPlatform = new GroundPlatform(this,
                11.5f,1f,-13, -6f, "data/grassplatform.png", 6 );


        GroundPlatform elevatedPlatform1 = new GroundPlatform(this,
                12.5f,1f,23,-13.5f,  "data/grassplatform.png", 6 );

        GroundPlatform elevatedPlatform2 = new GroundPlatform(this,
                12.5f,1f,61,-13.5f,  "data/grassplatform.png", 6 );

        GroundPlatform elevatedPlatform3 = new GroundPlatform(this,
                12.5f,1f,51,-2,  "data/grassplatform.png", 6 );

        //create trampoline platform
        Vec2 trampolinePosition = new Vec2(31, -9);
        Trampoline trampoline = new Trampoline(this,  trampolinePosition, 5.5f,0.05f,"data/movingGrassPlatform.png", 2.5f,0.2f,4.5f,0);

        Vec2 trampolinePosition1 = new Vec2(42, -17);
        Trampoline trampoline1 = new Trampoline(this, trampolinePosition1, 4.5f,0.05f,"data/movingGrassPlatform.png", 2.5f,0.2f,4.5f,0);

        Vec2 trampolinePosition2 = new Vec2(5, -17);
        Trampoline trampoline2 = new Trampoline(this, trampolinePosition2, 4.5f,0.04f,"data/movingGrassPlatform.png", 2.5f,0.2f,4.5f,0);


        //using for-loop to add 10 coins to the game world along intervals of x,
        // the value of x coordinate is incremented by x
        float startX = 112;
        float startY = -16;

        int numCoins = 4;
        for(int i = 0; i < numCoins; i++){
            Coins coins = new Coins(this,0.8f,startX,startY,6);
            startX+=8;

        }

        // Add coins
        ArrayList<Coins> coinsList = new ArrayList<>();
        coinsList.add(new Coins(this, 0.8f, -13.5f, -3f, 6));
        coinsList.add(new Coins(this, 0.8f, -15.5f, -3f, 6));
        coinsList.add(new Coins(this, 0.8f, 61f, -10f, 6));


        //create other instances from other classes
        Treasure treasure1 = new Treasure(this, 2, 2,65f,-11f,5);


        Trap turtle = new Trap(this, "data/obstacle1.gif", 7);
        turtle.setPosition(new Vec2(-6, -3.4f));
        Trap beartrap = new Trap(this, "data/beartrap.gif",5);
        beartrap.setPosition(new Vec2(52, -10.9f));


        Potion potion = new Potion(this,1,100,-18,4);


        float g2startX = 146f;
        float g2startY = -21f;
        int numberPlatforms = 1;
        for(int i = 0; i < numberPlatforms; i++){
            GroundPlatform groundPlatform = new GroundPlatform(this,
                    40,2.6f,g2startX, g2startY, "data/grassfloor.png", 9 );
            groundPlatform.setPosition(new Vec2(g2startX, g2startY));
            g2startX+=56;

        }

        //add a checkpoint towards the end of the game(just image)

        CheckPoint flagy = (new CheckPoint(this));
        flagy.setPosition(new Vec2(150, -13.2f));



    }



    /**
     * Checks if the level is complete.
     *
     * @return true if the key is collected, indicating level completion, else false,
     */


    @Override
    public boolean isComplete(){
        boolean keyCollected = getWarrior().getKey() > 0;
        if (keyCollected) {
        }
        return keyCollected;



    }

    /**
     * Stops the background music for the level.
     */
    public void stopMusic() {
        if (gameMusic != null) {
            gameMusic.stop();
        }

    }



}
