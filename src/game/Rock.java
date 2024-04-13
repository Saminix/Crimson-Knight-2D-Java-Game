package game;

import city.cs.engine.*;
import org.jbox2d.common.Vec2;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.io.IOException;

public class Rock extends Collectibles{

    private int health;

    private static final String image = "data/rocky.png";

    private static SoundClip destorySound;


    private boolean isPlayingAudio = false;

    static {
        try {
            destorySound = new SoundClip("audio/breakRock.wav");
        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
            System.out.println(e);
        }
    }

    public Rock(World world, float boxSizeWidth, float x, float y, float height){
        super(world, new CircleShape(boxSizeWidth), new Vec2(x,y), height);
        addImage(new BodyImage(image, height));
        this.health = 50;
    }

    public void TakenHit() {
        destorySound.play();
        if (getHealth() <= 0) {
            destorySound.play();
            super.destroy();

        }

    }
    public void setHealth(int health){
        this.health = health;

    }
    public int getHealth() {
        return health;
    }


    public void decrementHealth(int x){
        health = health - x;
    }
}



