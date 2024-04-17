package game;
import city.cs.engine.UserView;


import javax.swing.*;
import java.awt.*;

/**
 * A Class GameView Represents the Graphical and Visual display of the Game
 * Provides methods for rendering the game graphics.
 */

public class GameView extends UserView {
    private Image background;

    private Game game;
    private Image coinsimage;
    private Image pointimage;


    private Image keyimage;
    private Warrior warrior;

    private Boolean gameOver;

    /**
     * Constructs a GameView with the specified GameLevel, width, height, and background image path.
     *
     * @param level The GameLevel associated with this view.
     * @param width The width of the view.
     * @param height The height of the view.
     * @param path The path to the background image.
     */

    public GameView(GameLevel level, int width, int height, String path) {
        super(level, width, height);
        background = new ImageIcon(path).getImage();
        this.warrior = level.getWarrior();
        this.game = game;

        gameOver = false;

    }

    /**
     * Protected Method to Draw using Graphics2D
     *
     * @param g Graphics 2D to Draw
     */

    @Override
    protected void paintForeground(Graphics2D g) {
        super.paintForeground(g);
        drawHealthBar(g);
        drawCoinCount(g);
        drawScoreCount(g);
        drawKeyCount(g);
        drawSpecialPowerBar(g);

    }

    //creating stats

    /**
     * Method to draw a health Bar
     *
     * @param g Graphics 2D to Draw
     */
    private void drawHealthBar(Graphics2D g){
        int Health = warrior.getHealth();
        int maxHealth = 100;
        int healthBarWidth = 190;
        int healthBarHeight = 20;
        int x = 20;
        int y = 50;

        g.setColor(Color.gray);
        g.fillRect(x,y,healthBarWidth,healthBarHeight);

        int BarWidth = (int) ((double) Health / maxHealth * healthBarWidth);
        g.setColor(Color.GREEN);
        g.fillRect(x,y, BarWidth,healthBarHeight);

        g.setColor(Color.BLACK);
        g.drawRect(x ,y, healthBarWidth, healthBarHeight);

    }

    /**
     * Method to Draw Special Ability Charge Bar.
     *
     * @param g Graphics 2D to Draw
     */

    private void drawSpecialPowerBar(Graphics2D g){
        int Health = warrior.getSpecial();
        int maxPower = 3;
        int BarPowerWidth = 190;
        int BarPowerHeight = 10;
        int x = 20;
        int y = 25;

        g.setColor(Color.gray);
        g.fillRect(x,y,BarPowerWidth,BarPowerHeight);


        int BarWidth = (int) ((double) Health / maxPower * BarPowerWidth);
        g.setColor(Color.ORANGE);
        g.fillRect(x,y, BarWidth,BarPowerHeight);


        g.setColor(Color.BLACK);
        g.drawRect(x ,y, BarWidth, BarPowerHeight);

    }

    //creating a coin count and symbol
    /**
     * Method to draw Coins, small Gif Image on corner of screen and
     * the coin count by the side.
     *
     * @param g Graphics 2D to Draw
     */
    private void drawCoinCount(Graphics2D g){
        int CoinCount = warrior.getCoins();
        coinsimage = new ImageIcon("data/Coin.gif").getImage();

        int coinWidth = coinsimage.getWidth(this) / 5; // You can adjust the divisor for desired size
        int coinHeight = coinsimage.getHeight(this) / 5;

        String coinsText = "" + CoinCount;
        g.setColor(Color.black);
        g.drawImage(coinsimage, -9, 40, coinWidth, coinHeight, this);
        g.drawString(coinsText, 80, 100);

    }

    //creating a score count and symbol
    /**
     * Method to draw points, small Gif Image on corner of screen and
     * the score count by the side.
     *
     * @param g Graphics 2D to Draw
     */
    private void drawScoreCount(Graphics2D g){
        int ScoreCount = warrior.getScore();
        pointimage = new ImageIcon("data/PointOrb.gif").getImage();
        int pointWidth = pointimage.getWidth(this) / 4; // You can adjust the divisor for desired size
        int pointHeight = pointimage.getHeight(this) / 4;
        String pointText =  "" + ScoreCount;
        g.setColor(Color.black);
        g.drawImage(pointimage, 10, 110, pointWidth, pointHeight, this);
        g.drawString(pointText, 80, 140);
    }
    /**
     * Method to draw a Key, small Gif Image on corner of screen and
     * the key count by the side.
     *
     * @param g Graphics 2D to Draw
     */
    private void drawKeyCount(Graphics2D g){
        keyimage = new ImageIcon("data/key.gif").getImage();
        int Width = keyimage.getWidth(this) / 13; // You can adjust the divisor for desired size
        int Height = keyimage.getHeight(this) / 13;
        int keyCount = warrior.getKey();
        String keyText =  "" + keyCount;
        g.setColor(Color.black);
        g.drawImage(keyimage, 730, 10, Width, Height, this);
        g.drawString(keyText, 727, 30);

    }

    /**
     * Method to Paint The Background accordingly.
     * @param g Graphics 2D to Draw
     */
    @Override
    protected void paintBackground(Graphics2D g) {
        g.drawImage(background, 0, 0, getWidth(), getHeight(), this);
    }

    /**
     * Method to set the Background image from String Path in constructor
     * as the background.
     *
     * @param imagePath String Image Path of the background.
     */

    public void setBackgroundImage(String imagePath) {
        background = new ImageIcon(imagePath).getImage();
    }

    /**
     * Updates the warrior instance associated with view.
     * @param warrior The new warrior instance.
     */
    public void updateWarriorInstance(Warrior warrior) {
        this.warrior = warrior;
    }

}


