
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

public class HashMapStudentLookup {

    private final Map<String, Student> students = new HashMap<>();

    // Adds a student to the HashMap
    public void addStudent(Student student) {
        String id = student.getId().toLowerCase(Locale.ROOT);
        students.putIfAbsent(id, student);
    }

    // Searches for a student using their ID
    public Student searchStudent(String id) {

        if (id == null) {
            return null;
        }

        return students.get(id.toLowerCase(Locale.ROOT));
    }

    // Returns the total number of students
    public int size() {
        return students.size();
    }
}
