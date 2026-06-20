# Exercise 5: Task Management System

## Singly vs Doubly Linked Lists
- **Singly Linked List:** Each node contains data and a pointer to the next node in the sequence. It allows traversal in the forward direction only and has lower memory overhead per node.
- **Doubly Linked List:** Each node contains data and two pointers: one to the next node and one to the previous node. This allows traversal in both directions and simplifies deletion/insertion if a reference to the node is already available, though it requires more memory.

---

## Time Complexity Analysis

| Operation | Singly Linked List Time Complexity | Explanation |
| :--- | :--- | :--- |
| **Add (to end)** | $O(N)$ (or $O(1)$ with tail pointer) | Since we traverse to the end of the list, it takes $O(N)$ time. With a tail pointer, it would be $O(1)$. |
| **Search** | $O(N)$ | Requires sequential scan from the head to find the element. |
| **Traverse** | $O(N)$ | Requires visiting all nodes in sequence. |
| **Delete** | $O(N)$ | Requires searching for the node to delete and its predecessor, taking $O(N)$ time. |

---

## Advantages of Linked Lists over Arrays
1. **Dynamic Size:** Linked lists can grow or shrink dynamically without requiring reallocation or copying of elements.
2. **Efficient Insertions/Deletions:** Inserting or deleting an element does not require shifting other elements in memory; it only requires updating pointer references, which is an $O(1)$ operation once the position is located.
3. **No Memory Over-allocation:** Memory is allocated node-by-node only when needed, avoiding wasted space.
