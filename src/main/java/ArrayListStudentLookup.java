
import java.util.ArrayList;
import java.util.List;

public class ArrayListStudentLookup {

    private final List<Student> students = new ArrayList<>();

    // Adds a student to the list
    public void addStudent(Student student) {
        students.add(student);
    }

    // Searches for a student using their ID
    public Student searchStudent(String id) {

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
