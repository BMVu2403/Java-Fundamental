package PTIT_CNTT1_IT203A_Session02;

import java.util.Scanner;

public class Exercise04 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Nhap so luong sach tra muon: ");
        int n = sc.nextInt();

        int total = 0;

        for (int i = 1; i <= n; i++) {
            System.out.print("Nhap so ngay tre cua sach thu " + i + ": ");
            int soNgayTre = sc.nextInt();
            total += soNgayTre * 5000;
        }

        System.out.println("Tong tien phat: " + total + " VND");

        sc.close();
    }
}
