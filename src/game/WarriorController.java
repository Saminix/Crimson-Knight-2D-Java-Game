package game;

import game.Warrior;
import city.cs.engine.*;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class WarriorController implements KeyListener {
    private Warrior warrior;

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
            warrior.addImage(new BodyImage("data/WarriorLeft.gif", 9.5f));

        } else if (code == KeyEvent.VK_D) {
            warrior.startWalking(5);
            warrior.removeAllImages();
            warrior.addImage(new BodyImage("data/warrior.gif", 9.5f));

        } else if ( code == KeyEvent.VK_W){
            warrior.jump(12);
        }


    }

    @Override
    public void keyReleased(KeyEvent e) {
        int code = e.getKeyCode();
        if ( code == KeyEvent.VK_A) {
            warrior.stopWalking();
        } else if ( code == KeyEvent.VK_D){
            warrior.stopWalking();
        }


    }



}
