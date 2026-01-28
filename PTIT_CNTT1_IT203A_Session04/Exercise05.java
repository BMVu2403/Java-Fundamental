import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Exercise05 {
    public static void main(String[] args) {
        String[] logs = {
                "2024-05-20 | User: NguyenVanA | Action: BORROW | BookID: BK12345",
                "2024-05-21 | User: TranThiB | Action: RETURN | BookID: BK67890",
                "2024-05-22 | User: LeVanC | Action: BORROW | BookID: BK11111"
        };
        int borrow = 0, returnCount = 0;
        String regex = "(\\d{4}-\\d{2}-\\d{2}) \\| User: (\\w+) \\| Action: (\\w+) \\| BookID: (\\w+)";
        Pattern p = Pattern.compile(regex);
        for (String log : logs) {
            Matcher m = p.matcher(log);
            if (m.find()) {
                String date = m.group(1);
                String user = m.group(2);
                String action = m.group(3);
                String bookId = m.group(4);
                System.out.println("Ngay: " + date);
                System.out.println("User: " + user);
                System.out.println("Action: " + action);
                System.out.println("BookID: " + bookId);
                System.out.println("----------------");
                if (action.equals("BORROW"))
                    borrow++;
                if (action.equals("RETURN"))
                    returnCount++;
            }
        }
        System.out.println("Tong BORROW: " + borrow);
        System.out.println("Tong RETURN: " + returnCount);
    }
}
