
import java.util.ArrayList;
import java.util.List;

public class ArrayListStudentLookup {

    private final List<Student> students = new ArrayList<>();

    // Adds a student to the list
    public void addStudent(Student student) {

        if (student == null) {
            throw new IllegalArgumentException("Student cannot be null");
        }

        String id = student.getId();

        if (id == null || id.isBlank()) {
            throw new IllegalArgumentException("Student ID cannot be null or blank");
        }

        if (searchStudent(id) != null) {
            throw new IllegalArgumentException("Duplicate student ID: " + id);
        }

        students.add(student);
    }

    // Searches for a student using their ID
    public Student searchStudent(String id) {

        if (id == null || id.isBlank()) {
            return null;
        }

        for (Student student : students) {

            if (student.getId().equalsIgnoreCase(id)) {
                return student;
            }
        }

        return null;
    }

    // Returns the total number of students
    public int size() {
        return students.size();
    }
}
