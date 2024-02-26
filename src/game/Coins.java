package game;
import city.cs.engine.*;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.io.IOException;

import city.cs.engine.DynamicBody;

public class Coins extends StaticBody {
    private static final Shape coinsShape = new CircleShape(1);

    private static final BodyImage image = new BodyImage("data/Coin.gif", 4f);


    public Coins(World w){
        super(w, coinsShape);
        addImage(image);
    }
}
