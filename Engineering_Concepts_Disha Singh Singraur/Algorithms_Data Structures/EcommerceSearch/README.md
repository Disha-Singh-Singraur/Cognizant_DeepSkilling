# Exercise 2: E-commerce Platform Search Function

## Asymptotic Notation (Big O)
Big O notation describes the upper bound of the execution time of an algorithm in terms of the size of the input data ($N$). It helps analyze the scalability and efficiency of algorithms without relying on hardware or system-specific performance.

### Best, Average, and Worst-Case Scenarios
* **Best Case:** The minimum number of steps an algorithm needs to execute. For a search, it is usually $O(1)$ (e.g., the target is the very first element checked).
* **Average Case:** The expected execution time over random inputs.
* **Worst Case:** The maximum number of steps an algorithm will take (e.g., target is at the end or not present).

---

## Comparison of Search Algorithms

### 1. Linear Search
* **Time Complexity:**
  - Best Case: $O(1)$ (when the target is the first element)
  - Average Case: $O(N)$
  - Worst Case: $O(N)$ (when the target is at the end or not found)
* **Space Complexity:** $O(1)$
* **Requirements:** Works on any array (sorted or unsorted).

### 2. Binary Search
* **Time Complexity:**
  - Best Case: $O(1)$ (when the mid element matches target immediately)
  - Average Case: $O(\log N)$
  - Worst Case: $O(\log N)$
* **Space Complexity:** $O(1)$
* **Requirements:** Input array **must** be sorted.

---

## Decision for E-commerce Platform
For a search platform:
* If the dataset is small or updates constantly (making sorting overhead higher than simple searches), **linear search** is simple and acceptable.
* For most production systems where catalog data is queried millions of times but updated less frequently, **binary search** is far superior due to its $O(\log N)$ efficiency, provided we maintain a sorted list of products.
