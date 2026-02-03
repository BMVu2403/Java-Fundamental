package PTIT_CNTT1_IT203A_Session08;

import java.util.Scanner;

public class StudyInClass {

    static class Student {
        private String id;
        private String name;
        private double score;

        public Student() {
        }

        public Student(String id, String name, double score) {
            this.id = id;
            this.name = name;
            this.score = score;
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public double getScore() {
            return score;
        }

        public void setScore(double score) {
            this.score = score;
        }

        public String getRank() {
            if (score >= 8.0) {
                return "Gioi";
            } else if (score >= 6.5) {
                return "Kha";
            } else {
                return "Trung Binh";
            }
        }

        @Override
        public String toString() {
            return "Ma SV: " + id +
                    " | Ten: " + name +
                    " | Diem: " + score +
                    " | Hoc luc: " + getRank();
        }
    }

    static Scanner scanner = new Scanner(System.in);
    static Student[] students;
    static int n = 0;

    public static void main(String[] args) {
        int choice;

        do {
            System.out.println("===== QUAN LY DIEM SINH VIEN =====");
            System.out.println("1. Nhap danh sach sinh vien");
            System.out.println("2. Hien thi danh sach sinh vien");
            System.out.println("3. Tim kiem sinh vien theo hoc luc");
            System.out.println("4. Sap xep theo hoc luc giam dan");
            System.out.println("5. Thoat");
            System.out.println("=================================");
            System.out.print("Chon chuc nang: ");

            choice = scanner.nextInt();
            scanner.nextLine(); 

            switch (choice) {
                case 1:
                    inputStudents();
                    break;
                case 2:
                    displayStudents();
                    break;
                case 3:
                    searchByRank();
                    break;
                case 4:
                    sortByScoreDesc();
                    System.out.println("Da sap xep xong!");
                    break;
                case 5:
                    System.out.println("Thoat chuong trinh!");
                    break;
                default:
                    System.out.println("Lua chon khong hop le!");
            }
        } while (choice != 5);
    }

    // Chức năng 1: Nhập danh sách 
    static void inputStudents() {
        System.out.print("Nhap so luong sinh vien: ");
        n = scanner.nextInt();
        scanner.nextLine();

        students = new Student[n];

        for (int i = 0; i < n; i++) {
            System.out.println("Sinh vien thu " + (i + 1));

            String id;
            while (true) {
                System.out.print("Ma SV (SVxxx): ");
                id = scanner.nextLine();
                if (id.matches("SV\\d{3}")) {
                    break;
                }
                System.out.println("Ma sinh vien khong hop le!");
            }

            System.out.print("Ten sinh vien: ");
            String name = scanner.nextLine();

            System.out.print("Diem trung binh: ");
            double score = scanner.nextDouble();
            scanner.nextLine();

            students[i] = new Student(id, name, score);
        }
    }

    // Chức năng 2: Hiển thị 
    static void displayStudents() {
        if (students == null || n == 0) {
            System.out.println("Danh sach rong!");
            return;
        }

        for (Student s : students) {
            System.out.println(s);
        }
    }

    // Chức năng 3: Tìm kiếm theo học lực 
    static void searchByRank() {
        System.out.print("Nhap hoc luc (Gioi/Kha/Trung Binh): ");
        String rank = scanner.nextLine();

        boolean found = false;
        for (Student s : students) {
            if (s.getRank().equalsIgnoreCase(rank)) {
                System.out.println(s);
                found = true;
            }
        }

        if (!found) {
            System.out.println("Khong tim thay sinh vien!");
        }
    }

    // Chức năng 4: Sắp xếp giảm dần 
    static void sortByScoreDesc() {
        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                if (students[i].getScore() < students[j].getScore()) {
                    Student temp = students[i];
                    students[i] = students[j];
                    students[j] = temp;
                }
            }
        }
    }
}
