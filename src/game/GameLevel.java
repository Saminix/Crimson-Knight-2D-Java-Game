package game;
import city.cs.engine.SoundClip;
import city.cs.engine.World;
import org.jbox2d.common.Vec2;
import javax.swing.JFrame;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * A SuperClass GameLevel which is a Subclass of the World.
 * Enable to develop multi-Levels
 * Provides common functionality and attributes for game levels.
 */

public abstract class GameLevel extends World {
    /**
     * The warrior character associated with this level.
     */
    protected Warrior warrior;

    /**
     * Sets the player statistics for this level.
     * @param playerStats playerStats The statistics of the player to set.
     */
    public abstract void setPlayerStats(String playerStats);

    /**
     * Gets the player statistics for this level.
     *
     * @return A string representing the player statistics.
     */
    public abstract String getPlayerStats();

    /**
     * Gets the name of the level.
     *
     * @return The name of the level.
     */
    public abstract String getLevelName();


    /**
     * The checkpoint associated with this level.
     */
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
     * Creates a specific level based on the provided Game instance and level name.
     *
     * @param game The Game instance associated with the level.
     * @param levelName The name of the level to create.
     * @return A GameLevel object representing the specified level.
     */
    public static GameLevel createLevel(Game game, String levelName) {
        if (levelName.equals("Level1")) {
            return new Level1(game, "level1");
        } else if (levelName.equals("Level2")) {
            return new Level2(game, "level2");
        }else if (levelName.equals("Level3")) {
            return new Level3(game, "level3");
        }else if (levelName.equals("Level4")) {
            return new Level4(game, "level4");
        }
        return null;
    }


    /**
     * Loads a game level from a save file.
     *
     * @param game The Game instance associated with the level.
     *
     * @return A GameLevel object representing the loaded level.
     * @throws IOException If an I/O error occurs while loading the level.
     */
    public static GameLevel loadLevel(Game game) throws IOException {
        GameLevel loadedLevel = null;
        String fileName = "save_game.txt";
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            // Read and process the level data from the file
            String line = reader.readLine();
            String[] data = line.split(",");
            String levelName = data[0];
            String playerStats = data[1]; // Assuming player stats are stored in the save file

            // Create the appropriate level based on the level name
            loadedLevel = createLevel(game, levelName);

            // Set player stats for the loaded level
            loadedLevel.setPlayerStats(playerStats);

            // You may need to load other level-specific data here...

        } catch (IOException e) {
            // Handle IO exception
            throw e;
        }
        return loadedLevel;
    }

    /**
     * Stops the level by stopping any ongoing sounds and level.
     */
    public void stop() {
        stopMusic();
        super.stop();
    }
}
