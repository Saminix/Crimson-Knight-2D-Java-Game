package game;
import city.cs.engine.*;
import org.jbox2d.common.Vec2;
import java.util.Timer;
import java.util.TimerTask;


import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Timer;
import java.util.TimerTask;

public class PowerBlast extends Shoot implements KeyListener {
    private GameLevel level;

    private boolean isBlasting = false;
    private GameView view;
    private DynamicBody blast;
    private static final Shape shotShape = new CircleShape(1f);
    private static final BodyImage image = new BodyImage("data/PowerBlast.gif", 6.4f);
    private Timer timer;


    public PowerBlast(GameLevel level, GameView view) {
        super(level, view);
        this.timer = new Timer();

    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        int code = e.getKeyCode();
        if (code == KeyEvent.VK_N && !isBlasting) {
            WarriorAttackBlast(e);
            timer.schedule(new TimerTask() {
                @Override
                public void run() {
                    isBlasting = false;
                }

            }, 20000);
        }
    }


        @Override
        public void keyReleased (KeyEvent e){

        }



    public void WarriorAttackBlast(KeyEvent e){
        blast = new DynamicBody(level, shotShape);
        movementPlay();

        Vec2 warriorPosition = level.getWarrior().getPosition();
        float blastX = warriorPosition.x;
        float blastY = warriorPosition.y;

        blast.setPosition(new Vec2(blastX, blastY));
        blast.addCollisionListener(this);


        boolean isFacingRight = level.getWarrior().isFacingRight();


        float sign = isFacingRight ? -1.0f : 1.0f;
        float shotSpeed = 7.5f;


        Vec2 impulseShot = new Vec2(sign * blastX * shotSpeed, blastY * shotSpeed);


        blast.applyImpulse(impulseShot);
        blast.addImage(image);
        blast.setGravityScale(0);

        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                movementPlay();
            }
        }, 20);
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                blast.destroy();
                movementStopPlaying();
            }
        }, 5000); // 2000 milliseconds = 2 seconds
    }

    @Override
    public void collide(CollisionEvent e) {
        if (e.getOtherBody() instanceof Monster) {
            blast.destroy();
            Enemy monster = (Enemy) e.getOtherBody();
            monster.decrementHealth(10);
            monster.TakenHit();
        }
        if (e.getOtherBody() instanceof Bat) {
            blast.destroy();
            Enemy bat = (Enemy) e.getOtherBody();
            bat.decrementHealth(15);
            bat.TakenHit();
        }
        if (e.getOtherBody() instanceof Skeleton) {
            blast.destroy();
            Enemy mummy = (Enemy) e.getOtherBody();
            mummy.decrementHealth(20);
            mummy.TakenHit();
        }
        if (e.getOtherBody() == blast) {
            blast.destroy();

        }
        if (e.getOtherBody() instanceof Platform) {
            blast.destroy();

        }
        if (e.getOtherBody() instanceof BoxCrate) {
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
            rock.decrementHealth(15);
            rock.TakenHit();
        }
    }
}


