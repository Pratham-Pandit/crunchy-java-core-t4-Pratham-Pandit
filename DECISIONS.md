# Data Structure Decision

## 1. Selected Data Structure: HashMap

For the Student Lookup feature, HashMap is selected as the final data structure.

It stores student records using their IDs as keys, allowing efficient retrieval.

## 2. Measured Reason

The final benchmark produced the following results:

| Number of Records | ArrayList (ns/lookup) | HashMap (ns/lookup) |
|---:|---:|---:|
| 10 | 47.28 | 10.58 |
| 100,000 | 921,960.90 | 23.60 |

For the 100,000-record dataset, HashMap demonstrated approximately 39,066 times faster lookup in the measured workload.

The time complexities are:

- ArrayList: O(n) for linear search.
- HashMap: O(1) average lookup time.

Therefore, HashMap is selected for this student ID lookup feature.

## 3. When ArrayList Would Be Preferred

ArrayList would be preferable when:

- Sequential access to student records is frequently required.
- Maintaining insertion order is important.
- The application frequently iterates through the entire collection.
- Key-based searching is not the main requirement.

ArrayList also provides a simpler structure when direct key-based lookup is unnecessary.

## 4. Final Decision

HashMap is selected because it provides substantially better measured lookup performance for the tested workload, especially with 100,000 records.

However, data structure selection depends on application requirements. HashMap is not universally better than ArrayList.
