package PTIT_CNTT1_IT203A_Session04;

import java.util.Scanner;

public class Exercise01 {
    public static String chuanHoaTenTacGia(String input) {
        input = input.trim();
        String[] words = input.split("\\s+");
        StringBuilder result = new StringBuilder();
        for (String word : words) {
            result.append(word.substring(0, 1).toUpperCase() + word.substring(1).toLowerCase()).append(" ");
        }
        return result.toString().trim();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhap ten sach: ");
        String tenSach = sc.nextLine();
        System.out.print("Nhap tac gia: ");
        String tacGia = sc.nextLine();
        System.out.print("Nhap the loai: ");
        String theLoai = sc.nextLine();
        tenSach = tenSach.trim().replaceAll("\\s+", " ").toUpperCase();
        tacGia = chuanHoaTenTacGia(tacGia);
        theLoai = theLoai.trim().replaceAll("\\s+", " ");
        System.out.println(tenSach + " - Tac gia: " + tacGia);
        sc.close();
    }
}
