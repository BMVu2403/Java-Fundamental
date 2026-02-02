package PTIT_CNTT1_IT203A_Session07;

public class Exercise03 {

    static class ScoreUtils {

        public static boolean isPass(double score) {
            return score >= 5.0;
        }

        public static double average(double s1, double s2, double s3) {
            return (s1 + s2 + s3) / 3;
        }
    }

    public static void main(String[] args) {

        double score1 = 6.5;
        double score2 = 7.0;
        double score3 = 4.5;

        double avg = ScoreUtils.average(score1, score2, score3);

        System.out.println("Diem trung binh: " + avg);
        System.out.println("Ket qua: " + (ScoreUtils.isPass(avg) ? "Dat" : "Khong dat"));
    }
}
