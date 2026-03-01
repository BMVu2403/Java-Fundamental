package PTIT_CNTT1_IT203A_Session14;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class Exercise04 {
    public static void main(String[] args) {

        // Danh sach ca benh bao cao trong ngay
        List<String> danhSachCaBenh = new ArrayList<>();
        danhSachCaBenh.add("Cum A");
        danhSachCaBenh.add("Sot xuat huyet");
        danhSachCaBenh.add("Cum A");
        danhSachCaBenh.add("Covid-19");
        danhSachCaBenh.add("Cum A");
        danhSachCaBenh.add("Sot xuat huyet");

        // TreeMap de thong ke va sap xep theo ten benh
        Map<String, Integer> thongKe = new TreeMap<>();

        for (String benh : danhSachCaBenh) {
            if (thongKe.containsKey(benh)) {
                thongKe.put(benh, thongKe.get(benh) + 1);
            } else {
                thongKe.put(benh, 1);
            }
        }

        // In bao cao
        System.out.println("Bao cao thong ke dich te:");
        for (Map.Entry<String, Integer> entry : thongKe.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue() + " ca");
        }
    }
}
