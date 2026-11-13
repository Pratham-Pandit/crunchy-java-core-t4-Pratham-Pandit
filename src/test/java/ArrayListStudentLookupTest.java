
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
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

        assertEquals("Amit", lookup.searchStudent("103").getName());
    }

    @Test
    void shouldFindStudentUsingDifferentLetterCase() {
        ArrayListStudentLookup lookup = new ArrayListStudentLookup();

        Student student = new Student("ABC101", "Rahul", "CSE");
        lookup.addStudent(student);

        assertEquals(student, lookup.searchStudent("abc101"));
    }

    @Test
    void shouldRejectDuplicateStudentId() {
        ArrayListStudentLookup lookup = new ArrayListStudentLookup();

        lookup.addStudent(new Student("101", "Rahul", "CSE"));

        assertThrows(IllegalArgumentException.class, ()
                -> lookup.addStudent(new Student("101", "Amit", "ECE")));
    }

    @Test
    void shouldRejectDuplicateIdWithDifferentCase() {
        ArrayListStudentLookup lookup = new ArrayListStudentLookup();

        lookup.addStudent(new Student("ABC101", "Rahul", "CSE"));

        assertThrows(IllegalArgumentException.class, ()
                -> lookup.addStudent(new Student("abc101", "Amit", "ECE")));
    }

    @Test
    void shouldRejectNullStudent() {
        ArrayListStudentLookup lookup = new ArrayListStudentLookup();

        assertThrows(IllegalArgumentException.class, ()
                -> lookup.addStudent(null));
    }

    @Test
    void shouldRejectBlankStudentId() {
        ArrayListStudentLookup lookup = new ArrayListStudentLookup();

        Student student = new Student(" ", "Rahul", "CSE");

        assertThrows(IllegalArgumentException.class, ()
                -> lookup.addStudent(student));
    }

    @Test
    void shouldReturnNullForNullOrBlankSearchId() {
        ArrayListStudentLookup lookup = new ArrayListStudentLookup();

        assertNull(lookup.searchStudent(null));
        assertNull(lookup.searchStudent(" "));
    }
}
