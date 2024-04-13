package game;

import city.cs.engine.*;
import org.jbox2d.common.Vec2;

public class Trampoline extends StaticBody implements StepListener, CollisionListener{


    private static final Shape trampolineShape = new BoxShape(2.5f,0.2F);
    private static final BodyImage image = new BodyImage("data/movingGrassPlatform.png", 4.5f);
    public Vec2 setPosition;
    private  Vec2 startPosition;
    private float bounceStrength;

    private GameLevel world;
    private float top, bottom;
    private float delta;

    //Controlling the speed of the trampoline by assigning a new value in parameter(speed)

    public Trampoline(World w, Vec2 position, float height, float speed, float bounceStrength){
        super(w, trampolineShape);
        this.addImage(image);
        startPosition = position;
        bottom = startPosition.y;
        top = startPosition.y+ height;
        this.bounceStrength = bounceStrength;
        delta=speed;
        setPosition(startPosition);
        w.addStepListener(this);


    }

    @Override
    public void preStep(StepEvent stepEvent){
        if (getPosition().y < bottom){
            this.setPosition(startPosition);
            delta*=-1;

        }
        if (getPosition().y > top){
            delta*=-1;
        }
        this.setPosition(new Vec2(this.getPosition().x, this.getPosition().y+delta));

    }
    @Override
    public void postStep(StepEvent stepEvent) {
    }

    @Override
    public void collide(CollisionEvent collisionEvent) {
        if (collisionEvent.getOtherBody() instanceof Warrior) {
            Warrior warrior = (Warrior) collisionEvent.getOtherBody();
            // Apply an impulse to the warrior to make it bounce
            warrior.applyImpulse(new Vec2(0, bounceStrength));
        }
    }

    public void setPosition(Vec2 position) {
        super.setPosition(position);
    }
}





