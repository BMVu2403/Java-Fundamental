package PTIT_CNTT1_IT203A_Session03;

import java.util.Scanner;

public class Exercise01 {
    public static int[] addBookToLibraries(int n, Scanner sc) {
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            System.out.print("Nhap ma sach thu " + (i + 1) + ": ");
            arr[i] = sc.nextInt();
        }

        return arr;
    }

    public static void displayLibraries(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            if (i > 0) {
                System.out.print(", ");
            }
            System.out.print(arr[i]);
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Nhap so luong sach: ");
        int n = sc.nextInt();

        int[] libraries = addBookToLibraries(n, sc);
        displayLibraries(libraries);

        sc.close();
    }
}
