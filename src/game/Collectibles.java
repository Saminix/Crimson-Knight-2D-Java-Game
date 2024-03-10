package game;


import city.cs.engine.Shape;
import city.cs.engine.StaticBody;
import city.cs.engine.World;
import org.jbox2d.common.Vec2;

public abstract class Collectibles extends StaticBody {

    private int value;

    public Collectibles(World world, Shape shape, Vec2 position){
        super(world, shape);
        this.value = value;
        setPosition(position);


    }


    public int collectItem(int value){
        return value;

    }
}
