import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;

public class Frame extends JFrame implements Runnable, KeyListener
{
    public static final int UPS = 35;

    public int totalLives = 5;

    private BufferedImage buffer = null;
    private long updatesDone = 0;

    public boolean gameWon = false;
    public boolean levelWon = false;

    public int level = 1;

    public Game game = new Game();

    public Frame() {
        super();

        game.loadLevel(level);

        setSize(400, 400);

        buffer = new BufferedImage(getWidth(), getHeight(), BufferedImage.TYPE_4BYTE_ABGR);

        addKeyListener(this);
        setUndecorated(true);
        setResizable(false);
        setVisible(true);

        Thread t = new Thread(this);
        t.start();
    }

    public void paint(Graphics g) {
        //GRAY BACKGROUND
        Graphics bg = buffer.getGraphics();
        bg.setColor(Color.LIGHT_GRAY);
        bg.fillRect(0, 0, getWidth(), getHeight());

        //ALL UP DOWN RECTS
        for (int i = 0; i < game.upDownRects.size(); i++) {
            {
                //BASIC OBSTACLE 1
                bg.setColor(game.upDownRects.get(i).getColor());
                bg.fillRect((int) game.upDownRects.get(i).getRect().getX(), (int) game.upDownRects.get(i).getRect().getY(), (int) game.upDownRects.get(i).getRect().getWidth(), (int) game.upDownRects.get(i).getRect().getHeight());
            }
        }

        //FOR ALL LEFT RIGHT RECTS
        for (int i = 0; i < game.leftRightRects.size(); i++) {
            {
                //BASIC OBSTACLE 1
                bg.setColor(game.leftRightRects.get(i).getColor());
                bg.fillRect((int) game.leftRightRects.get(i).getRect().getX(), (int) game.leftRightRects.get(i).getRect().getY(), (int) game.leftRightRects.get(i).getRect().getWidth(), (int) game.leftRightRects.get(i).getRect().getHeight());
            }
        }

        //All WALLS
        for (int i = 0; i < game.walls.size(); i++) {
            bg.setColor(game.walls.get(i).getColor());
            bg.fillRect((int) game.walls.get(i).getRect().getX(), (int) game.walls.get(i).getRect().getY(), (int) game.walls.get(i).getRect().getWidth(), (int) game.walls.get(i).getRect().getHeight());
        }

        //ALL PATTERN RECTS
        for (int i = 0; i < game.patternRects.size(); i++) {
            bg.setColor(game.patternRects.get(i).getColor());
            bg.fillRect((int) game.patternRects.get(i).getRect().getX(), (int) game.patternRects.get(i).getRect().getY(), (int) game.patternRects.get(i).getRect().getWidth(), (int) game.patternRects.get(i).getRect().getHeight());
        }

        //LASERS
        for(int i=0; i < game.lasers.size(); i++)
        {
            bg.setColor(game.lasers.get(i).getColor());

            if(game.lasers.get(i).show)
            {
                bg.fillRect((int) game.lasers.get(i).getRect().getX(), (int) game.lasers.get(i).getRect().getY(), (int) game.lasers.get(i).getRect().getWidth(), (int) game.lasers.get(i).getRect().getHeight());
            }
            else
            {
            }
        }

        //GOAL
        bg.setColor(game.goal.getColor());
        bg.fillRect((int) game.goal.getRect().getX(), (int) game.goal.getRect().getY(), (int) game.goal.getRect().getWidth(), (int) game.goal.getRect().getHeight());

        //PLAYER
        bg.setColor(game.player.getColor());
        bg.fillRect((int) game.player.getRect().getX(), (int) game.player.getRect().getY(), (int) game.player.getRect().getWidth(), (int) game.player.getRect().getHeight());

        //IMPORTANT
        g.drawImage(buffer, 0, 0, null);
    }

    @Override
    public void run() {
        long startTime = System.nanoTime();

        double sleepTime = 1000.0/UPS;
        while(true)
        {
            boolean didUpDate = false;
            long updatesNeed = (long)(((System.nanoTime()-startTime)/1000000)/sleepTime);

            for(;updatesDone<updatesNeed; updatesDone++)
            {
                update();
                didUpDate = true;
            }

            if(didUpDate)
                repaint();

            try
            {
                Thread.sleep((int)sleepTime);
            }catch(Exception e)
            { }
        }
    }

    public void resetPlayer(int level)
    {
        if(level == 1) {

            game.player.setX(5);
            game.player.setY(370);
        }
        if(level == 2)
        {
            //System.out.println("aa");
            game.player.setX(10);
            game.player.setY(30);
        }
        if(level == 3)
        {
            game.player.setX(10);
            game.player.setY(30);
        }
    }

    public void update() {
        double oldX = game.player.getX();
        double oldY = game.player.getY();

        game.player.update();

        //if the player intersects the wall set him to his old coordinates
        for (int i = 0; i < game.walls.size(); i++) {
            if (game.player.getRect().intersects(game.walls.get(i).getRect())) {
                game.player.setX(oldX);
                game.player.setY(oldY);
            }
        }

        //UP DOWN RECTS
        for(int i = 0; i < game.upDownRects.size(); i++){
            game.upDownRects.get(i).update();
        }

        //Update LEFT RIGHT RECTS
        for(int i = 0; i < game.leftRightRects.size(); i++){
            game.leftRightRects.get(i).update();
        }

        //Update ALL PATTERN RECTS
        for(int i = 0; i < game.patternRects.size(); i++){
            game.patternRects.get(i).update();
        }

        //Update All Lasers
        for(int i = 0; i < game.lasers.size(); i++){
            game.lasers.get(i).update();
        }

        if(level == 1 || level == 2 || level == 3 || level == 4 || level == 5)
        System.out.println("Total Lives: " + totalLives);
        
        //------------------------------------------------------------------------------------------------------------------
        //if player intersects upDownRects then reset the position and the lives
        for(int i = 0; i < game.upDownRects.size(); i++) {
            if (game.player.getRect().intersects(game.upDownRects.get(i).getRect()))
            {
                resetPlayer(level);
                totalLives--;
                //level = 1;
                game.loadLevel(level);
            }
        }

        //if player intersects LEFTRIGHTRects then reset the position and the lives
        for(int i = 0; i < game.leftRightRects.size(); i++) {
            if (game.player.getRect().intersects(game.leftRightRects.get(i).getRect()))
            {
                resetPlayer(level);
                totalLives--;
               // level = 1;
                game.loadLevel(level);
            }
        }

        //if player intersects pattern Rects then reset the position and the lives
        for(int i = 0; i < game.patternRects.size(); i++) {
            if (game.player.getRect().intersects(game.patternRects.get(i).getRect()))
            {
                resetPlayer(level);
                totalLives--;
               // level = 1;
                game.loadLevel(level);
            }
        }

        //if player intersects the laser while its show is equal to true then resetPlayer's level, decrease lives, set level equal to 1. and load the level again
        for(int i = 0; i < game.lasers.size(); i++) {
            if (game.player.getRect().intersects(game.lasers.get(i).getRect()) && game.lasers.get(i).show)
            {
                resetPlayer(level);
                totalLives--;
               // level = 1;
                game.loadLevel(level);
            }
        }
        //---------------------------------------------------------------------------------------------------------------------------------------------

        //if the player reaches the goal then increase lives and level, load the level
        if(game.player.getRect().intersects(game.goal.getRect()))
        {
            if(level == 6)
            {
                System.out.println("YOU WON \n Press R to Reset");
            }

            totalLives++;
            level++;
            game.loadLevel(level);
        }

        if(totalLives == 0)
        {
            level = 6;
            System.out.println("YOU LOST");
        }

        //makes upDownRects go back and forth
       for (int i = 0; i < game.upDownRects.size(); i++) {

        if(game.upDownRects.get(i).getRect().getY()<=game.upDownRects.get(i).getMinY() || game.upDownRects.get(i).getRect().getY() + game.upDownRects.get(i).getRect().getHeight()> game.upDownRects.get(i).getMaxY())
        {
            game.upDownRects.get(i).changeDirection();
        }
       }

       //makes the leftRightRects go left and right
        for (int i = 0; i < game.leftRightRects.size(); i++) {

            if(game.leftRightRects.get(i).getRect().getX()<=game.leftRightRects.get(i).getMinX() || game.leftRightRects.get(i).getRect().getX() + game.leftRightRects.get(i).getRect().getHeight()> game.leftRightRects.get(i).getMaxX())
            {
                game.leftRightRects.get(i).changeDirection();
            }
        }
        //makes pattern rect go right then down and up then left and repeat
        for(int i = 0; i < game.patternRects.size(); i++){
            if(game.patternRects.get(i).right && game.patternRects.get(i).getRect().getX()>=game.patternRects.get(i).getMaxX())
            {
                game.patternRects.get(i).setRight(false);
                game.patternRects.get(i).setDown(true);
            }
            if(game.patternRects.get(i).down && game.patternRects.get(i).getRect().getY()>=game.patternRects.get(i).getMaxY())
            {
                game.patternRects.get(i).setDown(false);
                game.patternRects.get(i).setUp(true);
            }
            if(game.patternRects.get(i).up && game.patternRects.get(i).getRect().getY()<=game.patternRects.get(i).getMinY())
            {
                game.patternRects.get(i).setUp(false);
                game.patternRects.get(i).setLeft(true);
            }

            if(game.patternRects.get(i).left && game.patternRects.get(i).getRect().getX()<=game.patternRects.get(i).getMinX())
            {
                game.patternRects.get(i).setLeft(false);
                game.patternRects.get(i).setRight(true);
            }
        }
    }

    @Override
    public void keyTyped(KeyEvent e) { }

    //will always be laggy in key pressed
    @Override
    public void keyPressed(KeyEvent e) {
        if(e.getKeyCode() == KeyEvent.VK_ESCAPE)
        {
            System.exit(0);
        }

        if(e.getKeyCode() == KeyEvent.VK_UP)
        {
            game.player.setUp(true);
        }

        if(e.getKeyCode() == KeyEvent.VK_DOWN)
            game.player.setDown(true);

        if(e.getKeyCode() == KeyEvent.VK_LEFT)
            game.player.setLeft(true);

        if(e.getKeyCode() == KeyEvent.VK_RIGHT)
            game.player.setRight(true);

        //RESETS THE GAME//STILL HAVE TO TEST
        if(e.getKeyCode() == KeyEvent.VK_R)
        {
            if(gameWon)
            {
                totalLives = 5;
                level = 1;
                resetPlayer(level);
                game.loadLevel(level);
                System.out.println("YOU WON");
            }
                totalLives = 5;
                level = 1;
                resetPlayer(level);
                game.loadLevel(level);

        }
    }

    @Override
    public void keyReleased(KeyEvent e) {

        if(e.getKeyCode() == KeyEvent.VK_UP)
            game.player.setUp(false);

        if(e.getKeyCode() == KeyEvent.VK_DOWN)
            game.player.setDown(false);

        if(e.getKeyCode() == KeyEvent.VK_LEFT)
            game.player.setLeft(false);

        if(e.getKeyCode() == KeyEvent.VK_RIGHT)
            game.player.setRight(false);

    }
}
