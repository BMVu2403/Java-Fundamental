abstract class Employee {
    protected String name;
    protected double baseSalary;

    public Employee(String name, double baseSalary) {
        this.name = name;
        this.baseSalary = baseSalary;
    }

    public abstract double calculateSalary();
}

interface BonusCalculator {
    double getBonus();
}

class OfficeStaff extends Employee {
    public OfficeStaff(String name, double baseSalary) {
        super(name, baseSalary);
    }

    public double calculateSalary() {
        return baseSalary;
    }
}

class Manager extends Employee implements BonusCalculator {
    private double bonus;

    public Manager(String name, double baseSalary, double bonus) {
        super(name, baseSalary);
        this.bonus = bonus;
    }

    public double getBonus() {
        return bonus;
    }

    public double calculateSalary() {
        return baseSalary + bonus;
    }
}

public class Exercise05 {
    public static void main(String[] args) {
        Employee e1 = new OfficeStaff("Nhan vien van phong", 8000000);
        Employee e2 = new Manager("Quan ly", 12000000, 3000000);
        System.out.println("Bang luong:");
        System.out.println(e1.name + " - Luong = " + e1.calculateSalary());
        System.out.println(e2.name + " - Luong = " + e2.calculateSalary());
    }
}
