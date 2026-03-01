package PTIT_CNTT1_IT203A_Session14;

import java.util.Comparator;
import java.util.Set;
import java.util.TreeSet;

class Patient {
    String name;
    int severity; // 1 = Nguy kich, 2 = Nang, 3 = Nhe
    int arrivalTime; // Thoi gian den, vi du: 800, 815, 805

    public Patient(String name, int severity, int arrivalTime) {
        this.name = name;
        this.severity = severity;
        this.arrivalTime = arrivalTime;
    }

    @Override
    public String toString() {
        return name + " (Muc " + severity + ", den luc " + arrivalTime + ")";
    }
}

public class Exercise05 {
    public static void main(String[] args) {

        // TreeSet voi Comparator tuy chinh
        Set<Patient> hangDoiCapCuu = new TreeSet<>(new Comparator<Patient>() {
            @Override
            public int compare(Patient p1, Patient p2) {

                // So sanh theo muc do nghiem trong (nho hon uu tien truoc)
                if (p1.severity != p2.severity) {
                    return p1.severity - p2.severity;
                }

                // Neu cung muc do, so sanh thoi gian den
                if (p1.arrivalTime != p2.arrivalTime) {
                    return p1.arrivalTime - p2.arrivalTime;
                }

                // Neu trung ca severity va arrivalTime
                return p1.name.compareTo(p2.name);
            }
        });

        // Them benh nhan
        hangDoiCapCuu.add(new Patient("Benh nhan A", 3, 800));
        hangDoiCapCuu.add(new Patient("Benh nhan B", 1, 815));
        hangDoiCapCuu.add(new Patient("Benh nhan C", 1, 805));
        hangDoiCapCuu.add(new Patient("Benh nhan D", 2, 810));

        // In thu tu xu ly
        System.out.println("Thu tu xu ly cap cuu:");
        for (Patient p : hangDoiCapCuu) {
            System.out.println(p);
        }
    }
}
