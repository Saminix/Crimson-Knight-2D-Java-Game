package game;
import city.cs.engine.*;
import org.jbox2d.common.Vec2;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.awt.event.MouseListener;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.util.Timer;
import java.util.TimerTask;

/**
 * Class Represents the Special power ability of the warrior
 * Implementing a mouseListener and CollisionListener.
 */


public class Shoot implements MouseListener, CollisionListener {
    private GameLevel level;
    private GameView view;
    private DynamicBody ball;
    private boolean stopShooting = false;
    private static final Shape shotShape = new CircleShape(1f);
    private static final BodyImage image = new BodyImage("data/shurk.gif", 6.4f);

    private Timer timer;
    private static SoundClip destorySound;

    private static SoundClip shootingSound;



    private boolean isPlayingAudio = false;

    static {
        try {
            shootingSound = new SoundClip("audio/throwingknife.wav");
            destorySound = new SoundClip("audio/breakRock.wav");
            shootingSound.play();
        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
            System.out.println(e);
        }
    }


    /**
     * Constructs the Shoot object.
     *
     * @param level The GameLevel in which the shooting occurs.
     * @param view  The GameView associated with the level.
     */

    public Shoot(GameLevel level, GameView view) {
        this.level = level;
        this.view = view;
        this.timer = new Timer();



    }

    @Override
    public void mousePressed(MouseEvent e) {

    }


    /**
     * Handles the mouse click event to initiate shooting.
     *
     * @param e The MouseEvent that triggered the method call.
     */

    @Override
    public void mouseClicked(MouseEvent e) {
        if (!stopShooting) {


            ball = new DynamicBody(level, shotShape);
            movementPlay();


            java.awt.Point mousePoint = e.getPoint();
            Vec2 worldPoint = view.viewToWorld(mousePoint);

            ball.setPosition(worldPoint);
            ball.addCollisionListener(this);


            boolean isFacingRight = level.getWarrior().isFacingRight();


            Vec2 warriorPosition = level.getWarrior().getPosition();
            Vec2 direction = worldPoint.sub(warriorPosition);


            float sign = isFacingRight ? -1.0f : 1.0f;
            float shotSpeed = 7.5f;


            Vec2 impulseShot = new Vec2(sign * direction.x * shotSpeed, direction.y * shotSpeed);


            ball.applyImpulse(impulseShot);
            ball.addImage(image);
            ball.setGravityScale(0);


            timer.schedule(new TimerTask() {
                @Override
                public void run() {
                    movementPlay();
                }
            }, 30);
            timer.schedule(new TimerTask() {
                @Override
                public void run() {
                    ball.destroy();
                    movementStopPlaying();
                }
            }, 4000); // 2000 milliseconds = 2 seconds
        }
    }

    @Override
    public void mouseReleased(MouseEvent e) {
    }

    @Override
    public void mouseEntered(MouseEvent e) {
    }

    @Override
    public void mouseExited(MouseEvent e) {
    }


    /**
     * Handles collisions between the shot projectile and other objects in the game.
     *
     * @param e The CollisionEvent representing the collision.
     */

    // Collision handling logic for the blast with different types of bodies
    @Override
    public void collide(CollisionEvent e) {
        if (e.getOtherBody() instanceof Monster) {
            ball.destroy();
            Enemy monster = (Enemy) e.getOtherBody();
            monster.decrementHealth(10);
            monster.TakenHit();
        }
        if (e.getOtherBody() instanceof Bat) {
            ball.destroy();
            Enemy bat = (Enemy) e.getOtherBody();
            bat.decrementHealth(10);
            bat.TakenHit();
        }
        if (e.getOtherBody() instanceof Skeleton) {
            ball.destroy();
            Enemy skeleton = (Enemy) e.getOtherBody();
            skeleton.decrementHealth(4);
            skeleton.TakenHit();
        }
        if (e.getOtherBody() instanceof Zombie) {
            ball.destroy();
            Enemy zombie = (Enemy) e.getOtherBody();
            zombie.decrementHealth(14);
            zombie.TakenHit();
        }
        if (e.getOtherBody() instanceof PumpkinMan) {
            ball.destroy();
            Enemy zombie = (Enemy) e.getOtherBody();
            zombie.decrementHealth(9);
            zombie.TakenHit();
        }
        if (e.getOtherBody() == ball) {
            ball.destroy();

        }
        if (e.getOtherBody() instanceof Platform) {
            ball.destroy();

        }
        if (e.getOtherBody() instanceof Obstacle) {
            ball.destroy();
        }

        if (e.getOtherBody() instanceof Trampoline) {
            ball.destroy();
        }
        if (e.getOtherBody() instanceof Collectibles) {
            ball.destroy();
        }
        if (e.getOtherBody() instanceof Rock) {
            Rock rock = (Rock) e.getOtherBody();
            destorySound.play();
            rock.decrementHealth(10);
            rock.TakenHit();
        }
        if (e.getOtherBody() instanceof RockOre) {
            RockOre rockOre = (RockOre) e.getOtherBody();
            destorySound.play();
            rockOre.decrementHealth(5);
            rockOre.TakenHit();
        }
    }


    /**
     * Plays the movement sound associated with the shoot.
     */

    public void movementPlay(){
        if(!isPlayingAudio){
            shootingSound.play();
            shootingSound.setVolume(0.2);
            isPlayingAudio = true;
        }

    }

    /**
     * Stops playing the movement sound associated with the shoot.
     */

    public void movementStopPlaying(){
        shootingSound.stop();
        isPlayingAudio = false;
    }


    /**
     * Gets the current status of shooting.
     *
     * @return true if shooting is stopped, else false.
     */
    public boolean stopShooting(){
        return stopShooting;
    }

    /**
     * Sets the status of shooting.
     *
     * @param stopShooting true to stop shooting, false to allow shooting
     */
    public void setStopShooting(boolean stopShooting) {
        this.stopShooting = stopShooting;
    }




}
