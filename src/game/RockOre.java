package game;


import city.cs.engine.*;

public class RockOre extends Rock {

    private static final String image = "data/rockore.png";

    public RockOre(World world, float boxSizeWidth, float x, float y, float height) {
        super(world, boxSizeWidth, x, y, height);
        addImage(new BodyImage(image, height));

    }

    @Override
    public void TakenHit() {
        super.TakenHit();
        if (getHealth() <= 0) {
            Treasure gem = new Treasure(this.getWorld(), 2, 3, getPosition().x, getPosition().y, 5);
            gem.setPosition(getPosition());
        }
        }
    }


