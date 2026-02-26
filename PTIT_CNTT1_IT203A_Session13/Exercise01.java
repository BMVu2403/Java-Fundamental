import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;

public class Exercise01 {
    public static void main(String[] args) {

        ArrayList<Double> temps = new ArrayList<>(
                Arrays.asList(36.5, 40.2, 37.0, 12.5, 39.8, 99.9, 36.8));

        System.out.println("Danh sach ban dau: " + temps);

        Iterator<Double> iterator = temps.iterator();
        while (iterator.hasNext()) {
            double temp = iterator.next();
            if (temp < 34.0 || temp > 42.0) {
                iterator.remove();
            }
        }

        System.out.println("Danh sach sau khi loc: " + temps);

        double sum = 0;
        for (double temp : temps) {
            sum += temp;
        }

        double average = sum / temps.size();
        System.out.printf("Nhiet do trung binh: %.2f\n", average);
    }
}
