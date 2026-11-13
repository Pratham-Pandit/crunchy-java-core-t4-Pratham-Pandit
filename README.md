# Student Lookup Performance Comparison

A Java-based project comparing two data structures, ArrayList and HashMap, for searching student records by ID.

This project demonstrates how choosing the right data structure can improve performance when working with large datasets.

## Project Objective

The objective is to implement the same student lookup feature using two different data structures, generate 100,000 student records, benchmark both implementations, and compare their performance.

## Technologies Used

- Java 21
- Maven
- JUnit 5
- Java Collections Framework
- System.nanoTime()

## Project Structure

```text
src/
├── main/
│   └── java/
│       ├── Student.java
│       ├── ArrayListStudentLookup.java
│       ├── HashMapStudentLookup.java
│       ├── StudentDataGenerator.java
│       └── Benchmark.java
│
└── test/
    └── java/
        ├── ArrayListStudentLookupTest.java
        ├── HashMapStudentLookupTest.java
        └── StudentDataGeneratorTest.java

BASELINE.md
RESULTS.md
DECISIONS.md
pom.xml
README.md
```

## Implementations

### 1. ArrayList Student Lookup

- Stores student records in an ArrayList.
- Searches for a student by checking IDs one by one.
- Time complexity: O(n).

### 2. HashMap Student Lookup

- Stores student records using student IDs as keys.
- Retrieves records using their IDs.
- Average lookup time complexity: O(1).

## Dataset Generation

The `StudentDataGenerator` class generates student records automatically.

The project supports generating 100,000 student records for performance testing.

## Benchmark Results

Both implementations were tested using the same generated datasets.

| Records | ArrayList (ns/lookup) | HashMap (ns/lookup) |
|---:|---:|---:|
| 10 | 47.28 | 10.58 |
| 100,000 | 921,960.90 | 23.60 |

### Benchmark Methodology

- Three JVM warm-up rounds.
- Five measurement rounds.
- Median lookup time reported.
- Alternating measurement order.
- Same dataset and lookup target for both implementations.
- The last student ID is searched in each dataset.

HashMap demonstrated significantly lower lookup time in this workload, particularly with 100,000 records.

These measurements are specific to the tested environment and should not be interpreted as a universal performance guarantee.

See `RESULTS.md` for detailed measurements and `DECISIONS.md` for the final data structure decision.


## Testing

JUnit 5 is used to test both implementations and the data generator.

Current test results:

- ArrayListStudentLookupTest: 4 tests passed.
- HashMapStudentLookupTest: 5 tests passed.
- StudentDataGeneratorTest: 2 tests passed.

Total: 11 tests passed with zero failures.

Run the tests using:

```bash
mvn clean test
```

## Running the Benchmark

Compile the project:

```bash
mvn clean compile
```

Run the benchmark:

```bash
java -cp target/classes Benchmark
```

## Final Decision

HashMap was selected as the preferred data structure for student ID lookup because it demonstrated significantly better performance with 100,000 records.

ArrayList remains useful for sequential access and smaller collections.

See `DECISIONS.md` for the detailed reasoning.

## Author

**Pratham Pandit**