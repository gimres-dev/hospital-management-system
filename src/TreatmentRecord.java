public class TreatmentRecord {
    int patientId;
    String patientName;
    String medicalCondition;
    String treatmentDate;

    public TreatmentRecord(int patientId, String patientName, String medicalCondition, String treatmentDate) {
        this.patientId = patientId;
        this.patientName = patientName;
        this.medicalCondition = medicalCondition;
        this.treatmentDate = treatmentDate;
    }

    public String toString() {
        return "Treated -> ID: " + patientId + " | Name: " + patientName
                + " | Condition: " + medicalCondition + " | Date: " + treatmentDate;
    }
}
