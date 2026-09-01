import java.util.Scanner;

public class Main {
    static PatientBST patientBST = new PatientBST();
    static EmergencyQueue emergencyQueue = new EmergencyQueue();
    static TreatmentStack treatmentStack = new TreatmentStack();
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int choice;
        do {
            printMenu();
            choice = Integer.parseInt(sc.nextLine());
            switch (choice) {
                case 1: registerPatient(); break;
                case 2: searchPatient(); break;
                case 3: deletePatient(); break;
                case 4: patientBST.displayInOrder(); break;
                case 5: addToEmergencyQueue(); break;
                case 6: treatNextPatient(); break;
                case 7: emergencyQueue.displayQueue(); break;
                case 8: treatmentStack.displayStack(); break;
                case 9: popTreatmentRecord(); break;
                case 10: addVisit(); break;
                case 11: removeVisit(); break;
                case 12: searchVisit(); break;
                case 13: displayVisitHistory(); break;
                case 0: System.out.println("Exiting system. Goodbye!"); break;
                default: System.out.println("Invalid choice, try again.");
            }
            System.out.println();
        } while (choice != 0);
        sc.close();
    }

    static void printMenu() {
        System.out.println("===== Mini Hospital Emergency Management System =====");
        System.out.println("--- Patient Records (BST) ---");
        System.out.println("1. Register new patient");
        System.out.println("2. Search patient by ID");
        System.out.println("3. Delete patient by ID");
        System.out.println("4. Display all patients (in-order)");
        System.out.println("--- Emergency Queue ---");
        System.out.println("5. Add patient to emergency queue");
        System.out.println("6. Treat next patient (dequeue)");
        System.out.println("7. Display waiting queue");
        System.out.println("--- Treatment History (Stack) ---");
        System.out.println("8. Display treatment history");
        System.out.println("9. Undo last treatment record (pop)");
        System.out.println("--- Patient Visit History (Linked List) ---");
        System.out.println("10. Add visit to patient history");
        System.out.println("11. Remove visit from patient history");
        System.out.println("12. Search visit in patient history");
        System.out.println("13. Display patient visit history");
        System.out.println("0. Exit");
        System.out.print("Enter your choice: ");
    }

    // ---------- BST operations ----------
    static void registerPatient() {
        System.out.print("Enter Patient ID: ");
        int id = Integer.parseInt(sc.nextLine());
        System.out.print("Enter Name: ");
        String name = sc.nextLine();
        System.out.print("Enter Age: ");
        int age = Integer.parseInt(sc.nextLine());
        System.out.print("Enter Contact Number: ");
        String contact = sc.nextLine();
        System.out.print("Enter Medical Condition: ");
        String condition = sc.nextLine();
        patientBST.insert(id, name, age, contact, condition);
        System.out.println("Patient registered successfully.");
    }

    static void searchPatient() {
        System.out.print("Enter Patient ID to search: ");
        int id = Integer.parseInt(sc.nextLine());
        Patient p = patientBST.search(id);
        if (p != null) {
            System.out.println("Found: " + p);
        } else {
            System.out.println("Patient not found.");
        }
    }

    static void deletePatient() {
        System.out.print("Enter Patient ID to delete: ");
        int id = Integer.parseInt(sc.nextLine());
        patientBST.delete(id);
    }

    // ---------- Queue operations ----------
    static void addToEmergencyQueue() {
        System.out.print("Enter Patient ID to add to queue: ");
        int id = Integer.parseInt(sc.nextLine());
        Patient p = patientBST.search(id);
        if (p == null) {
            System.out.println("Patient must be registered first (use option 1).");
            return;
        }
        emergencyQueue.enqueue(p);
    }

    static void treatNextPatient() {
        Patient p = emergencyQueue.dequeue();
        if (p != null) {
            TreatmentRecord record = new TreatmentRecord(p.patientId, p.name, p.medicalCondition, "2026-09-01");
            treatmentStack.push(record);
        }
    }

    // ---------- Stack operations ----------
    static void popTreatmentRecord() {
        treatmentStack.pop();
    }

    // ---------- Linked list operations ----------
    static void addVisit() {
        System.out.print("Enter Patient ID: ");
        int id = Integer.parseInt(sc.nextLine());
        Patient p = patientBST.search(id);
        if (p == null) {
            System.out.println("Patient not found.");
            return;
        }
        System.out.print("Enter Visit ID: ");
        int vid = Integer.parseInt(sc.nextLine());
        System.out.print("Enter Visit Date: ");
        String date = sc.nextLine();
        System.out.print("Enter Doctor Name: ");
        String doctor = sc.nextLine();
        System.out.print("Enter Diagnosis: ");
        String diagnosis = sc.nextLine();
        System.out.print("Enter Treatment: ");
        String treatment = sc.nextLine();
        p.visitHistory.addVisit(vid, date, doctor, diagnosis, treatment);
    }

    static void removeVisit() {
        System.out.print("Enter Patient ID: ");
        int id = Integer.parseInt(sc.nextLine());
        Patient p = patientBST.search(id);
        if (p == null) {
            System.out.println("Patient not found.");
            return;
        }
        System.out.print("Enter Visit ID to remove: ");
        int vid = Integer.parseInt(sc.nextLine());
        p.visitHistory.removeVisit(vid);
    }

    static void searchVisit() {
        System.out.print("Enter Patient ID: ");
        int id = Integer.parseInt(sc.nextLine());
        Patient p = patientBST.search(id);
        if (p == null) {
            System.out.println("Patient not found.");
            return;
        }
        System.out.print("Enter Visit ID to search: ");
        int vid = Integer.parseInt(sc.nextLine());
        Visit v = p.visitHistory.searchVisit(vid);
        System.out.println(v != null ? "Found: " + v : "Visit not found.");
    }

    static void displayVisitHistory() {
        System.out.print("Enter Patient ID: ");
        int id = Integer.parseInt(sc.nextLine());
        Patient p = patientBST.search(id);
        if (p == null) {
            System.out.println("Patient not found.");
            return;
        }
        System.out.println("Visit history for " + p.name + ":");
        p.visitHistory.displayHistory();
    }
}
