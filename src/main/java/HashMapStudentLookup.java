
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

public class HashMapStudentLookup {

    private final Map<String, Student> students = new HashMap<>();

    // Adds a student to the HashMap
    public void addStudent(Student student) {

        if (student == null) {
            throw new IllegalArgumentException("Student cannot be null");
        }

        String id = student.getId();

        if (id == null || id.isBlank()) {
            throw new IllegalArgumentException("Student ID cannot be null or blank");
        }

        String key = id.toLowerCase(Locale.ROOT);

        if (students.containsKey(key)) {
            throw new IllegalArgumentException("Duplicate student ID: " + id);
        }

        students.put(key, student);
    }

    // Searches for a student using their ID
    public Student searchStudent(String id) {

        if (id == null || id.isBlank()) {
            return null;
        }

        return students.get(id.toLowerCase(Locale.ROOT));
    }

    // Returns the total number of students
    public int size() {
        return students.size();
    }
}
