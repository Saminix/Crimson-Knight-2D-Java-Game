package game;

import city.cs.engine.SoundClip;
import org.jbox2d.common.Vec2;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Class Level3 is a subclass of GameLevel
 * Represent Level3 of the game.
 */

public class Level3 extends GameLevel{
    private SoundClip gameMusicLevel3;


    /**
     * Constructs the Level3 object.
     *
     * @param game The game object associated with this level.
     */


    public Level3(Game game, SoundClip gameMusicLevel3){
        super(game);
        this.gameMusicLevel3 = gameMusicLevel3;


        //add a checkpoint towards the end of the game(just image)


        Mushrooms mushrooms = new Mushrooms(this,1.5f,-182f,-7f,3);
        Mushrooms mushrooms1 = new Mushrooms(this,1.5f,-20f,7f,3);


        float startPlantX = -171;
        float startPlantY = -7.5f;

        int numofPlants = 3;
        for(int i = 0; i < numofPlants; i++){
            Trap plant = new Trap(this, "data/plant1.gif", 7);
            plant.setPosition(new Vec2(startPlantX, startPlantY));
            startPlantX+=22.5f;

        }


        float gstartX = -195;
        float gstartY = -13.5f;
        int numPlatforms = 40;
        for(int i = 0; i < numPlatforms; i++){
            GroundPlatform groundPlatform = new GroundPlatform(this,
                    28,2.8f,gstartX, gstartY, "data/cobblestone.jpg", 7 );
            groundPlatform.setPosition(new Vec2(gstartX, gstartY));
            gstartX+=30;

        }

        GroundPlatform wall = new GroundPlatform(this, 4,20, -198.5f,-11,"data/brickwall.jpg",70);


        float startX = -185;
        float startY = -8;

        int numCoins = 10;
        for(int i = 0; i < numCoins; i++){
            Coins coins = new Coins(this,0.8f,startX,startY,6);
            startX+=8;

        }

        float startZombX = -10;
        float startZombY = -6.2f;

        int numofZomb = 3;
        for(int i = 0; i < numofZomb; i++){
            Zombie zombies = new Zombie(this, new Vec2(startZombX,startZombY),6,0.04f,warrior);
            startZombX+=15;

        }


        ArrayList<GroundPlatform> elevatedPlatforms = new ArrayList<>();

        //1st platform

        GroundPlatform elevatedPlatform1 = new GroundPlatform(this,
                11f, 1f, -85, 2, "data/Level3Platform.png", 5.3f);
        elevatedPlatforms.add(elevatedPlatform1);


        //middle platform

        GroundPlatform elevatedPlatform2 = new GroundPlatform(this,
                11f, 1.2f, -45f, 3, "data/Level3Platform.png", 5.3f);
        elevatedPlatforms.add(elevatedPlatform2);


        //Last Platform

        GroundPlatform elevatedPlatform4 = new GroundPlatform(this,
                11f, 1.2f, -20f, 4.5f, "data/Level3Platform.png", 5.3f);
        elevatedPlatforms.add(elevatedPlatform4);

        Vec2 batPosition = new Vec2(-80,8f);
        Bat bat = new Bat(this,batPosition,30,0.08f);



        Rock Boulder = new Rock(this,1.5f,-15,8f,7f);


        Vec2 trampolinePosition = new Vec2(-103.5f, -7f);
        Trampoline trampoline = new Trampoline(this, trampolinePosition, 11.5f,0.05f,"data/Level3MovingPlatform.png",3.5f,1f,5.5f,0);


        float start2X = -53;
        float start2Y = 6;

        int numCoins2 = 5;
        for(int i = 0; i < numCoins2; i++){
            Coins coins1 = new Coins(this,0.8f,start2X,start2Y,6);
            start2X+=4;

        }


        float start3X = 90;
        float start3Y = 7;

        int numCoins3 = 5;
        for(int i = 0; i < numCoins3; i++){
            Coins coins = new Coins(this,0.8f,start3X,start3Y,6);
            start3X+=5;

        }


        Vec2 trampolinePosition2 = new Vec2(-3f, -7f);
        Trampoline trampoline2 = new Trampoline(this, trampolinePosition2, 11.5f,0.05f,"data/Level3MovingPlatform.png",2.5f,0.5f,3.5f,0);

        Potion potion = new Potion(this,1,16,5.5f,4);


        GroundPlatform elevatedPlatform5 = new GroundPlatform(this,
                11f, 1.2f, 14f, 2.5f, "data/Level3Platform.png", 5.3f);
        elevatedPlatforms.add(elevatedPlatform5);


        Vec2 batPosition2 = new Vec2(40,-5f);
        Bat bat2 = new Bat(this,batPosition2,30,0.08f);



        float startPlant2X = 48;
        float startPlant2Y = -7.5f;

        int numofPlants2 = 3;
        for(int i = 0; i < numofPlants2; i++){
            Trap plant = new Trap(this, "data/plant1.gif", 7);
            plant.setPosition(new Vec2(startPlant2X, startPlant2Y));
            startPlant2X+=45f;

        }


        float startZombieX = 190;
        float startZombieY = -6.2f;

        int numofZombies = 10;
        for(int i = 0; i < numofZombies; i++){
            Zombie zombiesHoarde = new Zombie(this, new Vec2(startZombieX,startZombieY),6,0.03f,warrior);
            startZombieX+=20;

        }

        Mushrooms mushrooms3 = new Mushrooms(this,1.5f,0f,-7.5f,3);
        Potion potion2 = new Potion(this,1,66,-7.5f,4);


        GroundPlatform elevatedPlatform6 = new GroundPlatform(this,
                11f, 1.2f, 55f, 3.5f, "data/Level3Platform.png", 5.3f);
        elevatedPlatforms.add(elevatedPlatform6);


        Vec2 trampolinePosition3 = new Vec2(36f, -7f);
        Trampoline trampoline3 = new Trampoline(this, trampolinePosition3, 11.5f,0.05f,"data/Level3MovingPlatform.png",2.5f,0.5f,4.5f,0);

        GroundPlatform elevatedPlatform7 = new GroundPlatform(this,
                11f, 1.2f, 70f, 3.5f, "data/Level3Platform.png", 5.3f);
        elevatedPlatforms.add(elevatedPlatform7);

        Rock Boulder2 = new Rock(this,1.5f,75,6f,7f);

        GroundPlatform elevatedPlatform8 = new GroundPlatform(this,
                11f, 1.2f, 100f, 3.5f, "data/Level3Platform.png", 5.3f);
        elevatedPlatforms.add(elevatedPlatform8);



        Key key = new Key(this,2,140f,7,3);

        getWarrior().setPosition(new Vec2(-192, 8));
        getWarrior().setLinearVelocity(new Vec2(0, 0));

        Vec2 trampolinePosition4 = new Vec2(125f, -7f);
        Trampoline trampoline4 = new Trampoline(this, trampolinePosition4, 13.5f,0.05f,"data/Level3MovingPlatform.png",3.5f,0.5f,5f,0);


        GroundPlatform elevatedPlatform9 = new GroundPlatform(this,
                11f, 1.2f, 147f, 3.5f, "data/Level3Platform.png", 5.3f);
        elevatedPlatforms.add(elevatedPlatform9);

        Treasure treasure1 = new Treasure(this, 2, 2,73f,6f,5);


        CheckPoint flag = (new CheckPoint(this));


        flag.setPosition(new Vec2(150, 7f));


        GroundPlatform wallend = new GroundPlatform(this, 4,20, 170f,-11,"data/brickwall.jpg",70);

    }

    /**
     * Checks if the level3 is complete.
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
        if (gameMusicLevel3 != null) {
            gameMusicLevel3.stop();
        }

    }


}
