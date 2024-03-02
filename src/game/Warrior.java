package game;
import city.cs.engine.*;
import city.cs.engine.BoxShape;
import city.cs.engine.Shape;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;


public class Warrior extends Walker {
    private static final Shape warriorShape = new PolygonShape(-1.12f,-2.55f, 0.76f,-2.57f, 1.52f,-0.28f, 1.35f,1.93f, -0.9f,2.33f, -1.47f,0.14f, -1.22f,-2.28f);
    private static final BodyImage image = new BodyImage("data/HoodedCharacter/HWarriorStop.gif", 7.5f);

    private int coins = 0;
    private int score = 0;

    private int health;

    private int coinCount;

    public Warrior(World world){
        super(world, warriorShape);
        this.addImage(image);

        this.coins = 0;
        this.score = 0;
        this.health = 100;


    }

    public void setCoins(int coins){
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
