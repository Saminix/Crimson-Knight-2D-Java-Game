package game;
import city.cs.engine.*;
import city.cs.engine.BoxShape;
import city.cs.engine.Shape;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;


public class Warrior extends Walker {
    private static final Shape warriorShape = new PolygonShape(0.11f,0.6f, 1.81f,0.43f, 1.81f,-2.02f, 0.11f,-4.5f, -3.93f,-3.39f, -2.81f,-0.54f, -0.45f,0.63f);
    private static final BodyImage image = new BodyImage("data/warrior.gif", 10.5f);

    private int coins = 0;
    private int score = 0;

    private int health = 100;

    private int coinCount;

    public Warrior(World world){
        super(world, warriorShape);
        this.addImage(image);

        coins = 0;
        score = 0;
        health = 100;


    }

    public void setCoins(int points){
        this.coins = coins;
    }

    public int getCoins() {
        return coins;
    }


    public void setHealth( int health){
        this.health = health;
    }

    public int getHealth() {
        return health;
    }

    public void setScore(int score){ this.score = score;}


    public int getScore() {
        return score;
    }

    public void setCoinCount( int coinCount){
        this.coinCount = coinCount;

        System.out.println("Becoming richer: Coins = " + coinCount);
    }

}
