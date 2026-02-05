public class Exercise06 {

    static abstract class Shape {
        public abstract double calculateArea();
    }

    static class Circle extends Shape {
        private double radius;

        public Circle(double radius) {
            this.radius = radius;
        }

        @Override
        public double calculateArea() {
            return Math.PI * radius * radius;
        }
    }

    static class Rectangle extends Shape {
        private double width;
        private double height;

        public Rectangle(double width, double height) {
            this.width = width;
            this.height = height;
        }

        public Rectangle(double side) {
            this.width = side;
            this.height = side;
        }

        @Override
        public double calculateArea() {
            return width * height;
        }
    }

    public static void main(String[] args) {
        Shape[] shapes = new Shape[3];

        shapes[0] = new Circle(5);
        shapes[1] = new Rectangle(3, 4);
        shapes[2] = new Rectangle(6);

        for (Shape s : shapes) {
            System.out.println("Area: " + s.calculateArea());
        }
    }
}
