
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import org.junit.jupiter.api.Test;

public class ArrayListStudentLookupTest {

    @Test
    void shouldFindExistingStudent() {
        ArrayListStudentLookup lookup = new ArrayListStudentLookup();

        Student student = new Student("101", "Rahul", "CSE");
        lookup.addStudent(student);

        assertEquals(student, lookup.searchStudent("101"));
    }

    @Test
    void shouldReturnNullForMissingStudent() {
        ArrayListStudentLookup lookup = new ArrayListStudentLookup();

        lookup.addStudent(new Student("101", "Rahul", "CSE"));

        assertNull(lookup.searchStudent("999"));
    }

    @Test
    void shouldReturnNullForEmptyList() {
        ArrayListStudentLookup lookup = new ArrayListStudentLookup();

        assertNull(lookup.searchStudent("101"));
    }

    @Test
    void shouldFindStudentAmongMultipleRecords() {
        ArrayListStudentLookup lookup = new ArrayListStudentLookup();

        lookup.addStudent(new Student("101", "Rahul", "CSE"));
        lookup.addStudent(new Student("102", "Priya", "ECE"));
        lookup.addStudent(new Student("103", "Amit", "IT"));

        Student result = lookup.searchStudent("103");

        assertNotNull(result);
        assertEquals("Amit", result.getName());
    }
}
