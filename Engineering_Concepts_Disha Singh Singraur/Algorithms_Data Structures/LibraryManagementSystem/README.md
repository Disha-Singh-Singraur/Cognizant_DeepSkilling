# Exercise 6: Library Management System

## Linear Search vs Binary Search

### 1. Linear Search
* **Concept:** Scan the list sequentially element-by-element from the beginning until a match is found.
* **Time Complexity:** 
  - Best Case: $O(1)$
  - Worst Case: $O(N)$
  - Average Case: $O(N)$
* **Requirements:** Can be performed on unsorted or sorted data.

### 2. Binary Search
* **Concept:** Divide-and-conquer strategy that finds the middle element, compares it with the target, and discards the half that cannot contain the target. Repeat recursively.
* **Time Complexity:**
  - Best Case: $O(1)$
  - Worst Case: $O(\log N)$
  - Average Case: $O(\log N)$
* **Requirements:** Data **must** be sorted.

---

## When to Use Which
* **Use Linear Search when:**
  - The dataset is small (e.g., less than 50 elements) where search time is negligible.
  - The dataset is unsorted and frequently changing, and the cost of sorting before binary search exceeds the search benefits.
  
* **Use Binary Search when:**
  - The dataset is large (e.g., thousands of books) because $O(\log N)$ scales very efficiently.
  - The list is already sorted or infrequently updated, allowing us to sort it once and run many search queries.
