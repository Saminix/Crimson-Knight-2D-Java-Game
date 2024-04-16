package game;

import city.cs.engine.*;
import city.cs.engine.Shape;
import org.jbox2d.common.Vec2;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.io.IOException;

/**
 * This class is a Subclass of Enemy which is called Zombie.
 *
 * This class represents the Zombie enemy entity in the game.
 * implements the StepListener interface.
 * This represents the Zombie entity in the game.
 * The class is comprised of the Zombie Behaviour, Attributes, Movement, Direction,Sound and Health.
 *
 */


public class Zombie extends Enemy implements StepListener {
    private static final Shape monsterShape = new PolygonShape(-0.54f,1.55f, 0.53f,1.6f, 0.75f,-0.13f, 0.19f,-1.65f, -0.74f,-1.61f, -0.68f,1.22f);

    private static final BodyImage image = new BodyImage("data/Zombie1.gif", 8.5f);

    private boolean movingLeft = false;
    private final Vec2 startPosition;

    private float left, right;
    private static SoundClip hit;
    private float delta;
    private static SoundClip snarlSound;

    private Warrior warriorTarget;

    private boolean isPlayingAudio = false;

    private static final float SNARL_INTERVAL = 5f; // Interval between snarl sounds in seconds
    private float timeSinceLastSnarl = 0f; // Tracks time since the last snarl sound

    static {
        try {
            snarlSound = new SoundClip("audio/ZombieSound.wav");
            hit = new SoundClip("audio/HitFlesh.wav");
        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
            System.out.println(e);
        }
    }

    /**
     * Constructs a Zombie object.
     * 
     * Constructs a Zombie object.
     * A Zombie Entity is Constructed from these Parameters.
     * Unique Zombie Objects can be initialised with different speeds,positions or health.
     *      
     * @param world The world in which the Zombie exists.
     * @param position The initial position of the Zombie.
     * @param EnemyHealth The health of the Zombie.
     * @param EnemySpeed The speed of the Zombie.
     * @param target The warrior target for the Zombie to chase.
     */
    public Zombie(World world, Vec2 position, int EnemyHealth, float EnemySpeed, Warrior target) {
        super((GameLevel) world, monsterShape, EnemyHealth, EnemySpeed);
        startPosition = position;
        this.warriorTarget = target;
        left = startPosition.x - 14;
        right = startPosition.x + 14;
        delta = EnemySpeed;
        setPosition(startPosition);

        world.addStepListener(this);
        this.addImage(image);
    }



    /**
     * Overrides the preStep method of StepListener.
     * Controls the movement of the Zombie.
     *
     * @param stepEvent Information about the step event.
     */
    @Override
    public void preStep(StepEvent stepEvent) {
        chaseWarrior();
        // Increment the time since the last snarl sound
        timeSinceLastSnarl += stepEvent.getStep();
        // Check if it's time to play the snarl sound
        if (timeSinceLastSnarl >= SNARL_INTERVAL) {
            playSnarlSound();
            // Reset the timer
            timeSinceLastSnarl = 0f;
        }
    }

    /**
     * Moves the Zombie towards the warrior target.
     */ 

    public void chaseWarrior() {
        Vec2 zombiePosition = getPosition();
        Vec2 warriorPosition = warriorTarget.getPosition();
        Vec2 direction = new Vec2(warriorPosition.x - zombiePosition.x, 0);
        direction.normalize();

        if (direction.x < 0) {
            movingLeft = true;
        } else {
            movingLeft = false;
        }

        Vec2 newPosition = new Vec2(zombiePosition.x + direction.x * delta, zombiePosition.y);
        setPosition(newPosition);

        updateZombieImage();
    }


    /**
     * Overrides the postStep method of StepListener.
     *
     * @param stepEvent Information about the step event.
     */

    @Override
    public void postStep(StepEvent stepEvent) {
    }


    /**
     * Changes the Zombie's image and plays the sound when moving left.
     */

    //changing the way the Zombie moves left and right animation

    private void updateZombieImage() {
        if (movingLeft) {
            removeAllImages();
            playZombieSound();
            addImage(new BodyImage("data/Zombie1Left.gif", 10.5f));
        } else {
            removeAllImages();
            stopPlayingZombieSound();
            addImage(new BodyImage("data/Zombie1.gif", 10.5f));
        }
    }


    /**
     * Sets the position of the Zombie.
     *
     * @param position The new position to set.
     */

    public void setPosition(Vec2 position) {
        super.setPosition(position);
    }


    /**
     * Decreases the health of the Zombie by a specified amount.
     *
     * @param x The amount by which to decrement the health.
     * @return The remaining health after decrementing.
     */


    @Override
    public int decrementHealth(int x) {
        EnemyHealth -= x;
        return EnemyHealth;
    }


    /**
     * Performs actions when the Zombie is hit.
     * Plays the snarl sound and destroys the Zombie if its health is <= 0.
     */

    @Override
    public void TakenHit() {
        snarlSound.play();
        hit.play();
        if (getHealth() <= 0) {
            snarlSound.play();
            destroy();
            Point point = new Point(this.getWorld(), 2, getPosition().x, getPosition().y, 6);
            point.setPosition(getPosition());
        }
    }


    /**
     * Gets the health of the Zombie.
     *
     * @return The health of the Zombie.
     */
    @Override
    public int getHealth() {
        return EnemyHealth;
    }


    /**
     * Plays the sound of the Zombie.
     */

    public void playZombieSound() {
        if (!isPlayingAudio) {
            snarlSound.play();
            isPlayingAudio = true;
        }
    }

    /**
     * Stops playing the sound of the Zombie.
     */
    public void stopPlayingZombieSound() {
        snarlSound.stop();
        isPlayingAudio = false;
    }

    /**
     * Plays the snarl sound of the Zombie.
     */
    public void playSnarlSound() {
        if (!isPlayingAudio) {
            snarlSound.play();
            isPlayingAudio = true;
        }
    }
}
