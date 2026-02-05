public class Exercise05 {

    static abstract class Employee {
        protected String name;

        public Employee(String name) {
            this.name = name;
        }

        public abstract long calculateSalary();

        public void showInfo() {
            System.out.println("Name: " + name);
            System.out.println("Salary: " + calculateSalary());
        }
    }

    static class OfficeEmployee extends Employee {
        private long baseSalary;

        public OfficeEmployee(String name, long baseSalary) {
            super(name);
            this.baseSalary = baseSalary;
        }

        @Override
        public long calculateSalary() {
            return baseSalary;
        }
    }

    static class ProductionEmployee extends Employee {
        private int numOfProducts;
        private long price;

        public ProductionEmployee(String name, int numOfProducts, long price) {
            super(name);
            this.numOfProducts = numOfProducts;
            this.price = price;
        }

        @Override
        public long calculateSalary() {
            return numOfProducts * price;
        }
    }

    public static void main(String[] args) {
        Employee[] employees = new Employee[3];

        employees[0] = new OfficeEmployee("Nguyen Van A", 8000000L);
        employees[1] = new ProductionEmployee("Tran Van B", 120, 50000L);
        employees[2] = new OfficeEmployee("Le Thi C", 9000000L);

        long totalSalary = 0;

        for (Employee e : employees) {
            e.showInfo();
            totalSalary += e.calculateSalary();
            System.out.println("-----");
        }

        System.out.println("Total salary: " + totalSalary);
    }
}
