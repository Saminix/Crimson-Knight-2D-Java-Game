package game;
import city.cs.engine.*;
import org.jbox2d.common.Vec2;

import java.util.ArrayList;

public class GameWorld extends World {

    private final Warrior warrior;


    private Point pointOrb;

    public GameWorld(){
        super();
        // Create the warrior
        warrior = new Warrior(this);
        warrior.setPosition(new Vec2(7, -9)); // Set initial position of the warrior

        // Add collision listener for coin pickups
        WarriorPickup pickup = new WarriorPickup(warrior);
        warrior.addCollisionListener(pickup);

        WarriorCollisions trap = new WarriorCollisions(warrior);
        warrior.addCollisionListener(trap);

        // Create the ground
        Shape groundShape = new BoxShape(80, 2f); // Set the shape of the ground
        StaticBody ground = new StaticBody(this, groundShape);
        ground.setPosition(new Vec2(0f, -23.5f)); // Set position of the ground
        ground.addImage(new BodyImage("data/grassfloor.png", 7)); // Add image to the ground

        // Make a suspended platform
        Shape platformShape1 = new BoxShape(11.5f, 1f);
        StaticBody platform1 = new StaticBody(this, platformShape1);
        platform1.setPosition(new Vec2(-9, -6f));
        platform1.addImage(new BodyImage("data/grassplatform.png", 6));

        Shape platformShape2 = new BoxShape(11.5f, 1f);
        StaticBody platform2 = new StaticBody(this, platformShape2);
        platform2.setPosition(new Vec2(7.5f, 5.5f));
        platform2.addImage(new BodyImage("data/grassplatform.png", 6));

        Shape platformShape3 = new BoxShape(12.5f, 1f);
        StaticBody platform3 = new StaticBody(this, platformShape3);
        platform3.setPosition(new Vec2(23.5f, -13.5f));
        platform3.addImage(new BodyImage("data/grassplatform.png", 6f));

        // Add the monster
        Monster monster = new Monster(this,60,12);
        monster.setPosition(new Vec2(3, 8));

        // Add coins
        new Coins(this).setPosition(new Vec2(-13.5f,-3f));
        new Coins(this).setPosition(new Vec2(-15.5f,-3f));
        new Coins(this).setPosition(new Vec2(12,8));
        new Coins(this).setPosition(new Vec2(14,8));


        new Trap(this).setPosition(new Vec2(-6, -3.4f));
    }



    public Warrior getWarrior(){
        return warrior;
    }

    public void  addPoint(Point pointOrb){
        this.addPoint(pointOrb);
    }


    //make an arraylist of the amount of enemies populated in the world
    public static ArrayList<Enemy> getEnemies(){
        ArrayList<Enemy> enemyList = new ArrayList<>();
        World world = new World();
        for (Object body: world.getDynamicBodies()){
            if (body instanceof Enemy){
                enemyList.add((Enemy)body);
            }
        }
        return enemyList;


    }
}