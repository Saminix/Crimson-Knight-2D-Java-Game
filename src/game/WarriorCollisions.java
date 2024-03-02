package game;

import city.cs.engine.BodyImage;
import city.cs.engine.CollisionEvent;
import city.cs.engine.CollisionListener;


public class WarriorCollisions implements CollisionListener {
    private Warrior warrior;
    public WarriorCollisions(Warrior warrior){
        this.warrior = warrior;
    }

    @Override
    public void collide( CollisionEvent e) {
        if (e.getOtherBody() instanceof Trap){
            warrior.removeAllImages();
            warrior.addImage(new BodyImage("data/HoodedCharacter/WarriorHurt.gif", 7.5f));
            warrior.setHealth(warrior.getHealth() - 5);
        }else if (e.getOtherBody() instanceof Monster) {
            warrior.removeAllImages();
            warrior.addImage(new BodyImage("data/HoodedCharacter/WarriorHurt.gif", 7.5f));
            warrior.setHealth(warrior.getHealth() - 15);
        }



    }
}
