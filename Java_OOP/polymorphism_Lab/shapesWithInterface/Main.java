package polymorphism_Lab.shapesWithInterface;

public class Main {
    public static void main(String[] args) {


        Shape rectangle = new Rectangle(2D, 4D);
        Shape circle = new Circle(13.4);

        printShape(rectangle);
        printShape(circle);


    }

    public static void printShape (Shape shape) {
        System.out.println(shape.calculatePerimeter());
        System.out.println(shape.calculateArea());
    }
}
