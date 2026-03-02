package PTIT_CNTT1_IT203A_Session15;

import java.util.Stack;

public class Exercise01 {

    // Lop EditAction
    static class EditAction {
        private String description;
        private String time;

        public EditAction(String description, String time) {
            this.description = description;
            this.time = time;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public String getTime() {
            return time;
        }

        public void setTime(String time) {
            this.time = time;
        }

        @Override
        public String toString() {
            return "EditAction{description='" + description + "', time='" + time + "'}";
        }
    }

    // Lop MedicalRecordHistory
    static class MedicalRecordHistory {
        private Stack<EditAction> history;

        public MedicalRecordHistory() {
            history = new Stack<>();
        }

        // Them chinh sua
        public void addEdit(EditAction action) {
            history.push(action);
            System.out.println("Add edit: " + action);
        }

        // Undo chinh sua gan nhat
        public EditAction undoEdit() {
            if (history.isEmpty()) {
                System.out.println("No edit to undo");
                return null;
            }
            EditAction action = history.pop();
            System.out.println("Undo edit: " + action);
            return action;
        }

        // Xem chinh sua gan nhat
        public EditAction getLatestEdit() {
            if (history.isEmpty()) {
                System.out.println("No edit available");
                return null;
            }
            return history.peek();
        }

        // Kiem tra rong
        public boolean isEmpty() {
            return history.isEmpty();
        }

        // Hien thi lich su
        public void displayHistory() {
            if (history.isEmpty()) {
                System.out.println("Edit history is empty");
                return;
            }

            System.out.println("Edit history:");
            for (EditAction action : history) {
                System.out.println(action);
            }
        }
    }

    // Ham main
    public static void main(String[] args) {
        MedicalRecordHistory history = new MedicalRecordHistory();

        history.addEdit(new EditAction("Update diagnosis", "08:30"));
        history.addEdit(new EditAction("Change medicine", "09:00"));
        history.addEdit(new EditAction("Add test result", "09:30"));

        System.out.println();
        System.out.println("Latest edit:");
        System.out.println(history.getLatestEdit());

        System.out.println();
        history.undoEdit();

        System.out.println();
        history.displayHistory();
    }
}
