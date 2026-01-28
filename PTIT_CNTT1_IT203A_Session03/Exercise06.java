package PTIT_CNTT1_IT203A_Session03;

public class Exercise06 {
    public static int[] mergeBooks(int[] a, int[] b) {
        int[] temp = new int[a.length + b.length];

        int i = 0, j = 0, k = 0;

        while (i < a.length && j < b.length) {
            if (a[i] < b[j]) {
                temp[k++] = a[i++];
            } else if (a[i] > b[j]) {
                temp[k++] = b[j++];
            } else {
                temp[k++] = a[i];
                i++;
                j++;
            }
        }

        while (i < a.length) {
            temp[k++] = a[i++];
        }

        while (j < b.length) {
            temp[k++] = b[j++];
        }

        int[] result = new int[k];
        for (int x = 0; x < k; x++) {
            result[x] = temp[x];
        }

        return result;
    }

    public static void display(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            if (i > 0) {
                System.out.print(", ");
            }
            System.out.print(arr[i]);
        }
        System.out.println();
    }

    public static void main(String[] args) {

        int[] arrayFirst = { 101, 205, 330, 450, 512 };
        int[] arraySecond = { 205, 330, 400, 678 };

        System.out.println("Kho cu:");
        display(arrayFirst);

        System.out.println("Kho moi:");
        display(arraySecond);

        int[] arrayMerge = mergeBooks(arrayFirst, arraySecond);

        System.out.println("Kho sau khi gop va loai bo trung lap:");
        display(arrayMerge);
    }
}
