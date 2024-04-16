package game;
import city.cs.engine.*;
import city.cs.engine.Shape;
import org.jbox2d.common.Vec2;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.io.IOException;

/**
 * This class is a Subclass of Enemy which is called Monster.
 * This represents the Monster entity in the game.
 * The class is comprised of the Monster Behaviour, Attributes, Movement, Direction,Sound and Health.
 *
 */

public class Monster extends Enemy implements StepListener {
    private static final Shape monsterShape = new CircleShape(2);
    private static final BodyImage image = new BodyImage("data/CactusMonster.gif", 10.5f);
    private boolean movingLeft = false;
    private  Vec2 startPosition;
    private float left, right;
    private float delta;
    private static SoundClip snarlSound;

    private boolean isPlayingAudio = false;

    static {
        try {
            snarlSound = new SoundClip("audio/monsterSnarl.wav");
        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
            System.out.println(e);
        }
    }

    /**
     * Constructs a Monster enemy.
     * A Monster Entity is Constructed from these Parameters.
     * Unique Monster Objects can be initialised with different speeds,positions or health.
     *
     * @param world The world in which the monster exists.
     * @param position The initial position of the monster.
     * @param EnemyHealth The health of the monster.
     * @param EnemySpeed The speed of the monster.
     */

    public Monster(World world,Vec2 position, int EnemyHealth, float EnemySpeed) {
        super((GameLevel) world, monsterShape,EnemyHealth,EnemySpeed );
        startPosition = position;
        left = startPosition.x - 12;
        right = startPosition.x + 12;
        delta=EnemySpeed;
        setPosition(startPosition);
        world.addStepListener(this);
        this.addImage(image);
    }

    //make the Monster move left and right with step-listener and range of 12:

    /**
     * This method uses the preStep
     * Updates the monster's position and direction before each step.
     * @param stepEvent Represents the StepEvent of the Monster.
     */
    @Override
    public void preStep(StepEvent stepEvent) {
        if (getPosition().x <= left || getPosition().x >= right) {
            // Change direction and update position
            if (getPosition().x <= left) {
                movingLeft = true;
                monsterLeft();
            } else {
                movingLeft = false;
                monsterRight();
            }
            delta *= -1; // Reverse the direction
        }
        Vec2 newPosition = new Vec2(getPosition().x + delta, getPosition().y);
        setPosition(newPosition);
    }

    /**
     * This method Uses the PostStep.
     * @param stepEvent represents the StepEvent of the Monster
     */

    @Override
    public void postStep(StepEvent stepEvent) {
    }
    //changing the way the monster moves left and right animation

    /**
     * Changes the monster's image and sound when moving left.
     *
     * Using two methods that change the Way the Monster Animation moves.
     * Each time The Monster Unique sound is called.
     * BodyImage is changed to left Animation, if the Monster is moving left.
     */
    public void monsterLeft(){
        if (movingLeft){
            removeAllImages();
            playMonsterSound();
            addImage(new BodyImage("data/CactusMonsterLeft.gif", 9.5f));
        }

    }
    /**
     * Changes the monster's image and stops sound when moving right.
     */
    public void monsterRight(){
        if(!movingLeft ){
            removeAllImages();
            StopPlayingMonsterSound();
            addImage(new BodyImage("data/CactusMonster.gif", 9.5f));
        }
    }

    /**
     * Sets the position of the monster.
     *
     * @param position The new position of the monster.
     */
    public void setPosition(Vec2 position) {super.setPosition(position);}
    /**
     * Method is used to decrement the Health of the monster.
     *
     * @param x The amount to decrement the health by.
     * @return The new health value.
     */
    @Override
    public int decrementHealth(int x){ EnemyHealth = EnemyHealth - x;return EnemyHealth;}
    /**
     * Handles when the monster is hit.
     * Method that plays a Sound if the Monster is Hit.
     * Consists of a condition, if the Health is less or Equal to 0, Monster  will be destroyed.
     * Furthermore, Spawning a Point.
     */
    @Override
    public void TakenHit() {
        snarlSound.play();
        if (getHealth() <= 0) {
            destroy();
            Point point = new Point(this.getWorld(), 2, getPosition().x, getPosition().y, 6);
            point.setPosition(getPosition());
        }
    }

    /**
     * Gets the current health of the monster.
     *
     * @return The current health value.
     */
    @Override
    public int getHealth(){
        return EnemyHealth;
    }

    /**
     * Plays the monster snarl sound.
     */
    public void playMonsterSound(){
        if(!isPlayingAudio){
            //snarlSound.setVolume(0.4);
            snarlSound.play();
            isPlayingAudio = true;
        }
    }
    /**
     * Stops playing the monster snarl sound.
     */
    public void StopPlayingMonsterSound(){
        snarlSound.stop();
        isPlayingAudio = false;
    }
}
