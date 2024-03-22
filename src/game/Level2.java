package game;

import city.cs.engine.BoxShape;
import city.cs.engine.Shape;
import city.cs.engine.StaticBody;
import org.jbox2d.common.Vec2;

public class Level2 extends GameLevel{
    public Level2(Game game){
        super(game);

        // make a platform
        Shape shape = new BoxShape(3, 0.5f);
        StaticBody platform = new StaticBody(this, shape);
        platform.setPosition(new Vec2(-52f, 12));

        // make another platform
        StaticBody platform2 = new StaticBody(this, shape);
        platform2.setPosition(new Vec2(-10f, 2));

    }

    @Override
    public boolean isComplete() {
        return getWarrior().getCoins()> 100;
    }
}

