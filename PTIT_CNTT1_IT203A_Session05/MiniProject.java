package PTIT_CNTT1_IT203A_Session05;

import java.util.Scanner;
import java.util.Arrays;

public class MiniProject {

    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int choice;

        do {
            System.out.println("===== MINI PROJECT SRS =====");
            System.out.println("1. Two Sum");
            System.out.println("2. Move Zeroes");
            System.out.println("3. Valid Palindrome");
            System.out.println("4. Reverse Words");
            System.out.println("5. Happy Number");
            System.out.println("0. Thoat");
            System.out.print("Chon chuc nang: ");

            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    twoSum();
                    break;
                case 2:
                    moveZeroes();
                    break;
                case 3:
                    validPalindrome();
                    break;
                case 4:
                    reverseWords();
                    break;
                case 5:
                    happyNumber();
                    break;
                case 0:
                    System.out.println("Ket thuc chuong trinh.");
                    break;
                default:
                    System.out.println("Lua chon khong hop le.");
            }

        } while (choice != 0);
    }

    // ===== BAI 1: TWO SUM =====
    static void twoSum() {
        System.out.print("Nhap so phan tu mang: ");
        int n = scanner.nextInt();

        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            System.out.print("arr[" + i + "] = ");
            arr[i] = scanner.nextInt();
        }

        System.out.print("Nhap target: ");
        int target = scanner.nextInt();

        boolean found = false;

        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                if (arr[i] + arr[j] == target) {
                    System.out.println("Tim thay chi so: " + i + " va " + j);
                    found = true;
                    break;
                }
            }
            if (found)
                break;
        }

        if (!found) {
            System.out.println("Khong tim thay cap so.");
        }
    }

    // ===== BAI 2: MOVE ZEROES =====
    static void moveZeroes() {
        System.out.print("Nhap so phan tu mang: ");
        int n = scanner.nextInt();

        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            System.out.print("arr[" + i + "] = ");
            arr[i] = scanner.nextInt();
        }

        int index = 0;

        for (int i = 0; i < n; i++) {
            if (arr[i] != 0) {
                arr[index] = arr[i];
                index++;
            }
        }

        while (index < n) {
            arr[index] = 0;
            index++;
        }

        System.out.println(Arrays.toString(arr));
    }

    // ===== BAI 3: VALID PALINDROME =====
    static void validPalindrome() {
        scanner.nextLine();
        System.out.print("Nhap chuoi: ");
        String input = scanner.nextLine();

        String cleaned = input.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();

        int left = 0;
        int right = cleaned.length() - 1;
        boolean isPalindrome = true;

        while (left < right) {
            if (cleaned.charAt(left) != cleaned.charAt(right)) {
                isPalindrome = false;
                break;
            }
            left++;
            right--;
        }

        System.out.println(isPalindrome);
    }

    // ===== BAI 4: REVERSE WORDS =====
    static void reverseWords() {
        scanner.nextLine();
        System.out.print("Nhap chuoi: ");
        String input = scanner.nextLine();

        input = input.trim().replaceAll("\\s+", " ");

        if (input.isEmpty()) {
            System.out.println("Chuoi rong.");
            return;
        }

        String[] words = input.split(" ");
        String result = "";

        for (int i = words.length - 1; i >= 0; i--) {
            result = result + words[i] + " ";
        }

        System.out.println(result.trim());
    }

    // ===== BAI 5: HAPPY NUMBER (KHONG DUNG SET) =====
    static void happyNumber() {
        System.out.print("Nhap so nguyen duong n: ");
        int n = scanner.nextInt();

        int[] history = new int[100];
        int count = 0;

        while (n != 1) {

            for (int i = 0; i < count; i++) {
                if (history[i] == n) {
                    System.out.println("Khong phai so hanh phuc.");
                    return;
                }
            }

            history[count] = n;
            count++;

            n = sumSquareDigits(n);
        }

        System.out.println("La so hanh phuc.");
    }

    static int sumSquareDigits(int n) {
        int sum = 0;

        while (n > 0) {
            int digit = n % 10;
            sum = sum + digit * digit;
            n = n / 10;
        }

        return sum;
    }
}
