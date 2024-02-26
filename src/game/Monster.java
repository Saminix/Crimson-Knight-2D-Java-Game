package game;
import city.cs.engine.*;
import city.cs.engine.BoxShape;
import city.cs.engine.Shape;


public class Monster extends Walker {
    private static final Shape monsterShape = new PolygonShape(0.56f,2.46f, -4.24f,0.55f, 0.03f,-3.31f, 4.41f,-1.57f, 7.67f,2.46f, 5.62f,3.81f, 1.6f,2.81f);
    private static final BodyImage image = new BodyImage("data/Monster1.gif", 9.5f);


    public Monster(World world) {
        super(world, monsterShape);
        this.addImage(image);

    }

}