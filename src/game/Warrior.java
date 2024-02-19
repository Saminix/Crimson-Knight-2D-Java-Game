package game;
import city.cs.engine.*;
import city.cs.engine.BoxShape;
import city.cs.engine.Shape;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;


public class Warrior extends Walker {
    private static final Shape warriorShape = new BoxShape(2,4);
    private static final BodyImage image = new BodyImage("data/warrior.gif", 9.5f);

    private int points = 0;

    public Warrior(World world){
        super(world, warriorShape);
        this.addImage(image);

    }

    public void setPoints(int points){
        this.points = points;
    }

    public int getPoints() {
        return points;
    }







}
