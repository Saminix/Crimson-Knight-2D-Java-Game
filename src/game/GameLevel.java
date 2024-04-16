package game;
import city.cs.engine.SoundClip;
import city.cs.engine.World;
import org.jbox2d.common.Vec2;
import javax.swing.JFrame;

/**
 * A SuperClass GameLevel which is a Subclass of the World.
 * Enable to develop multi-Levels
 * Provides common functionality and attributes for game levels.
 */

public abstract class GameLevel extends World {
    protected Warrior warrior;
    private CheckPoint CheckPoint;
    public abstract void stopMusic();
    private Enemy enemy;

    // Reference to the Game instance associated with this level
    private Game game;
    private JFrame frame;
    private SoundClip gameMusic;

    /**
     * Constructs a GameLevel with specified Game instance.
     *
     * @param game The Game instance associated with this level.
     */
    public GameLevel(Game game){
        this.game = game;

        // Create the warrior
        warrior = new Warrior(this);
        warrior.setPosition(new Vec2(-190, -10.5f));

        // Add collision listener for coin/treasure/points/potion pickups
        WarriorPickup pickup = new WarriorPickup(warrior);

        warrior.addCollisionListener(pickup);
        WarriorCollisions trap = new WarriorCollisions(warrior, game);
        warrior.addCollisionListener(trap);

        warrior.addCollisionListener(new CheckPointEncounter(this, game));

        WarriorController warriorController = new WarriorController(warrior);
        warrior.setWarriorController(warriorController);
    }

    /**
     * Sets the warrior character for this level.
     *
     * @param warrior sets the warrior character.
     */
    public void setWarrior(Warrior warrior) {
        this.warrior = warrior;
    }


    /**
     * Gets the warrior Character for this level
     *
     * @return warrior character
     */
    public Warrior getWarrior() {
        return warrior;
    }

    /**
     * Abstract method to check if the level is complete.
     *
     * @return True if the level is complete.
     */
    public abstract boolean isComplete();

    /**
     * Get the Number of coins collected by the warrior in the level.
     *
     * @return Number of coins collected by warrior
     */
    public int coins(){
        return getWarrior().getCoins();
    }


    /**
     * Stops the level by stopping any ongoing sounds and level.
     */
    public void stop() {
        stopMusic();
        super.stop();
    }
}
