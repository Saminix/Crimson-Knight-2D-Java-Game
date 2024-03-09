package game;
import city.cs.engine.*;
import org.jbox2d.common.Vec2;


public class GameWorld extends World  {

    private final Warrior warrior;

    public GameWorld(){
        super();


        // Create the warrior
        warrior = new Warrior(this);
        warrior.setPosition(new Vec2(-90, -10.5f)); // Set initial position of the warrior


        // Add collision listener for coin/treasure/points/potion pickups
        WarriorPickup pickup = new WarriorPickup(warrior);
        warrior.addCollisionListener(pickup);
        WarriorCollisions trap = new WarriorCollisions(warrior);
        warrior.addCollisionListener(trap);

        Vec2 monsterPosition = new Vec2(-15, -18.5f);
        Monster monster = new Monster(this, monsterPosition,50,15,this);

        Vec2 monsterPosition1 = new Vec2(65, -18.5f);
        Monster monster1 = new Monster(this, monsterPosition1,50,15,this);


        Vec2 batPosition = new Vec2(50, 2f);
        Bat bat = new Bat(this,batPosition,30,12,this);


        float boxX = -165;
        float boxY = -18.5f;

        int BoxS = 4;
        for(int i = 0; i < BoxS; i++){
            BoxCrate box = new BoxCrate(this);
            box.setPosition(new Vec2(boxX, boxY));
            boxX+=37;

        }

        BoxCrate box1 = new BoxCrate(this);
        box1.setPosition(new Vec2(-124.1f, -18.5f));
        BoxCrate box2 = new BoxCrate(this);
        box2.setPosition(new Vec2(-124.1f, -14.5f));

        BoxCrate box3 = new BoxCrate(this);
        box3.setPosition(new Vec2(-124.1f, -14.5f));

        float box2X = -83;
        float box2Y = -18.5f;


        int BoxxS = 3;
        for(int i = 0; i < BoxxS; i++){
            BoxCrate box4 = new BoxCrate(this);
            box4.setPosition(new Vec2(box2X, box2Y));
            box2Y+=4.5;

        }
        BoxCrate box5 = new BoxCrate(this);
        box5.setPosition(new Vec2(-87, -18.5f));
        BoxCrate box6 = new BoxCrate(this);
        box6.setPosition(new Vec2(-87, -14.5f));
        //make 3 layer box obstacle


        float startCoinX = -164;
        float startCoinY = -17.9f;

        int numCoins2 = 20;
        for(int i = 0; i < numCoins2; i++){
            Coins coins = new Coins(this,0.8f,startCoinX,startCoinY);
            startCoinX+=9;

        }


        float startTurtleX = -150;
        float startTurtleY = -19.5f;

        int numTurtle = 3;
        for(int i = 0; i < numTurtle; i++){
            Trap turtle = new Trap(this, "data/obstacle1.gif", 7);
            turtle.setPosition(new Vec2(startTurtleX, startTurtleY));
            startTurtleX+=45;

        }

        //create Platforms using for loop that extend for the duration of the game;

        float gstartX = -165;
        float gstartY = -22.9f;
        int numPlatforms = 8;
        for(int i = 0; i < numPlatforms; i++){
            GroundPlatform groundPlatform = new GroundPlatform(this,
                    28,2.2f,gstartX, gstartY, "data/grassfloor.png", 7 );
            groundPlatform.setPosition(new Vec2(gstartX, gstartY));
            gstartX+=56;

        }
        // Make a suspended platform
        GroundPlatform elevatedPlatform = new GroundPlatform(this,
                11.5f,1f,-13, -6f, "data/grassplatform.png", 6 );


        GroundPlatform elevatedPlatform1 = new GroundPlatform(this,
                12.5f,1f,23,-13.5f,  "data/grassplatform.png", 6 );

        GroundPlatform elevatedPlatform2 = new GroundPlatform(this,
                12.5f,1f,61,-13.5f,  "data/grassplatform.png", 6 );

        GroundPlatform elevatedPlatform3 = new GroundPlatform(this,
                12.5f,1f,51,-2,  "data/grassplatform.png", 6 );

        //create trampoline platform
        Vec2 trampolinePosition = new Vec2(31, -11);
        Trampoline trampoline = new Trampoline(this, trampolinePosition, 10,0.08f);

        Vec2 trampolinePosition1 = new Vec2(42, -17);
        Trampoline trampoline1 = new Trampoline(this, trampolinePosition1, 5,0.08f);

        Vec2 trampolinePosition2 = new Vec2(5, -17);
        Trampoline trampoline2 = new Trampoline(this, trampolinePosition2, 10,0.04f);


        //using for-loop to add 10 coins to the game world along intervals of x,
        // the value of x coordinate is incremented by x
        float startX = 135;
        float startY = -18;

        int numCoins = 10;
        for(int i = 0; i < numCoins; i++){
            Coins coins = new Coins(this,0.8f,startX,startY);
            startX+=8;

        }

        // Add coins
        new Coins(this,0.8f,-13.5f,-3f);
        new Coins(this,0.8f,-15.5f,-3f);
        new Coins(this,0.8f,61f,-10f);


        Treasure treasure1 = new Treasure(this, 2, 2,65f,-11f);


        Trap turtle = new Trap(this, "data/obstacle1.gif", 7);
        turtle.setPosition(new Vec2(-6, -3.4f));
        Trap beartrap = new Trap(this, "data/beartrap.gif",5);
        beartrap.setPosition(new Vec2(52, -10.9f));
        Potion potion = new Potion(this,1,1,90,-18);

    }

    public Warrior getWarrior(){
        return warrior;
    }



}