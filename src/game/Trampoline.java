package game;

import city.cs.engine.*;
import org.jbox2d.common.Vec2;

public class Trampoline extends StaticBody implements StepListener{


    private static final Shape trampolineShape = new BoxShape(2.5f,0.2F);
    private static final BodyImage image = new BodyImage("data/movingGrassPlatform.png", 4.5f);
    public Vec2 setPosition;
    private  Vec2 startPosition;

    private GameWorld world;
    private float top, bottom;
    private float delta;

    public Trampoline(World w, Vec2 position, float height){
        //height is the amount is travels up and down
        super(w, trampolineShape);
        this.addImage(image);
        startPosition = position;
        bottom = startPosition.y;
        top = startPosition.y+ height;
        delta=0.08f;
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

    public void setPosition(Vec2 position) {
        super.setPosition(position);
    }
}





