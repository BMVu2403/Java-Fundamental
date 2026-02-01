package PTIT_CNTT1_IT203A_Session06;

public class Exercise05 {

    static class Book {
        String maSach;
        String tenSach;
        String tacGia;
        double gia;

        public Book(String maSach, String tenSach, String tacGia, double gia) {
            this.maSach = maSach;
            this.tenSach = tenSach;
            this.tacGia = tacGia;
            this.gia = gia;
        }

        public void hienThiThongTin() {
            System.out.println("Ma sach: " + maSach);
            System.out.println("Ten sach: " + tenSach);
            System.out.println("Tac gia: " + tacGia);
            System.out.println("Gia: " + gia);
            System.out.println("--------------------");
        }
    }

    public static void main(String[] args) {
        Book b = new Book("S01", "Lap trinh Java", "Nguyen Van A", 120000);
        b.hienThiThongTin();
    }
}
