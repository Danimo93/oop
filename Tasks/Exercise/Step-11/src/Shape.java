import java.awt.*;

public abstract class Shape {

    private Color color;
    private boolean filled;
    private final int id;

    public Shape(int id) {
        this.id = id;
        this.color = Color.RED;
        this.filled=true;
    }

    public Shape(int id, Color color, boolean filled) {
        this.id = id;
        this.color = color;
        this.filled = filled;

    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public boolean isFilled() {
        return filled;
    }

    public void setFilled(boolean filled) {
        this.filled = filled;
    }



}
