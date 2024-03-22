package game;


import city.cs.engine.*;

public class CheckPoint extends StaticBody {
    private static final Shape flagShape = new BoxShape(3,2);
    private static final BodyImage image = new BodyImage("data/endcheck.gif", 9);

    public CheckPoint(World world){
        super(world, flagShape);
        addImage(image);
    }
}
