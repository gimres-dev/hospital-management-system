public class PatientBST {
    private Patient root;

    public PatientBST() {
        root = null;
    }

    // ---------- INSERT ----------
    public void insert(int patientId, String name, int age, String contactNumber, String medicalCondition) {
        root = insertRec(root, patientId, name, age, contactNumber, medicalCondition);
    }

    private Patient insertRec(Patient node, int patientId, String name, int age, String contactNumber, String medicalCondition) {
        if (node == null) {
            return new Patient(patientId, name, age, contactNumber, medicalCondition);
        }
        if (patientId < node.patientId) {
            node.left = insertRec(node.left, patientId, name, age, contactNumber, medicalCondition);
        } else if (patientId > node.patientId) {
            node.right = insertRec(node.right, patientId, name, age, contactNumber, medicalCondition);
        } else {
            System.out.println("Patient ID " + patientId + " already exists.");
        }
        return node;
    }

    // ---------- SEARCH ----------
    public Patient search(int patientId) {
        return searchRec(root, patientId);
    }

    private Patient searchRec(Patient node, int patientId) {
        if (node == null || node.patientId == patientId) {
            return node;
        }
        if (patientId < node.patientId) {
            return searchRec(node.left, patientId);
        }
        return searchRec(node.right, patientId);
    }

    // ---------- DELETE ----------
    public void delete(int patientId) {
        root = deleteRec(root, patientId);
    }

    private Patient deleteRec(Patient node, int patientId) {
        if (node == null) {
            System.out.println("Patient ID " + patientId + " not found.");
            return null;
        }
        if (patientId < node.patientId) {
            node.left = deleteRec(node.left, patientId);
        } else if (patientId > node.patientId) {
            node.right = deleteRec(node.right, patientId);
        } else {
            // node found
            if (node.left == null) return node.right;
            if (node.right == null) return node.left;

            // two children: replace with in-order successor (smallest in right subtree)
            Patient successor = findMin(node.right);
            node.patientId = successor.patientId;
            node.name = successor.name;
            node.age = successor.age;
            node.contactNumber = successor.contactNumber;
            node.medicalCondition = successor.medicalCondition;
            node.visitHistory = successor.visitHistory;
            node.right = deleteRec(node.right, successor.patientId);
        }
        return node;
    }

    private Patient findMin(Patient node) {
        while (node.left != null) {
            node = node.left;
        }
        return node;
    }

    // ---------- IN-ORDER TRAVERSAL (ascending order of Patient ID) ----------
    public void displayInOrder() {
        if (root == null) {
            System.out.println("No patient records found.");
            return;
        }
        inOrderRec(root);
    }

    private void inOrderRec(Patient node) {
        if (node != null) {
            inOrderRec(node.left);
            System.out.println(node);
            inOrderRec(node.right);
        }
    }
}
