package game;
import city.cs.engine.*;
import city.cs.engine.Shape;
public class Point extends DynamicBody {

    private static final Shape pointorb = new CircleShape(0.5F);
    private static final BodyImage image = new BodyImage("data/pointOrb.giff", 1);

    public Point(World world){
        super(world, pointorb);
        this.addImage(image);
    }





}

