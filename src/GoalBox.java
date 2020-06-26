import java.awt.*;

public class GoalBox {
    private Rectangle rect = null;
    private Color color;

    public GoalBox(Rectangle rect, Color color) {
        this.rect = rect;
        this.color = color;
    }

    public Rectangle getRect() {
        return rect;
    }

    public void setRect(Rectangle rect) {
        this.rect = rect;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }
}
