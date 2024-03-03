package game;
import city.cs.engine.*;
import city.cs.engine.Shape;



public class Monster extends Enemy {

    private static final Shape monsterShape = new PolygonShape(-1.15f,1.59f, -2.53f,-0.39f, 0.62f,-2.65f, 2.78f,-0.08f, 3.65f,1.76f, 1.18f,2.25f, -0.8f,2.04f);
    private static final BodyImage image = new BodyImage("data/Monster1.gif", 10.5f);

    private GameWorld world;


    public Monster(World world, int EnemyHealth, int EnemySpeed) {
        super(world, monsterShape,EnemyHealth,EnemySpeed );
        this.addImage(image);

    }

    @Override
    public void attack(){

    }

    @Override
    public void movement() {

    }
    @Override
    public void destory(){
        Point pointOrb = new Point(world);
        pointOrb.setPosition(getPosition());
        world.addPoint(pointOrb);

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