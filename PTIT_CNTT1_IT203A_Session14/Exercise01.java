package PTIT_CNTT1_IT203A_Session14;

import java.util.LinkedHashSet;
import java.util.Set;

public class Exercise01 {
    public static void main(String[] args) {

        String[] input = {
                "Nguyen Van A - Yen Bai",
                "Tran Thi B - Thai Binh",
                "Nguyen Van A - Yen Bai",
                "Le Van C - Hung Yen"
        };

        Set<String> danhSachCho = new LinkedHashSet<>();

        for (String benhNhan : input) {
            danhSachCho.add(benhNhan);
        }

        System.out.println("Danh sach goi kham:");
        for (String benhNhan : danhSachCho) {
            System.out.println(benhNhan);
        }
    }
}
