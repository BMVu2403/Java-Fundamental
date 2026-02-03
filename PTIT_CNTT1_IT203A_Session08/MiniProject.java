package PTIT_CNTT1_IT203A_Session08;

import java.util.Scanner;

/* ===================== MINI PROJECT ===================== */
public class MiniProject {
    private static final int DEFAULT_CAPACITY = 100;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StudentManager manager = new StudentManager(DEFAULT_CAPACITY);

        while (true) {
            printMenu();
            int choice = readIntInRange(sc, "Chon chuc nang (1-9): ", 1, 9);

            switch (choice) {
                case 1:
                    addStudentUI(sc, manager);
                    break;
                case 2:
                    manager.displayStudentList();
                    break;
                case 3:
                    System.out.print("Nhap ma SV hoac ten can tim: ");
                    String keyword = sc.nextLine();
                    manager.findByKeyword(keyword);
                    break;
                case 4:
                    updateStudentUI(sc, manager);
                    break;
                case 5:
                    System.out.print("Nhap ma SV can xoa: ");
                    String maXoa = sc.nextLine();
                    manager.deleteStudentById(maXoa);
                    break;
                case 6:
                    System.out.print("Nhap ma SV can tinh DTB & xep loai: ");
                    String maTinh = sc.nextLine();
                    manager.printAvgAndRank(maTinh);
                    break;
                case 7:
                    sortUI(sc, manager);
                    break;
                case 8:
                    manager.thongKe();
                    break;
                case 9:
                    System.out.println("Tam biet!");
                    return;
            }
            System.out.println();
        }
    }

    /* ===================== UI METHODS ===================== */
    private static void printMenu() {
        System.out.println("===== QUAN LY SINH VIEN =====");
        System.out.println("1. Them sinh vien moi");
        System.out.println("2. Hien thi tat ca sinh vien");
        System.out.println("3. Tim kiem sinh vien");
        System.out.println("4. Cap nhat thong tin sinh vien");
        System.out.println("5. Xoa sinh vien");
        System.out.println("6. Tinh diem trung binh va xep loai");
        System.out.println("7. Sap xep sinh vien");
        System.out.println("8. Thong ke");
        System.out.println("9. Thoat");
    }

    private static void addStudentUI(Scanner sc, StudentManager manager) {
        String maSV;
        do {
            System.out.print("Nhap ma SV: ");
            maSV = sc.nextLine();
            if (maSV.isBlank() || manager.findByMaSV(maSV) != null) {
                System.out.println("Ma SV khong hop le hoac da ton tai!");
                maSV = "";
            }
        } while (maSV.isBlank());

        System.out.print("Nhap ho ten: ");
        String hoTen = sc.nextLine();

        int tuoi = readIntInRange(sc, "Nhap tuoi (18-30): ", 18, 30);

        String gioiTinh;
        do {
            System.out.print("Nhap gioi tinh (Nam/Nu): ");
            gioiTinh = sc.nextLine();
        } while (!gioiTinh.equalsIgnoreCase("Nam") && !gioiTinh.equalsIgnoreCase("Nu"));

        double diemToan = readDoubleInRange(sc, "Nhap diem toan (0-10): ", 0, 10);
        double diemLy = readDoubleInRange(sc, "Nhap diem ly (0-10): ", 0, 10);
        double diemHoa = readDoubleInRange(sc, "Nhap diem hoa (0-10): ", 0, 10);

        manager.addStudent(new Student(maSV, hoTen, tuoi, gioiTinh, diemToan, diemLy, diemHoa));
    }

    private static void updateStudentUI(Scanner sc, StudentManager manager) {
        System.out.print("Nhap ma SV can cap nhat: ");
        String maSV = sc.nextLine();

        if (manager.findByMaSV(maSV) == null) {
            System.out.println("Khong tim thay sinh vien!");
            return;
        }

        System.out.print("Nhap ho ten moi: ");
        String hoTen = sc.nextLine();
        int tuoi = readIntInRange(sc, "Nhap tuoi (18-30): ", 18, 30);

        String gioiTinh;
        do {
            System.out.print("Nhap gioi tinh (Nam/Nu): ");
            gioiTinh = sc.nextLine();
        } while (!gioiTinh.equalsIgnoreCase("Nam") && !gioiTinh.equalsIgnoreCase("Nu"));

        double diemToan = readDoubleInRange(sc, "Nhap diem toan (0-10): ", 0, 10);
        double diemLy = readDoubleInRange(sc, "Nhap diem ly (0-10): ", 0, 10);
        double diemHoa = readDoubleInRange(sc, "Nhap diem hoa (0-10): ", 0, 10);

        manager.updateStudent(maSV, hoTen, tuoi, gioiTinh, diemToan, diemLy, diemHoa);
    }

    private static void sortUI(Scanner sc, StudentManager manager) {
        System.out.println("1. Sap xep theo DTB giam dan");
        System.out.println("2. Sap xep theo ten A-Z");
        int c = readIntInRange(sc, "Chon (1-2): ", 1, 2);
        if (c == 1)
            manager.sortByAvgBubble();
        else
            manager.sortByNameSelection();
    }

    private static int readIntInRange(Scanner sc, String prompt, int min, int max) {
        while (true) {
            try {
                System.out.print(prompt);
                int v = Integer.parseInt(sc.nextLine());
                if (v >= min && v <= max)
                    return v;
            } catch (Exception ignored) {
            }
            System.out.println("Gia tri khong hop le!");
        }
    }

    private static double readDoubleInRange(Scanner sc, String prompt, double min, double max) {
        while (true) {
            try {
                System.out.print(prompt);
                double v = Double.parseDouble(sc.nextLine());
                if (v >= min && v <= max)
                    return v;
            } catch (Exception ignored) {
            }
            System.out.println("Gia tri khong hop le!");
        }
    }
}

/* ===================== STUDENT ===================== */
class Student {
    private String maSV, hoTen, gioiTinh;
    private int tuoi;
    private double diemToan, diemLy, diemHoa, diemTB;
    private String xepLoai;

    public Student(String maSV, String hoTen, int tuoi, String gioiTinh,
            double diemToan, double diemLy, double diemHoa) {
        this.maSV = maSV;
        this.hoTen = hoTen;
        this.tuoi = tuoi;
        this.gioiTinh = gioiTinh;
        this.diemToan = diemToan;
        this.diemLy = diemLy;
        this.diemHoa = diemHoa;
        tinhDiemVaXepLoai();
    }

    public void tinhDiemVaXepLoai() {
        diemTB = (diemToan + diemLy + diemHoa) / 3;
        if (diemTB >= 8)
            xepLoai = "Gioi";
        else if (diemTB >= 6.5)
            xepLoai = "Kha";
        else if (diemTB >= 5)
            xepLoai = "Trung binh";
        else
            xepLoai = "Yeu";
    }

    public void studentInfo() {
        System.out.printf("%-10s %-17s %-5d %-8s %-6.2f %-12s\n",
                maSV, hoTen, tuoi, gioiTinh, diemTB, xepLoai);
    }

    public String getMaSV() {
        return maSV;
    }

    public String getHoTen() {
        return hoTen;
    }

    public double getDiemTB() {
        return diemTB;
    }

    public String getXepLoai() {
        return xepLoai;
    }

    public void setHoTen(String hoTen) {
        this.hoTen = hoTen;
    }

    public void setTuoi(int tuoi) {
        this.tuoi = tuoi;
    }

    public void setGioiTinh(String gioiTinh) {
        this.gioiTinh = gioiTinh;
    }

    public void setDiemToan(double d) {
        diemToan = d;
    }

    public void setDiemLy(double d) {
        diemLy = d;
    }

    public void setDiemHoa(double d) {
        diemHoa = d;
    }
}

/* ===================== STUDENT MANAGER ===================== */
class StudentManager {
    private Student[] students;
    private int size;

    public StudentManager(int cap) {
        students = new Student[cap];
        size = 0;
    }

    public Student findByMaSV(String ma) {
        for (int i = 0; i < size; i++)
            if (students[i].getMaSV().equalsIgnoreCase(ma))
                return students[i];
        return null;
    }

    public void addStudent(Student s) {
        students[size++] = s;
        System.out.println("Them sinh vien thanh cong!");
    }

    public void displayStudentList() {
        if (size == 0) {
            System.out.println("Danh sach rong!");
            return;
        }
        for (int i = 0; i < size; i++)
            students[i].studentInfo();
    }

    public void findByKeyword(String kw) {
        for (int i = 0; i < size; i++)
            if (students[i].getMaSV().equalsIgnoreCase(kw)
                    || students[i].getHoTen().toLowerCase().contains(kw.toLowerCase()))
                students[i].studentInfo();
    }

    public void updateStudent(String ma, String ten, int tuoi, String gt,
            double t, double l, double h) {
        Student s = findByMaSV(ma);
        if (s == null)
            return;
        s.setHoTen(ten);
        s.setTuoi(tuoi);
        s.setGioiTinh(gt);
        s.setDiemToan(t);
        s.setDiemLy(l);
        s.setDiemHoa(h);
        s.tinhDiemVaXepLoai();
        System.out.println("Cap nhat thanh cong!");
    }

    public void deleteStudentById(String ma) {
        for (int i = 0; i < size; i++) {
            if (students[i].getMaSV().equals(ma)) {
                for (int j = i; j < size - 1; j++)
                    students[j] = students[j + 1];
                size--;
                System.out.println("Da xoa sinh vien!");
                return;
            }
        }
    }

    public void printAvgAndRank(String ma) {
        Student s = findByMaSV(ma);
        if (s != null)
            System.out.println("DTB: " + s.getDiemTB() + " | Xep loai: " + s.getXepLoai());
    }

    public void sortByAvgBubble() {
        for (int i = 0; i < size - 1; i++)
            for (int j = 0; j < size - i - 1; j++)
                if (students[j].getDiemTB() < students[j + 1].getDiemTB()) {
                    Student t = students[j];
                    students[j] = students[j + 1];
                    students[j + 1] = t;
                }
    }

    public void sortByNameSelection() {
        for (int i = 0; i < size - 1; i++) {
            int min = i;
            for (int j = i + 1; j < size; j++)
                if (students[j].getHoTen()
                        .compareToIgnoreCase(students[min].getHoTen()) < 0)
                    min = j;
            Student t = students[i];
            students[i] = students[min];
            students[min] = t;
        }
    }

    public void thongKe() {
        int g = 0, k = 0, tb = 0, y = 0;
        for (int i = 0; i < size; i++) {
            switch (students[i].getXepLoai()) {
                case "Gioi":
                    g++;
                    break;
                case "Kha":
                    k++;
                    break;
                case "Trung binh":
                    tb++;
                    break;
                default:
                    y++;
            }
        }
        System.out.println("Gioi: " + g + ", Kha: " + k + ", TB: " + tb + ", Yeu: " + y);
    }
}
