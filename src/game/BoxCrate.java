package game;
import city.cs.engine.*;


public class BoxCrate extends StaticBody {
    private static final Shape boxShape = new BoxShape(2f,2f);

    private static final BodyImage image = new BodyImage("data/box.png", 5f);


    public BoxCrate(World world){
        super(world, boxShape);
        addImage(image);
    }
}
