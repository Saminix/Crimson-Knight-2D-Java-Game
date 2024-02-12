package game;
import city.cs.engine.*;
import city.cs.engine.BoxShape;
import city.cs.engine.DynamicBody;
import city.cs.engine.Shape;

public class Warrior extends DynamicBody {
    private static final Shape warriorShape = new BoxShape(2,4);
    private static final BodyImage image = new BodyImage("data/warrior.gif", 9.5f);

    public Warrior(World world){
        super(world, warriorShape);
        this.addImage(image);


    }
}
