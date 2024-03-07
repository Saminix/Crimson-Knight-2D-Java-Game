package game;
import city.cs.engine.*;
import org.jbox2d.common.Vec2;

import javax.swing.*;
import java.util.ArrayList;

import java.util.Random;



public class GameWorld extends World {

    private final Warrior warrior;
    private Treasure treasure;
    private Monster monster;

    private Trampoline trampoline;

    private ArrayList<Bat> bats = new ArrayList<>();

    private  Bat bat;


    public GameWorld(){
        super();

        //this.pointOrb = new Point(this);
        // Create the warrior
        warrior = new Warrior(this);
        warrior.setPosition(new Vec2(56, -9)); // Set initial position of the warrior

        // Add collision listener for coin/treasure/points/potion pickups
        WarriorPickup pickup = new WarriorPickup(warrior, treasure);
        warrior.addCollisionListener(pickup);

        WarriorCollisions trap = new WarriorCollisions(warrior);
        warrior.addCollisionListener(trap);


        Monster monster = new Monster(this,30,12,this);
        monster.setPosition(new Vec2(-5, -9f));




        Vec2 batPosition = new Vec2(50, 2f);
        bat = new Bat(this,batPosition,30,12,this);

        //Bat bat = new Bat(this,40,12,this);
        //bat.setPosition(new Vec2(40, 2f));




        float boxX = -165;
        float boxY = -19;

        int Boxs = 4;
        for(int i = 0; i < Boxs; i++){
            BoxCrate box = new BoxCrate(this);
            box.setPosition(new Vec2(boxX, boxY));
            boxX+=37;

        }

        float startcoinX = -164;
        float startcoinY = -18;

        int numCoins2 = 22;
        for(int i = 0; i < numCoins2; i++){
            Coins coins = new Coins(this);
            coins.setPosition(new Vec2(startcoinX, startcoinY));
            startcoinX+=6;

        }


        float startTurtleX = -150;
        float startTurtleY = -20;

        int numTurtle = 4;
        for(int i = 0; i < numTurtle; i++){
            Trap turtle = new Trap(this, "data/obstacle1.gif", 7);
            turtle.setPosition(new Vec2(startTurtleX, startTurtleY));
            startTurtleX+=35;

        }



        float gstartX = -165;
        float gstartY = -23.5f;



        int numPlatforms = 4;
        for(int i = 0; i < numPlatforms; i++){
            Shape groundShape = new BoxShape(28, 2f); // Set the shape of the ground
            StaticBody grounds = new StaticBody(this, groundShape);
            grounds.addImage(new BodyImage("data/grassfloor.png", 7));
            grounds.setPosition(new Vec2(gstartX, gstartY));
            gstartX+=56;

        }




        float waterX = 42;
        float waterY = -19.5f;

        int waterp = 2;
        for(int i = 0; i < waterp; i++){
            Shape waterShape = new BoxShape(20, 1f); // Set the shape of the ground
            StaticBody waterGround = new StaticBody(this, waterShape);
            waterGround.addImage(new BodyImage("data/wavesg.gif", 20));
            waterGround.setPosition(new Vec2(waterX, waterY));
            waterX+=37.89f;

        }



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


        float g2startX = 130f;
        float g2startY = -23.5f;
        //make second grass floor loop


        int num2Platforms = 2;
        for(int i = 0; i < num2Platforms; i++){
            Shape groundShape = new BoxShape(28, 2f); // Set the shape of the ground
            StaticBody grounds = new StaticBody(this, groundShape);
            grounds.addImage(new BodyImage("data/grassfloor.png", 7));
            grounds.setPosition(new Vec2(g2startX, g2startY));
            g2startX+=56;

        }

        //new Trampoline(this).setPosition(new Vec2(100,-103));
        //Trampoline trampoline = new Trampoline(this);
        //trampoline.setPosition(new Vec2(50,-41));
        Vec2 trampolinePosition = new Vec2(31, -11);
        trampoline = new Trampoline(this, trampolinePosition);




        //Vec2 batPosition2 = new Vec2(70, -3f); // Example position for bat2
        //Bat bat2 = new Bat(this, batPosition2, 12, 12, this);
        //bats.add(bat2);



        //using forloop to add 10 coins to the game world along intervals of x,
        // the value of x coordinate is incremented by x
        float startX = 135;
        float startY = -18;

        int numCoins = 10;
        for(int i = 0; i < numCoins; i++){
            Coins coins = new Coins(this);
            coins.setPosition(new Vec2(startX, startY));
            startX+=8;

        }




        // Add coins
        new Coins(this).setPosition(new Vec2(-13.5f,-3f));
        new Coins(this).setPosition(new Vec2(-15.5f,-3f));

        new Coins(this).setPosition(new Vec2(50f,-10f));
        new Coins(this).setPosition(new Vec2(49f,-10f));
        new Coins(this).setPosition(new Vec2(59f,-10f));
        new Coins(this).setPosition(new Vec2(61f,-10f));

        new Treasure(this).setPosition(new Vec2(50f,-10));



        Trap turtle = new Trap(this, "data/obstacle1.gif", 7);
        turtle.setPosition(new Vec2(-6, -3.4f));
        Trap beartrap = new Trap(this, "data/beartrap.gif",5);
        beartrap.setPosition(new Vec2(45, -10.9f));

    }



    public Warrior getWarrior(){
        return warrior;
    }

    public Treasure getTreasure(){
        return treasure;
    }

    public Monster getMonster() {
        return monster;
    }


    public  Vec2 TrampolineGetPosition(){
        return trampoline.setPosition;
    }

    public  Vec2 BatGetPosition(){
        return bat.setPosition;
    }




    public Bat getBat() {
        return bat;
    }




    public ArrayList<Monster> getMonsters() {
        ArrayList<Monster> monsterList = new ArrayList<>();
        for (Object body : this.getDynamicBodies()) {
            if (body instanceof Monster) {
                monsterList.add((Monster) body);
            }
        }
        return monsterList;
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