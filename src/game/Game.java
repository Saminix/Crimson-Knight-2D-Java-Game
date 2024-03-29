package game;

import city.cs.engine.*;

import java.io.IOException;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.*;



/**
 * Your main game entry point
 */
public class Game {

    GameLevel currentLevel;
    private JFrame frame;

    /** A graphical display of the world (a specialised JPanel). */
    GameView view;

    private SoundClip gameMusic;

    WarriorController controller;

    Warrior warrior;





    /** Initialise a new Game. */
    public Game() {
        MainMenu menu = new MainMenu(this);

        try {
            gameMusic = new SoundClip("audio/Birds.wav");
            gameMusic.loop();
        }catch (UnsupportedAudioFileException|IOException|LineUnavailableException e) {
            System.out.println(e);
        }


        if(menu.IsPlayButtonPressed()){
            System.out.println("button pressed");
            startGame();
        }




    }


    public void startGame(){


        currentLevel = new Level1(this);




        //3. make a view to look into the game world
        view = new GameView(currentLevel, 800, 600, "data/forestbac.jpg");

        controller = new WarriorController(currentLevel.getWarrior());
        view.addKeyListener(controller);
        view.addMouseListener(new GiveFocus(view));

        //make the view continue - over out of scope
        currentLevel.addStepListener(new Tracker(view, currentLevel.getWarrior()));
        view.setCentre(currentLevel.getWarrior().getPosition());

        //optional: draw a 1-metre grid over the view
        // view.setGridResolution(1);



        //4. create a Java window (frame) and add the game
        //   view to it
        final JFrame frame = new JFrame("City Game");
        frame.add(view);
        // enable the frame to quit the application
        // when the x button is pressed
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationByPlatform(true);
        frame.setLocationRelativeTo(null);
        // don't let the frame be resized
        frame.setResizable(false);
        // size the frame to fit the world view
        frame.pack();
        // finally, make the frame visible
        frame.setVisible(true);


        //optional: uncomment this to make a debugging view
        JFrame debugView = new DebugViewer(currentLevel, 800, 600);
        // start our game world simulation!
        view.requestFocus();
        currentLevel.start();
    }





    public void isNextLevel(){
        LevelPanel nextLevel = new LevelPanel(this);
        if(nextLevel.IsButtonPressed()){
            goToNextLevel();
        }


    }




    public void goToNextLevel(){





        System.out.println("Yes, lets go to next level");

        if (currentLevel instanceof Level1) {

            currentLevel.stop();

            currentLevel = new Level2(this);
            Warrior newWarrior = currentLevel.getWarrior();
            JFrame debugView = new DebugViewer(currentLevel, 800, 600);

            currentLevel.addStepListener(new Tracker(view, currentLevel.getWarrior()));
            view.setCentre(currentLevel.getWarrior().getPosition());


            view.setWorld(currentLevel);
            controller.updateWarrior(currentLevel.getWarrior());
           
            view.setBackgroundImage("data/dessesrt.jpg");

            currentLevel.getWarrior().ResetAttributes();




            currentLevel.start();
        }
        else if (currentLevel instanceof  Level2){
            System.out.println("Game done");
            System.exit(0);
        }





    }






    /** Run the game. */
    public static void main(String[] args) {

        new Game();
    }





}
