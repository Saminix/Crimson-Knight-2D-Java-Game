package game;
import city.cs.engine.*;
/**
 * SuperClass Enemy that Represents all Enemies in the Game.
 * Consists of StaticBodies that have common Attributes and properties that
 * make up an enemy.
 */
public abstract class Enemy extends StaticBody {
    protected int EnemyHealth;
    protected float EnemySpeed;
    /**
     * Constructs an Enemy in the World using Specified Parameters.
     *
     * @param world    The GameLevel World in Which the Enemy Exists.
     * @param shape    The shape of the enemy.
     * @param EnemyHealth  The health of the enemy.
     * @param EnemySpeed   The speed of the enemy.
     */
    public Enemy(GameLevel world, Shape shape, int EnemyHealth, float EnemySpeed){
        super(world,shape);
        this.EnemyHealth = EnemyHealth;
        this.EnemySpeed = EnemySpeed;
    }
    /**
     * Abstract method to get the health of the enemy.
     *
     * @return the Health of the Enemy.
     */
    public abstract int getHealth();

    /**
     * Method to handle actions when enemy is Taken a Hit.
     * Subclasses can override this method to define specific behavior
     * of when an enemy has Taken a Hit.
     */

    public void TakenHit(){

    }

    /**
     * Method to decrement the enemy's health.
     * Subclasses may override this method to define specific behavior.
     *
     * @param x The Amount to Decrease the Health by.
     * @return Updated Health of enemy
     */

    public int decrementHealth(int x) {
        return 0;
        //needs a return value...
    }
}
