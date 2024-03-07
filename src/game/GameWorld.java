package game;
import city.cs.engine.*;
import org.jbox2d.common.Vec2;

import java.util.ArrayList;





public class GameWorld extends World {

    private final Warrior warrior;



    public GameWorld(){
        super();

        //this.pointOrb = new Point(this);
        // Create the warrior
        warrior = new Warrior(this);
        warrior.setPosition(new Vec2(50, -9)); // Set initial position of the warrior

        // Add collision listener for coin/treasure/points/potion pickups
        WarriorPickup pickup = new WarriorPickup(warrior);
        warrior.addCollisionListener(pickup);
        WarriorCollisions trap = new WarriorCollisions(warrior);
        warrior.addCollisionListener(trap);


        //Monster monster = new Monster(this,30,12,this); monster.setPosition(new Vec2(-5, -9f));


        Vec2 batPosition = new Vec2(50, 2f);
        Bat bat = new Bat(this,batPosition,30,12,this);

        //Bat bat = new Bat(this,40,12,this);
        //bat.setPosition(new Vec2(40, 2f));


        float boxX = -165;
        float boxY = -18.7f;

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
            Coins coins = new Coins(this,1.3f,startcoinX,startcoinY);
            //coins.setPosition(new Vec2(startcoinX, startcoinY));
            startcoinX+=6;

        }


        float startTurtleX = -150;
        float startTurtleY = -19.8f;

        int numTurtle = 4;
        for(int i = 0; i < numTurtle; i++){
            Trap turtle = new Trap(this, "data/obstacle1.gif", 7);
            turtle.setPosition(new Vec2(startTurtleX, startTurtleY));
            startTurtleX+=35;

        }

        //create Platforms using for loop that extend for the duration of the game;

        float gstartX = -165;
        float gstartY = -22.9f;
        int numPlatforms = 8;
        for(int i = 0; i < numPlatforms; i++){
            GroundPlatform groundPlatform = new GroundPlatform(this,
                    28,2f,gstartX, gstartY, "data/grassfloor.png", 7 );
            groundPlatform.setPosition(new Vec2(gstartX, gstartY));
            gstartX+=56;

        }

        // Make a suspended platform
        GroundPlatform elevatedPlatform = new GroundPlatform(this,
                11.5f,1f,-9, -6f, "data/grassplatform.png", 6 );


        GroundPlatform elevatedPlatform1 = new GroundPlatform(this,
                12.5f,1f,23,-13.5f,  "data/grassplatform.png", 6 );

        GroundPlatform elevatedPlatform2 = new GroundPlatform(this,
                12.5f,1f,61,-13.5f,  "data/grassplatform.png", 6 );

        GroundPlatform elevatedPlatform3 = new GroundPlatform(this,
                12.5f,1f,51,-2,  "data/grassplatform.png", 6 );

        //create trampoline platform
        Vec2 trampolinePosition = new Vec2(31, -11);
        Trampoline trampoline = new Trampoline(this, trampolinePosition, 10);

        Vec2 trampolinePosition1 = new Vec2(42, -17);
        Trampoline trampoline1 = new Trampoline(this, trampolinePosition1, 5);


        //using for-loop to add 10 coins to the game world along intervals of x,
        // the value of x coordinate is incremented by x
        float startX = 135;
        float startY = -18;

        int numCoins = 10;
        for(int i = 0; i < numCoins; i++){
            Coins coins = new Coins(this,1.3f,startX,startY);
            startX+=8;

        }


        // Add coins


        new Coins(this,1.3f,-13.5f,-3f);
        new Coins(this,1.3f,-15.5f,-3f);
        new Coins(this,1.3f,-59f,-10f);
        new Coins(this,1.3f,61f,-10f);


       ;


        Treasure treasure1 = new Treasure(this, 2, 2,65f,-11f);


        Trap turtle = new Trap(this, "data/obstacle1.gif", 7);
        turtle.setPosition(new Vec2(-6, -3.4f));
        Trap beartrap = new Trap(this, "data/beartrap.gif",5);
        beartrap.setPosition(new Vec2(52, -10.9f));

    }



    public Warrior getWarrior(){
        return warrior;
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