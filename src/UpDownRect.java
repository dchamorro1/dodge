import com.sun.javafx.scene.traversal.Direction;

import java.awt.*;
import java.awt.geom.Rectangle2D;

public class UpDownRect extends Collidable {
    public static final int UP = 0;
    public static final int DOWN = 1;

    private Color color;
    private int direction;
    private int minY;
    private int maxY;

    public UpDownRect(Rectangle rect, Color color, int direction, int minY, int maxY) {
        super(rect);
        this.color = color;
        this.direction = direction;
        this.minY = minY;
        this.maxY = maxY;
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

    public void update()
    {
        int yChange = (direction==UP)?1:-1;
        int newY = ((int)getRect().getY()-yChange);
        setRect(new Rectangle((int)getRect().getX(), newY, (int)getRect().getWidth(), (int)getRect().getHeight()));
    }
}

