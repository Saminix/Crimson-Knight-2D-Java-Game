package game;
import city.cs.engine.*;
import city.cs.engine.Shape;
import org.jbox2d.common.Vec2;
/**
 * A class representing the warrior, in the game.
 */

public class Warrior extends Walker {
    private static final Shape warriorShape = new PolygonShape(-1.12f,-2.55f, 0.76f,-2.57f, 1.52f,-0.28f, 1.35f,1.93f, -0.9f,2.33f, -1.47f,0.14f, -1.22f,-2.28f);
    private static final BodyImage image = new BodyImage("data/HoodedCharacter/HWarriorStop.gif", 6.4f);

    private int coins;
    private WarriorController warriorController;
    private int special;

    private int score;
    private int key;
    private int health;


    /**
     * Constructs a Warrior object.
     * @param world The world in which the warrior exists.
     */
    public Warrior(World world){
        super(world, warriorShape);
        this.addImage(image);
        setGravityScale(2);


        this.coins = 0;

        this.score = 0;
        this.health = 100;
        this.special = 0;
        this.key = 0;


    }

    /**
     * Sets the number of coins collected by the warrior.
     * @param coins The number of coins collected.
     */

    public void setCoins(int coins){
        this.coins = coins;
    }

    /**
     * Sets the WarriorController for controlling the warrior's actions.
     * @param warriorController The WarriorController instance.
     */
    public void setWarriorController(WarriorController warriorController) {
        this.warriorController = warriorController;
    }

    /**
     * Sets the warrior's special ability.
     * @param special The level of the warrior's special ability.
     */
    public void setSpecial(int special) {
        this.special = special;

    }
    /**
     * Gets the level of the warrior's special ability.
     * @return The level of the warrior's special ability.
     */
    public int getSpecial() {
        return special;
    }


    /**
     * Gets the number of coins collected by the warrior.
     * @return The number of coins collected.
     */
    public int getCoins() {
        return coins;
    }


    /**
     * Sets the warrior's health.
     * @param health The warrior's health.
     */
    public void setHealth( int health){
        this.health = health;
        if ( this.health <= 0){
            this.destroy();


        }

    }

    /**
     * Gets the warrior's health.
     * @return The warrior's health.
     */

    public int getHealth() {
        return health;
    }



    /**
     * Sets the warrior's score.
     * @param score The warrior's score.
     */
    public void setScore(int score){ this.score = score;}

    /**
     * Resets the warrior's attributes such as coins, score, and health.
     */

    public void ResetAttributes(){
        this.coins =0;
        this.score = 0;
        this.health = 100;

    }
    /**
     * Sets the key collected by the warrior.
     * @param key The key collected.
     */

    public void setKey(int key) {
        this.key = key;
    }

    /**
     * Gets the key collected by the warrior.
     * @return The key collected.
     */

    public int getKey() {
        return key;
    }

    /**
     * Gets the warrior's score.
     * @return The warrior's score.
     */
    public int getScore() {
        return score;
    }

    /**
     * Checks if the warrior is facing right.
     * @return True if the warrior is facing right, otherwise false.
     */
    public boolean isFacingRight(){
        return warriorController.isFacingRight();
    }



    public void setPlayerStats(String playerStats) {
        // Implement the logic to set player stats for the warrior
        // For example:
        // Assuming playerStats is a string representation of the warrior's stats
        // You can parse the string and set the warrior's stats accordingly
        // For example:
        // parsePlayerStats(playerStats);
    }




}








