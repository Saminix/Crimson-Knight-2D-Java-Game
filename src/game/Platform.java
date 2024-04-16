package game;

import city.cs.engine.*;
import org.jbox2d.common.Vec2;

/**
 * Represents a platform in the game world.
 * This class is abstract and can be subclassed to create specific types of platforms.
 */

public abstract class Platform extends StaticBody {
    /**
     * Constructs a platform with the specified properties.
     *
     * @param world The world in which  platform exists.
     * @param shape The shape of the platform.
     * @param position The position of the platform.
     * @param imagePath The file path of the image representing the platform.
     * @param height The height of the platform's image.
     */
    public Platform(World world, Shape shape, Vec2 position, String imagePath, float height){
        super(world, shape);
        addImage(new BodyImage(imagePath, height));
        setPosition(position);

    }
}
