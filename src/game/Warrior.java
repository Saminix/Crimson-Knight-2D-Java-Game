package game;
import city.cs.engine.*;
import city.cs.engine.Shape;
import org.jbox2d.common.Vec2;








public class Warrior extends Walker {
    private static final Shape warriorShape = new PolygonShape(-1.12f,-2.55f, 0.76f,-2.57f, 1.52f,-0.28f, 1.35f,1.93f, -0.9f,2.33f, -1.47f,0.14f, -1.22f,-2.28f);
    private static final BodyImage image = new BodyImage("data/HoodedCharacter/HWarriorStop.gif", 6.4f);

    private int coins;

    private WarriorController warriorController;

    private int special;

    private int score;
    private int key;



    //private GameView view;

    private int health;




    public Warrior(World world){
        super(world, warriorShape);
        this.addImage(image);
        setGravityScale(2);


        //this.view = view;

        this.coins = 0;
        this.score = 0;
        this.health = 100;
        this.special = 1;
        this.key = 0;




    }

    public void setCoins(int coins){
        this.coins = coins;
    }


    public void setWarriorController(WarriorController warriorController) {
        this.warriorController = warriorController;
    }


    public void setSpecial(int special) {
        this.special = special;
        if (getSpecial() > 100){

        }

    }

    public int getSpecial() {
        return special;
    }

    public int getCoins() {
        return coins;
    }


    public void setHealth( int health){
        this.health = health;
        if ( this.health <= 0){
            this.destroy();


        }

    }

    public int getHealth() {
        return health;
    }




    public void setScore(int score){ this.score = score;}



    public void ResetAttributes(){
        this.coins =0;
        this.score = 0;
        this.health = 100;

    }


    public void setKey(int key) {
        this.key = key;
    }


    public int getKey() {
        return key;
    }

    public int getScore() {
        return score;
    }


    public boolean isFacingRight(){
        return warriorController.isFacingRight();
    }




}








