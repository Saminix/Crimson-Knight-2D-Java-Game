package game;

import game.Warrior;
import city.cs.engine.*;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.io.IOException;
import javax.sound.sampled.LineUnavailableException;


import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;

public class WarriorController implements KeyListener {
    private Warrior warrior;
    private static final int walkSpeed = 10;
    private static final int jumpSpeed = 12;
    private static final float imageScale = 7.5f;

    private GameWorld gameworld;

    private Enemy enemy;

    private boolean isAttacking = false;

    private boolean isFacingRight = false;

    // in order to allow the player to move the character in the direction it is facing, to jump or run etc


    public WarriorController(Warrior warrior, GameWorld gameworld) {

        this.warrior = warrior;
        this.gameworld = gameworld;
        this.enemy = enemy;
    }


    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        int code = e.getKeyCode();
        if (code == KeyEvent.VK_A) {
            warrior.startWalking(-walkSpeed);
            warrior.removeAllImages();
            warrior.addImage(new BodyImage("data/HoodedCharacter/HWarriorRUNLeft.gif", imageScale));
            isFacingRight = false;

        } else if (code == KeyEvent.VK_D) {
            warrior.startWalking(walkSpeed);
            warrior.removeAllImages();
            warrior.addImage(new BodyImage("data/HoodedCharacter/HWarriorRUN.gif", imageScale));
            isFacingRight = true;

        } else if (code == KeyEvent.VK_W) {
            warrior.jump(jumpSpeed);
            if (isFacingRight) {
                warrior.removeAllImages();
                warrior.addImage(new BodyImage("data/HoodedCharacter/warriorJump.gif", imageScale - 1));
            } else {
                warrior.removeAllImages();
                warrior.addImage(new BodyImage("data/HoodedCharacter/warriorJumpLeft.gif", imageScale - 1));
            }


        } else if (code == KeyEvent.VK_M) {
            isAttacking = true;
            attack();

        }


    }

    @Override
    public void keyReleased(KeyEvent e) {
        int code = e.getKeyCode();
        if (code == KeyEvent.VK_A || code == KeyEvent.VK_D) {
            warrior.stopWalking();
        } else if (code == KeyEvent.VK_M) {
            setWarriorToStop();
        } else if (code == KeyEvent.VK_W) {
            setWarriorToStop();

        }


    }


    // method to position which direction the warrior stops in.

    private void setWarriorToStop() {

        warrior.removeAllImages();
        if (isFacingRight) {
            warrior.removeAllImages();
            warrior.addImage(new BodyImage("data/HoodedCharacter/HWarriorStop.gif", imageScale));
        } else {
            warrior.removeAllImages();
            warrior.addImage(new BodyImage("data/HoodedCharacter/HWarriorStopLeft.gif", imageScale));
        }
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
        //AudioClip swordslash = new AudioClip("data/Audio/swordSlash.wav");
        //swordslash.play();
        //} catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {

        //e.printStackTrace();
        // }
        // Accessing enemies from the world
        // foreach loop.

        Monster monster = gameworld.getMonster();
        if (monster != null) {
            // Attack the monster
            warrior.attack(monster);
        }
            //if the monster object obtained from the gameworld is not null.check for nullpointer exceptions

        }


    }












