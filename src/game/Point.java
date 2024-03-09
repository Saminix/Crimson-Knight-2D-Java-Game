package game;
import city.cs.engine.*;
import city.cs.engine.Shape;
import org.jbox2d.common.Vec2;

public class Point extends Collectibles {


    private static final String imagePath = "data/PointOrb.gif";

    public Point(World world, float boxSizeWidth, float x, float y){
        super(world, new CircleShape(boxSizeWidth), new Vec2(x,y));
        float height = 2;
        addImage(new BodyImage(imagePath, height));
    }



    @Override
    public int collectItem(int value){
        return value;

    }









}

