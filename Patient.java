public class Patient {
    int SSN;
    int age;
    String fullName;
    Patient next;

    public Patient(int SSN, int age, String fullName) {
        this.SSN = SSN;
        this.age = age;
        this.fullName = fullName;
        this.next = null;
    }

    @Override
    public String toString() {
        return String.format("SSN: %d, Age: %d, Name: %s", SSN, age, fullName);
    }
}
