
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
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
    void shouldFindStudentUsingDifferentLetterCase() {
        HashMapStudentLookup lookup = new HashMapStudentLookup();

        Student student = new Student("ABC101", "Rahul", "CSE");
        lookup.addStudent(student);

        assertEquals(student, lookup.searchStudent("abc101"));
    }

    @Test
    void shouldPreserveFirstStudentWhenDuplicateIdIsAdded() {
        HashMapStudentLookup lookup = new HashMapStudentLookup();

        Student first = new Student("101", "Rahul", "CSE");
        Student second = new Student("101", "Amit", "ECE");

        lookup.addStudent(first);
        lookup.addStudent(second);

        assertEquals(first, lookup.searchStudent("101"));
        assertEquals(1, lookup.size());
    }
}
