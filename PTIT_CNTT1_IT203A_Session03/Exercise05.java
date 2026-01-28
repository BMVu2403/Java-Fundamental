package PTIT_CNTT1_IT203A_Session03;

import java.util.Scanner;

public class Exercise05 {
    public static int deleteBook(int[] arr, int n, int bookId) {
        int pos = -1;

        for (int i = 0; i < n; i++) {
            if (arr[i] == bookId) {
                pos = i;
                break;
            }
        }

        if (pos == -1) {
            System.out.println("Khong tim thay ma sach can xoa");
            return n;
        }

        for (int i = pos; i < n - 1; i++) {
            arr[i] = arr[i + 1];
        }

        return n - 1;
    }

    public static void displayBooks(int[] arr, int n) {
        if (n == 0) {
            System.out.println("Kho sach rong");
            return;
        }

        for (int i = 0; i < n; i++) {
            if (i > 0) {
                System.out.print(", ");
            }
            System.out.print(arr[i]);
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int[] books = { 101, 205, 330, 450, 512, 678 };
        int n = books.length;

        while (n > 0) {
            System.out.println("Danh sach sach hien tai:");
            displayBooks(books, n);

            System.out.print("Nhap ma sach can xoa (-1 de dung): ");
            int bookId = sc.nextInt();

            if (bookId == -1) {
                break;
            }

            n = deleteBook(books, n, bookId);
        }

        System.out.println("Danh sach sach cuoi cung:");
        displayBooks(books, n);

        sc.close();
    }
}
