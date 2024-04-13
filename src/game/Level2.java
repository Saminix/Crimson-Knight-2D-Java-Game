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

public class Level2 extends GameLevel{
    private SoundClip gameMusic;
    public Level2(Game game){
        super(game);

        /*

        try {
            gameMusic = new SoundClip("audio/GameMusic.wav");
            gameMusic.setVolume(0.1);
            gameMusic.play();
        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
            System.out.println(e);
        }

         */

        BoxCrate Lastpoint = new BoxCrate(this);
        Lastpoint.setPosition(new Vec2(-25,-9));
        BoxCrate Lastpointstack = new BoxCrate(this);
        Lastpointstack.setPosition(new Vec2(-25,-5.2f));

        Rock skyBoulder = new Rock(this,1.5f,21,8.3f,5.5f);
        Skeleton skel = new Skeleton(this,new Vec2(89,-6.3f),50,0.08f);



        float startX = 21;
        float startY = -8;

        int numCoins = 6;
        for(int i = 0; i < numCoins; i++){
            Coins coins = new Coins(this,0.8f,startX,startY,6);
            startX+=6;

        }


        float RockstartX = 14;
        float RockstartY = -8f;
        int numofRocks = 5;
        for(int i = 0; i < numofRocks; i++){
            Rock boulders = new Rock(this, 2.3f,RockstartX, RockstartY,8 );
            boulders.setPosition(new Vec2(RockstartX, RockstartY));
            RockstartX+=50;

        }



        //Trap Cactus = new Trap(this, "data/CactusSpikes.gif", 9);
        //Cactus.setPosition(new Vec2(68,-8));

        RockOre mines = new RockOre(this,2,58,-8,5);
        mines.setHealth(75);





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

        GroundPlatform elevatedPlatform3 = new GroundPlatform(this,
                6f, 1f, 29, 5, "data/EarthFloor copy 3.png", 4);
        elevatedPlatforms.add(elevatedPlatform3);




        getWarrior().setPosition(new Vec2(0, 0)); // Set initial position of the warrior
        getWarrior().setLinearVelocity(new Vec2(0, 0));

        //JumpPad pad = new JumpPad(this, new Vec2(20,-6),5,10, 10);

        CheckPoint flag = (new CheckPoint(this));
        flag.setPosition(new Vec2(200, -7f));





    }

    @Override
    public boolean isComplete() {
        boolean coinsCollected = getWarrior().getKey() > 1;
        if (coinsCollected) {
            gameMusic.stop();
        }
        return coinsCollected;

    }

    public void stopMusic() {
        if (gameMusic != null) {
            gameMusic.stop();
        }

    }
}

