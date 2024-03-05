package game;
import city.cs.engine.*;
import org.jbox2d.common.Vec2;

import java.util.ArrayList;
import org.jbox2d.dynamics.BodyDef;
import org.jbox2d.dynamics.Body;


public class GameWorld extends World {

    private final Warrior warrior;
    private Monster monster;


    private Point pointOrb;

    public GameWorld(){
        super();

        //this.pointOrb = new Point(this);
        // Create the warrior
        warrior = new Warrior(this);
        warrior.setPosition(new Vec2(7, -9)); // Set initial position of the warrior

        // Add collision listener for coin pickups
        WarriorPickup pickup = new WarriorPickup(warrior);
        warrior.addCollisionListener(pickup);

        WarriorCollisions trap = new WarriorCollisions(warrior);
        warrior.addCollisionListener(trap);

        Monster monster = new Monster(this,80,12,this);
        monster.setPosition(new Vec2(2, -9f));
        monster.chaseWarrior(getWarrior());

        new BoxCrate(this).setPosition(new Vec2(-20,-18.5f));

        // Create the ground
        Shape groundShape = new BoxShape(28, 2f); // Set the shape of the ground
        StaticBody ground = new StaticBody(this, groundShape);
        ground.setPosition(new Vec2(0f, -23.5f)); // Set position of the ground
        ground.addImage(new BodyImage("data/grassfloor.png", 7)); // Add image to the ground

        //make water floor
        Shape waterShape = new BoxShape(25, 2f); // Set the shape of the ground
        StaticBody waterGround = new StaticBody(this, waterShape);
        waterGround.setPosition(new Vec2(51f, -23.5f)); // Set position of the ground
        waterGround.addImage(new BodyImage("data/WaterPlatform.gif", 7));

        Shape groundShape1 = new BoxShape(28, 2f); // Set the shape of the ground
        StaticBody ground1 = new StaticBody(this, groundShape1);
        ground1.setPosition(new Vec2(101f, -23.5f)); // Set position of the ground
        ground1.addImage(new BodyImage("data/grassfloor.png", 7));



        // Make a suspended platform
        Shape platformShape1 = new BoxShape(11.5f, 1f);
        StaticBody platform1 = new StaticBody(this, platformShape1);
        platform1.setPosition(new Vec2(-9, -6f));
        platform1.addImage(new BodyImage("data/grassplatform.png", 6));



        Shape platformShape3 = new BoxShape(12.5f, 1f);
        StaticBody platform3 = new StaticBody(this, platformShape3);
        platform3.setPosition(new Vec2(23.5f, -13.5f));
        platform3.addImage(new BodyImage("data/grassplatform.png", 6f));
        //make joint platform

        Shape platformShape4 = new BoxShape(12.5f, 1f);
        StaticBody platform4 = new StaticBody(this, platformShape4);
        platform4.setPosition(new Vec2(49f, -13.5f));
        platform4.addImage(new BodyImage("data/grassplatform.png", 6f));
        Shape platformShape5 = new BoxShape(12.5f, 1f);
        StaticBody platform5 = new StaticBody(this, platformShape5);
        platform5.setPosition(new Vec2(49f, -2f));
        platform5.addImage(new BodyImage("data/grassplatform.png", 6f));




        // Add coins
        new Coins(this).setPosition(new Vec2(-13.5f,-3f));
        new Coins(this).setPosition(new Vec2(-15.5f,-3f));



        Trap turtle = new Trap(this, "data/obstacle1.gif", 7);
        turtle.setPosition(new Vec2(-6, -3.4f));
        Trap beartrap = new Trap(this, "data/beartrap.gif",5);
        beartrap.setPosition(new Vec2(46, -10.9f));

    }



    public Warrior getWarrior(){
        return warrior;
    }

    public Monster getMonster() {
        return monster;
    }


    public void setMonsterChase() {

    }





    //make an arraylist of the amount of enemies populated in the world
    public ArrayList<Enemy> getEnemies(){
        ArrayList<Enemy> enemyList = new ArrayList<>();
        for (Object body: this.getDynamicBodies()){
            if (body instanceof Enemy){
                enemyList.add((Enemy)body);

            }
        }
        return enemyList;


    }
}