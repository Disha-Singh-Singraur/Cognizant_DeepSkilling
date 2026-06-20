# Exercise 7: Financial Forecasting

## Recursion Analysis
Recursion is an algorithm design pattern where a method calls itself to solve a smaller subproblem of the same problem.
In this exercise, to calculate future value over $N$ periods, we define:
- **Base Case:** For $N = 0$, $FV = PV$.
- **Recursive Case:** For $N > 0$, $FV(N) = FV(N - 1) \times (1 + r)$.

---

## Time Complexity
* **Time Complexity:** $O(N)$
  - Since we decrement `periods` by 1 at each step, the recursive function calls itself exactly $N$ times.
* **Space Complexity:** $O(N)$
  - Each recursive call adds a frame to the call stack. For $N$ periods, the stack height is $N$, which can lead to a `StackOverflowError` if $N$ is excessively large.

---

## Optimizations to Avoid Excessive Computation
To optimize recursive algorithms and prevent potential stack overflow, we can use the following strategies:

### 1. Iterative Solution
Replacing recursion with a simple loop reduces space complexity from $O(N)$ to $O(1)$ by removing call stack overhead:
```java
public static double calculateFutureValueIterative(double currentValue, double growthRate, int periods) {
    double value = currentValue;
    for (int i = 0; i < periods; i++) {
        value *= (1 + growthRate);
    }
    return value;
}
```

### 2. Memoization (Top-down Dynamic Programming)
If there are overlapping subproblems (e.g., in calculating complex Fibonacci-like multi-variable forecasts), we can cache computed results in a map or array. When the same subproblem is encountered, the cached result is returned immediately in $O(1)$ time.

### 3. Direct Mathematical Formula
For compound growth, future value can be solved directly in $O(\log N)$ or $O(1)$ using exponentiation (`Math.pow`):
$$FV = PV \times (1 + r)^N$$
In Java:
```java
public static double calculateFutureValueFormula(double currentValue, double growthRate, int periods) {
    return currentValue * Math.pow(1 + growthRate, periods);
}
```
This requires no recursion and avoids call stack overhead.
