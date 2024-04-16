package game;
import city.cs.engine.BodyImage;
import city.cs.engine.CollisionEvent;
import city.cs.engine.CollisionListener;

/**
 * A class to handle collision events involving the warrior.
 */

public class WarriorCollisions implements CollisionListener {
    private Warrior warrior;
    private Game game;


    /**
     * Constructs a WarriorCollisions object.
     * @param warrior The warrior involved in the collisions.
     * @param game The game instance.
     */
    public WarriorCollisions(Warrior warrior, Game game) {
        this.warrior = warrior;
        this.game = game;

    }

    /**
     * Handles collision events.
     * @param e The collision event.
     */
    @Override
    public void collide(CollisionEvent e) {
        if (e.getOtherBody() instanceof Trap) {
            warrior.removeAllImages();
            warrior.addImage(new BodyImage("data/HoodedCharacter/WarriorHurt.gif", 6.9f));
            warrior.setHealth(warrior.getHealth() - 5);
        } else if (e.getOtherBody() instanceof Monster) {
            warrior.removeAllImages();
            warrior.addImage(new BodyImage("data/HoodedCharacter/WarriorHurt.gif", 6.9f));
            warrior.setHealth(warrior.getHealth() - 15);

        } else if (e.getOtherBody() instanceof Bat) {
            warrior.removeAllImages();
            warrior.addImage(new BodyImage("data/HoodedCharacter/WarriorHurt.gif", 6.9f));
            warrior.setHealth(warrior.getHealth() - 10);

        }else if (e.getOtherBody() instanceof Skeleton) {
            warrior.removeAllImages();
            warrior.addImage(new BodyImage("data/HoodedCharacter/WarriorHurt.gif", 6.9f));
            warrior.setHealth(warrior.getHealth() - 25);

        }else if (e.getOtherBody() instanceof PumpkinMan) {
            warrior.removeAllImages();
            warrior.addImage(new BodyImage("data/HoodedCharacter/WarriorHurt.gif", 6.9f));
            warrior.setHealth(warrior.getHealth() - 25);
        }else if (e.getOtherBody() instanceof Zombie) {
            warrior.removeAllImages();
            warrior.addImage(new BodyImage("data/HoodedCharacter/WarriorHurt.gif", 6.9f));
            warrior.setHealth(warrior.getHealth() -5);
        }

        if(warrior.getHealth() <= 0){
            game.currentLevel.stop();
            game.disposeCurrentLevelFrame();

            game.showGameOver();

        }

    }


}