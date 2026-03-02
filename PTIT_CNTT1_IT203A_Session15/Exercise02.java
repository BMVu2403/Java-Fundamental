package PTIT_CNTT1_IT203A_Session15;

import java.util.LinkedList;
import java.util.Queue;

public class Exercise02 {

    // Lop Patient
    static class Patient {
        private String id;
        private String name;
        private int age;

        public Patient(String id, String name, int age) {
            this.id = id;
            this.name = name;
            this.age = age;
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }

        @Override
        public String toString() {
            return "Patient{id='" + id + "', name='" + name + "', age=" + age + "}";
        }
    }

    // Lop PatientQueue
    static class PatientQueue {
        private Queue<Patient> queue;

        public PatientQueue() {
            queue = new LinkedList<>();
        }

        // Them benh nhan vao hang doi
        public void addPatient(Patient p) {
            queue.offer(p);
            System.out.println("Add patient: " + p);
        }

        // Goi benh nhan tiep theo
        public Patient callNextPatient() {
            if (queue.isEmpty()) {
                System.out.println("No patient to call");
                return null;
            }
            Patient p = queue.poll();
            System.out.println("Call patient: " + p);
            return p;
        }

        // Xem benh nhan tiep theo
        public Patient peekNextPatient() {
            if (queue.isEmpty()) {
                System.out.println("No patient in queue");
                return null;
            }
            return queue.peek();
        }

        // Kiem tra rong
        public boolean isEmpty() {
            return queue.isEmpty();
        }

        // Hien thi danh sach cho
        public void displayQueue() {
            if (queue.isEmpty()) {
                System.out.println("Patient queue is empty");
                return;
            }

            System.out.println("Patient waiting list:");
            for (Patient p : queue) {
                System.out.println(p);
            }
        }
    }

    // Ham main
    public static void main(String[] args) {
        PatientQueue patientQueue = new PatientQueue();

        patientQueue.addPatient(new Patient("BN01", "Nguyen Van A", 30));
        patientQueue.addPatient(new Patient("BN02", "Tran Thi B", 25));
        patientQueue.addPatient(new Patient("BN03", "Le Van C", 40));

        System.out.println();
        System.out.println("Next patient:");
        System.out.println(patientQueue.peekNextPatient());

        System.out.println();
        patientQueue.callNextPatient();

        System.out.println();
        patientQueue.displayQueue();
    }
}
