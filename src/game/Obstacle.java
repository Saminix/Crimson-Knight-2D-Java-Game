package game;
import city.cs.engine.*;
import org.jbox2d.common.Vec2;

/**
 * Represents an obstacle in the game world.
 *
 */
public class Obstacle extends StaticBody {
    private final String imagePath;
    /**
     * Constructs an obstacle with the specified properties.
     *
     * @param world The world in which the obstacle exists.
     * @param shape The shape of the obstacle.
     * @param imagePath The file path of the image representing the obstacle.
     * @param x The x-coordinate of the obstacle's position.
     * @param y The y-coordinate of the obstacle's position.
     * @param height The height of the obstacle's image.
     */

    public Obstacle(World world, Shape shape, String imagePath, float x, float y, float height) {
        super(world, shape);
        this.imagePath = imagePath;
        addImage(new BodyImage(imagePath, height));
        setPosition(new Vec2(x, y));
    }

}




