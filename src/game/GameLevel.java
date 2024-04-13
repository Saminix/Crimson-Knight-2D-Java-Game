package game;

import city.cs.engine.SoundClip;
import city.cs.engine.World;
import org.jbox2d.common.Vec2;
import javax.swing.JFrame;


public abstract class GameLevel extends World {
    protected Warrior warrior;

    private CheckPoint CheckPoint;
    public abstract void stopMusic();


    private Enemy enemy;
    private Game game;
    private JFrame frame;
    private SoundClip gameMusic;



    public GameLevel(Game game){
        this.game = game;

        // Create the warrior
        warrior = new Warrior(this);
        warrior.setPosition(new Vec2(120, -10.5f)); // Set initial position of the warrior

        // Add collision listener for coin/treasure/points/potion pickups
        WarriorPickup pickup = new WarriorPickup(warrior);

        warrior.addCollisionListener(pickup);
        WarriorCollisions trap = new WarriorCollisions(warrior, game);
        warrior.addCollisionListener(trap);

        warrior.addCollisionListener(new CheckPointEncounter(this, game));

        WarriorController warriorController = new WarriorController(warrior);
        warrior.setWarriorController(warriorController);










    }


    public void setWarrior(Warrior warrior) {
        this.warrior = warrior;
    }



    public Warrior getWarrior() {
        return warrior;
    }
    public Enemy getEnemy(){return enemy;}

    public  CheckPoint getCheckPoint(){
        return CheckPoint;
    }

    public abstract boolean isComplete();


    public int coins(){
        return getWarrior().getCoins();
    }

    public void stop() {
        // Stop any ongoing sounds or music
        stopMusic();
        // Stop the simulation
        super.stop();
    }


}
