package game;
import city.cs.engine.*;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.*;
import java.awt.*;
import java.io.IOException;

/**
 * My Game Main Entry Point.
 *
 * This Class Represents The Games Main Entry Point and control.
 * consists and manages the initialisations, transitions and interfaces
 */
public class Game {


   // Reference to the current game level
    GameLevel currentLevel;

    // Reference to the main JFrame
    private JFrame frame;

    private boolean isLastLevel;
    // Flag to track whether the current level is the last level

    /**
     * A graphical display of the world (a specialised JPanel).
     */
    GameView view;



    // Total coins collected in the game
    private int totalCoins = 0;
    // Total score accumulated in the game
    private int totalScore = 0;

    private boolean isPaused = false;

    WarriorController controller;
    // Controller for the game's warrior
    private SoundClip gameMusic;

    private SoundClip gameMusicLevel3;




    Warrior warrior;
    // Reference to the game's warrior


    /**
     * Initialise a new Game.
     * Creates the main menu and starts the game if the play button is pressed.
     */
    public Game() {
        MainMenu menu = new MainMenu(this);
        if (menu.IsPlayButtonPressed()) {
            System.out.println("button pressed");
            startGame();
        }
    }



    /**
     * Method to Initialise and start the Game
     */
    public void startGame() {

        currentLevel = new Level1(this, gameMusic);
        try {
            gameMusic = new SoundClip("audio/GameMusic.wav");
            playGameMusic();
        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
            System.out.println(e);
        }
        warrior = currentLevel.getWarrior();
        this.isLastLevel = false;
        view = new GameView(currentLevel, 800, 600, "data/ForestBackGround.jpg");



        controller = new WarriorController(currentLevel.getWarrior());
        view.addKeyListener(controller);
        view.addMouseListener(new GiveFocus(view));

        //make the view continue to Track the Player
        currentLevel.addStepListener(new Tracker(view, currentLevel.getWarrior()));
        view.setCentre(currentLevel.getWarrior().getPosition());

        Shoot mouseHandler = new Shoot(currentLevel, view);
        view.addMouseListener(mouseHandler);

        PowerBlast keyHandler = new PowerBlast(currentLevel,view, warrior, mouseHandler);
        view.addMouseListener(keyHandler);


        final JFrame frame = new JFrame("Crimson Ghost");
        frame.add(view);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationByPlatform(true);
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);
        frame.pack();
        frame.setVisible(true);

        ControlPanel controlPanel = new ControlPanel(this);
        frame.add(controlPanel, BorderLayout.SOUTH);



        // Start the game world simulation
        view.requestFocus();
        currentLevel.start();

    }

    /**
     * Method that Handles the Transition to the Next Level and to
     * Make sure if the Level need to go to Next Level.
     * Updates the Game and Stops the current level.
     * Initiates a Game Complete Panel is the Last level is true.
     */


    public void isNextLevel() {
        currentLevel.stop();
        disposeCurrentLevelFrame();
        Warrior oldWarrior = currentLevel.getWarrior();
        totalCoins += oldWarrior.getCoins();
        totalScore += oldWarrior.getScore();

        //Store the Score & Coins From Level 1
        if(isLastLevel() == false){
            LevelPanel nextLevel = new LevelPanel(this,oldWarrior.getCoins(), oldWarrior.getScore());
            if (nextLevel.IsButtonPressed()) {
                goToNextLevel();
            }
        }else{
            GameComplete panel = new GameComplete(this, totalCoins,totalScore);
        }

    }

    /**
     * Proceeds to the next level of the game.
     * Initializes the next level and updates the game view, Warrior.
     */


    public void goToNextLevel() {
        if (currentLevel instanceof Level1) {
            System.out.println("Level 2 Initiated");
            currentLevel.stop();


            Warrior oldWarrior = currentLevel.getWarrior();
            //get whole score for level

            totalCoins += oldWarrior.getCoins();
            totalScore += oldWarrior.getScore();

            currentLevel = new Level2(this);
            Warrior newWarrior = currentLevel.getWarrior();
            newWarrior.setSpecial(oldWarrior.getSpecial());

            currentLevel.addStepListener(new Tracker(view, newWarrior));
            view.setCentre(newWarrior.getPosition());
            view.setWorld(currentLevel);
            controller.updateWarrior(newWarrior);

            Shoot mouseHandler = new Shoot(currentLevel, view);
            view.addKeyListener(controller);

            PowerBlast keyHandler = new PowerBlast(currentLevel,view, newWarrior, mouseHandler);
            view.addMouseListener(keyHandler);
            view.addMouseListener(mouseHandler);
            view.updateWarriorInstance(newWarrior);
            view.setBackgroundImage("data/Desert.jpg");
            currentLevel.getWarrior().ResetAttributes();

            currentLevel.start();

        } else if (currentLevel instanceof Level2) {
            System.out.println("Level 3 Initiated");
            stopGameMusic();
            currentLevel.stop();
            Warrior oldWarrior = currentLevel.getWarrior();

            //get whole score for level
            totalCoins += oldWarrior.getCoins();
            totalScore += oldWarrior.getScore();


            currentLevel = new Level3(this, gameMusicLevel3);

            try {
                gameMusicLevel3 = new SoundClip("audio/ScaryMusic.wav");
                gameMusicLevel3.setVolume(0.3);
                gameMusicLevel3.loop();
            } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
                System.out.println(e);
            }

            Warrior newWarrior = currentLevel.getWarrior();
            newWarrior.setSpecial(oldWarrior.getSpecial());

            currentLevel.addStepListener(new Tracker(view, newWarrior));
            view.setCentre(newWarrior.getPosition());
            view.setWorld(currentLevel);
            controller.updateWarrior(newWarrior);

            Shoot mouseHandler = new Shoot(currentLevel, view);
            view.addKeyListener(controller);

            PowerBlast keyHandler = new PowerBlast(currentLevel,view, newWarrior, mouseHandler);
            view.addMouseListener(keyHandler);
            view.addMouseListener(mouseHandler);

            view.updateWarriorInstance(newWarrior);
            view.setBackgroundImage("data/gloomyForest.jpg");
            currentLevel.getWarrior().ResetAttributes();
            currentLevel.start();
        } else if (currentLevel instanceof Level3) {
            gameMusicLevel3.stop();
            System.out.println("Level 4 Initiated");
            currentLevel.stop();

            playGameMusic();
            Warrior oldWarrior = currentLevel.getWarrior();

            totalCoins += oldWarrior.getCoins();
            totalScore += oldWarrior.getScore();

            currentLevel = new Level4(this);
            Warrior newWarrior = currentLevel.getWarrior();
            newWarrior.setSpecial(oldWarrior.getSpecial());


            currentLevel.addStepListener(new Tracker(view, newWarrior));
            view.setCentre(newWarrior.getPosition());
            view.setWorld(currentLevel);
            controller.updateWarrior(newWarrior);

            Shoot mouseHandler = new Shoot(currentLevel, view);
            view.addKeyListener(controller);

            PowerBlast keyHandler = new PowerBlast(currentLevel,view, newWarrior, mouseHandler);
            view.addMouseListener(keyHandler);
            view.addMouseListener(mouseHandler);

            view.updateWarriorInstance(newWarrior);
            view.setBackgroundImage("data/Farm.jpg");
            currentLevel.getWarrior().ResetAttributes();
            currentLevel.start();

        }else if (currentLevel instanceof Level4) {
            setLastLevel(true);
            stopGameMusic();
            currentLevel.stop();
            disposeCurrentLevelFrame();
            GameComplete panel = new GameComplete(this, totalCoins,totalScore);
        }
    }


    /**
     * Run the game.
     * Main method to run the game.
     */
    public static void main(String[] args) {

        new Game();
    }

    /**
     * Disposes of the current level's frame.
     */
    public void disposeCurrentLevelFrame() {
        if (frame != null) {
            frame.dispose();
        }
    }

    public void setGameMusic(SoundClip gameMusic) {
        this.gameMusic = gameMusic;
    }


    public void stopGameMusic(){
        gameMusic.stop();
    }

    public void playGameMusic(){
        gameMusic.setVolume(0.3);
        gameMusic.loop();
    }


    /**
     * Method to toggle the pause state of the game.
     */
    public void togglePause() {
        isPaused = !isPaused; // Toggle pause state

        if (isPaused) {
            currentLevel.stop(); // Stop the game simulation if paused
            if (gameMusic != null || gameMusicLevel3 !=null) {
                gameMusic.pause();// Pause the game music
                gameMusicLevel3.pause();
            }
        } else {
            currentLevel.start(); // Start or resume the game simulation if unpaused
            if (gameMusic != null || gameMusicLevel3 !=null) {
                gameMusic.resume();
                gameMusicLevel3.resume();// Resume the game music
            }
        }
    }

    public void showGameOver(){
        GameOver panel = new GameOver(this);
    }

    /**
     * Getter for the isLastLevel flag.
     *
     * @return True if the current level is the last level, otherwise false.
     */

    public boolean isLastLevel() {
        return isLastLevel;
    }

    /**
     * Setter for the isLastLevel flag.
     *
     * @param lastLevel True if the current level is the last level, otherwise false.
     */
    public void setLastLevel(boolean lastLevel) {
        isLastLevel = lastLevel;
    }
}

