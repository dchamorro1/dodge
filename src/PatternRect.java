import com.sun.javafx.scene.traversal.Direction;

import java.awt.*;
import java.awt.geom.Rectangle2D;

public class PatternRect extends Collidable {


    public boolean up = false;
    public boolean down = false;
    public boolean left = false;
    public boolean right = true;
    public double x;
    public double y;
    public double speed;

    private Color color;
    public boolean direction;
    private int minX;
    private int maxX;
    private int minY;
    private int maxY;

    public int width;
    public int height;



    public PatternRect(Rectangle rect, Color color, int speed, int x, int y, int minX, int maxX, int minY,int maxY, int width, int height) {
        super(rect);
        this.color = color;
        this.speed = speed;
        this.x = x;
        this.y = y;
        this.minX = minX;
        this.maxX = maxX;
        this.minY = minY;
        this.maxY = maxY;
        this.width = width;
        this.height = height;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }


    public int getMinX() {
        return minX;
    }

    public void setMinX(int minX) {
        this.minX = minX;
    }

    public int getMaxX() {
        return maxX;
    }

    public void setMaxX(int maxX) {
        this.maxX = maxX;
    }

    public int getMinY() {
        return minY;
    }

    public void setMinY(int minY) {
        this.minY = minY;
    }

    public int getMaxY() {
        return maxY;
    }

    public void setMaxY(int maxY) {
        this.maxY = maxY;
    }

    public void setUp(boolean direction)
    {
        up = direction;
    }

    public void setDown(boolean direction)
    {

        down = direction;

    }
    public void setLeft(boolean direction)
    {
        left = direction;
    }
    public void setRight(boolean direction)
    {
        right = direction;
    }

    public void setX(double x)
    {
        this.x=x;
        setRect(new Rectangle((int)x,(int)y,width,height));
    }

    public void setY(double y) {
        this.y = y;
        setRect(new Rectangle((int)x,(int)y,width,height));
    }

    public void moveTo(double x, double y)
    {
        setX(x);
        setY(y);
        setRect(new Rectangle((int)x,(int)y,width,height));
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public void update()
    {
        if(left)
        {
            moveTo(getX()-speed,getY());
        }
        else if(right)
        {
            moveTo(getX()+speed,getY());
        }
        else if (up)
        {
            moveTo(getX(),getY()-speed);
        }
        else if(down)
        {
            moveTo(getX(),getY()+speed);
        }
    }
}

