package PTIT_CNTT1_IT203A_Session15;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Exercise06 {

    // ================== PATIENT WAITING QUEUE ==================
    static class Patient {
        String id;
        String name;
        int age;
        String gender;

        public Patient(String id, String name, int age, String gender) {
            this.id = id;
            this.name = name;
            this.age = age;
            this.gender = gender;
        }

        @Override
        public String toString() {
            return "Patient{id='" + id + "', name='" + name + "', age=" + age + ", gender='" + gender + "'}";
        }
    }

    static class PatientWaitingQueue {
        Queue<Patient> waitingQueue = new LinkedList<>();
        int totalPatients = 0;

        public void addPatient(Patient p) {
            waitingQueue.offer(p);
            totalPatients++;
            System.out.println("Add patient: " + p);
        }

        public Patient callNext() {
            if (waitingQueue.isEmpty())
                return null;
            totalPatients--;
            return waitingQueue.poll();
        }
    }

    // ================== MEDICAL RECORD HISTORY ==================
    static class EditAction {
        String description;
        String editedBy;
        String editTime;

        public EditAction(String description, String editedBy, String editTime) {
            this.description = description;
            this.editedBy = editedBy;
            this.editTime = editTime;
        }

        @Override
        public String toString() {
            return "Edit{desc='" + description + "', by='" + editedBy + "', time='" + editTime + "'}";
        }
    }

    static class MedicalRecordHistory {
        Stack<EditAction> editStack = new Stack<>();
        String recordId;

        public MedicalRecordHistory(String recordId) {
            this.recordId = recordId;
        }

        public void addEdit(EditAction e) {
            editStack.push(e);
            System.out.println("Add edit: " + e);
        }

        public EditAction undoEdit() {
            if (editStack.isEmpty())
                return null;
            return editStack.pop();
        }
    }

    // ================== TICKET SYSTEM ==================
    static class Ticket {
        int ticketNumber;
        String issuedTime;

        public Ticket(int ticketNumber, String issuedTime) {
            this.ticketNumber = ticketNumber;
            this.issuedTime = issuedTime;
        }

        @Override
        public String toString() {
            return "Ticket{number=" + ticketNumber + ", time='" + issuedTime + "'}";
        }
    }

    static class TicketSystem {
        Queue<Ticket> ticketQueue = new LinkedList<>();
        int currentNumber = 0;

        public Ticket issueTicket(String time) {
            currentNumber++;
            Ticket t = new Ticket(currentNumber, time);
            ticketQueue.offer(t);
            return t;
        }

        public Ticket callTicket() {
            return ticketQueue.poll();
        }
    }

    // ================== UNDO MANAGER ==================
    static class InputAction {
        String fieldName;
        String oldValue;
        String newValue;
        String actionTime;

        public InputAction(String fieldName, String oldValue, String newValue, String actionTime) {
            this.fieldName = fieldName;
            this.oldValue = oldValue;
            this.newValue = newValue;
            this.actionTime = actionTime;
        }

        @Override
        public String toString() {
            return "Action{field='" + fieldName + "', old='" + oldValue + "', new='" + newValue + "'}";
        }
    }

    static class UndoManager {
        Stack<InputAction> undoStack = new Stack<>();
        int maxUndoSteps;

        public UndoManager(int maxUndoSteps) {
            this.maxUndoSteps = maxUndoSteps;
        }

        public void addAction(InputAction action) {
            if (undoStack.size() == maxUndoSteps) {
                undoStack.remove(0);
            }
            undoStack.push(action);
            System.out.println("Add action: " + action);
        }

        public InputAction undo() {
            if (undoStack.isEmpty())
                return null;
            return undoStack.pop();
        }
    }

    // ================== MAIN TEST ==================
    public static void main(String[] args) {

        System.out.println("=== PATIENT WAITING QUEUE ===");
        PatientWaitingQueue pq = new PatientWaitingQueue();
        pq.addPatient(new Patient("BN01", "Nguyen Van A", 30, "Male"));
        pq.addPatient(new Patient("BN02", "Tran Thi B", 25, "Female"));
        System.out.println("Call next: " + pq.callNext());

        System.out.println("\n=== MEDICAL RECORD HISTORY ===");
        MedicalRecordHistory history = new MedicalRecordHistory("HS01");
        history.addEdit(new EditAction("Update diagnosis", "Doctor A", "08:30"));
        history.addEdit(new EditAction("Change medicine", "Doctor B", "09:00"));
        System.out.println("Undo: " + history.undoEdit());

        System.out.println("\n=== TICKET SYSTEM ===");
        TicketSystem ts = new TicketSystem();
        System.out.println("Issue: " + ts.issueTicket("08:00"));
        System.out.println("Call: " + ts.callTicket());

        System.out.println("\n=== UNDO MANAGER ===");
        UndoManager um = new UndoManager(3);
        um.addAction(new InputAction("name", "A", "B", "10:00"));
        um.addAction(new InputAction("age", "20", "21", "10:01"));
        System.out.println("Undo: " + um.undo());
    }
}
