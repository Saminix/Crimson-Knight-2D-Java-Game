package game;
import city.cs.engine.*;
import city.cs.engine.Shape;
import org.jbox2d.common.Vec2;

//create a subclass Monster which inherits the constructor from Enemy using the super()
public class Monster extends Enemy implements StepListener {
    private static final Shape monsterShape = new CircleShape(2);
    private static final BodyImage image = new BodyImage("data/CactusMonster.gif", 10.5f);
    private final GameWorld gameWorld;

    private boolean movingLeft = false;
    private  Vec2 startPosition;
    private float left, right;
    private float delta;

    public Monster(World world,Vec2 position, int EnemyHealth, float EnemySpeed, GameWorld gameWorld) {
        super(world, monsterShape,EnemyHealth,EnemySpeed );
        startPosition = position;
        left = startPosition.x - 12;
        right = startPosition.x + 12;
        delta=EnemySpeed;
        setPosition(startPosition);

        world.addStepListener(this);
        //implement access of the game-world for public methods.
        this.gameWorld = gameWorld;
        this.addImage(image);


    }

//make the Monster move left and right with step-listener and range of 12:
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



    @Override
    public void postStep(StepEvent stepEvent) {
    }
    //changing the way the monster moves left and right animation

    public void monsterLeft(){
        if (movingLeft){
            removeAllImages();
            addImage(new BodyImage("data/CactusMonsterLeft.gif", 9.5f));
        }

    }

    public void monsterRight(){
        if(!movingLeft ){
            removeAllImages();
            addImage(new BodyImage("data/CactusMonster.gif", 9.5f));
        }
    }


    public void setPosition(Vec2 position) {super.setPosition(position);}


    @Override
    public int decrementHealth(int x){ EnemyHealth = EnemyHealth - x;return EnemyHealth;}


    @Override
    public void TakenHit() {
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
