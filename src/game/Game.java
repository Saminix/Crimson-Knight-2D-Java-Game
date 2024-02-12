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


    /** Initialise a new Game. */
    public Game() {

        //1. make an empty game world
        World world = new World();

        //2. populate it with bodies (ex: platforms, collectibles, characters)

        //make a character (with an overlaid image)
        Shape warriorShape = new BoxShape(2,4);
        DynamicBody warrior = new DynamicBody(world, warriorShape);
        warrior.setPosition(new Vec2(6,-12.5f));
        warrior.addImage(new BodyImage("data/warrior.gif", 9.5f));

        //make a ground platform
        Shape shape = new BoxShape(30, 0.9f);
        //measure width and height for the block
        StaticBody ground = new StaticBody(world, shape);
        ground.setPosition(new Vec2(5f, -12.5f));
        ground.addImage(new BodyImage("data/grassfloor.png", 5));
        //y(-5.5f) = y coordinate
        //x(0f) = x coordinate

        // make a suspended platform
        Shape platformShape1 = new BoxShape(3, 0.5f);
        //create another block( in the air) and measure out length and height
        StaticBody platform1 = new StaticBody(world, platformShape1);
        // call this static block platform 1 and populate into world
        platform1.setPosition(new Vec2(-9, -6f));
        platform1.addImage(new BodyImage("data/grassplatform.png", 5));
        //initialise the coordinates of the block - note this is the centre of coordinates

        Shape platformShape2 = new BoxShape(3, 0.5f);
        StaticBody platform2 = new StaticBody(world, platformShape2);
        platform2.setPosition(new Vec2(3,5));
        platform2.addImage(new BodyImage("data/grassplatform.png", 6));


       








        //3. make a view to look into the game world
        UserView view = new UserView(world, 600, 500);


        //optional: draw a 1-metre grid over the view
         view.setGridResolution(1);


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
         JFrame debugView = new DebugViewer(world, 500, 500);

        // start our game world simulation!
        world.start();
    }

    /** Run the game. */
    public static void main(String[] args) {

        new Game();
    }
}
