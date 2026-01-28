import java.util.Scanner;

public class Exercise01 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String bookID;
        String bookName;
        int publishYear;
        double price;
        boolean isAvailable;

        System.out.print("Nhap ma sach: ");
        bookID = sc.nextLine();

        System.out.print("Nhap ten sach: ");
        bookName = sc.nextLine();

        System.out.print("Nhap nam xuat ban: ");
        publishYear = sc.nextInt();

        System.out.print("Nhap gia sach: ");
        price = sc.nextDouble();

        System.out.print("Sach con trong kho? (true/false): ");
        isAvailable = sc.nextBoolean();

        int age = 2026 - publishYear;

        System.out.println("\n===== PHIEU THONG TIN SACH =====");
        System.out.println("Ma sach: " + bookID);
        System.out.println("Ten sach: " + bookName.toUpperCase());
        System.out.println("Nam xuat ban: " + publishYear);
        System.out.println("Tuoi tho sach: " + age + " nam");
        System.out.printf("Gia sach: %.2f\n", price);
        System.out.println("Tinh trang: " + (isAvailable ? "Con sach" : "Da muon"));

        sc.close();
    }
}
