# Data Structure Decision

## 1. Selected Data Structure: HashMap

For the Student Lookup feature, I selected **HashMap** as the final data structure.

HashMap stores student records using their student ID as the key, allowing efficient retrieval without checking every record individually.

## 2. Reason for Selection

The benchmark results showed that HashMap performed significantly better for student lookup.

| Number of Records | ArrayList | HashMap |
|---:|---:|---:|
| 10 | 57.63 ns | 21.47 ns |
| 100,000 | 2,043,445 ns | 121.20 ns |

For 100,000 records, HashMap was approximately 16,860 times faster in the measured workload.

The main reason is the difference in time complexity:

- **ArrayList:** O(n) for linear search.
- **HashMap:** O(1) average time for lookup.

Therefore, HashMap is more suitable for this feature when the number of student records becomes large.

## 3. When ArrayList Would Be Preferred

ArrayList would be preferable when:

- The application mainly needs sequential access to records.
- Maintaining insertion order is important.
- The collection is small and simple to manage.
- Frequent iteration is more important than searching by ID.

ArrayList is also simpler when key-based lookup is not required.

## 4. Final Conclusion

Based on the benchmark measurements and time complexity analysis, HashMap is selected for the Student Lookup feature.

However, the choice of data structure depends on the application's requirements. HashMap is not universally better than ArrayList for every use case.
