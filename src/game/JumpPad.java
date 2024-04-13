package game;

import city.cs.engine.*;
import org.jbox2d.common.Vec2;

public class JumpPad extends Trampoline{

    private static final Shape padShape = new BoxShape(2.5f,0.2F);
    private static final BodyImage image = new BodyImage("data/jumpPad.gif", 4.5f);

    private static final int boostSpeed = 15;


    public JumpPad(World w, Vec2 position, float height, float speed, float bounceStrength) {
        super(w, position, height, speed, bounceStrength);
        this.removeAllImages();
        this.addImage(image);

    }

    @Override
    public void collide(CollisionEvent collisionEvent) {
        if (collisionEvent.getOtherBody() instanceof Warrior) {
            Warrior warrior = (Warrior) collisionEvent.getOtherBody();
            warrior.jumpForce(boostSpeed);
        }
    }




    @Override
    public void preStep(StepEvent stepEvent){

    }
    @Override
    public void postStep(StepEvent stepEvent) {
    }

    public void setPosition(Vec2 position) {
        super.setPosition(position);
    }


}

