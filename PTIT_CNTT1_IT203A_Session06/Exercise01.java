package PTIT_CNTT1_IT203A_Session06;

public class Exercise01 {

    static class Student {
        String maSV;
        String hoTen;
        int namSinh;
        double diemTrungBinh;

        public Student(String maSV, String hoTen, int namSinh, double diemTrungBinh) {
            this.maSV = maSV;
            this.hoTen = hoTen;
            this.namSinh = namSinh;
            this.diemTrungBinh = diemTrungBinh;
        }

        public void hienThiThongTin() {
            System.out.println("Ma sinh vien: " + maSV);
            System.out.println("Ho ten: " + hoTen);
            System.out.println("Nam sinh: " + namSinh);
            System.out.println("Diem trung binh: " + diemTrungBinh);
            System.out.println("-------------------------");
        }
    }

    public static void main(String[] args) {
        Student sv1 = new Student("SV001", "Nguyen Van A", 2003, 8.5);
        Student sv2 = new Student("SV002", "Tran Thi B", 2004, 7.8);

        sv1.hienThiThongTin();
        sv2.hienThiThongTin();
    }
}
