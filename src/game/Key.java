package game;
import city.cs.engine.BodyImage;
import city.cs.engine.CircleShape;
import city.cs.engine.SoundClip;
import city.cs.engine.World;
import org.jbox2d.common.Vec2;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.io.IOException;

/**
 * Represents a key collectible in the game.
 * Extends the Collectibles class.
 */

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
    /**
     * Constructs a Key object in the world with the specified parameters.
     *
     * @param world  The world in which the key exists.
     * @param radius The radius of the key's circle shape.
     * @param x      The x-coordinate of the key's position.
     * @param y      The y-coordinate of the key's position.
     * @param height The height of the key.
     */

    public Key(World world, float radius, float x, float y, float height){
        super(world, new CircleShape(radius), new Vec2(x,y), height);
        addImage(new BodyImage(imagePath, height));
    }

    /**
     * Method to collect the key.
     *
     * @param value The value associated, when collecting the key.
     * @return The value collected.
     */
    @Override
    public int collectItem(int value){
        return value;
    }
    /**
     * Method to destroy the key and playing a collect sound.
     */
    @Override
    public void destroy()
    {
        collectSound.play();
        collectSound.setVolume(0.5);
        super.destroy();
        //destroy key object.
    }

}
