package PTIT_CNTT1_IT203A_Session07;

public class Exercise02 {

    static class Student {
        String name;
    }

    public static void main(String[] args) {

        int a = 10;
        int b = a;
        b = 20;

        System.out.println("Gia tri a: " + a);
        System.out.println("Gia tri b: " + b);

        Student s1 = new Student();
        s1.name = "Nguyen Van A";

        Student s2 = s1;
        s2.name = "Tran Thi B";

        System.out.println("Ten sinh vien s1: " + s1.name);
        System.out.println("Ten sinh vien s2: " + s2.name);
    }
}
