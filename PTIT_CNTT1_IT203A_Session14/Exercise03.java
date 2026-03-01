package PTIT_CNTT1_IT203A_Session14;

import java.util.HashSet;
import java.util.Set;

public class Exercise03 {
    public static void main(String[] args) {

        // Set A: thanh phan trong thuoc moi
        Set<String> thanhPhanThuoc = new HashSet<>();
        thanhPhanThuoc.add("Aspirin");
        thanhPhanThuoc.add("Caffeine");
        thanhPhanThuoc.add("Paracetamol");

        // Set B: cac chat benh nhan bi di ung
        Set<String> chatDiUng = new HashSet<>();
        chatDiUng.add("Penicillin");
        chatDiUng.add("Aspirin");

        // Tim giao nhau (canh bao di ung)
        Set<String> canhBaoDiUng = new HashSet<>(thanhPhanThuoc);
        canhBaoDiUng.retainAll(chatDiUng);

        // Tim thanh phan an toan (hieu)
        Set<String> thanhPhanAnToan = new HashSet<>(thanhPhanThuoc);
        thanhPhanAnToan.removeAll(chatDiUng);

        // In ket qua
        System.out.println("Canh bao di ung: " + canhBaoDiUng);
        System.out.println("Thanh phan an toan: " + thanhPhanAnToan);
    }
}
