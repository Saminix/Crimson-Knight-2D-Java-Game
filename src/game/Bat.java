package game;
import city.cs.engine.*;
import city.cs.engine.Shape;
import org.jbox2d.common.Vec2;


public class Bat extends Enemy  {
    private static final Shape batShape = new PolygonShape(-0.09f,1.16f, -1.2f,0.78f, -1.2f,0.02f, -0.09f,-0.4f, 0.68f,-0.32f, 1.24f,0.51f, 0.3f,1.16f);
    private static final BodyImage image = new BodyImage("data/bat.gif", 8.5f);
    private GameWorld gameWorld;
    private boolean movingLeft = false;
    private  Vec2 startPosition;
    private float left, right;
    private float delta;

    public Bat(World world,Vec2 position, int EnemyHealth, int EnemySpeed, GameWorld gameWorld) {
        super(world, batShape,EnemyHealth,EnemySpeed );
        startPosition = position;
        left = startPosition.x - 10;
        right = startPosition.x + 10;
        delta = 0.08f;
        setPosition(startPosition);
        //makes the bat move(step-listener)
        world.addStepListener(this);
        //implement access of the game-world for public methods.
        this.gameWorld = gameWorld;
        this.addImage(image);
        this.setAngularVelocity(0);
        // Disable gravity
        this.setGravityScale(0);

    }


    @Override
    public void preStep(StepEvent stepEvent) {
        if (getPosition().x <= left || getPosition().x >= right) {
            // Change direction and update position
            if (getPosition().x <= left) {
                movingLeft = true;
                batLeft();
            } else {
                movingLeft = false;
                batRight();
            }
            delta *= -1; // Reverse the direction
        }
        Vec2 newPosition = new Vec2(getPosition().x + delta, getPosition().y);
        setPosition(newPosition);

    }



    @Override
    public void postStep(StepEvent stepEvent) {
    }

    public void batLeft(){
        if (movingLeft){
            removeAllImages();
            addImage(new BodyImage("data/batLeft.gif", 8.5f));
        }

    }

    public void batRight(){
        if(!movingLeft ){
            removeAllImages();
            addImage(new BodyImage("data/bat.gif", 8.5f));
        }
    }


    public void setPosition(Vec2 position) {super.setPosition(position);}


    @Override
    public int decrementHealth(int x){ EnemyHealth = EnemyHealth - x;return EnemyHealth;}


    @Override
    public void TakenHit(int damage) {
        decrementHealth(damage);
        if (getHealth() <= 0) {
            destroy();
            Point point = new Point(this.getWorld(), 2, getPosition().x, getPosition().y);
            point.setPosition(getPosition());
        }


    }

    @Override
    public int getHealth(){
        return EnemyHealth;
    }
}
