# Performance Benchmark Results

## 1. Objective

The objective of this benchmark is to compare two data structures for searching students by their ID:

- **ArrayList:** Uses linear search to find a student.
- **HashMap:** Uses the student ID as a key for direct lookup.

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

## 3. Benchmark Results

The following results were obtained by searching for the last student ID in each dataset.

| Number of Records | ArrayList (ns/lookup) | HashMap (ns/lookup) |
|---:|---:|---:|
| 10 | 57.63 | 21.47 |
| 100,000 | 2,043,445.00 | 121.20 |

## 4. Analysis

For 10 records, HashMap performed faster than ArrayList in this benchmark.

For 100,000 records, HashMap performed significantly faster. ArrayList must examine records one by one, whereas HashMap provides average constant-time lookup.

The measured ArrayList lookup time was approximately 16,860 times higher than the HashMap lookup time for the 100,000-record dataset.

## 5. Conclusion

The benchmark demonstrates that HashMap is a better choice for this student lookup feature when working with a large number of records.

ArrayList is still useful for smaller collections and situations where sequential access is important.

The results are specific to this benchmark environment and workload. They should not be interpreted as a guarantee that HashMap is always faster in every situation.
