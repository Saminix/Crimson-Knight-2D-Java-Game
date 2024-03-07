package game;

import city.cs.engine.CollisionListener;
import city.cs.engine.CollisionEvent;

public class WarriorPickup implements CollisionListener {
    private Warrior warrior;



    public WarriorPickup(Warrior warrior) {
        this.warrior = warrior;

    }

    @Override
    public void collide(CollisionEvent e) {
        if (e.getOtherBody() instanceof Coins) {
            int collectedCoin = ((Coins) e.getOtherBody()).collectItem(1);
            warrior.setCoins(warrior.getCoins() + collectedCoin);
            e.getOtherBody().destroy();
        } else if (e.getOtherBody() instanceof Point) {
            int collectedPoint = ((Point) e.getOtherBody()).collectItem(20);
            warrior.setScore(warrior.getScore() + collectedPoint);
            e.getOtherBody().destroy();
        } else if (e.getOtherBody() instanceof Treasure){
            int collectedTreasure = ((Treasure) e.getOtherBody()).collectItem(60);
            warrior.setCoins(warrior.getCoins() + collectedTreasure);
            e.getOtherBody().destroy();
        }
    }
}