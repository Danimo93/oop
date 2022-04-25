import java.awt.*;


public class Circle extends Shape{

    private double radius;

    public Circle(){
        super();
        radius = 1.0;
    }

    public Circle(double radius){
        super();
        this.radius = radius;
    }

    public Circle(double radius, Color color, boolean filled){
        super(color, filled);
        this.radius = radius;
    }

    public double getRadius() {return radius;}

    public double getArea() {return (radius*radius)*Math.PI;}

    public double getPerimeter() {return 2*Math.PI*radius;}

    public void setRadius(double radius) {
        this.radius = radius;
    }

    public String toString() {
        return String.format("A Circle with a radius = %s, Which is a sub class of %s",
               radius, super.toString());
    }

}

