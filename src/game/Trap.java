package game;

import city.cs.engine.*;


public class Trap extends StaticBody{
    private static final Shape trapShape = new CircleShape(1.6f);

    private BodyImage image;




    public Trap(World world, String imagePath, float height){
        super(world, trapShape);
        image = new BodyImage(imagePath, height);
        addImage(image);
    }
}


