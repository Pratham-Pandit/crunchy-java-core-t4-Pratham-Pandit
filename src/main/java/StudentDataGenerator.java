
import java.util.ArrayList;
import java.util.List;

public class StudentDataGenerator {

    // Generates the requested number of student records
    public static List<Student> generateStudents(int count) {

        List<Student> students = new ArrayList<>();

        for (int i = 1; i <= count; i++) {

            String id = String.valueOf(i);
            String name = "Student" + i;
            String course = "CSE";

            students.add(new Student(id, name, course));
        }

        return students;
    }
}
