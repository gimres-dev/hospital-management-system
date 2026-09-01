public class VisitHistory {
    private Visit head;

    public VisitHistory() {
        head = null;
    }

    // Add a new visit at the end of the list
    public void addVisit(int visitId, String visitDate, String doctorName, String diagnosis, String treatment) {
        Visit newVisit = new Visit(visitId, visitDate, doctorName, diagnosis, treatment);
        if (head == null) {
            head = newVisit;
            return;
        }
        Visit temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = newVisit;
        System.out.println("Visit " + visitId + " added to history.");
    }

    // Remove a visit by visitId
    public void removeVisit(int visitId) {
        if (head == null) {
            System.out.println("No visit history to remove from.");
            return;
        }
        if (head.visitId == visitId) {
            head = head.next;
            System.out.println("Visit " + visitId + " removed.");
            return;
        }
        Visit temp = head;
        while (temp.next != null && temp.next.visitId != visitId) {
            temp = temp.next;
        }
        if (temp.next == null) {
            System.out.println("Visit " + visitId + " not found.");
        } else {
            temp.next = temp.next.next;
            System.out.println("Visit " + visitId + " removed.");
        }
    }

    // Search for a visit by visitId
    public Visit searchVisit(int visitId) {
        Visit temp = head;
        while (temp != null) {
            if (temp.visitId == visitId) {
                return temp;
            }
            temp = temp.next;
        }
        return null;
    }

    // Display all visits
    public void displayHistory() {
        if (head == null) {
            System.out.println("  No visit history.");
            return;
        }
        Visit temp = head;
        while (temp != null) {
            System.out.println("  " + temp);
            temp = temp.next;
        }
    }
}
