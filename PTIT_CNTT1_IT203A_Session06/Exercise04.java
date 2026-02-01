package PTIT_CNTT1_IT203A_Session06;

public class Exercise04 {

    static class Employee {
        String maNV;
        String tenNV;
        double luong;

        public Employee() {
            this.maNV = "Chua co";
            this.tenNV = "Chua co";
            this.luong = 0;
        }

        public Employee(String maNV, String tenNV) {
            this.maNV = maNV;
            this.tenNV = tenNV;
            this.luong = 0;
        }

        public Employee(String maNV, String tenNV, double luong) {
            this.maNV = maNV;
            this.tenNV = tenNV;
            this.luong = luong;
        }

        public void hienThiThongTin() {
            System.out.println("Ma NV: " + maNV);
            System.out.println("Ten NV: " + tenNV);
            System.out.println("Luong: " + luong);
            System.out.println("--------------------");
        }
    }

    public static void main(String[] args) {
        Employee e1 = new Employee();
        Employee e2 = new Employee("NV01", "Nguyen Van A");
        Employee e3 = new Employee("NV02", "Tran Thi B", 15000000);

        e1.hienThiThongTin();
        e2.hienThiThongTin();
        e3.hienThiThongTin();
    }
}
