package game;
import city.cs.engine.*;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.io.IOException;

import city.cs.engine.DynamicBody;

public class BoxCrate extends StaticBody {
    private static final Shape boxShape = new BoxShape(2f,2f);

    private static final BodyImage image = new BodyImage("data/BoxCrate.png", 5f);


    public BoxCrate(World world){
        super(world, boxShape);
        addImage(image);
    }
}
