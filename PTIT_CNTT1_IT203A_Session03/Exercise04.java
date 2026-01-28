package PTIT_CNTT1_IT203A_Session03;

public class Exercise04 {
    public static void sortBooks(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] > arr[j]) {
                    int temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
        }
    }

    public static void displayBooks(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            if (i > 0) {
                System.out.print(", ");
            }
            System.out.print(arr[i]);
        }
        System.out.println();
    }

    public static void main(String[] args) {

        int[] books = { 45, 12, 89, 33, 7, 60 };

        System.out.println("Mang truoc khi sap xep:");
        displayBooks(books);

        sortBooks(books);

        System.out.println("Mang sau khi sap xep:");
        displayBooks(books);
    }
}
