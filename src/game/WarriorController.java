package game;
import city.cs.engine.*;


import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class WarriorController implements KeyListener {
    private Warrior warrior;
    private static final int walkSpeed = 10;
    private static final int jumpSpeed = 15;
    private static final float imageScale = 6.8f;

    private boolean isFacingRight = false;

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

    }

    private void setWarriorMove(){
        warrior.startWalking(walkSpeed);
        warrior.removeAllImages();
        warrior.addImage(new BodyImage("data/HoodedCharacter/HWarriorRUN.gif", imageScale));
        isFacingRight = true;

    }

    private void setWarriorMoveLeft(){
        warrior.startWalking(-walkSpeed);
        warrior.removeAllImages();
        warrior.addImage(new BodyImage("data/HoodedCharacter/HWarriorRUNLeft.gif", imageScale));
        isFacingRight = false;

    }


    private void attack() {

        if (isFacingRight) {
            warrior.removeAllImages();
            warrior.addImage(new BodyImage("data/HoodedCharacter/HWarriorHit.gif", imageScale));
        } else {
            warrior.removeAllImages();
            warrior.addImage(new BodyImage("data/HoodedCharacter/HWarriorHitLeft.gif", imageScale));
        }

        //try {
        //AudioClip swordSlash = new AudioClip("data/Audio/swordSlash.wav");
        //swordSlash.play();
        //} catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {

    }




    public void updateWarrior(Warrior newWarrior){
        warrior = newWarrior;
    }








}



