import java.util.LinkedList;

public class EmergencyQueue {
    private LinkedList<Patient> queue;

    public EmergencyQueue() {
        queue = new LinkedList<>();
    }

    // Enqueue - add patient to the back of the waiting line
    public void enqueue(Patient patient) {
        queue.addLast(patient);
        System.out.println("Patient " + patient.patientId + " added to emergency queue.");
    }

    // Dequeue - remove the next patient for treatment (front of the queue)
    public Patient dequeue() {
        if (isEmpty()) {
            System.out.println("Emergency queue is empty. No patients waiting.");
            return null;
        }
        Patient p = queue.removeFirst();
        System.out.println("Patient " + p.patientId + " is now being treated.");
        return p;
    }

    public boolean isEmpty() {
        return queue.isEmpty();
    }

    // Display all patients currently waiting (FIFO order)
    public void displayQueue() {
        if (isEmpty()) {
            System.out.println("No patients currently waiting.");
            return;
        }
        System.out.println("Patients waiting (front to back):");
        for (Patient p : queue) {
            System.out.println("  " + p);
        }
    }
}
