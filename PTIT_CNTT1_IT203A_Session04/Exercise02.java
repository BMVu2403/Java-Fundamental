package PTIT_CNTT1_IT203A_Session04;

import java.util.Scanner;

public class Exercise02 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhap mo ta sach: ");
        String moTa = sc.nextLine();
        if (moTa.contains("Kệ:")) {
            int start = moTa.indexOf("Kệ:") + 3;
            int end = moTa.indexOf(",", start);
            String maKe;
            if (end != -1) {
                maKe = moTa.substring(start, end).trim();
            } else {
                maKe = moTa.substring(start).trim();
            }
            System.out.println("Ma vi tri ke sach: " + maKe);
            String moTaMoi = moTa.replace("Kệ:", "Vị trí lưu trữ:");
            System.out.println(moTaMoi);
        } else {
            System.out.println("Khong co thong tin ke sach");
        }
        sc.close();
    }
}
