package polymorphism_Lab.shapes;

public class Rectangle extends Shape {

    private final Double height;
    private final Double width;


    public Rectangle(Double height, Double width) {
        this.height = height;
        this.width = width;
    }

    public Double getHeight() {
        return height;
    }

    public Double getWidth() {
        return width;
    }

    @Override
    public Double calculatePerimeter() {
        return (getHeight() + getWidth()) * 2;

    }

    @Override
    public Double calculateArea() {
        return height * width;
    }
}