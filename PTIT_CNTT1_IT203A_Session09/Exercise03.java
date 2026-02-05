public class Exercise03 {

    static class Employee {
        protected String ten;
        protected long luongCoBan;

        public Employee(String ten, long luongCoBan) {
            this.ten = ten;
            this.luongCoBan = luongCoBan;
        }

        public void hienThiThongTin() {
            System.out.println("Ten: " + ten);
            System.out.println("Luong co ban: " + luongCoBan);
        }
    }

    static class Manager extends Employee {
        private String phongBan;

        public Manager(String ten, long luongCoBan, String phongBan) {
            super(ten, luongCoBan);
            this.phongBan = phongBan;
        }

        @Override
        public void hienThiThongTin() {
            super.hienThiThongTin();
            System.out.println("Phong ban: " + phongBan);
        }
    }

    public static void main(String[] args) {
        Manager m = new Manager("Tran Van B", 15000000L, "Nhan su");
        m.hienThiThongTin();
    }
}
