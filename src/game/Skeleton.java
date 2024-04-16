package game;
import city.cs.engine.*;
import city.cs.engine.Shape;
import org.jbox2d.common.Vec2;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.io.IOException;


/**
 * This class is a Subclass of Enemy which is called Skeleton.
 * This class represents the Skeleton enemy entity in the game.
 * implements the StepListener interface.
 * This represents the Skeleton entity in the game.
 * The class is comprised of the Skeleton Behaviour, Attributes, Movement, Direction,Sound and Health.
 *
 */
public class Skeleton extends Enemy implements StepListener {
    private static final Shape monsterShape = new PolygonShape(-0.84f,0.78f, 0.31f,0.74f, 0.12f,-1.43f, -0.62f,-1.46f, -1.17f,-0.2f, -0.96f,0.68f);

    private static final BodyImage image = new BodyImage("data/skeleton1.gif", 10.5f);


    private boolean movingLeft = false;
    private final Vec2 startPosition;
    private float left, right;
    private float delta;
    private static SoundClip snarlSound;

    private boolean isPlayingAudio = false;

    static {
        try {
            snarlSound = new SoundClip("audio/GruntMonster.wav");
        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
            System.out.println(e);
        }
    }

    /**
     * Constructs a Skeleton object.
     * A Skeleton Entity is Constructed from these Parameters.
     * Unique Skeleton Objects can be initialised with different speeds,positions or health.
     *
     * @param world The world in which the Skeleton exists.
     * @param position The initial position of the Skeleton.
     * @param EnemyHealth The health of the Skeleton enemy.
     * @param EnemySpeed The speed of the Skeleton enemy.
     */

    public Skeleton(World world,Vec2 position, int EnemyHealth, float EnemySpeed) {
        super((GameLevel) world, monsterShape,EnemyHealth,EnemySpeed );
        startPosition = position;
        left = startPosition.x - 14;
        right = startPosition.x + 14;
        delta=EnemySpeed;
        setPosition(startPosition);

        world.addStepListener(this);
        //implement access of the game-world for public methods.
        //this.gameWorld = gameWorld;
        this.addImage(image);


    }

    //make the skeleton move left and right with step-listener and range of 12:
    

    /**
     * Overrides the preStep method of StepListener.
     * Controls the movement of the Skeleton.
     *
     * @param stepEvent Information about the step event.
     */
    @Override
    public void preStep(StepEvent stepEvent) {
        if (getPosition().x <= left || getPosition().x >= right) {
            // Change direction and update position
            if (getPosition().x <= left) {
                movingLeft = true;
                skeletonLeft();
            } else {
                movingLeft = false;
                skeletonRight();
            }
            delta *= -1; // Reverse the direction
        }
        Vec2 newPosition = new Vec2(getPosition().x + delta, getPosition().y);
        setPosition(newPosition);

    }

    /**
     * Overrides the postStep method of StepListener.
     *
     * @param stepEvent Information about the step event.
     */



    @Override
    public void postStep(StepEvent stepEvent) {
    }
    //changing the way the skeleton moves left and right animation

    /**
     * Changes the Skeleton's image and plays the sound when moving left.
     */


    public void skeletonLeft(){
        if (movingLeft){
            removeAllImages();
            playSkeletonSound();
            addImage(new BodyImage("data/skeleton1.gif", 10.5f));
        }

    }

    /**
     * Changes the Skeleton's image and stops playing the sound when moving right.
     */

    public void skeletonRight(){
        if(!movingLeft ){
            removeAllImages();
            StopPlayingSkeletonSound();
            addImage(new BodyImage("data/skeleton1Left.gif", 10.5f));
        }
    }


    /**
     * Sets the position of the Skeleton.
     *
     * @param position The new position to set.
     */

    public void setPosition(Vec2 position) {super.setPosition(position);}


    /**
     * Decreases the health of the Skeleton by a specified amount.
     *
     * @param x The amount by which to decrement the health.
     * @return The remaining health after decrementing.
     */



    @Override
    public int decrementHealth(int x){ EnemyHealth = EnemyHealth - x;return EnemyHealth;}


    /**
     * Performs actions when the Skeleton is hit.
     * Plays the snarl sound and destroys the Skeleton if its health is <= 0.
     */
    
    @Override
    public void TakenHit() {
        snarlSound.play();
        if (getHealth() <= 0) {
            destroy();
            Point point = new Point(this.getWorld(), 2, getPosition().x, getPosition().y,6);
            point.setPosition(getPosition());
        }


    }
    
    /**
     * Gets the health of the Skeleton.
     *
     * @return The health of the Skeleton.
     */
    @Override
    public int getHealth(){
        return EnemyHealth;
    }



    /**
     * Plays the snarl sound associated with the Skeleton.
     */

    public void playSkeletonSound(){
        if(!isPlayingAudio){
            //snarlSound.setVolume(0.4);
            snarlSound.play();
            isPlayingAudio = true;
        }
    }

    /**
     * Stops playing the snarl sound associated with the Skeleton.
     */

    public void StopPlayingSkeletonSound(){
        snarlSound.stop();
        isPlayingAudio = false;
    }
}