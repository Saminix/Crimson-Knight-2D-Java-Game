package game;


import city.cs.engine.BodyImage;
import city.cs.engine.CircleShape;
import city.cs.engine.SoundClip;
import city.cs.engine.World;
import org.jbox2d.common.Vec2;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.io.IOException;

public class Key extends Collectibles{
    private static final String imagePath = "data/Key.gif";

    private static SoundClip collectSound;

    static {
        try {
            collectSound = new SoundClip("audio/potion.wav");

        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
            System.out.println(e);
        }
    }

    public Key(World world, float radius, float x, float y, float height){
        super(world, new CircleShape(radius), new Vec2(x,y), height);
        height = 4;
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
