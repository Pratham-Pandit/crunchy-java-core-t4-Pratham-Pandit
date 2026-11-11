
# ArrayList Baseline Benchmark

## Environment
- Java: 21
- Build tool: Maven
- Benchmark tool: System.nanoTime()
- Lookup repetitions: 1,000
- JVM warm-up: 5 iterations

## Results

| Records | Average Lookup Time |
|---:|---:|
| 10 | 212.3 ns |
| 100,000 | 852,301.6 ns |

## Observation

The ArrayList implementation performs a linear search.
As the number of student records increases, lookup time
increases because records are checked one by one.

These measurements will be compared against the
HashMap implementation in the final benchmark.
