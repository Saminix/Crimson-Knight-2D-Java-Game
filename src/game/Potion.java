package game;
import city.cs.engine.*;
import org.jbox2d.common.Vec2;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.io.IOException;
/**
 * Class Potion Represents a potion collectible in the game world.
 */

public class Potion extends Collectibles{
    private static final String imagePath = "data/HealthPotion.gif";
    private static SoundClip collectSound;

    static {
        try {
            collectSound = new SoundClip("audio/potion.wav");

        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
            System.out.println(e);
        }
    }

    /**
     *
     * Constructs a Potion collectible in the World with specific Parameters.
     *
     * @param world The world in which the potion collectible exists.
     * @param radius The radius of the potion collectible.
     * @param x The x-coordinate of the potion collectible's position.
     * @param y The y-coordinate of the potion collectible's position.
     * @param height The height of the potion collectible's image.
     */
    public Potion(World world, float radius, float x, float y, float height){
        super(world, new CircleShape(radius), new Vec2(x,y), height);
        height = 4;
        addImage(new BodyImage(imagePath, height));
    }

    /**
     * Collects the potion and returns its value.
     *
     * @param value The value of the potion collectible.
     * @return The value of the potion collectible.
     */
    @Override
    public int collectItem(int value){
        return value;
    }
    /**
     * Destroys the potion collectible and plays the collection sound.
     */
    @Override
    public void destroy()
    {
        collectSound.play();
        collectSound.setVolume(0.5);
        super.destroy();
    }

}