package game;
import city.cs.engine.*;


import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.IOException;

public class WarriorController implements KeyListener {
    private Warrior warrior;
    private static final int walkSpeed = 10;
    private static final int jumpSpeed = 15;
    private static final float imageScale = 6.8f;


    private boolean isFacingRight = false;
    private boolean isPlayingMovingAudio = false;
    private boolean isPlayingJumpAudio = false;

    private static SoundClip movingSound,jumpSound;

    static {
        try {
            movingSound = new SoundClip("audio/footsteps.wav");
            jumpSound = new SoundClip("audio/jump.wav");
        } catch (UnsupportedAudioFileException|IOException|LineUnavailableException e) {
            System.out.println(e);
        }
    }

    // in order to allow the player to move the character in the direction it is facing, to jump or run etc

    public WarriorController(Warrior warrior) {
        this.warrior = warrior;








    }


    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        int code = e.getKeyCode();
        if (code == KeyEvent.VK_A) {
           setWarriorMoveLeft();

        } else if (code == KeyEvent.VK_D) {
            setWarriorMove();

        } else if (code == KeyEvent.VK_W) {
            setWarriorJump();


        } else if (code == KeyEvent.VK_M){
            attack();



        }


    }

    @Override
    public void keyReleased(KeyEvent e) {
        int code = e.getKeyCode();
        if (code == KeyEvent.VK_A || code == KeyEvent.VK_D) {
            warrior.stopWalking();
            setWarriorToStop();
        } else if (code == KeyEvent.VK_M) {
            warrior.stopWalking();
            setWarriorToStop();
        } else if (code == KeyEvent.VK_W) {
            warrior.stopWalking();
            setWarriorToStop();
        }
    }

    // method to position which direction the warrior stops in.
    private void setWarriorToStop() {
        warrior.stopWalking();
        warriorMovementStopPlaying();
        warriorJumpStopPlaying();
        warrior.removeAllImages();
        if (isFacingRight) {
            warrior.removeAllImages();
            warrior.addImage(new BodyImage("data/HoodedCharacter/HWarriorStop.gif", imageScale));
        } else {
            warrior.removeAllImages();
            warrior.addImage(new BodyImage("data/HoodedCharacter/HWarriorStopLeft.gif", imageScale));
        }
    }

    private void setWarriorJump(){
        warrior.jump(jumpSpeed);
        if (isFacingRight) {
            warrior.removeAllImages();
            warrior.addImage(new BodyImage("data/HoodedCharacter/warriorJump.gif", imageScale - 1));
        } else {
            warrior.removeAllImages();
            warrior.addImage(new BodyImage("data/HoodedCharacter/warriorJumpLeft.gif", imageScale - 1));
        }

        warriorJumpPlay();


    }

    private void setWarriorMove(){
        warrior.startWalking(walkSpeed);
        warriorMovementPlay();
        warrior.removeAllImages();
        warrior.addImage(new BodyImage("data/HoodedCharacter/HWarriorRUN.gif", imageScale));
        isFacingRight = true;

    }

    private void setWarriorMoveLeft(){
        warrior.startWalking(-walkSpeed);
        warriorMovementPlay();
        warrior.removeAllImages();
        warrior.addImage(new BodyImage("data/HoodedCharacter/HWarriorRUNLeft.gif", imageScale));
        isFacingRight = false;

    }


    public void attack() {

        if (isFacingRight) {
            warrior.removeAllImages();
            warrior.addImage(new BodyImage("data/HoodedCharacter/HWarriorHit.gif", imageScale));
        } else {
            warrior.removeAllImages();
            warrior.addImage(new BodyImage("data/HoodedCharacter/HWarriorHitLeft.gif", imageScale));
        }



    }


    public void updateWarrior(Warrior newWarrior){
        warrior = newWarrior;
    }


    public void warriorMovementPlay(){
        if(!isPlayingMovingAudio){
            movingSound.play();
            isPlayingMovingAudio = true;
        }

    }

    public void warriorMovementStopPlaying(){
        movingSound.stop();
        isPlayingMovingAudio = false;
    }

    public void warriorJumpPlay(){
        if(!isPlayingJumpAudio){
            jumpSound.play();
            isPlayingJumpAudio = true;
        }

    }

    public void warriorJumpStopPlaying(){
        jumpSound.stop();
        isPlayingJumpAudio = false;
    }

    public boolean isFacingRight(){
        return isFacingRight;
    }








}



