public class Patient {
    int patientId;
    String name;
    int age;
    String contactNumber;
    String medicalCondition;
    VisitHistory visitHistory; // singly linked list of past visits

    Patient left, right; // BST child pointers

    public Patient(int patientId, String name, int age, String contactNumber, String medicalCondition) {
        this.patientId = patientId;
        this.name = name;
        this.age = age;
        this.contactNumber = contactNumber;
        this.medicalCondition = medicalCondition;
        this.visitHistory = new VisitHistory();
        this.left = null;
        this.right = null;
    }

    public String toString() {
        return "ID: " + patientId + " | Name: " + name + " | Age: " + age
                + " | Contact: " + contactNumber + " | Condition: " + medicalCondition;
    }
}
