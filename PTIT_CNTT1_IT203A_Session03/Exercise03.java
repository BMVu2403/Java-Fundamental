package PTIT_CNTT1_IT203A_Session03;

public class Exercise03 {
    public static void maxQuantityOfBooks(String[] names, int[] quantities) {
        int max = quantities[0];

        for (int i = 1; i < quantities.length; i++) {
            if (quantities[i] > max) {
                max = quantities[i];
            }
        }

        System.out.println("Sach co so luong nhieu nhat:");
        for (int i = 0; i < quantities.length; i++) {
            if (quantities[i] == max) {
                System.out.println(names[i] + " - " + quantities[i]);
            }
        }
    }

    public static void minQuantityOfBooks(String[] names, int[] quantities) {
        int min = quantities[0];

        for (int i = 1; i < quantities.length; i++) {
            if (quantities[i] < min) {
                min = quantities[i];
            }
        }

        System.out.println("Sach co so luong it nhat:");
        for (int i = 0; i < quantities.length; i++) {
            if (quantities[i] == min) {
                System.out.println(names[i] + " - " + quantities[i]);
            }
        }
    }

    public static void main(String[] args) {

        String[] names = {
                "Lap trinh Java",
                "Cau truc du lieu",
                "Giai thuat",
                "Co so du lieu",
                "Mang may tinh"
        };

        int[] quantities = { 10, 5, 10, 3, 3 };

        maxQuantityOfBooks(names, quantities);
        minQuantityOfBooks(names, quantities);
    }
}
