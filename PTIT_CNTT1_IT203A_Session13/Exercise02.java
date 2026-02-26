import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Exercise02 {

    public static List<String> removeDuplicateAndSort(List<String> drugs) {
        List<String> result = new ArrayList<>();

        for (String drug : drugs) {
            if (!result.contains(drug)) {
                result.add(drug);
            }
        }

        Collections.sort(result);
        return result;
    }

    public static void main(String[] args) {

        List<String> input = Arrays.asList(
                "Paracetamol",
                "Ibuprofen",
                "Panadol",
                "Paracetamol",
                "Aspirin",
                "Ibuprofen");

        System.out.println("Danh sach ban dau: " + input);

        List<String> output = removeDuplicateAndSort(input);

        System.out.println("Danh sach sau khi xu ly: " + output);
    }
}
