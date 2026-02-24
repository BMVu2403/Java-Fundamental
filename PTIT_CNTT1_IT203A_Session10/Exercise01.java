interface Shape {
    double getArea();

    double getPerimeter();
}

class Circle implements Shape {
    private double radius;

    public Circle(double radius) {
        this.radius = radius;
    }

    @Override
    public double getArea() {
        return Math.PI * radius * radius;
    }

    @Override
    public double getPerimeter() {
        return 2 * Math.PI * radius;
    }
}

class Rectangle implements Shape {
    private double width;
    private double height;

    public Rectangle(double width, double height) {
        this.width = width;
        this.height = height;
    }

    @Override
    public double getArea() {
        return width * height;
    }

    @Override
    public double getPerimeter() {
        return 2 * (width + height);
    }
}

public class Exercise01 {
    public static void main(String[] args) {
        Shape c = new Circle(5);
        Shape r = new Rectangle(4, 6);
        System.out.println("Hinh tron:");
        System.out.println("Dien tich = " + c.getArea());
        System.out.println("Chu vi = " + c.getPerimeter());
        System.out.println();
        System.out.println("Hinh chu nhat:");
        System.out.println("Dien tich = " + r.getArea());
        System.out.println("Chu vi = " + r.getPerimeter());
    }
}
