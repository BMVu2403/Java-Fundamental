package PTIT_CNTT1_IT203A_Session01;

import java.util.Scanner;

public class Exercise06 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Nhap so thu tu sach (stt): ");
        int stt = sc.nextInt();

        int shelf = (stt - 1) / 25 + 1;
        int position = (stt - 1) % 25 + 1;

        String area = (shelf <= 10) ? "Khu Can" : "Khu Vien";

        System.out.println("Ke so " + shelf + " - Vi tri " + position + " - Khu vuc " + area);

        sc.close();
    }
}
