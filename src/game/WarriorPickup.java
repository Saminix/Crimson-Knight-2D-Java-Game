package game;

import city.cs.engine.CollisionListener;
import city.cs.engine.CollisionEvent;

public class WarriorPickup implements CollisionListener {
    private Warrior warrior;

    public WarriorPickup(Warrior warrior) { this.warrior = warrior; }

    @Override
    public void collide( CollisionEvent e){
        if( e.getOtherBody() instanceof Coins){
            warrior.setCoins(warrior.getCoins()+ 1);
            e.getOtherBody().destroy();
        }
    }
}
