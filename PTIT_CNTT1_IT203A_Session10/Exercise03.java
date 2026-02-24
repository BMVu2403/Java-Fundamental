abstract class Animal {
    protected String name;

    public Animal(String name) {
        this.name = name;
    }
}

interface Swimmable {
    void swim();
}

interface Flyable {
    void fly();
}

class Duck extends Animal implements Swimmable, Flyable {
    public Duck(String name) {
        super(name);
    }

    public void swim() {
        System.out.println(name + " dang boi");
    }

    public void fly() {
        System.out.println(name + " dang bay");
    }
}

class Fish extends Animal implements Swimmable {
    public Fish(String name) {
        super(name);
    }

    public void swim() {
        System.out.println(name + " dang boi");
    }
}

public class Exercise03 {
    public static void main(String[] args) {
        Animal duck = new Duck("Vit");
        Animal fish = new Fish("Ca");
        ((Duck) duck).swim();
        ((Duck) duck).fly();
        ((Fish) fish).swim();
    }
}
