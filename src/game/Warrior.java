package game;
import city.cs.engine.*;
import city.cs.engine.BoxShape;
import city.cs.engine.Shape;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;


public class Warrior extends Walker {
    private static final Shape warriorShape = new PolygonShape(0.11f,0.6f, 1.81f,0.43f, 1.81f,-2.02f, 0.11f,-4.5f, -3.93f,-3.39f, -2.81f,-0.54f, -0.45f,0.63f);
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
