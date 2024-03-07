package game;

import city.cs.engine.*;
import org.jbox2d.common.Vec2;

public abstract class  Platform extends StaticBody {
    public Platform(World world, Shape shape, Vec2 position, String imagePath, float height){
        super(world, shape);
        addImage(new BodyImage(imagePath, height));
        setPosition(position);

    }
}
