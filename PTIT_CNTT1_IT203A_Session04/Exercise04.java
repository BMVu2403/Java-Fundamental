import java.util.Scanner;

public class Exercise04 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhap ma the thu vien: ");
        String maThe = sc.nextLine();
        if (!maThe.matches("^[A-Z]{2}.*")) {
            System.out.println("Thieu tien to 2 chu cai in hoa");
        } else if (!maThe.matches("^[A-Z]{2}\\d{4}.*")) {
            System.out.println("Nam khong hop le");
        } else if (!maThe.matches("^[A-Z]{2}\\d{4}\\d{5}$")) {
            System.out.println("So ky tu cuoi khong hop le");
        } else {
            System.out.println("Ma the hop le");
        }
        sc.close();
    }
}
