import com.sun.javafx.scene.traversal.Direction;

import java.awt.*;
import java.awt.geom.Rectangle2D;

public class LeftRightRect extends Collidable {
    public static final int LEFT = 0;
    public static final int RIGHT = 1;

    private Color color;
    private int direction;
    private int minX;
    private int maxX;

    public LeftRightRect(Rectangle rect, Color color, int direction, int minX, int maxX) {
        super(rect);
        this.color = color;
        this.direction = direction;
        this.minX = minX;
        this.maxX = maxX;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public int getDirection() {
        return direction;
    }

    public void changeDirection() {
        direction = (direction+1)%2;
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

    public void update()
    {
        int xChange = (direction==LEFT)?1:-1;
        int newX = ((int)getRect().getX()-xChange);
        setRect(new Rectangle(newX, (int)getRect().getY(), (int)getRect().getWidth(), (int)getRect().getHeight()));
    }
}

