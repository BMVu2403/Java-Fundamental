import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Exercise03 {

    public static <T> List<T> findCommonPatients(List<T> listA, List<T> listB) {
        List<T> result = new ArrayList<>();

        for (T item : listA) {
            if (listB.contains(item)) {
                result.add(item);
            }
        }

        return result;
    }

    public static void main(String[] args) {

        // Test case 1: Integer
        List<Integer> khoaNoi = Arrays.asList(101, 102, 105);
        List<Integer> khoaNgoai = Arrays.asList(102, 105, 108);

        List<Integer> commonInt = findCommonPatients(khoaNoi, khoaNgoai);
        System.out.println("Test Case 1 Output: " + commonInt);

        // Test case 2: String
        List<String> khoaNoiStr = Arrays.asList("DN01", "DN02", "DN03");
        List<String> khoaNgoaiStr = Arrays.asList("DN02", "DN04");

        List<String> commonStr = findCommonPatients(khoaNoiStr, khoaNgoaiStr);
        System.out.println("Test Case 2 Output: " + commonStr);
    }
}
