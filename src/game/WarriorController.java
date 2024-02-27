package game;

import game.Warrior;
import city.cs.engine.*;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class WarriorController implements KeyListener {
    private Warrior warrior;

    private boolean isFacingRight = true;

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
            warrior.startWalking(-5);
            warrior.removeAllImages();
            warrior.addImage(new BodyImage("data/WarriorLeft.gif", 10.5f));
            isFacingRight = false;

        } else if (code == KeyEvent.VK_D) {
            warrior.startWalking(5);
            warrior.removeAllImages();
            warrior.addImage(new BodyImage("data/warrior.gif", 10.5f));
            isFacingRight = true;

        } else if ( code == KeyEvent.VK_W){
            warrior.jump(13);
        }else if ( code == KeyEvent.VK_M  ){
            if ( isFacingRight ){
                warrior.removeAllImages();
                warrior.addImage(new BodyImage("data/warriorstant.png", 21.5f));
            }else {
                warrior.removeAllImages();
                warrior.addImage(new BodyImage("data/warriorstantLeft.png", 21.5f));
            }

        }


    }

    @Override
    public void keyReleased(KeyEvent e) {
        int code = e.getKeyCode();
        if ( code == KeyEvent.VK_A) {
            warrior.stopWalking();
        } else if ( code == KeyEvent.VK_D){
            warrior.stopWalking();
        } else if ( code == KeyEvent.VK_M){
            warrior.removeAllImages();
            warrior.addImage(new BodyImage("data/warrior.gif", 10.5f));

        }


    }



}
