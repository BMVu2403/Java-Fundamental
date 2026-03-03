package PTIT_CNTT1_IT203A_Session16;

import java.util.*;

public class Practice {

    interface IRepository<T> {
        boolean add(T item);

        boolean removeById(String id);

        T findById(String id);

        List<T> findAll();
    }

    static abstract class Product {
        protected String id;
        protected String name;
        protected double price;

        public Product(String id, String name, double price) {
            this.id = id;
            this.name = name;
            this.price = price;
        }

        public String getId() {
            return id;
        }

        public double getPrice() {
            return price;
        }

        public abstract double calculateFinalPrice();

        public void displayInfo() {
            System.out.println("Ma: " + id + ", Ten: " + name + ", Gia goc: " + price);
        }
    }

    static class ElectronicProduct extends Product {
        private int warrantyMonths;

        public ElectronicProduct(String id, String name, double price, int warrantyMonths) {
            super(id, name, price);
            this.warrantyMonths = warrantyMonths;
        }

        @Override
        public double calculateFinalPrice() {
            return warrantyMonths > 12 ? price + 1_000_000 : price;
        }

        @Override
        public void displayInfo() {
            super.displayInfo();
            System.out.println("Bao hanh: " + warrantyMonths + " thang");
        }
    }

    static class FoodProduct extends Product {
        private int discountPercent;

        public FoodProduct(String id, String name, double price, int discountPercent) {
            super(id, name, price);
            this.discountPercent = discountPercent;
        }

        @Override
        public double calculateFinalPrice() {
            return price - (price * discountPercent / 100.0);
        }

        @Override
        public void displayInfo() {
            super.displayInfo();
            System.out.println("Giam gia: " + discountPercent + "%");
        }
    }

    static class ProductRepository implements IRepository<Product> {

        private List<Product> list = new ArrayList<>();
        private Map<String, Product> map = new HashMap<>();

        @Override
        public boolean add(Product item) {
            if (item == null || map.containsKey(item.getId()))
                return false;
            list.add(item);
            map.put(item.getId(), item);
            return true;
        }

        @Override
        public boolean removeById(String id) {
            if (id == null || !map.containsKey(id))
                return false;
            Product p = map.remove(id);
            list.remove(p);
            return true;
        }

        @Override
        public Product findById(String id) {
            if (id == null)
                return null;
            return map.get(id);
        }

        @Override
        public List<Product> findAll() {
            return list;
        }
    }

    public static void main(String[] args) {

        ProductRepository repo = new ProductRepository();

        repo.add(new ElectronicProduct("01", "Tivi", 12000000, 24));
        repo.add(new ElectronicProduct("02", "Laptop", 20000000, 12));
        repo.add(new FoodProduct("01", "Banh mi", 20000, 10));
        repo.add(new FoodProduct("02", "Sua", 15000, 5));

        for (Product p : repo.findAll()) {
            p.displayInfo();
            System.out.println("Thanh tien: " + p.calculateFinalPrice());
            System.out.println("------");
        }

        Product found = repo.findById("01");
        if (found != null) {
            found.displayInfo();
        }

        Collections.sort(repo.findAll(), Comparator.comparingDouble(Product::getPrice));

        Map<String, Integer> stat = new HashMap<>();
        for (Product p : repo.findAll()) {
            String type = p instanceof ElectronicProduct ? "Electronic" : "Food";
            stat.put(type, stat.getOrDefault(type, 0) + 1);
        }

        System.out.println(stat);
    }
}
