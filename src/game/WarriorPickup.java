package game;

import city.cs.engine.CollisionListener;
import city.cs.engine.CollisionEvent;

public class WarriorPickup implements CollisionListener {
    private Warrior warrior;

    private Treasure treasure;

    public WarriorPickup(Warrior warrior, Treasure treasure) {
        this.warrior = warrior;
        this.treasure = treasure;
    }

    @Override
    public void collide(CollisionEvent e) {
        if (e.getOtherBody() instanceof Coins) {
            warrior.setCoins(warrior.getCoins() + 1);
            e.getOtherBody().destroy();
        } else if (e.getOtherBody() instanceof Point) {
            warrior.setScore(warrior.getScore() + 10);
            e.getOtherBody().destroy();
        } else if (e.getOtherBody() instanceof Treasure){
            int collectedTreasure = ((Treasure) e.getOtherBody()).CollectTreasure();
            warrior.setCoins(warrior.getCoins() + collectedTreasure);
            e.getOtherBody().destroy();
        }
    }
}