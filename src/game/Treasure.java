package game;
import city.cs.engine.*;
import org.jbox2d.common.Vec2;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.io.IOException;

/**
 * A class representing a treasure in the game.
 * Treasures are subclass of Collectibles that are collectible items
 * that provide High Coin points to the player when collected.
 */

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

    /**
     * Constructs a Treasure object.
     * @param world The world in which the treasure exists.
     * @param boxSizeWidth The width of the treasure box.
     * @param boxSizeHeight The height of the treasure box.
     * @param x The x-coordinate of the treasure's position.
     * @param y The y-coordinate of the treasure's position.
     * @param height The height of the treasure image.
     */

    public Treasure(World world, float boxSizeWidth, float boxSizeHeight, float x, float y, float height){
        super(world, new BoxShape(boxSizeWidth, boxSizeHeight), new Vec2(x,y), height);
        height = 5;
        addImage(new BodyImage(imagePath, height));
    }

    /**
     * Method to collect the treasure.
     * @param value The value of the treasure.
     * @return The value of the treasure.
     */
    @Override
    public int collectItem(int value){
        return value;

    }

    /**
     * Method to destroy the treasure.
     */
    @Override
    public void destroy()

    {
        collectSound.play();
        collectSound.setVolume(0.5);
        super.destroy();
    }




}




