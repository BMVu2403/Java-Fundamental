package PTIT_CNTT1_IT203A_Session14;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Patient {
    String name;
    int age;
    String khoa;

    public Patient(String name, int age, String khoa) {
        this.name = name;
        this.age = age;
        this.khoa = khoa;
    }

    @Override
    public String toString() {
        return name + " (" + age + " tuoi)";
    }
}

public class Exercise06 {
    public static void main(String[] args) {

        List<Patient> danhSachBenhNhan = new ArrayList<>();
        danhSachBenhNhan.add(new Patient("Lan", 30, "Tim mach"));
        danhSachBenhNhan.add(new Patient("Hung", 45, "Noi tiet"));
        danhSachBenhNhan.add(new Patient("Mai", 25, "Tim mach"));
        danhSachBenhNhan.add(new Patient("An", 60, "Tim mach"));

        Map<String, List<Patient>> benhNhanTheoKhoa = new HashMap<>();

        for (Patient p : danhSachBenhNhan) {
            if (!benhNhanTheoKhoa.containsKey(p.khoa)) {
                benhNhanTheoKhoa.put(p.khoa, new ArrayList<>());
            }
            benhNhanTheoKhoa.get(p.khoa).add(p);
        }

        System.out.println("Danh sach benh nhan theo khoa:");
        for (String khoa : benhNhanTheoKhoa.keySet()) {
            System.out.println("Khoa: " + khoa);
            for (Patient p : benhNhanTheoKhoa.get(khoa)) {
                System.out.println("  - " + p);
            }
        }
    }
}
