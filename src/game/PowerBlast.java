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
 * Class Represents the Special power blast ability of the warrior
 * Implementing a mouseListener and CollisionListener.
 */

public class PowerBlast implements MouseListener, CollisionListener {
    private GameLevel level;
    private GameView view;
    private DynamicBody blast;

    private static final int SPECIAL = 3;
    private Warrior warrior;

    private Shoot shoot;
    private static final Shape shotShape = new CircleShape(2f);
    private static final BodyImage image = new BodyImage("data/fireball.gif", 20f);
    private static SoundClip shootingSound;

    private Timer timer;
    private boolean isPlayingAudio = false;

    static {
        try {
            shootingSound = new SoundClip("audio/special.wav");
        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
            System.out.println(e);
        }
    }

    /**
     * Constructs the PowerBlast object.
     *
     * @param level The GameLevel in which the powerBlast occurs.
     * @param view The GameView associated with the level.
     * @param warrior The Warrior object representing the player.
     * @param shoot The Shoot object handling shooting
     */

    public PowerBlast(GameLevel level, GameView view, Warrior warrior, Shoot shoot) {
        this.level = level;
        this.view = view;
        this.shoot = shoot;
        this.warrior = warrior;
        this.timer = new Timer();
    }


    /**
     * Method includes the event that is triggered when mouse is clicked,
     * how the blast ball behaves, direction and speed.
     *
     * @param e the event to be processed
     */

    @Override
    public void mouseClicked(MouseEvent e) {
        if (warrior.getSpecial() >= SPECIAL) {
            shoot.setStopShooting(true);

            blast = new DynamicBody(level, shotShape);


            java.awt.Point mousePoint = e.getPoint();
            Vec2 worldPoint = view.viewToWorld(mousePoint);
            // Set the blast position to the warrior's position

            blast.setPosition(worldPoint);
            blast.addCollisionListener(this);

            // Determine the direction and speed of the blast based on the mouse position

            boolean isFacingRight = level.getWarrior().isFacingRight();

            Vec2 warriorPosition = level.getWarrior().getPosition();
            Vec2 direction = worldPoint.sub(warriorPosition);

            float sign = isFacingRight ? -1.0f : 1.0f;
            float shotSpeed = 6.5f; // Increase shot speed for a straight direction
            Vec2 impulseShot = new Vec2(sign * direction.x * shotSpeed, direction.y * shotSpeed);
            blast.applyImpulse(impulseShot);
            blast.addImage(image);
            blast.setGravityScale(0);

            //adding timers to determine when the shooting sound would be played after mouseclicked.


            timer.schedule(new TimerTask() {
                @Override
                public void run() {
                    movementPlay();
                    shootingSound.play();
                }
            }, 20);

            timer.schedule(new TimerTask() {
                @Override
                public void run() {
                    // Schedule a task to destroy the blast and reset the warrior's special after a delay

                    blast.destroy();
                    //reset the special after destroyed.
                    warrior.setSpecial(0);
                    shootingSound.stop();
                    shoot.setStopShooting(false);
                }
            }, 15000);
        }
    }
    // Implementing other mouse event methods (mousePressed, mouseReleased, mouseEntered, mouseExited)
    // but leaving them empty as they are not needed for this class
    @Override
    public void mousePressed(MouseEvent e) {

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


    // Collision handling logic for the blast with different types of bodies

    /**
     * Handles collisions between the shot power Blast projectile and other objects in the game.
     *
     * @param e The CollisionEvent representing the collision.
     */
    @Override
    public void collide(CollisionEvent e) {
        if (e.getOtherBody() instanceof Monster) {
            blast.destroy();
            Enemy monster = (Enemy) e.getOtherBody();
            monster.decrementHealth(25);
            monster.TakenHit();
        }
        if (e.getOtherBody() instanceof Bat) {
            blast.destroy();
            Enemy bat = (Enemy) e.getOtherBody();
            bat.decrementHealth(20);
            bat.TakenHit();
        }
        if (e.getOtherBody() instanceof Skeleton) {
            blast.destroy();
            Enemy Skeleton = (Enemy) e.getOtherBody();
            Skeleton.decrementHealth(25);
            Skeleton.TakenHit();
        }
        if (e.getOtherBody() instanceof PumpkinMan) {
            blast.destroy();
            Enemy Skeleton = (Enemy) e.getOtherBody();
            Skeleton.decrementHealth(26);
            Skeleton.TakenHit();
        }
        if (e.getOtherBody() instanceof Zombie) {
            blast.destroy();
            Enemy Skeleton = (Enemy) e.getOtherBody();
            Skeleton.decrementHealth(35);
            Skeleton.TakenHit();
        }
        if (e.getOtherBody() == blast) {
            blast.destroy();

        }
        if (e.getOtherBody() instanceof Platform) {
            blast.destroy();

        }
        if (e.getOtherBody() instanceof Obstacle) {
            blast.destroy();
        }
        if (e.getOtherBody() instanceof Warrior) {
            blast.destroy();
        }
        if (e.getOtherBody() instanceof Trampoline) {
            blast.destroy();
        }
        if (e.getOtherBody() instanceof Collectibles) {
            blast.destroy();
        }
        if (e.getOtherBody() instanceof Rock) {
            Rock rock = (Rock) e.getOtherBody();
            movementPlay();
            rock.decrementHealth(55);
            rock.TakenHit();
        }
    }


    /**
     * Plays the movement sound associated with the power blast.
     */

    public void movementPlay(){
        if(!isPlayingAudio){
            shootingSound.play();
            isPlayingAudio = true;
        }

    }

    /**
     * Stops playing the movement sound associated with the power blast.
     */
    public void movementStopPlaying(){
        shootingSound.stop();
        isPlayingAudio = false;
    }



}


