# Mini Hospital Emergency Management System

A console-based Java application built for CIT300 - Data Structures and Algorithms.
Simulates hospital patient registration, emergency queueing, treatment history, and
patient visit history using four core data structures.

## Data Structures Used

| Feature | Data Structure | File(s) |
|---|---|---|
| Patient Records | Binary Search Tree (BST) | `Patient.java`, `PatientBST.java` |
| Emergency Patient Queue | Queue (FIFO) | `EmergencyQueue.java` |
| Treatment History | Stack (LIFO) | `TreatmentRecord.java`, `TreatmentStack.java` |
| Patient Visit History | Singly Linked List | `Visit.java`, `VisitHistory.java` |
| Menu / Driver | - | `Main.java` |

## How to Run

1. Open the project in Eclipse (File > Open Projects from File System, select this folder).
2. Run `Main.java` as a Java Application.
3. Follow the on-screen menu.

## Example Flow

1. Register a patient (option 1).
2. Add them to the emergency queue (option 5).
3. Treat the next patient in the queue (option 6) — this dequeues them and pushes
   a record onto the treatment stack.
4. Add a past visit to their history (option 10).
5. View patients (option 4), the queue (option 7), treatment history (option 8),
   or a patient's visit history (option 13).

## Author

Haritha — BAIT, SLTC Research University
