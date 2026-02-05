public class Exercise04 {

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

        public void wagTail() {
            System.out.println("Dog wags tail");
        }
    }

    public static void main(String[] args) {
        Animal animal = new Dog();

        animal.sound();

        // animal.wagTail(); // loi bien dich

        if (animal instanceof Dog) {
            Dog dog = (Dog) animal;
            dog.wagTail();
        }
    }
}
