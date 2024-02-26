package game;
import city.cs.engine.*;
import org.jbox2d.common.Vec2;
public class GameWorld extends World {

    private Warrior warrior;
    public GameWorld(){
        super();
        warrior = new Warrior(this);
        //warrior.setAlwaysOutline(true);
        warrior.setPosition(new Vec2(7, -9));
        CoinPickup pickup = new CoinPickup(warrior);
        warrior.addCollisionListener(pickup);
        Monster Monster = new Monster(this);
        Monster.setPosition(new Vec2(3, 9));


        new Coins(this).setPosition(new Vec2(-9.5f,-4f));
        new Coins(this).setPosition(new Vec2(-11.5f,-4f));
        new Coins(this).setPosition(new Vec2(8,7));
        new Coins(this).setPosition(new Vec2(10,7));



        //make a ground platform
        Shape shape = new BoxShape(30, 0.9f);
        StaticBody ground = new StaticBody(this, shape);
        ground.setPosition(new Vec2(5f, -12.5f));
        ground.addImage(new BodyImage("data/grassfloor.png", 5));




        // make a suspended platform
        Shape platformShape1 = new BoxShape(3, 0.5f);
        StaticBody platform1 = new StaticBody(this, platformShape1);
        platform1.setPosition(new Vec2(-9, -6f));
        platform1.addImage(new BodyImage("data/grassplatform.png", 5));


        Shape platformShape2 = new BoxShape(3, 0.5f);
        StaticBody platform2 = new StaticBody(this, platformShape2);
        platform2.setPosition(new Vec2(3,5));
        platform2.addImage(new BodyImage("data/grassplatform.png", 6));




    }

    public Warrior getWarrior(){
        return warrior;
    }


}
