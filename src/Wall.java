import java.awt.*;
import java.awt.geom.Rectangle2D;

public class Wall extends Collidable {


    private Color color;
    private int direction;

    public Wall(Rectangle rect, Color color) {
        super(rect);
        this.color = color;
        //this.direction = direction;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

}

