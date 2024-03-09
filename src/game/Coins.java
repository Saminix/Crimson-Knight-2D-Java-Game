
package game;
import city.cs.engine.*;
import org.jbox2d.common.Vec2;

public class Coins extends Collectibles{


    private static final String imagePath = "data/Coin.gif";

    public Coins(World world, float radius,float x, float y){
        super(world, new CircleShape(radius), new Vec2(x,y));
        float height = 6;
        addImage(new BodyImage(imagePath, height));
    }




}



