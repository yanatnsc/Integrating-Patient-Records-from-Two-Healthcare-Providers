//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    static Patient newPatient(int SSN, int age, String fullName) {
        return new Patient(SSN, age, fullName);
    }

    // Merges two given lists in-place.
    // This function mainly compares head nodes and recursively calls itself
    static Patient merge(Patient h1, Patient h2) {
        if (h1 == null) {
            return h2;
        }
        if (h2 == null) {
            return h1;
        }

        // Start with the linked list whose head SSN is the least
        if (h1.SSN <= h2.SSN) {
            h1.next = merge(h1.next, h2);
            return h1;
        } else {
            h2.next = merge(h1, h2.next);
            return h2;
        }
    }

    public static void main(String[] args) {
        // Create HealthMerge's sorted patient list
        Patient healthMergeHead = newPatient(111111111, 30, "Patient A");
        healthMergeHead.next = newPatient(333333333, 35, "Patient B");
        healthMergeHead.next.next = newPatient(555555555, 50, "Patient C");

        // Create CarePlus's sorted patient list
        Patient carePlusHead = newPatient(222222222, 25, "Patient D");
        carePlusHead.next = newPatient(333333333, 35, "Patient B"); // Overlapping record with HealthMerge
        carePlusHead.next.next = newPatient(444444444, 45, "Patient E");
        carePlusHead.next.next.next = newPatient(666666666, 55, "Patient F");

        // Merge the two lists
        Patient mergedHead = merge(healthMergeHead, carePlusHead);

        // Print merged list
        while (mergedHead != null) {
            System.out.println(mergedHead); // This will use the overridden toString method
            mergedHead = mergedHead.next;
        }
    }
}