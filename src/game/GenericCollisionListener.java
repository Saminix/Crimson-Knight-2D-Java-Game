package game;

import city.cs.engine.CollisionListener;
import city.cs.engine.World;
import city.cs.engine.*;

public class GenericCollisionListener implements CollisionListener {
    private int counter = 0;

    @Override
    public void collide(CollisionEvent collisionEvent) {
        counter++;
        System.out.print("Collision " + counter + ":\n" +
                "  rep. body:" + collisionEvent.getReportingBody() + "\n" +
                "  oth. body:" + collisionEvent.getOtherBody() + "\n");
    }



}
