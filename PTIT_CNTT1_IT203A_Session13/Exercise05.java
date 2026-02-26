import java.util.*;

public class Exercise05 {

    static class Patient {
        String id;
        String fullName;
        int age;
        String diagnosis;

        Patient(String id, String fullName, int age, String diagnosis) {
            this.id = id;
            this.fullName = fullName;
            this.age = age;
            this.diagnosis = diagnosis;
        }

        void display() {
            System.out.println(id + " | " + fullName + " | " + age + " | " + diagnosis);
        }
    }

    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            ArrayList<Patient> list = new ArrayList<>();

            while (true) {
                System.out.println("\nMENU QUAN LY BENH AN");
                System.out.println("1. Tiep nhan benh nhan");
                System.out.println("2. Cap nhat chan doan");
                System.out.println("3. Xuat vien");
                System.out.println("4. Sap xep danh sach");
                System.out.println("5. Thoat");
                System.out.print("Chon: ");

                int choice = Integer.parseInt(sc.nextLine());

                switch (choice) {

                    case 1:
                        System.out.print("Nhap ID: ");
                        String id = sc.nextLine();

                        boolean exists = false;
                        for (Patient p : list) {
                            if (p.id.equals(id)) {
                                exists = true;
                                break;
                            }
                        }

                        if (exists) {
                            System.out.println("ID da ton tai");
                            break;
                        }

                        System.out.print("Nhap ho ten: ");
                        String name = sc.nextLine();

                        System.out.print("Nhap tuoi: ");
                        int age = Integer.parseInt(sc.nextLine());

                        System.out.print("Nhap chan doan: ");
                        String diagnosis = sc.nextLine();

                        list.add(new Patient(id, name, age, diagnosis));
                        System.out.println("Tiep nhan thanh cong");
                        break;

                    case 2:
                        System.out.print("Nhap ID can cap nhat: ");
                        String updateId = sc.nextLine();
                        boolean foundUpdate = false;

                        for (Patient p : list) {
                            if (p.id.equals(updateId)) {
                                System.out.print("Nhap chan doan moi: ");
                                p.diagnosis = sc.nextLine();
                                foundUpdate = true;
                                System.out.println("Cap nhat thanh cong");
                                break;
                            }
                        }

                        if (!foundUpdate) {
                            System.out.println("Khong tim thay benh nhan");
                        }
                        break;

                    case 3:
                        System.out.print("Nhap ID can xuat vien: ");
                        String removeId = sc.nextLine();
                        boolean removed = false;

                        Iterator<Patient> it = list.iterator();
                        while (it.hasNext()) {
                            Patient p = it.next();
                            if (p.id.equals(removeId)) {
                                it.remove();
                                removed = true;
                                System.out.println("Da xuat vien benh nhan");
                                break;
                            }
                        }

                        if (!removed) {
                            System.out.println("Khong tim thay benh nhan");
                        }
                        break;

                    case 4:
                        list.sort(new Comparator<Patient>() {
                            @Override
                            public int compare(Patient o1, Patient o2) {
                                if (o2.age != o1.age) {
                                    return o2.age - o1.age;
                                }
                                return o1.fullName.compareToIgnoreCase(o2.fullName);
                            }
                        });

                        System.out.println("Danh sach sau khi sap xep:");
                        for (Patient p : list) {
                            p.display();
                        }
                        break;

                    case 5:
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
