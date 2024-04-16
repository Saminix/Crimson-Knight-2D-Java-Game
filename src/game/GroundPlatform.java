package game;
import city.cs.engine.*;
import org.jbox2d.common.Vec2;

/**
 * Subclass representing a ground platform.
 * This class inherits from the Platform class.
 */

public class GroundPlatform extends Platform {

    /**
     * Constructs a GroundPlatform object with the specified parameters consisting of
     * Attributes, Sizes,Positions and  Height.
     *
     * @param world         The world in which the platform exists.
     * @param boxSizeWidth  The width of the platform's box shape
     * @param boxSizeHeight The height of the platform's box shape.
     * @param x             The x-coordinate of the platform's position
     * @param y             The y-coordinate of the platform's position.
     * @param path          The path to the image used for the platform.
     * @param height        The height of the platform
     */

    public GroundPlatform(World world, float boxSizeWidth, float boxSizeHeight, float x, float y, String path, float height) {
        super(world, new BoxShape(boxSizeWidth, boxSizeHeight), new Vec2(x, y), path, height);
    }

}