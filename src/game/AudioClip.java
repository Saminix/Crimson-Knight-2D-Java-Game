package game;
import city.cs.engine.SoundClip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.io.IOException;

public class AudioClip extends Object {
    private static SoundClip soundClip;


    public AudioClip(String fileName) throws UnsupportedAudioFileException, IOException, LineUnavailableException {
        soundClip = new SoundClip(fileName);
    }


    public void play(){
        soundClip.play();

    }

    public void stop(){
        soundClip.stop();

    }


}