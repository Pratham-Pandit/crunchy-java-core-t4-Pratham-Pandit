
import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import java.util.function.Function;

public class Benchmark {

    // Prevents the JVM from ignoring lookup results
    private static volatile Student lastFound;

    public static void main(String[] args) {

        int[] sizes = {10, 100000};

        System.out.println("===== FINAL PERFORMANCE COMPARISON =====");

        for (int size : sizes) {
            runBenchmark(size);
        }
    }

    private static void runBenchmark(int size) {

        // Generate one dataset for both implementations
        List<Student> students
                = StudentDataGenerator.generateStudents(size);

        ArrayListStudentLookup arrayList
                = new ArrayListStudentLookup();

        HashMapStudentLookup hashMap
                = new HashMapStudentLookup();

        // Add the same students to both structures
        for (Student student : students) {
            arrayList.addStudent(student);
            hashMap.addStudent(student);
        }

        // Search for the last student
        String searchId = String.valueOf(size);

        int repetitions = (size == 10) ? 100000 : 1000;

        int warmupRounds = 3;
        int measurementRounds = 5;

        // Warm up both implementations
        for (int i = 0; i < warmupRounds; i++) {
            measure(arrayList::searchStudent, searchId, repetitions);
            measure(hashMap::searchStudent, searchId, repetitions);
        }

        double[] arrayListTimes = new double[measurementRounds];
        double[] hashMapTimes = new double[measurementRounds];

        // Perform multiple measurement rounds
        // Alternate the measurement order for fairness
        for (int i = 0; i < measurementRounds; i++) {

            if (i % 2 == 0) {

                arrayListTimes[i]
                        = measure(arrayList::searchStudent, searchId, repetitions);

                hashMapTimes[i]
                        = measure(hashMap::searchStudent, searchId, repetitions);

            } else {

                hashMapTimes[i]
                        = measure(hashMap::searchStudent, searchId, repetitions);

                arrayListTimes[i]
                        = measure(arrayList::searchStudent, searchId, repetitions);
            }
        }

        double arrayListMedian = median(arrayListTimes);
        double hashMapMedian = median(hashMapTimes);

        System.out.println("\nRecords: " + size);
        System.out.println("Repetitions per round: " + repetitions);

        System.out.printf(Locale.ROOT,
                "ArrayList median: %.2f ns per lookup%n",
                arrayListMedian);

        System.out.printf(Locale.ROOT,
                "HashMap median: %.2f ns per lookup%n",
                hashMapMedian);
    }

    // Measures the time taken for repeated lookups
    private static double measure(
            Function<String, Student> search,
            String searchId,
            int repetitions) {

        long startTime = System.nanoTime();

        for (int i = 0; i < repetitions; i++) {
            lastFound = search.apply(searchId);
        }

        long endTime = System.nanoTime();

        return (double) (endTime - startTime) / repetitions;
    }

    // Finds the median of the measurement results
    private static double median(double[] times) {

        double[] sortedTimes = times.clone();

        Arrays.sort(sortedTimes);

        return sortedTimes[sortedTimes.length / 2];
    }
}
