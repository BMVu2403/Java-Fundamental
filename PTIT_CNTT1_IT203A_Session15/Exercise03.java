package PTIT_CNTT1_IT203A_Session15;

import java.util.Stack;

public class Exercise03 {

    // Lop MedicationProcessChecker
    static class MedicationProcessChecker {
        private Stack<String> stack;

        public MedicationProcessChecker() {
            stack = new Stack<>();
        }

        // Kiem tra quy trinh
        public boolean checkProcess(String[] actions) {
            for (int i = 0; i < actions.length; i++) {
                String action = actions[i];

                if (action.equals("PUSH")) {
                    stack.push("MEDICATION");
                    System.out.println("Step " + (i + 1) + ": PUSH - add medication");
                } else if (action.equals("POP")) {
                    if (stack.isEmpty()) {
                        System.out.println("Step " + (i + 1) + ": POP when stack is empty -> INVALID");
                        return false;
                    }
                    stack.pop();
                    System.out.println("Step " + (i + 1) + ": POP - complete medication");
                } else {
                    System.out.println("Step " + (i + 1) + ": Unknown action -> INVALID");
                    return false;
                }
            }

            if (!stack.isEmpty()) {
                System.out.println("End of shift but stack is not empty -> INVALID");
                return false;
            }

            System.out.println("Medication process is VALID");
            return true;
        }

        // Reset stack
        public void reset() {
            stack.clear();
        }
    }

    // Ham main de test
    public static void main(String[] args) {
        MedicationProcessChecker checker = new MedicationProcessChecker();

        // Case hop le
        String[] actions1 = { "PUSH", "PUSH", "POP", "PUSH", "POP", "POP" };
        System.out.println("Check process 1:");
        checker.checkProcess(actions1);

        System.out.println();
        checker.reset();

        // Case khong hop le (POP khi rong)
        String[] actions2 = { "PUSH", "POP", "POP" };
        System.out.println("Check process 2:");
        checker.checkProcess(actions2);

        System.out.println();
        checker.reset();

        // Case khong hop le (ket thuc stack khong rong)
        String[] actions3 = { "PUSH", "PUSH", "POP" };
        System.out.println("Check process 3:");
        checker.checkProcess(actions3);
    }
}
