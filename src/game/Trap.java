package game;

import city.cs.engine.*;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.io.IOException;

import city.cs.engine.DynamicBody;

public class Trap extends StaticBody{
    private static final Shape trapShape = new CircleShape(1.5f);

    private static final BodyImage image = new BodyImage("data/obstacle1.gif", 6f);


    public Trap(World world){
        super(world, trapShape);
        addImage(image);
    }
}


