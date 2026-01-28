import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Exercise06 {
    public static void main(String[] args) {

        String review = "Cuon sach nay qua te va rat ngu si. Noi dung cuc ky chan va te hai. Doc rat buc minh va kho chiu. Tac gia viet qua do";

        List<String> blacklist = new ArrayList<>();
        blacklist.add("te");
        blacklist.add("ngu si");
        blacklist.add("te hai");
        blacklist.add("chan");

        String result = review;

        for (String bad : blacklist) {
            String regex = "(?i)\\b" + Pattern.quote(bad) + "\\b";
            Pattern p = Pattern.compile(regex);
            Matcher m = p.matcher(result);
            StringBuffer sb = new StringBuffer();

            while (m.find()) {
                String stars = "";
                for (int i = 0; i < m.group().length(); i++)
                    stars += "*";
                m.appendReplacement(sb, stars);
            }

            m.appendTail(sb);
            result = sb.toString();
        }

        if (result.length() > 200) {
            int cut = 200;
            while (cut > 0 && result.charAt(cut) != ' ')
                cut--;
            StringBuilder builder = new StringBuilder();
            builder.append(result.substring(0, cut));
            builder.append("...");
            result = builder.toString();
        }

        System.out.println("Noi dung sau khi loc:");
        System.out.println(result);
    }
}
