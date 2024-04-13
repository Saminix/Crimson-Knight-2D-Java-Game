package game;

import city.cs.engine.SoundClip;
import org.jbox2d.common.Vec2;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.io.IOException;

public class Level3 extends GameLevel{
    private SoundClip gameMusic;



    public Level3(Game game){
        super(game);

        try {
            gameMusic = new SoundClip("audio/GameMusic.wav");
            gameMusic.setVolume(0.3);
            gameMusic.loop();
        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
            System.out.println(e);
        }


        //add a checkpoint towards the end of the game(just image)


        float gstartX = 0;
        float gstartY = -25f;
        int numPlatforms = 20;
        for(int i = 0; i < numPlatforms; i++){
            GroundPlatform groundPlatform = new GroundPlatform(this,
                    28,2.8f,gstartX, gstartY, "data/cobblestone.jpg", 7 );
            groundPlatform.setPosition(new Vec2(gstartX, gstartY));
            gstartX+=30;

        }



    }


    @Override
    public boolean isComplete(){
        boolean coinsCollected = getWarrior().getKey() > 2;
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
