package game;

import city.cs.engine.*;
import city.cs.engine.Shape;
import org.jbox2d.common.Vec2;

import javax.swing.JFrame;

import java.awt.*;
import java.io.IOException;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

/**
 * Your main game entry point
 */
public class Game {

    private GameWorld world;

    /** A graphical display of the world (a specialised JPanel). */
    private GameView view;

    private SoundClip gameMusic;


    /** Initialise a new Game. */
    public Game() {

        // World world = new World();




        //Shape shape = new CircleShape(1.5f);
        //Body ball = new DynamicBody(world, shape);

        //3. make a view to look into the game world
        GameWorld world = new GameWorld();
        view = new GameView(world, 800, 700);
        WarriorController controller = new WarriorController(world.getWarrior());
        view.addKeyListener(controller);
        view.addKeyListener(controller);
        view.addMouseListener(new GiveFocus(view));
        //make the view continue - over out of scope
        world.addStepListener(new Tracker(view, world.getWarrior()));
        view.setCentre(world.getWarrior().getPosition());
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
        JFrame debugView = new DebugViewer(world, 850, 700);



        // start our game world simulation!
        world.start();
        view.requestFocus();

    }

    /** Run the game. */
    public static void main(String[] args) {

        new Game();
    }



}
