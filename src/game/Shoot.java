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


public class Shoot implements MouseListener, CollisionListener {
    private GameLevel level;
    private GameView view;
    private DynamicBody ball;
    private static final Shape shotShape = new CircleShape(1f);
    private static final BodyImage image = new BodyImage("data/shurk.gif", 6.4f);

    private Timer timer;

    private static SoundClip shootingSound;

    private boolean isPlayingAudio = false;

    static {
        try {
            shootingSound = new SoundClip("audio/throwingknife.wav");
            shootingSound.play();
        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
            System.out.println(e);
        }
    }


    public Shoot(GameLevel level, GameView view) {
        this.level = level;
        this.view = view;
        this.timer = new Timer();



    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseClicked(MouseEvent e) {

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
        }, 20);
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                ball.destroy();
                movementStopPlaying();
            }
        }, 4000); // 2000 milliseconds = 2 seconds
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
            bat.decrementHealth(15);
            bat.TakenHit();
        }
        if (e.getOtherBody() instanceof Skeleton) {
            ball.destroy();
            Enemy mummy = (Enemy) e.getOtherBody();
            mummy.decrementHealth(20);
            mummy.TakenHit();
        }
        if (e.getOtherBody() == ball) {
            ball.destroy();

        }
        if (e.getOtherBody() instanceof Platform) {
            ball.destroy();

        }
        if (e.getOtherBody() instanceof BoxCrate) {
            ball.destroy();
        }
        if (e.getOtherBody() instanceof Warrior) {
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
            rock.decrementHealth(15);
            rock.TakenHit();
        }
    }


    public void movementPlay(){
        if(!isPlayingAudio){
            shootingSound.play();
            isPlayingAudio = true;
        }

    }

    public void movementStopPlaying(){
        shootingSound.stop();
        isPlayingAudio = false;
    }

}
