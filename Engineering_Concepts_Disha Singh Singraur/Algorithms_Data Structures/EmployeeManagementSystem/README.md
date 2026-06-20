# Exercise 4: Employee Management System

## Array Representation in Memory
Arrays are represented as contiguous blocks of memory. Each element in the array is stored next to the other, which enables:
- **Direct addressing:** Element access in $O(1)$ time by calculating the memory address as `Base Address + (Index * Size of Element)`.
- **Cache Locality:** Contiguous memory means loading one element into cache reads surrounding elements as well, optimizing subsequent accesses.

---

## Time Complexity Analysis

1. **Add (Insertion):** $O(1)$
   - Inserting an element at the end of the array (if space is available) takes constant time.
2. **Search:** $O(N)$
   - If the array is unsorted, we must perform a linear search, examining up to $N$ elements.
3. **Traverse:** $O(N)$
   - Displaying or visiting all elements requires scanning each element once.
4. **Delete:** $O(N)$
   - Deleting requires searching for the element ($O(N)$) and then shifting all subsequent elements left to maintain a contiguous array ($O(N)$).

---

## Limitations of Arrays
- **Fixed Size:** The size of an array is determined at creation and cannot grow dynamically.
- **Costly Deletions/Insertions:** Modifying elements in the middle of an array requires shifting elements, which is slow ($O(N)$).
- **Memory Inefficiency:** If the array size is overallocated, memory is wasted; if underallocated, it triggers costly resize/copy operations.
