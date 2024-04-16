package game;

import city.cs.engine.*;

/**
 * A class representing a Trap in the game.
 * Traps are static bodies with a circular shape.
 */


public class Trap extends StaticBody{
    private static final Shape trapShape = new CircleShape(1.6f);

    private BodyImage image;


    /**
     * Constructs a Trap
     *
     * @param world The world in which the trap exists.
     * @param imagePath The file path to the image of the trap.
     * @param height The height of the trap image.
     */

    public Trap(World world, String imagePath, float height){
        super(world, trapShape);
        image = new BodyImage(imagePath, height);
        addImage(image);
    }
}


