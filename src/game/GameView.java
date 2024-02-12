package game;
import city.cs.engine.UserView;
import city.cs.engine.World;

import javax.swing.*;
import java.awt.*;


public class GameView extends UserView {
    private Image background;
    @Override
    protected void paintBackground(Graphics2D g) {
        g.drawImage(background, 0, 0,getWidth(),getHeight(),this);
    }


    public GameView(GameWorld world, int width, int height) {
        super(world, width, height);
        background = new ImageIcon("data/forestbac.jpg").getImage();



    }



}


