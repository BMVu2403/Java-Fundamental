
public class Exercise03 {
    public static void main(String[] args) {
        String[] transactions = { "BK001-20/01", "BK005-21/01", "BK099-22/01" };
        long startBuilder = System.currentTimeMillis();
        StringBuilder reportBuilder = new StringBuilder();
        reportBuilder.append("--- BAO CAO MUON SACH ---\n");
        reportBuilder.append("Ngay tao: 24/01/2026\n");
        for (String t : transactions) {
            reportBuilder.append("Giao dich: ").append(t).append("\n");
        }
        long endBuilder = System.currentTimeMillis();
        long startString = System.currentTimeMillis();
        String reportString = "";
        reportString += "--- BAO CAO MUON SACH ---\n";
        reportString += "Ngay tao: 24/01/2026\n";
        for (String t : transactions) {
            reportString += "Giao dich: " + t + "\n";
        }
        long endString = System.currentTimeMillis();
        System.out.println(reportBuilder.toString());
        System.out.println(reportString);
        System.out.println("So thoi gian thuc thi doi voi StringBuilder: " + (endBuilder - startBuilder));
        System.out.println("So thoi gian thuc thi doi voi String: " + (endString - startString));
    }
}
