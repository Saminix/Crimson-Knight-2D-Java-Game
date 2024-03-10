package game;
import city.cs.engine.*;
public abstract class Enemy extends StaticBody {
    protected int EnemyHealth;
    protected float EnemySpeed;

    public Enemy(World world, Shape shape, int EnemyHealth, float EnemySpeed){
        super(world,shape);
        this.EnemyHealth = EnemyHealth;
        this.EnemySpeed = EnemySpeed;
    }


    public abstract int getHealth();

    public void TakenHit(){

    }

    public abstract int decrementHealth(int x);
}
