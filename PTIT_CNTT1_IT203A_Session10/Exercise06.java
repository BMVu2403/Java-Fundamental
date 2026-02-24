import java.util.*;

class Product {
    String name;
    double price;

    public Product(String name, double price) {
        this.name = name;
        this.price = price;
    }
}

public class Exercise06 {
    public static void main(String[] args) {
        List<Product> list = new ArrayList<>();
        list.add(new Product("Laptop", 1500));
        list.add(new Product("Mouse", 20));
        list.add(new Product("Keyboard", 50));
        list.add(new Product("Monitor", 300));

        /*
         * Anonymous Class dung khi:
         * - Can them thuoc tinh noi bo
         * - Interface co nhieu phuong thuc
         * - Can logic phuc tap, co state rieng
         */
        Collections.sort(list, new Comparator<Product>() {
            public int compare(Product p1, Product p2) {
                return Double.compare(p1.price, p2.price);
            }
        });
        System.out.println("Sap xep theo gia tang dan (Anonymous):");
        for (Product p : list) {
            System.out.println(p.name + " - " + p.price);
        }

        // Lambda Expression: gon gon, chi dung cho Functional Interface (1 abstract
        // method)
        Collections.sort(list, (p1, p2) -> p1.name.compareTo(p2.name));
        System.out.println("\nSap xep theo ten A-Z (Lambda):");
        for (Product p : list) {
            System.out.println(p.name + " - " + p.price);
        }

    }
}
