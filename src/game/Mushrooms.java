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
 * Class Mushrooms represents a subclass of the Collectibles class.
 */
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

    /**
     * Constructs a Mushroom object in the World with specific Parameters.
     *
     * @param world  In Which the Mushroom exists.
     * @param radius The radius of the Mushrooms Shape.
     * @param x      The  x-Coordinate of the Mushrooms Position.
     * @param y      The  y-Coordinate of the Mushrooms Position.
     * @param height The Size of the Mushroom's Image.
     */
    public Mushrooms(World world, float radius, float x, float y, float height){
        super(world, new CircleShape(radius), new Vec2(x,y), height);
        addImage(new BodyImage(imagePath, height));
    }
    /**
     * Method to destroy the Mushroom Object from the World
     * the Sound when this Happens.
     */
    @Override
    public void destroy()

    {
        MushroomSound.play();
        MushroomSound.setVolume(0.5);
        super.destroy();
    }


}


