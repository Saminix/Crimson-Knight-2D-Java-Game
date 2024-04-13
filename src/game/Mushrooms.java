package game;

import city.cs.engine.BodyImage;
import city.cs.engine.CircleShape;
import city.cs.engine.SoundClip;
import city.cs.engine.World;
import org.jbox2d.common.Vec2;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.io.IOException;

public class Mushrooms extends Collectibles{
    private static final String imagePath = "data/mushrooms.gif";
    private static SoundClip MushroomSound;

    static {
        try {
            MushroomSound = new SoundClip("audio/Arabian.wav");
        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
            System.out.println(e);
        }
    }


    public Mushrooms(World world, float radius, float x, float y, float height){
        super(world, new CircleShape(radius), new Vec2(x,y), height);
        addImage(new BodyImage(imagePath, height));

    }


    @Override
    public void destroy()

    {
        MushroomSound.play();
        MushroomSound.setVolume(0.5);
        super.destroy();
    }

    public void setVolume(double volume){

    }


}


