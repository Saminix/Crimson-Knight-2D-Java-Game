package game;
import city.cs.engine.*;
/**
 * CheckPoint Class Represents the Checkpoint in the game.
 * The Checkpoint is a static object with a DoorShape.
 *
 *
 */
public class CheckPoint extends StaticBody {
    private static final Shape DoorShape = new BoxShape(3,2);
    private static final BodyImage image = new BodyImage("data/Door.png", 9);
    /**
     * Constructs a Checkpoint, Attributes and position in the world.
     * @param world Where the Checkpoint Exists.
     */
    public CheckPoint(World world){
        super(world, DoorShape);
        addImage(image);
    }
}
