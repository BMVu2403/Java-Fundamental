package PTIT_CNTT1_IT203A_Session07;

public class Exercise04 {

    static class ClassRoom {
        private String studentName;
        private static double classFund = 0;

        public ClassRoom(String studentName) {
            this.studentName = studentName;
        }

        public void payFund(double amount) {
            classFund += amount;
            System.out.println(studentName + " dong: " + amount);
        }

        public static void showClassFund() {
            System.out.println("Tong quy lop: " + classFund);
        }
    }

    public static void main(String[] args) {

        ClassRoom s1 = new ClassRoom("Nguyen Van A");
        ClassRoom s2 = new ClassRoom("Tran Thi B");
        ClassRoom s3 = new ClassRoom("Le Van C");

        s1.payFund(100000);
        s2.payFund(150000);
        s3.payFund(200000);

        ClassRoom.showClassFund();
    }
}
