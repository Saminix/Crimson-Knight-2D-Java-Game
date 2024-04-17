package game;


import city.cs.engine.*;

/**
 * This class represents the RockOre collectible entity in the game.
 * It is a subclass of Rock.
 * Its Destroy can be OverRidden to spawn Treasure.
 */

public class RockOre extends Rock {

    private static final String image = "data/rockore.png";


    /**
     * Constructs a RockOre object.
     *
     * @param world The world in which the RockOre exists.
     * @param boxSizeWidth the width of the RockOre.
     * @param x The x-coordinate of the RockOre's initial position.
     * @param y The y-coordinate of the RockOre's initial position.
     * @param height The Size or Height of the RockOre.
     */
    public RockOre(World world, float boxSizeWidth, float x, float y, float height) {
        super(world, boxSizeWidth, x, y, height);
        addImage(new BodyImage(image, height));

    }


    /**
     * Overrides Method in SuperClass.
     * Performs actions when the RockOre is hit.
     * If the RockOre's health is less than or Equal to 0,
     * The RockOre is Destroyed from World and Treasure - another collectible
     * Takes its initial Place.
     */

    @Override
    public void TakenHit() {
        super.TakenHit();
        if (getHealth() <= 0) {
            Treasure gem = new Treasure(this.getWorld(), 2, 3, getPosition().x, getPosition().y, 5);
            gem.setPosition(getPosition());
        }
        }
    }


