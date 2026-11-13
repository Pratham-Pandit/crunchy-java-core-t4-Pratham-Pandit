
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.Test;

public class HashMapStudentLookupTest {

    @Test
    void shouldFindExistingStudent() {
        HashMapStudentLookup lookup = new HashMapStudentLookup();

        Student student = new Student("101", "Rahul", "CSE");
        lookup.addStudent(student);

        assertEquals(student, lookup.searchStudent("101"));
    }

    @Test
    void shouldReturnNullForMissingStudent() {
        HashMapStudentLookup lookup = new HashMapStudentLookup();

        lookup.addStudent(new Student("101", "Rahul", "CSE"));

        assertNull(lookup.searchStudent("999"));
    }

    @Test
    void shouldReturnNullForEmptyMap() {
        HashMapStudentLookup lookup = new HashMapStudentLookup();

        assertNull(lookup.searchStudent("101"));
    }

    @Test
    void shouldFindStudentAmongMultipleRecords() {
        HashMapStudentLookup lookup = new HashMapStudentLookup();

        lookup.addStudent(new Student("101", "Rahul", "CSE"));
        lookup.addStudent(new Student("102", "Priya", "ECE"));
        lookup.addStudent(new Student("103", "Amit", "IT"));

        assertEquals("Amit", lookup.searchStudent("103").getName());
    }

    @Test
    void shouldFindStudentUsingDifferentLetterCase() {
        HashMapStudentLookup lookup = new HashMapStudentLookup();

        Student student = new Student("ABC101", "Rahul", "CSE");
        lookup.addStudent(student);

        assertEquals(student, lookup.searchStudent("abc101"));
    }

    @Test
    void shouldRejectDuplicateStudentId() {
        HashMapStudentLookup lookup = new HashMapStudentLookup();

        lookup.addStudent(new Student("101", "Rahul", "CSE"));

        assertThrows(IllegalArgumentException.class, ()
                -> lookup.addStudent(new Student("101", "Amit", "ECE")));
    }

    @Test
    void shouldRejectDuplicateIdWithDifferentCase() {
        HashMapStudentLookup lookup = new HashMapStudentLookup();

        lookup.addStudent(new Student("ABC101", "Rahul", "CSE"));

        assertThrows(IllegalArgumentException.class, ()
                -> lookup.addStudent(new Student("abc101", "Amit", "ECE")));
    }

    @Test
    void shouldRejectNullStudent() {
        HashMapStudentLookup lookup = new HashMapStudentLookup();

        assertThrows(IllegalArgumentException.class, ()
                -> lookup.addStudent(null));
    }

    @Test
    void shouldRejectBlankStudentId() {
        HashMapStudentLookup lookup = new HashMapStudentLookup();

        Student student = new Student(" ", "Rahul", "CSE");

        assertThrows(IllegalArgumentException.class, ()
                -> lookup.addStudent(student));
    }

    @Test
    void shouldReturnNullForNullOrBlankSearchId() {
        HashMapStudentLookup lookup = new HashMapStudentLookup();

        assertNull(lookup.searchStudent(null));
        assertNull(lookup.searchStudent(" "));
    }
}
