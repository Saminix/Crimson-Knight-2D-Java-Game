package game;
import city.cs.engine.*;
import city.cs.engine.Shape;
public class Point extends StaticBody {

    private static final Shape pointorb = new CircleShape(0.5F);
    private static final BodyImage image = new BodyImage("data/pointOrb.gif", 3);

    public Point(World world){
        super(world, pointorb);
        this.addImage(image);
    }



}

