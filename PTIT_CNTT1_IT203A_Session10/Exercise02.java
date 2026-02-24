abstract class Vehicle {
    protected String brand;

    public Vehicle(String brand) {
        this.brand = brand;
    }

    public abstract void move();
}

class Car extends Vehicle {
    public Car(String brand) {
        super(brand);
    }

    @Override
    public void move() {
        System.out.println(brand + " - Cach di chuyen: Di chuyen bang dong co");
    }
}

class Bicycle extends Vehicle {
    public Bicycle(String brand) {
        super(brand);
    }

    @Override
    public void move() {
        System.out.println(brand + " - Cach di chuyen: Di chuyen bang suc nguoi");
    }
}

public class Exercise02 {
    public static void main(String[] args) {
        Vehicle v1 = new Car("Toyota");
        Vehicle v2 = new Bicycle("Thong Nhat");
        v1.move();
        v2.move();
    }
}
