package PTIT_CNTT1_IT203A_Session01;

import java.util.Scanner;

public class Exercise04 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        double priceUSD;
        float exchangeRate;

        System.out.print("Nhap gia sach (USD): ");
        priceUSD = sc.nextDouble();

        System.out.print("Nhap ty gia USD sang VND: ");
        exchangeRate = sc.nextFloat();

        double totalVND = priceUSD * exchangeRate;

        long roundedVND = (long) totalVND;

        System.out.println("Tong tien VND (lam tron): " + roundedVND);

        sc.close();
    }
}
