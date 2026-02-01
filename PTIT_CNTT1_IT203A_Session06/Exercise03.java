package PTIT_CNTT1_IT203A_Session06;

public class Exercise03 {

    static class Product {
        private String maSP;
        private String tenSP;
        private double giaBan;

        public Product(String maSP, String tenSP, double giaBan) {
            this.maSP = maSP;
            this.tenSP = tenSP;
            setGiaBan(giaBan);
        }

        public String getMaSP() {
            return maSP;
        }

        public void setMaSP(String maSP) {
            this.maSP = maSP;
        }

        public String getTenSP() {
            return tenSP;
        }

        public void setTenSP(String tenSP) {
            this.tenSP = tenSP;
        }

        public double getGiaBan() {
            return giaBan;
        }

        public void setGiaBan(double giaBan) {
            if (giaBan > 0) {
                this.giaBan = giaBan;
            } else {
                System.out.println("Gia ban khong hop le");
            }
        }

        public void hienThiThongTin() {
            System.out.println("Ma SP: " + maSP);
            System.out.println("Ten SP: " + tenSP);
            System.out.println("Gia ban: " + giaBan);
            System.out.println("--------------------");
        }
    }

    public static void main(String[] args) {
        Product p = new Product("SP01", "Ban phim", 500000);

        p.hienThiThongTin();

        p.setGiaBan(-100000);

        p.hienThiThongTin();
    }
}
