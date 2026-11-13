
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

public class StudentDataGeneratorTest {

    @Test
    void shouldGenerateRequestedNumberOfStudents() {

        List<Student> students
                = StudentDataGenerator.generateStudents(100000);

        assertEquals(100000, students.size());
    }

    @Test
    void shouldGenerateUniqueStudentIds() {

        List<Student> students
                = StudentDataGenerator.generateStudents(100000);

        Set<String> uniqueIds = new HashSet<>();

        for (Student student : students) {
            uniqueIds.add(student.getId());
        }

        assertEquals(100000, uniqueIds.size());
    }

    @Test
    void shouldGenerateCorrectFirstAndLastStudentIds() {

        List<Student> students
                = StudentDataGenerator.generateStudents(100000);

        assertEquals("1", students.get(0).getId());
        assertEquals("100000", students.get(99999).getId());
    }
}
