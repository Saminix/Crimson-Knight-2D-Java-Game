package game;
import city.cs.engine.*;
import city.cs.engine.Shape;
import org.jbox2d.common.Vec2;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.io.IOException;

/**
 * This class is a Subclass of Enemy which is called Bat.
 * This represents the bat entity in the game.
 * The class is comprised of the bats Behaviour, Attributes, Movement, Direction,Sound and Health.
 *
 */
public class Bat extends Enemy implements StepListener  {

    //Image & Shape components for visual.
    private static final Shape batShape = new PolygonShape(-0.09f,1.16f, -1.2f,0.78f, -1.2f,0.02f, -0.09f,-0.4f, 0.68f,-0.32f, 1.24f,0.51f, 0.3f,1.16f);
    private static final BodyImage image = new BodyImage("data/Bat.gif", 8.5f);

    //Movement and direction variables.
    private boolean movingLeft = false;
    private  Vec2 startPosition;
    private float left, right;
    private float delta;

    //sound variables
    private static SoundClip snarlSound;
    private boolean isPlayingAudio = false;

    //File exceptions Check for Sounds
    // Load soundClip

    static {
        try {
            snarlSound = new SoundClip("audio/BatNoise.wav");
        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
            System.out.println(e);
        }
    }

    /**
     * A Bat Entity is Constructed from these Parameters.
     * Unique Bat Objects can be initialised with different speeds,positions or health.
     *
     * @param world World that the bat exists.
     * @param position Position of the Bat.
     * @param EnemyHealth  Health of the Bat.
     * @param EnemySpeed  Speed of the bat Movement.
     */

    public Bat(World world,Vec2 position, int EnemyHealth, float EnemySpeed) {
        super((GameLevel) world, batShape,EnemyHealth,EnemySpeed );
        startPosition = position;
        left = startPosition.x - 10;
        right = startPosition.x + 10;
        delta = EnemySpeed;
        setPosition(startPosition);

        //makes the bat move(step-listener)
        world.addStepListener(this);
        this.addImage(image);
        getFixtureList().get(0).setDensity(10);
    }

    /**
     * This method uses the preStep
     * @param stepEvent Represents the StepEvent of the Bat.
     */

    @Override
    public void preStep(StepEvent stepEvent) {
        if (getPosition().x <= left || getPosition().x >= right) {
            // Change direction and update position.
            if (getPosition().x <= left) {
                playBatSound();
                movingLeft = true;
                batLeft();
            } else {
                movingLeft = false;
                StopPlayingBatSound();
                batRight();
            }
            delta *= -1; // Reverse the direction of the bat.
        }
        Vec2 newPosition = new Vec2(getPosition().x + delta, getPosition().y);
        setPosition(newPosition);

    }

    /**
     * This method Uses the PostStep.
     * @param stepEvent represents the StepEvent of the Bat
     */

    @Override
    public void postStep(StepEvent stepEvent) {
    }


    //changing the way the bat gif animation moves from left to right

    /**
     * Using two methods that change the Way the bats Animation moves.
     * Each time The Bats Unique sound is called.
     * BodyImage is changed to left Animation, if the Bat is moving left.
     */

    public void batLeft(){
        if (movingLeft){
            StopPlayingBatSound();
            removeAllImages();
            addImage(new BodyImage("data/BatLeft.gif", 8.5f));
        }

    }

    /**
     * BodyImage is changed to Right animation, if the bat is not moving left.
     */

    public void batRight(){
        if(!movingLeft ){
            playBatSound();
            removeAllImages();
            addImage(new BodyImage("data/Bat.gif", 8.5f));
        }
    }

    /**
     * Sets the Position of the bat.
     * @param position Position the bat, to what the parameter value is.
     */


    public void setPosition(Vec2 position) {super.setPosition(position);}
    /**
     * Method is used to decrement the Health of the bat.
     * @param x Represents the Amount to decrement health by.
     * @return Returns the Updated Health of the Bat through EnemyHealth.
     */

    @Override
    public int decrementHealth(int x){ EnemyHealth = EnemyHealth - x;return EnemyHealth;}


    /**
     * Method that plays a Sound if the bat is Hit.
     * Consists of a condition, if the Health is less or Equal to 0, the bat will be destroyed.
     * Furthermore, Spawning a Point.
     */
    @Override
    public void TakenHit() {
        snarlSound.play();
        if (getHealth() <= 0) {
            destroy();
            Point point = new Point(this.getWorld(), 2, getPosition().x, getPosition().y,6);
            //Spawn a Point where the Bat Died.
            point.setPosition(getPosition());
        }


    }
    /**
     * Method is used to get the Health
     * @return Will return the current Health of the Bat.
     */

    @Override
    public int getHealth(){
        return EnemyHealth;
    }


    /**
     * In order for the sound to not overlap, a condition has to be met where the sound is
     * not already playing.
     */

    public void playBatSound(){
        if(!isPlayingAudio){
            snarlSound.play();
            isPlayingAudio = true;
        }
    }

    /**
     * Stop playing the Bat noise.
     * initialising the audio to false each time audio has stopped.
     */


    public void StopPlayingBatSound(){
        snarlSound.stop();
        isPlayingAudio = false;
    }
}
