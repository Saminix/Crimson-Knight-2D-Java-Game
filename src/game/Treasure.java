package game;
import city.cs.engine.*;
import org.jbox2d.common.Vec2;

public class Treasure extends Collectibles{


    private static final String imagePath = "data/Treasure.gif";

    public Treasure(World world, float boxSizeWidth, float boxSizeHeight, float x, float y){
        super(world, new BoxShape(boxSizeWidth, boxSizeHeight), new Vec2(x,y));
        float height = 5;
        addImage(new BodyImage(imagePath, height));
    }



    @Override
    public int collectItem(int value){
        return value;

    }



}




