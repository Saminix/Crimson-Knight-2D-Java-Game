
package game;
import java.io.IOException;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import city.cs.engine.*;
import org.jbox2d.common.Vec2;

public class Coins extends Collectibles{


    private static final String imagePath = "data/Coin.gif";
    private static SoundClip coinsSound;

    static {
        try {
            coinsSound = new SoundClip("audio/coins.wav");
            System.out.println("coin sound");
        } catch (UnsupportedAudioFileException|IOException|LineUnavailableException e) {
            System.out.println(e);
        }
    }


    public Coins(World world, float radius,float x, float y){
        super(world, new CircleShape(radius), new Vec2(x,y));
        float height = 6;
        addImage(new BodyImage(imagePath, height));

    }


    @Override
    public void destroy()

    {
        coinsSound.play();
        coinsSound.setVolume(0.5);
        super.destroy();
    }

    public void setVolume(double volume){

    }


}



