package PTIT_CNTT1_IT203A_Session07;

public class Exercise05 {

    static class Config {
        public static final int MAX_SCORE = 10;
        public static final int MIN_SCORE = 0;
    }

    public static void main(String[] args) {

        int score = 8;

        if (score >= Config.MIN_SCORE && score <= Config.MAX_SCORE) {
            System.out.println("Diem hop le: " + score);
        } else {
            System.out.println("Diem khong hop le");
        }

        System.out.println("Diem toi da: " + Config.MAX_SCORE);
        System.out.println("Diem toi thieu: " + Config.MIN_SCORE);
    }
}
