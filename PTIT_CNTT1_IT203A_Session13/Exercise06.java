import java.util.*;

public class Exercise06 {

    static class Medicine {
        String drugId;
        String drugName;
        double unitPrice;
        int quantity;

        Medicine(String drugId, String drugName, double unitPrice, int quantity) {
            this.drugId = drugId;
            this.drugName = drugName;
            this.unitPrice = unitPrice;
            this.quantity = quantity;
        }

        double getTotalPrice() {
            return unitPrice * quantity;
        }
    }

    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            List<Medicine> cart = new ArrayList<>();

            while (true) {
                System.out.println("\nMENU KE DON THUOC");
                System.out.println("1. Them thuoc vao don");
                System.out.println("2. Dieu chinh so luong");
                System.out.println("3. Xoa thuoc");
                System.out.println("4. In hoa don");
                System.out.println("5. Tim thuoc gia re");
                System.out.println("6. Thoat");
                System.out.print("Chon: ");

                int choice = Integer.parseInt(sc.nextLine());

                switch (choice) {

                    case 1:
                        System.out.print("Nhap ma thuoc: ");
                        String id = sc.nextLine();

                        Medicine exist = null;
                        for (Medicine m : cart) {
                            if (m.drugId.equals(id)) {
                                exist = m;
                                break;
                            }
                        }

                        if (exist != null) {
                            System.out.print("Nhap so luong them: ");
                            int addQty = Integer.parseInt(sc.nextLine());
                            exist.quantity += addQty;
                            System.out.println("Da cong don so luong");
                        } else {
                            System.out.print("Nhap ten thuoc: ");
                            String name = sc.nextLine();

                            System.out.print("Nhap don gia: ");
                            double price = Double.parseDouble(sc.nextLine());

                            System.out.print("Nhap so luong: ");
                            int qty = Integer.parseInt(sc.nextLine());

                            cart.add(new Medicine(id, name, price, qty));
                            System.out.println("Them thuoc thanh cong");
                        }
                        break;

                    case 2:
                        System.out.print("Nhap ma thuoc: ");
                        String updateId = sc.nextLine();
                        boolean foundUpdate = false;

                        Iterator<Medicine> itUpdate = cart.iterator();
                        while (itUpdate.hasNext()) {
                            Medicine m = itUpdate.next();
                            if (m.drugId.equals(updateId)) {
                                System.out.print("Nhap so luong moi: ");
                                int newQty = Integer.parseInt(sc.nextLine());

                                if (newQty == 0) {
                                    itUpdate.remove();
                                    System.out.println("Da xoa thuoc do so luong = 0");
                                } else {
                                    m.quantity = newQty;
                                    System.out.println("Cap nhat so luong thanh cong");
                                }
                                foundUpdate = true;
                                break;
                            }
                        }

                        if (!foundUpdate) {
                            System.out.println("Khong tim thay thuoc");
                        }
                        break;

                    case 3:
                        System.out.print("Nhap ma thuoc can xoa: ");
                        String removeId = sc.nextLine();
                        boolean removed = false;

                        Iterator<Medicine> itRemove = cart.iterator();
                        while (itRemove.hasNext()) {
                            if (itRemove.next().drugId.equals(removeId)) {
                                itRemove.remove();
                                removed = true;
                                System.out.println("Da xoa thuoc");
                                break;
                            }
                        }

                        if (!removed) {
                            System.out.println("Khong tim thay thuoc");
                        }
                        break;

                    case 4:
                        if (cart.isEmpty()) {
                            System.out.println("Don thuoc rong");
                            break;
                        }

                        double totalBill = 0;
                        System.out.println("\nMA | TEN | GIA | SO LUONG | THANH TIEN");

                        for (Medicine m : cart) {
                            double itemTotal = m.getTotalPrice();
                            totalBill += itemTotal;
                            System.out.println(
                                    m.drugId + " | " +
                                            m.drugName + " | " +
                                            m.unitPrice + " | " +
                                            m.quantity + " | " +
                                            itemTotal);
                        }

                        System.out.println("Tong tien phai tra: " + totalBill);
                        cart.clear();
                        System.out.println("Da xoa don thuoc de tao don moi");
                        break;

                    case 5:
                        boolean foundCheap = false;
                        System.out.println("Thuoc co gia duoi 50000:");

                        for (Medicine m : cart) {
                            if (m.unitPrice < 50000) {
                                System.out.println(
                                        m.drugId + " | " +
                                                m.drugName + " | " +
                                                m.unitPrice);
                                foundCheap = true;
                            }
                        }

                        if (!foundCheap) {
                            System.out.println("Khong co thuoc nao phu hop");
                        }
                        break;

                    case 6:
                        System.out.println("Thoat chuong trinh");
                        return;

                    default:
                        System.out.println("Lua chon khong hop le");
                }
            }
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
    }
}
