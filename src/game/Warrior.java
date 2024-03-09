package game;
import city.cs.engine.*;
import city.cs.engine.Shape;
import org.jbox2d.common.Vec2;

import javax.swing.JOptionPane;




public class Warrior extends Walker {
    private static final Shape warriorShape = new PolygonShape(-1.12f,-2.55f, 0.76f,-2.57f, 1.52f,-0.28f, 1.35f,1.93f, -0.9f,2.33f, -1.47f,0.14f, -1.22f,-2.28f);
    private static final BodyImage image = new BodyImage("data/HoodedCharacter/HWarriorStop.gif", 6.4f);

    private int coins;

    private int score;

    //private GameView view;

    private int health;

    public Warrior(World world){
        super(world, warriorShape);
        this.addImage(image);
        setGravityScale(2);

        //this.view = view;

        this.coins = 0;
        this.score = 0;
        this.health = 100;
        Shape warriorShape1 = this.warriorShape;



    }

    public void setCoins(int coins){
        this.coins = coins;
    }

    public int getCoins() {
        return coins;
    }


    public void setHealth( int health){
        this.health = health;
        if ( this.health <= 0){
            this.destroy();
            JOptionPane.showMessageDialog(null, "GAME OVER!");
        }

    }

    public int getHealth() {
        return health;
    }

    public void setScore(int score){ this.score = score;}

    public void attack(Enemy enemy) {
             // or whatever value you want
            enemy.TakenHit();

    }




    public int getScore() {
        return score;
    }






}