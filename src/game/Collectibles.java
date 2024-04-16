package game;
import city.cs.engine.Shape;
import city.cs.engine.StaticBody;
import city.cs.engine.World;
import org.jbox2d.common.Vec2;


/**
 *  A SuperClass Collectibles with represents collectible objects in the game.
 *  Consists of collectible static bodies that can be collected by player.
 */

public abstract class Collectibles extends StaticBody {

    /**
     * Constructs a collectible object in the World using Specified Parameters
     * that a subclass will inherit.
     *
     * @param world The World where the Collectible Exists.
     * @param shape The Shape of the Collectible.
     * @param position The Position of the Collectible.
     * @param height The Collectible Image Size.
     */

    public Collectibles(World world, Shape shape, Vec2 position, float height){
        super(world, shape);
        setPosition(position);
    }

    /**
     * Method to collect the Collectibles and give it a presumed value for
     * each unique Collectible to which subclass may Override this method.
     *
     * @param value  The Value of Collectible.
     * @return Value of the Collectible
     */

    public int collectItem(int value){
        return value;

    }
}
