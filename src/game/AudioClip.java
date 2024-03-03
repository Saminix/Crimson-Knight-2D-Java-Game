package game;
import city.cs.engine.SoundClip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.io.IOException;

public class AudioClip extends Object {
    private static AudioClip audioClip;


    public AudioClip(String fileName) throws UnsupportedAudioFileException, IOException, LineUnavailableException {
        audioClip = new AudioClip(fileName);
    }


    public void play(){
        audioClip.play();

    }


}