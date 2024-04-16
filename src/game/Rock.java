package game;
import city.cs.engine.*;
import org.jbox2d.common.Vec2;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.io.IOException;

/**
 * This class represents the Rock collectible entity in the game.
 * It is a subclass of Collectibles.
 * Although it cannot be picked up, it can be Destroyed.
 */

public class Rock extends Collectibles{
    private int health;
    private static final String image = "data/Rock.png";
    private static SoundClip destorySound;
    private boolean isPlayingAudio = false;

    static {
        try {
            destorySound = new SoundClip("audio/breakRock.wav");
        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
            System.out.println(e);
        }
    }
    /**
     * Constructs a Rock object.
     *
     * @param world The world in which the Rock exists.
     * @param boxSizeWidth The width of the Rock.
     * @param x The x-coordinate of the Rock's initial position.
     * @param y The y-coordinate of the Rock's initial position.
     * @param height The height of the Rock.
     */
    public Rock(World world, float boxSizeWidth, float x, float y, float height){
        super(world, new CircleShape(boxSizeWidth), new Vec2(x,y), height);
        addImage(new BodyImage(image, height));
        this.health = 50;
    }
    /**
     * Performs actions when the Rock is hit.
     * If the Rock's health is <= 0, destroys the Rock.bye bye.
     */
    public void TakenHit() {
        if (getHealth() <= 0) {
            super.destroy();
        }
    }
    /**
     * Sets the health of the Rock.
     *
     * @param health The health to set.
     */
    public void setHealth(int health){
        this.health = health;

    }
    /**
     * Gets the health of the Rock.
     *
     * @return The health of the Rock.
     */
    public int getHealth() {
        return health;
    }


    /**
     * Decreases the health of the Rock by an amount, x.
     *
     * @param x The amount by which to decrement the health.
     */
    public void decrementHealth(int x){
        health = health - x;
    }
}



