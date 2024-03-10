package game;
import city.cs.engine.*;
import org.jbox2d.common.Vec2;

public class Potion extends Collectibles{


    private static final String imagePath = "data/HealthPotion.gif";

    public Potion(World world, float radius, float x, float y){
        super(world, new CircleShape(radius), new Vec2(x,y));
        float height = 4;
        addImage(new BodyImage(imagePath, height));
    }



    @Override
    public int collectItem(int value){
        return value;

    }





}