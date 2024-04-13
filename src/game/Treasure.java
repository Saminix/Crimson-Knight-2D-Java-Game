package game;
import city.cs.engine.*;
import org.jbox2d.common.Vec2;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.io.IOException;

public class Treasure extends Collectibles{


    private static final String imagePath = "data/Treasure.gif";


    private static SoundClip collectSound;

    static {
        try {
            collectSound = new SoundClip("audio/treasure.wav");

        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
            System.out.println(e);
        }
    }

    public Treasure(World world, float boxSizeWidth, float boxSizeHeight, float x, float y, float height){
        super(world, new BoxShape(boxSizeWidth, boxSizeHeight), new Vec2(x,y), height);
        height = 5;
        addImage(new BodyImage(imagePath, height));
    }



    @Override
    public int collectItem(int value){
        return value;

    }


    @Override
    public void destroy()

    {
        collectSound.play();
        collectSound.setVolume(0.5);
        super.destroy();
    }




}




