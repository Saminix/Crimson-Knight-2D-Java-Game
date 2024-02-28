package game;
import city.cs.engine.*;

import city.cs.engine.StaticBody;

public class Treasure extends StaticBody {

    private static final Shape treasureShape = new CircleShape(2);
    private static final BodyImage image = new BodyImage("data/Treasure.gif", 5f);


    public Treasure(World world){
        super(world, treasureShape);
        addImage(image);
    }
}

