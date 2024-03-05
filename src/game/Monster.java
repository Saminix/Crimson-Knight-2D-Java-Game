package game;
import city.cs.engine.*;
import city.cs.engine.Shape;
import org.jbox2d.common.Vec2;


public class Monster extends Enemy {

    private static final Shape monsterShape = new PolygonShape(-1.55f,-3.68f, 0.93f,-3.57f, 1.8f,-0.65f, 0.95f,2.44f, -1.42f,2.46f, -2.03f,-0.67f, -1.78f,-3.34f);
    private static final BodyImage image = new BodyImage("data/Monster1.gif", 8.5f);

    private GameWorld world;
    private Warrior targetWarrior;



    public Monster(World world, int EnemyHealth, int EnemySpeed, GameWorld gameworld) {
        super(world, monsterShape,EnemyHealth,EnemySpeed );
        this.targetWarrior = targetWarrior;
        this.world = gameworld;
        this.addImage(image);

    }




    @Override
    public void chaseWarrior(Warrior warrior) {
        Vec2 monsterPosition = this.getPosition();
        Vec2 warriorPosition = warrior.getPosition();
        Vec2 direction = warriorPosition.sub(monsterPosition); // Vector from monster to warrior
        direction.normalize(); // Normalize to get unit vector

        // Multiply direction by speed to get velocity vector
        Vec2 velocity = direction.mul(EnemySpeed);
        this.setLinearVelocity(velocity);
    }


    @Override
    public void movement() {

    }

    //public void destroy() {
        // Destroy the monster instance
        //this.destroy();

        // Create a point at the monster's position
    //}
    @Override
    public void TakenHit(){
        decrementHealth(50);
        if (getHealth() <= 0) {
            destroy();
            Point point = new Point(world);
            point.setPosition(getPosition());
            // Destroy monster if health is zero or below
        }else{

        }

    }

    @Override
    public void getEnemies(){

    }

    @Override
    public int getHealth(){
        return EnemyHealth;
    }

    @Override
    public int decrementHealth(int x){
       EnemyHealth = EnemyHealth - x;
        return EnemyHealth;
    }











}