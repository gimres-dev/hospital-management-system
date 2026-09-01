import java.util.Stack;

public class TreatmentStack {
    private Stack<TreatmentRecord> stack;

    public TreatmentStack() {
        stack = new Stack<>();
    }

    // Push - add a completed treatment record
    public void push(TreatmentRecord record) {
        stack.push(record);
        System.out.println("Treatment record for patient " + record.patientId + " pushed to stack.");
    }

    // Pop - remove the most recently completed treatment record
    public TreatmentRecord pop() {
        if (isEmpty()) {
            System.out.println("Treatment stack is empty.");
            return null;
        }
        TreatmentRecord record = stack.pop();
        System.out.println("Removed most recent treatment record: " + record);
        return record;
    }

    public boolean isEmpty() {
        return stack.isEmpty();
    }

    // Display treatment records (most recent first, LIFO order)
    public void displayStack() {
        if (isEmpty()) {
            System.out.println("No treatment records yet.");
            return;
        }
        System.out.println("Treatment history (most recent first):");
        for (int i = stack.size() - 1; i >= 0; i--) {
            System.out.println("  " + stack.get(i));
        }
    }
}
