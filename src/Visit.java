public class Visit {
    int visitId;
    String visitDate;
    String doctorName;
    String diagnosis;
    String treatment;
    Visit next; // pointer for singly linked list

    public Visit(int visitId, String visitDate, String doctorName, String diagnosis, String treatment) {
        this.visitId = visitId;
        this.visitDate = visitDate;
        this.doctorName = doctorName;
        this.diagnosis = diagnosis;
        this.treatment = treatment;
        this.next = null;
    }

    public String toString() {
        return "Visit#" + visitId + " | " + visitDate + " | Dr. " + doctorName
                + " | Diagnosis: " + diagnosis + " | Treatment: " + treatment;
    }
}
