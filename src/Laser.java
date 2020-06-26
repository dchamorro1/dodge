import com.sun.javafx.scene.traversal.Direction;

import java.awt.*;
import java.awt.geom.Rectangle2D;

public class Laser extends Collidable {

    private Color color;
    public int count;
     public boolean show;



    public Laser(Rectangle rect, Color color) {
        super(rect);
        this.color = color;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public void update()
    {
        count++;
        if(count == 100)
        {
            show =true;
        }
        else if (count == 200)
        {
            show = false;
            count = 0;
        }
    }
    public boolean isShow()
    {
        return show;
    }
}

