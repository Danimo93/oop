import java.awt.*;

public class Program {
    public void checkCircles(){
        System.out.println("Checking circles");
        System.out.println("------------");
        Circle c1 = new Circle();
        System.out.printf("Circle from empty constructor:%s%n", c1);
        Circle c2 = new Circle(2.0);
        System.out.printf("Circle with r=2:%s%n", c2);
        Circle c3 = new Circle(3.0, Color.BLUE, false);
        System.out.printf("Blue non-filled circle with r=3:%s%n", c3);
        System.out.printf("Area:%s, Perimeter:%s%n", c3.getArea(), c3.getPerimeter());
        System.out.println("Checking circles done");
        System.out.println("-------------");
    }

    public void checkSquares(){
        System.out.println("Checking square");
        System.out.println("------------");
        Square s1 = new Square();
        System.out.printf("Square from empty constructor:%s%n", s1);
        Square s2 = new Square(5);
        System.out.printf("Square with r=5:%s%n", s2);
        Square s3 = new Square(5, Color.BLUE, true);
        System.out.printf("Blue filled square with side=5:%s%n", s3);
        System.out.printf("Area:%s, Perimeter:%s%n", s3.getArea(), s3.getPerimeter());
        System.out.println("Checking square done");
        System.out.println("-------------");
    }

    public void checkRectangles(){
        System.out.println("Checking rectangle");
        System.out.println("------------");
        Rectangle r1 = new Rectangle();
        System.out.printf("Rectangle from empty constructor:%s%n", r1);
        Rectangle r2 = new Rectangle(3,4);
        System.out.printf("Rectangle with width=3 and length=4:%s%n", r2);
        Rectangle r3 = new Rectangle(3, 4, Color.LIGHT_GRAY, false);
        System.out.printf("Blue non-filled rectangle with width=3 and length=4:%s%n",r3);
        System.out.printf("Area:%s, Perimeter:%s%n", r3.getArea(), r3.getPerimeter());
        System.out.println("Checking rectangle done");
        System.out.println("-------------");
    }

    public void checkShapes(){
        System.out.println("Checking Shapes");
        System.out.println("------------");
        Shape s1 = new Shape();
        System.out.printf("Shape from empty constructor:%s%n", s1);
        Shape s2 = new Shape();
        System.out.printf("Shape from empty constryuctor:%s%n",s2);
        System.out.println("Checking shape done");
        System.out.println("-------------");

    }


}
