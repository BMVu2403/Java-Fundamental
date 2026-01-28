package PTIT_CNTT1_IT203A_Session02;

import java.util.Scanner;

public class Exercise05 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int diem = 100;
        int soNgay;

        System.out.print("Nhap so ngay tre (999 de thoat): ");
        soNgay = sc.nextInt();

        while (soNgay != 999) {
            if (soNgay <= 0) {
                diem += 5;
            } else {
                diem -= soNgay * 2;
            }

            System.out.print("Nhap so ngay tre (999 de thoat): ");
            soNgay = sc.nextInt();
        }

        System.out.println("Tong diem uy tin: " + diem);

        if (diem > 120) {
            System.out.println("Doc gia Than thiet");
        } else if (diem >= 80) {
            System.out.println("Doc gia Tieu chuan");
        } else {
            System.out.println("Doc gia can luu y");
        }

        sc.close();
    }
}
