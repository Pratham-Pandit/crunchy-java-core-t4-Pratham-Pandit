# Performance Benchmark Results

## 1. Objective

The objective is to compare ArrayList and HashMap for searching student records by ID.

Both implementations use the same generated student records.

## 2. Benchmark Environment

| Parameter | Value |
|---|---|
| Programming Language | Java 21 |
| Build Tool | Maven |
| Benchmark Tool | System.nanoTime() |
| JVM Warm-up Rounds | 3 |
| Measurement Rounds | 5 |
| Measurement Method | Median lookup time |
| Dataset Sizes | 10 and 100,000 |
| Lookup Target | Last student ID |

## 3. Final Benchmark Results

| Number of Records | ArrayList (ns/lookup) | HashMap (ns/lookup) |
|---:|---:|---:|
| 10 | 47.28 | 10.58 |
| 100,000 | 921,960.90 | 23.60 |

## 4. Analysis

For both dataset sizes, HashMap demonstrated lower lookup time in this benchmark.

For 100,000 records, the measured ArrayList lookup took approximately 39,066 times longer than HashMap.

ArrayList uses linear search, with O(n) time complexity. HashMap provides average O(1) lookup time.

The benchmark searches for the last student in the dataset, representing the worst-case search position for ArrayList.

The measurement order was alternated across five rounds to reduce consistent first-versus-second measurement bias.

## 5. Conclusion

HashMap is selected for the student ID lookup feature because it demonstrated significantly better performance for this workload, particularly with 100,000 records.

ArrayList remains useful for sequential access, maintaining an ordered collection, and situations where key-based lookup is not the primary requirement.

These results are specific to the tested environment and workload and do not establish that HashMap is universally faster.
