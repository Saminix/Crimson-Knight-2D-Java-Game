package game;

import city.cs.engine.BodyImage;
import city.cs.engine.CollisionEvent;
import city.cs.engine.CollisionListener;



public class WarriorCollisions implements CollisionListener {
    private Warrior warrior;

    public WarriorCollisions(Warrior warrior) {
        this.warrior = warrior;

    }
    @Override
    public void collide(CollisionEvent e) {
        if (e.getOtherBody() instanceof Trap) {
            warrior.removeAllImages();
            warrior.addImage(new BodyImage("data/HoodedCharacter/WarriorHurt.gif", 6.9f));
            warrior.setHealth(warrior.getHealth() - 5);
        } else if (e.getOtherBody() instanceof Monster) {
            warrior.setHealth(warrior.getHealth() - 5);
            Monster monster = (Monster) e.getOtherBody();
            monster.decrementHealth(13);
            warrior.attack(monster);

        } else if (e.getOtherBody() instanceof Bat) {

            warrior.setHealth(warrior.getHealth() - 10);
            Bat bat = (Bat) e.getOtherBody();
            bat.decrementHealth(14);
            warrior.attack(bat);

        }

    }
}