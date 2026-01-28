package PTIT_CNTT1_IT203A_Session02;

import java.util.Scanner;

public class Exercise06 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int max = -1;
        int min = Integer.MAX_VALUE;
        int tong = 0;
        int dem = 0;

        for (int i = 1; i <= 7; i++) {
            System.out.print("Nhap so luot muon ngay " + i + ": ");
            int luotMuon = sc.nextInt();

            if (luotMuon == 0) {
                continue;
            }

            if (luotMuon > max) {
                max = luotMuon;
            }

            if (luotMuon < min) {
                min = luotMuon;
            }

            tong += luotMuon;
            dem++;
        }

        if (dem > 0) {
            double trungBinh = (double) tong / dem;
            System.out.println("Luot muon cao nhat: " + max);
            System.out.println("Luot muon thap nhat: " + min);
            System.out.println("Trung binh luot muon: " + trungBinh);
        } else {
            System.out.println("Khong co ngay nao mo cua");
        }

        sc.close();
    }
}
