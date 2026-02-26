import java.util.LinkedList;

public class Exercise04 {

    static class EmergencyRoom {
        private LinkedList<String> queue = new LinkedList<>();

        // Benh nhan thuong
        public void patientCheckIn(String name) {
            queue.addLast(name);
        }

        // Cap cuu nguy kich
        public void emergencyCheckIn(String name) {
            queue.addFirst(name);
        }

        // Bac si goi benh nhan
        public void treatPatient() {
            if (queue.isEmpty()) {
                System.out.println("Khong con benh nhan nao");
                return;
            }

            String patient = queue.removeFirst();
            System.out.println("Dang cap cuu: " + patient);
        }
    }

    public static void main(String[] args) {

        EmergencyRoom er = new EmergencyRoom();

        // Mo phong
        er.patientCheckIn("A");
        er.patientCheckIn("B");
        er.emergencyCheckIn("C");

        er.treatPatient(); // C
        er.treatPatient(); // A
        er.treatPatient(); // B
    }
}
