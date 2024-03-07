package game;
import city.cs.engine.*;
import org.jbox2d.common.Vec2;

public class GroundPlatform extends Platform{

    public GroundPlatform(World world, float boxSizeWidth, float boxSizeHeight, float x,float y, String path, float height){
        super(world,new BoxShape(boxSizeWidth, boxSizeHeight), new Vec2(x,y), path, height );
    }

}
