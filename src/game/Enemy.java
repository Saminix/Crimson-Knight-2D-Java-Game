package game;
import city.cs.engine.*;
public abstract class Enemy extends Walker {

    protected int EnemyHealth;
    protected int EnemySpeed;


    public Enemy(World world, Shape shape, int EnemyHealth, int EnemySpeed){
        super(world,shape);
        this.EnemyHealth = EnemyHealth;
        this.EnemySpeed = EnemySpeed;
    }


    public abstract void attack();

    public abstract void movement();


    public abstract void destory();

    public abstract int getHealth();


    public abstract void getEnemies();

    public abstract int decrementHealth(int x);
}
