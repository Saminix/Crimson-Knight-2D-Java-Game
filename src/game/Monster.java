package game;
import city.cs.engine.*;
import city.cs.engine.Shape;
import org.jbox2d.common.Vec2;


public class Monster extends Enemy {

    private static final Shape monsterShape = new PolygonShape(-1.55f,-3.68f, 0.93f,-3.57f, 1.8f,-0.65f, 0.95f,2.44f, -1.42f,2.46f, -2.03f,-0.67f, -1.78f,-3.34f);
    private static final BodyImage image = new BodyImage("data/Monster1.gif", 8.5f);
    private GameWorld world;
    private Warrior targetWarrior;


    public Monster(World world,int EnemyHealth, int EnemySpeed, GameWorld gameworld) {
        super(world, monsterShape,EnemyHealth,EnemySpeed );
        this.targetWarrior = targetWarrior;
        world.addStepListener(this);
        this.world = gameworld;
        this.addImage(image);

    }




    @Override
    public void TakenHit(int damage){
        decrementHealth(damage);
        if (getHealth() <= 0) {
            destroy();
            Point point = new Point(this.getWorld(), 2, getPosition().x, getPosition().y);
            point.collectItem(10);
            point.setPosition(getPosition());
            // Destroy monster if health is zero or below
        }else{

        }

    }

    public void setPosition(Vec2 position) {super.setPosition(position);}


    @Override
    public int getHealth(){
        return EnemyHealth;
    }

    @Override
    public void preStep(StepEvent stepEvent) {

    }

    @Override
    public void postStep(StepEvent stepEvent) {
    }


    @Override
    public int decrementHealth(int x){ EnemyHealth = EnemyHealth - x;return EnemyHealth;}



}