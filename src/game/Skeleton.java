package game;
import city.cs.engine.*;
import city.cs.engine.Shape;
import org.jbox2d.common.Vec2;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.io.IOException;

//create a subclass Monster which inherits the constructor from Enemy using the super()
public class Skeleton extends Enemy implements StepListener {
    private static final Shape monsterShape = new CircleShape(2);

    private static final BodyImage image = new BodyImage("data/skeleton1.gif", 10.5f);
    //private final GameWorld gameWorld;

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

    //make the Monster move left and right with step-listener and range of 12:
    @Override
    public void preStep(StepEvent stepEvent) {
        if (getPosition().x <= left || getPosition().x >= right) {
            // Change direction and update position
            if (getPosition().x <= left) {
                movingLeft = true;
                mummyLeft();
            } else {
                movingLeft = false;
                mummyRight();
            }
            delta *= -1; // Reverse the direction
        }
        Vec2 newPosition = new Vec2(getPosition().x + delta, getPosition().y);
        setPosition(newPosition);

    }



    @Override
    public void postStep(StepEvent stepEvent) {
    }
    //changing the way the monster moves left and right animation

    public void mummyLeft(){
        if (movingLeft){
            removeAllImages();
            playMummySound();
            addImage(new BodyImage("data/skeleton1.gif", 10.5f));
        }

    }

    public void mummyRight(){
        if(!movingLeft ){
            removeAllImages();
            StopPlayingMummySound();
            addImage(new BodyImage("data/skeleton1Left.gif", 10.5f));
        }
    }


    public void setPosition(Vec2 position) {super.setPosition(position);}


    @Override
    public int decrementHealth(int x){ EnemyHealth = EnemyHealth - x;return EnemyHealth;}


    @Override
    public void TakenHit() {
        snarlSound.play();
        if (getHealth() <= 0) {
            destroy();
            Point point = new Point(this.getWorld(), 2, getPosition().x, getPosition().y,6);
            point.setPosition(getPosition());
        }


    }

    @Override
    public int getHealth(){
        return EnemyHealth;
    }

    public void playMummySound(){
        if(!isPlayingAudio){
            //snarlSound.setVolume(0.4);
            snarlSound.play();
            isPlayingAudio = true;
        }
    }


    public void StopPlayingMummySound(){
        snarlSound.stop();
        isPlayingAudio = false;
    }
}