package game;

import city.cs.engine.BodyImage;
import city.cs.engine.CollisionEvent;
import city.cs.engine.CollisionListener;



public class WarriorCollisions implements CollisionListener {
    private Warrior warrior;
    private Game game;

    public WarriorCollisions(Warrior warrior, Game game) {
        this.warrior = warrior;
        this.game = game;

    }
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
            //warrior.attack(monster);
        } else if (e.getOtherBody() instanceof Bat) {
            warrior.removeAllImages();
            warrior.addImage(new BodyImage("data/HoodedCharacter/WarriorHurt.gif", 6.9f));
            warrior.setHealth(warrior.getHealth() - 10);
            //warrior.attack(bat);
        }else if (e.getOtherBody() instanceof Skeleton) {
            warrior.removeAllImages();
            warrior.addImage(new BodyImage("data/HoodedCharacter/WarriorHurt.gif", 6.9f));
            warrior.setHealth(warrior.getHealth() - 25);
            //warrior.attack(bat);
        }

        if(warrior.getHealth() <= 0){
            game.currentLevel.stop();
            game.disposeCurrentLevelFrame();

            game.showGameOver();

        }

    }


}