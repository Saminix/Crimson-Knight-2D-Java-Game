package game;
import city.cs.engine.*;

import org.jbox2d.common.Vec2;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.io.IOException;
/**
 * Class Point represents a subclass of the Collectibles class.
 */
public class Point extends Collectibles {
    private static final String imagePath = "data/PointOrb.gif";

    private static SoundClip collectSound;

    static {
        try {
            collectSound = new SoundClip("audio/collectPoint.wav");

        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
            System.out.println(e);
        }
    }


    /**
     * Constructs a point collectible with the specified properties.
     *
     * @param world The world in which the point collectible exists.
     * @param boxSizeWidth The width of the point collectible.
     * @param x The x-coordinate of the point collectible's position.
     * @param y The y-coordinate of the point collectible's position.
     * @param height The height of the point collectible's image.
     */

    public Point(World world, float boxSizeWidth, float x, float y, float height){
        super(world, new CircleShape(boxSizeWidth), new Vec2(x,y), height);

        addImage(new BodyImage(imagePath, height));
    }

    /**
     * Collects the point and returns its value.
     *
     * @param value The value of the point collectible.
     * @return The value of the point collectible.
     */

    @Override
    public int collectItem(int value){
        return value;

    }

    /**
     * Destroys the point collectible and plays the collection sound.
     */
    @Override
    public void destroy()

    {
        collectSound.play();
        collectSound.setVolume(0.5);
        super.destroy();
    }


}

