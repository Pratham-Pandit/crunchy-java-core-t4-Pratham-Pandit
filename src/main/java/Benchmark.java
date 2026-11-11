
import java.util.List;

public class Benchmark {

    public static void main(String[] args) {

        int[] sizes = {10, 100000};

        // Warm up the JVM
        for (int i = 0; i < 5; i++) {
            runBenchmark(1000);
        }

        System.out.println("\n===== ARRAYLIST BASELINE BENCHMARK =====");

        for (int size : sizes) {
            runBenchmark(size);
        }
    }

    private static void runBenchmark(int size) {

        List<Student> students
                = StudentDataGenerator.generateStudents(size);

        ArrayListStudentLookup lookup
                = new ArrayListStudentLookup();

        for (Student student : students) {
            lookup.addStudent(student);
        }

        // Search for the last student
        String searchId = String.valueOf(size);

        int repetitions = 1000;

        long startTime = System.nanoTime();

        for (int i = 0; i < repetitions; i++) {
            lookup.searchStudent(searchId);
        }

        long endTime = System.nanoTime();

        long totalTime = endTime - startTime;
        double averageTime = (double) totalTime / repetitions;

        System.out.println("\nRecords: " + size);
        System.out.println("Total time: " + totalTime + " ns");
        System.out.println("Average lookup: " + averageTime + " ns");
    }
}
