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

    public abstract void chaseWarrior(Warrior warrior);

    public abstract int getHealth();

    public void TakenHit(int damage){
        EnemyHealth-= damage;

    }

    public abstract int decrementHealth(int x);
}
