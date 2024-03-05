package game;
import city.cs.engine.UserView;
import city.cs.engine.World;

import javax.swing.*;
import java.awt.*;


public class GameView extends UserView {
    private Image background;

    private Game game;
    private Image coinsimage;
    private Image pointimage;
    private Warrior warrior;

    private Boolean gameOver;



    public GameView(GameWorld world, int width, int height) {
        super(world, width, height);
        background = new ImageIcon("data/forestbac.jpg").getImage();
        this.warrior = world.getWarrior();
        this.game = game;

        gameOver = false;



    }






    @Override
    protected void paintForeground(Graphics2D g) {
        super.paintForeground(g);
        drawHealthBar(g);
        drawCoinCount(g);
        drawScoreCount(g);




    }







//creating statistic
    private void drawHealthBar(Graphics2D g){
        int Health = warrior.getHealth();
        int maxHealth = 100;
        int healthBarWidth = 190;
        int healthBarHeight = 20;
        int x = 20;
        int y = 50;

        g.setColor(Color.GRAY);
        g.fillRect(x,y,healthBarWidth,healthBarHeight);


        int BarWidth = (int) ((double) Health / maxHealth * healthBarWidth);
        g.setColor(Color.GREEN);
        g.fillRect(x,y, BarWidth,healthBarHeight);


        g.setColor(Color.BLACK);
        g.drawRect(x ,y, healthBarWidth, healthBarHeight);

    }








    //creating a coin count and symbol
    private void drawCoinCount(Graphics2D g){
        int CoinCount = warrior.getCoins();
        coinsimage = new ImageIcon("data/Coin.gif").getImage();

        int coinWidth = coinsimage.getWidth(this) / 5; // You can adjust the divisor for desired size
        int coinHeight = coinsimage.getHeight(this) / 5;

        String coinsText = "" + CoinCount;
        g.setColor(Color.darkGray);
        g.drawImage(coinsimage, -9, 40, coinWidth, coinHeight, this);
        g.drawString(coinsText, 80, 100);




    }

    //creating a score count and symbol

    private void drawScoreCount(Graphics2D g){
        int ScoreCount = warrior.getScore();
        pointimage = new ImageIcon("data/PointOrb.gif").getImage();
        int pointWidth = pointimage.getWidth(this) / 4; // You can adjust the divisor for desired size
        int pointHeight = pointimage.getHeight(this) / 4;
        String pointText =  "" + ScoreCount;
        g.setColor(Color.darkGray);
        g.drawImage(pointimage, 10, 110, pointWidth, pointHeight, this);
        g.drawString(pointText, 80, 140);


    }

    @Override
    protected void paintBackground(Graphics2D g) {
        g.drawImage(background, 0, 0, getWidth(), getHeight(), this);
    }







}


