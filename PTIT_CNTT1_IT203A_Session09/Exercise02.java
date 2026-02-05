public class Exercise02 {

    static class Animal {
        public void sound() {
            System.out.println("Animal makes a sound");
        }
    }

    static class Dog extends Animal {
        @Override
        public void sound() {
            System.out.println("Dog barks");
        }
    }

    static class Cat extends Animal {
        @Override
        public void sound() {
            System.out.println("Cat meows");
        }
    }

    public static void main(String[] args) {
        Animal a1 = new Dog();
        Animal a2 = new Cat();

        a1.sound();
        a2.sound();
    }
}
