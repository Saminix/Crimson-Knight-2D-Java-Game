package game;
import java.io.IOException;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import city.cs.engine.*;
import org.jbox2d.common.Vec2;

/**
 * Class Coins represents a subclass of the Collectibles class.
 */
public class Coins extends Collectibles{
    // Variables for Coin Sound
    private static final String imagePath = "data/Coin.gif";
    private static SoundClip coinsSound;
    //File exception for audio
    static {
        try {
            coinsSound = new SoundClip("audio/Coins.wav");
        } catch (UnsupportedAudioFileException|IOException|LineUnavailableException e) {
            System.out.println(e);
        }
    }

    /**
     * Constructs a Coin object in the World with specific Parameters.
     *
     * @param world  In Which the Coin exists.
     * @param radius The radius of the Coins Shape.
     * @param x      The  x-Coordinate of the Coins Position.
     * @param y      The  y-Coordinate of the Coins Position.
     * @param height The Size of the Coin's Image.
     */
    public Coins(World world, float radius,float x, float y, float height){
        super(world, new CircleShape(radius), new Vec2(x,y), height);
        addImage(new BodyImage(imagePath, height));

    }
    /**
     * Method to destroy the Coin Object from the World
     * the Sound when this Happens.
     */
    @Override
    public void destroy()

    {
        coinsSound.play();
        coinsSound.setVolume(0.5);
        super.destroy();
    }

}



