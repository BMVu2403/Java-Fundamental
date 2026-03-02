package PTIT_CNTT1_IT203A_Session15;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Exercise05 {

    // Lop Patient
    static class Patient {
        private String id;
        private String name;

        public Patient(String id, String name) {
            this.id = id;
            this.name = name;
        }

        @Override
        public String toString() {
            return "Patient{id='" + id + "', name='" + name + "'}";
        }
    }

    // Lop TreatmentStep
    static class TreatmentStep {
        private String description;
        private String time;

        public TreatmentStep(String description, String time) {
            this.description = description;
            this.time = time;
        }

        @Override
        public String toString() {
            return "Step{description='" + description + "', time='" + time + "'}";
        }
    }

    // Lop EmergencyCase
    static class EmergencyCase {
        private Patient patient;
        private Stack<TreatmentStep> steps;

        public EmergencyCase(Patient patient) {
            this.patient = patient;
            this.steps = new Stack<>();
        }

        // Them buoc xu ly
        public void addStep(TreatmentStep step) {
            steps.push(step);
            System.out.println("Add step: " + step);
        }

        // Undo buoc xu ly gan nhat
        public TreatmentStep undoStep() {
            if (steps.isEmpty()) {
                System.out.println("No step to undo");
                return null;
            }
            TreatmentStep step = steps.pop();
            System.out.println("Undo step: " + step);
            return step;
        }

        // Hien thi cac buoc xu ly
        public void displaySteps() {
            if (steps.isEmpty()) {
                System.out.println("No treatment steps");
                return;
            }
            System.out.println("Treatment steps for " + patient + ":");
            for (TreatmentStep step : steps) {
                System.out.println(step);
            }
        }

        public Patient getPatient() {
            return patient;
        }
    }

    // Lop EmergencyCaseQueue
    static class EmergencyCaseQueue {
        private Queue<EmergencyCase> cases;

        public EmergencyCaseQueue() {
            cases = new LinkedList<>();
        }

        // Them ca cap cuu
        public void addCase(EmergencyCase c) {
            cases.offer(c);
            System.out.println("Add emergency case: " + c.getPatient());
        }

        // Lay ca cap cuu tiep theo
        public EmergencyCase getNextCase() {
            if (cases.isEmpty()) {
                System.out.println("No emergency case in queue");
                return null;
            }
            EmergencyCase c = cases.poll();
            System.out.println("Process emergency case: " + c.getPatient());
            return c;
        }
    }

    // Ham main
    public static void main(String[] args) {
        EmergencyCaseQueue queue = new EmergencyCaseQueue();

        // Tao benh nhan
        Patient p1 = new Patient("BN01", "Nguyen Van A");
        Patient p2 = new Patient("BN02", "Tran Thi B");

        // Tao ca cap cuu
        EmergencyCase case1 = new EmergencyCase(p1);
        EmergencyCase case2 = new EmergencyCase(p2);

        // Them vao queue
        queue.addCase(case1);
        queue.addCase(case2);

        System.out.println();

        // Xu ly ca cap cuu dau tien
        EmergencyCase currentCase = queue.getNextCase();
        if (currentCase != null) {
            currentCase.addStep(new TreatmentStep("Receive patient", "08:00"));
            currentCase.addStep(new TreatmentStep("Diagnosis", "08:05"));
            currentCase.addStep(new TreatmentStep("Emergency treatment", "08:10"));

            System.out.println();
            currentCase.displaySteps();

            System.out.println();
            currentCase.undoStep();

            System.out.println();
            currentCase.displaySteps();
        }
    }
}
