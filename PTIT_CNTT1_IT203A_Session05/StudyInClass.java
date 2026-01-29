package PTIT_CNTT1_IT203A_Session05;

import java.util.Scanner;
import java.util.regex.Pattern;

public class StudyInClass {
    static final int MAX = 100;
    static String[] mssvList = new String[MAX];
    static int count = 0;
    static final String MSSV_REGEX = "^B\\d{7}$";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int choice;
        do {
            showMenu();
            System.out.print("Chon chuc nang: ");
            while (!scanner.hasNextInt()) {
                scanner.nextLine();
                System.out.print("Vui long nhap so hop le: ");
            }
            choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice) {
                case 1:
                    displayList();
                    break;
                case 2:
                    addMssv(scanner);
                    break;
                case 3:
                    updateMssv(scanner);
                    break;
                case 4:
                    deleteMssv(scanner);
                    break;
                case 5:
                    searchMssv(scanner);
                    break;
                case 6:
                    System.out.println("Da thoat chuong trinh!");
                    break;
                default:
                    System.out.println("Lua chon khong hop le!");
            }
        } while (choice != 6);
        scanner.close();
    }

    static void showMenu() {
        System.out.println("\n===== QUAN LY MSSV =====");
        System.out.println("1. Hien thi danh sach");
        System.out.println("2. Them MSSV");
        System.out.println("3. Cap nhat MSSV");
        System.out.println("4. Xoa MSSV");
        System.out.println("5. Tim kiem MSSV");
        System.out.println("6. Thoat");
    }

    static void displayList() {
        if (count == 0) {
            System.out.println("Danh sach rong!");
            return;
        }
        for (int i = 0; i < count; i++) {
            System.out.println((i + 1) + ". " + mssvList[i]);
        }
    }

    static void addMssv(Scanner scanner) {
        if (count >= MAX) {
            System.out.println("Mang da day!");
            return;
        }
        String mssv;
        do {
            System.out.print("Nhap MSSV: ");
            mssv = scanner.nextLine();
        } while (!Pattern.matches(MSSV_REGEX, mssv));
        mssvList[count++] = mssv;
        System.out.println("Them thanh cong!");
    }

    static void updateMssv(Scanner scanner) {
        if (count == 0) {
            System.out.println("Danh sach rong!");
            return;
        }
        System.out.print("Nhap index can sua: ");
        int index = scanner.nextInt();
        scanner.nextLine();
        if (index < 0 || index >= count) {
            System.out.println("Index khong hop le!");
            return;
        }
        String newMssv;
        do {
            System.out.print("Nhap MSSV moi: ");
            newMssv = scanner.nextLine();
        } while (!Pattern.matches(MSSV_REGEX, newMssv));
        mssvList[index] = newMssv;
        System.out.println("Cap nhat thanh cong!");
    }

    static void deleteMssv(Scanner scanner) {
        if (count == 0) {
            System.out.println("Danh sach rong!");
            return;
        }
        System.out.print("Nhap MSSV can xoa: ");
        String code = scanner.nextLine();
        int index = -1;
        for (int i = 0; i < count; i++) {
            if (mssvList[i].equalsIgnoreCase(code)) {
                index = i;
                break;
            }
        }
        if (index == -1) {
            System.out.println("Khong tim thay!");
            return;
        }
        for (int i = index; i < count - 1; i++) {
            mssvList[i] = mssvList[i + 1];
        }
        mssvList[--count] = null;
        System.out.println("Xoa thanh cong!");
    }

    static void searchMssv(Scanner scanner) {
        if (count == 0) {
            System.out.println("Danh sach rong!");
            return;
        }
        System.out.print("Nhap chuoi tim kiem: ");
        String keyword = scanner.nextLine().toLowerCase();
        boolean found = false;
        for (int i = 0; i < count; i++) {
            if (mssvList[i].toLowerCase().contains(keyword)) {
                System.out.println(mssvList[i]);
                found = true;
            }
        }
        if (!found) {
            System.out.println("Khong co ket qua!");
        }
    }
}
