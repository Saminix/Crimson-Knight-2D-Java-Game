package game;
import city.cs.engine.*;
import city.cs.engine.Shape;
import org.jbox2d.common.Vec2;


public class Bat extends Enemy implements StepListener {
    private static final Shape batShape = new PolygonShape(-0.09f,1.16f, -1.2f,0.78f, -1.2f,0.02f, -0.09f,-0.4f, 0.68f,-0.32f, 1.24f,0.51f, 0.3f,1.16f);
    private static final BodyImage image = new BodyImage("data/bat.gif", 8.5f);
    private GameWorld world;
    private boolean movingLeft = false;
    public Vec2 setPosition;
    private  Vec2 startPosition;
    private float left, right;
    private float delta;

    public Bat(World world,Vec2 position, int EnemyHealth, int EnemySpeed, GameWorld gameworld) {
        super(world, batShape,EnemyHealth,EnemySpeed );
        startPosition = position;
        left = startPosition.x - 10;
        right = startPosition.x + 10;
        delta = 0.08f;
        setPosition(startPosition);
        world.addStepListener(this);
        this.world = gameworld;
        this.addImage(image);
        this.setAngularVelocity(0);
        // Disable gravity
        this.setGravityScale(0);

    }

    @Override
    public void preStep(StepEvent stepEvent) {
        if (getPosition().x <= left || getPosition().x >= right) {
            if (getPosition().x <= left) {
                movingLeft = true;
                batLeft();
                this.setPosition(startPosition);
                 // Reverse the direction of movement when bat is facing left.
            } else{
                movingLeft = false;
                batRight();
                this.setPosition(startPosition);

            }
            delta *= -1;
        }
        Vec2 newPosition = new Vec2(getPosition().x + delta, getPosition().y);
        setPosition(newPosition);

    }

    public void batLeft(){
        if (movingLeft){
            removeAllImages();
            addImage(new BodyImage("data/batLeft.gif", 8.5f));
        }

    }

    public void batRight(){
        if(!movingLeft){
            removeAllImages();
            addImage(new BodyImage("data/bat.gif", 8.5f));
        }
    }


    public void setPosition(Vec2 position) {super.setPosition(position);}


    @Override
    public int decrementHealth(int x){ EnemyHealth = EnemyHealth - x;return EnemyHealth;}

    @Override
    public void chaseWarrior(Warrior warrior) {

    }

    @Override
    public void TakenHit(int damage) {
        super.TakenHit(damage);
        if (getHealth() <= 0) {
            destroy();
            Point point = new Point(world);
            point.setPosition(getPosition());

        } else {

        }
    }

    @Override
    public void postStep(StepEvent stepEvent) {
    }

    @Override
    public int getHealth(){
        return EnemyHealth;
    }
}
