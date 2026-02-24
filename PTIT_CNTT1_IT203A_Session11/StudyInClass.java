package PTIT_CNTT1_IT203A_Session11;

interface IMixable {
    void mix();
}

abstract class Drink {
    protected String id;
    protected String name;
    protected double price;

    public Drink(String id, String name, double price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

    public abstract double calculatePrice();

    public void displayInfo() {
        System.out.println("Ma do uong: " + id);
        System.out.println("Ten do uong: " + name);
        System.out.println("Gia goc: " + price);
    }
}

class Coffee extends Drink {
    private boolean hasMilk;

    public Coffee(String id, String name, double price, boolean hasMilk) {
        super(id, name, price);
        this.hasMilk = hasMilk;
    }

    @Override
    public double calculatePrice() {
        if (hasMilk) {
            return price + 5000;
        }
        return price;
    }

    @Override
    public void displayInfo() {
        super.displayInfo();
        if (hasMilk) {
            System.out.println("Loai: Co sua");
        } else {
            System.out.println("Loai: Den da");
        }
    }
}

class FruitJuice extends Drink implements IMixable {
    private int discountPercent;

    public FruitJuice(String id, String name, double price, int discountPercent) {
        super(id, name, price);
        this.discountPercent = discountPercent;
    }

    @Override
    public double calculatePrice() {
        return price - (price * discountPercent / 100);
    }

    @Override
    public void mix() {
        System.out.println("Dang ep tra cay tuoi...");
    }
}

public class StudyInClass {
    public static void main(String[] args) {

        Drink[] drinks = new Drink[3];

        drinks[0] = new Coffee("CF01", "Bac siu", 30000, true);
        drinks[1] = new FruitJuice("FJ01", "Nuoc cam", 40000, 10);
        drinks[2] = null;

        for (int i = 0; i < drinks.length; i++) {
            if (drinks[i] != null) {
                System.out.println("---------------");
                drinks[i].displayInfo();
                System.out.println("Thanh tien: " + drinks[i].calculatePrice());

                if (drinks[i] instanceof IMixable) {
                    ((IMixable) drinks[i]).mix();
                }
            }
        }
    }
}
