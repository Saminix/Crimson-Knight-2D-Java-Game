package game;
import city.cs.engine.*;

import city.cs.engine.StaticBody;

public class Treasure extends StaticBody {

    private static final Shape treasureShape = new CircleShape(2);
    private static final BodyImage image = new BodyImage("data/Treasure.gif", 5f);
    private int treasure = 50;


    public Treasure(World world){
        super(world, treasureShape);
        addImage(image);
        this.treasure = treasure;

    }

    public int CollectTreasure(){
        return treasure;

    }





}

