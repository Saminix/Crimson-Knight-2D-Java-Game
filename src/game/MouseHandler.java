package game;
import city.cs.engine.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import city.cs.engine.Shape;
import org.jbox2d.common.Vec2;
import java.awt.Point;


public class MouseHandler implements MouseListener {
    private GameWorld world;
    private GameView view;
    private Warrior warrior;

    public MouseHandler( GameWorld w, GameView v){
        world = w;
        view = v;

    }
    @Override
    public void mousePressed(MouseEvent e) {
        Point mousePoint = e.getPoint();


       // warrior.removeAllImages();
        //warrior.addImage(new BodyImage("data/MonsterFight.gif", 9.5f));
        //ec2 worldPoint = view.viewToWorld(mousePoint);
        //warrior.setPosition(worldPoint);

        //Shape circleShape = new CircleShape(2f);
        //DynamicBody ball = new DynamicBody(world, circleShape);
        //Point mousePoint = e.getPoint();
        //Vec2 worldPoint = view.viewToWorld(mousePoint);
        //ball.setPosition(worldPoint);
    }
    @Override
    public void mouseClicked(MouseEvent e) {
    }
    @Override
    public void mouseReleased(MouseEvent e) {
    }
    @Override
    public void mouseEntered(MouseEvent e) {
    }
    @Override
    public void mouseExited(MouseEvent e) {
    }
}