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
        if (code == KeyEvent.VK_1) {
            warrior.startWalking(-5);
        } else if (code == KeyEvent.VK_2) {
            warrior.startWalking(5);
        }

    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
