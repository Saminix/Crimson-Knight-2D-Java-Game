package game;

import city.cs.engine.*;
import org.jbox2d.common.Vec2;


import javax.swing.*;



/**
 * Your main game entry point
 */
public class Game {

    GameLevel currentLevel;

    /** A graphical display of the world (a specialised JPanel). */
    GameView view;

    WarriorController controller;





    /** Initialise a new Game. */
    public Game() {

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

    public void goToNextLevel(){

        System.out.println("Yes, lets go to next level");

        if (currentLevel instanceof Level1) {

            currentLevel.stop();

            Warrior prevStudent = currentLevel.getWarrior();

            currentLevel = new Level2(this);

            Warrior newStudent = currentLevel.getWarrior();

            view.setWorld(currentLevel);
            view.setBackgroundImage("data/dessert.jpg");

            controller.updateWarrior(currentLevel.getWarrior());


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
