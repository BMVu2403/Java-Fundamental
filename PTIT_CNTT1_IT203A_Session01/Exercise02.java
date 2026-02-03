package PTIT_CNTT1_IT203A_Session01;

import java.util.Scanner;

public class Exercise02 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n;
        int m;

        System.out.print("Nhap so ngay cham tre: ");
        n = sc.nextInt();

        System.out.print("Nhap so luong sach muon: ");
        m = sc.nextInt();

        double total = n * m * 5000;

        if (n > 7 && m >= 3) {
            total = total * 1.2;
        }

        boolean requireBlock = total > 50000;

        System.out.println("Tong tien phat: " + total);
        System.out.println("Yeu cau khoa the: " + requireBlock);

        sc.close();
    }
}
