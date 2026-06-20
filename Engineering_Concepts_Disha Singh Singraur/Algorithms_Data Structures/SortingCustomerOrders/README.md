# Exercise 3: Sorting Customer Orders

## Understanding Sorting Algorithms
* **Bubble Sort:** A simple comparison-based sorting algorithm that repeatedly steps through the list, compares adjacent elements, and swaps them if they are in the wrong order. It is inefficient for large datasets.
* **Insertion Sort:** Builds the final sorted array one item at a time, inserting each element into its proper position relative to the already sorted part. It is efficient for small datasets.
* **Quick Sort:** A divide-and-conquer algorithm that selects a 'pivot' element, partitions the array into elements smaller and larger than the pivot, and recursively sorts the sub-arrays.
* **Merge Sort:** A divide-and-conquer algorithm that divides the array in half, recursively sorts both halves, and then merges the sorted halves back together. It is stable and has guaranteed performance.

---

## Comparison of Bubble Sort and Quick Sort

| Algorithm | Best Case Time Complexity | Average Case Time Complexity | Worst Case Time Complexity | Space Complexity |
| :--- | :--- | :--- | :--- | :--- |
| **Bubble Sort** | $O(N)$ (if already sorted) | $O(N^2)$ | $O(N^2)$ | $O(1)$ |
| **Quick Sort** | $O(N \log N)$ | $O(N \log N)$ | $O(N^2)$ (poor pivot selection) | $O(\log N)$ |

---

## Why Quick Sort is Preferred
1. **Average Performance:** Its average-case complexity is $O(N \log N)$, which grows much slower than $O(N^2)$ as $N$ increases.
2. **In-place Sorting:** Quick Sort is highly efficient in memory usage as it sorts elements in-place (with $O(\log N)$ recursion stack space), unlike Merge Sort which requires auxiliary space.
3. **Cache Friendly:** It has good locality of reference, making it faster in practice than other $O(N \log N)$ sorting algorithms on modern computer architectures.
