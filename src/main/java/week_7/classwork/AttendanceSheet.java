public class AttendanceSheet {
    private final String[] presentStudents;
    private int count;

    public AttendanceSheet(int capacity) {
        this.presentStudents = new String[capacity];
        this.count = 0;
    }

    public void markPresent(String name) {
        if (isPresent(name)) {
            return; // Avoid duplicate entries
        }
        if (count < presentStudents.length) {
            presentStudents[count] = name;
            count++;
        }
    }

    public int getPresentCount() {
        return count;
    }

    public boolean isPresent(String name) {
        for (int i = 0; i < count; i++) {
            if (presentStudents[i].equalsIgnoreCase(name)) {
                return true;
            }
        }
        return false;
    }
}