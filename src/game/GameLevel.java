package game;

import city.cs.engine.World;
import org.jbox2d.common.Vec2;

public abstract class GameLevel extends World {
    private Warrior warrior;

    private CheckPoint CheckPoint;

    private Enemy enemy;
    private Game game;

    public GameLevel(Game game){
        this.game = game;

        // Create the warrior
        warrior = new Warrior(this);
        warrior.setPosition(new Vec2(100, -10.5f)); // Set initial position of the warrior

        // Add collision listener for coin/treasure/points/potion pickups
        WarriorPickup pickup = new WarriorPickup(warrior);
        warrior.addCollisionListener(pickup);
        WarriorCollisions trap = new WarriorCollisions(warrior);
        warrior.addCollisionListener(trap);

        warrior.addCollisionListener(new CheckPointEncounter(this, game));






    }


    public Warrior getWarrior(){return warrior;}
    public Enemy getEnemy(){return enemy;}

    public  CheckPoint getCheckPoint(){
        return CheckPoint;
    }

    public abstract boolean isComplete();


    public int coins(){
        return getWarrior().getCoins();
    }
}
