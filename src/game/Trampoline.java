package game;

import city.cs.engine.*;
import org.jbox2d.common.Vec2;

/**
 * A class representing a Trampoline in the game.
 * Trampolines can either move vertically or horizontally based on their width.
 */

public class Trampoline extends StaticBody implements StepListener, CollisionListener {

    private static Shape trampolineShape;
    private static BodyImage image;
    private Vec2 startPosition;

    private float width;

    private float left, right;
    private float delta;
    private float top, bottom;


    /**
     * Constructs a Trampoline object.
     *
     *
     * @param w The world in which the trampoline exists.
     * @param position The initial position of the trampoline.
     * @param height The height of the trampoline.
     * @param speed The speed at which the trampoline moves.
     * @param path The file path to the image of the trampoline.
     * @param x The width of the trampoline's box shape.
     * @param y The height of the trampoline's box shape.
     * @param size The size of the trampoline image.
     * @param width The width of the trampoline.
     */

    public Trampoline(World w, Vec2 position, float height, float speed, String path, float x, float y, float size, float width) {
        super(w, new BoxShape(x, y));
        image = new BodyImage(path, size);
        this.addImage(image);
        startPosition = position;
        bottom = startPosition.y;
        top = startPosition.y + height;
        delta = speed;
        setPosition(startPosition);
        left = startPosition.x - width;
        this.width = width;
        right = startPosition.x + width;
        w.addStepListener(this);
    }

    /**
     * Method called for each step event
     * @param stepEvent the step event.
     */
    @Override
    public void preStep(StepEvent stepEvent) {
        if(this.width == 0){
            if (getPosition().y < bottom) {
                this.setPosition(startPosition);
                delta *= -1;
            }
            if (getPosition().y > top) {
                delta *= -1;
            }
            this.setPosition(new Vec2(this.getPosition().x, this.getPosition().y + delta));
        }
       else{
           GoSideways();
        }
    }


    /**
     * Moves the trampoline horizontally.
     */

    public void GoSideways(){
        float currentX = getPosition().x;
        float newX = currentX + delta;

        // Check if the new x-coordinate exceeds the left or right boundaries
        if (newX < left || newX > right) {
            // If so, reverse the direction and update the new x-coordinate
            delta *= -1;
            newX = currentX + delta;
        }

        // Update the position with the new x-coordinate and the same y-coordinate
        this.setPosition(new Vec2(newX, getPosition().y));

    }


    @Override
    public void postStep(StepEvent stepEvent) {
        // Perform post-step actions if needed
    }

    @Override
    public void collide(CollisionEvent collisionEvent) {
        // Handle collisions if needed
    }

    public void setPosition(Vec2 position) {
        super.setPosition(position);
    }
}




