# Exercise 1: Inventory Management System

## Why Data Structures & Algorithms are Essential
In handling large inventories, data structures and algorithms are essential because they dictate the scalability of operations. If a warehouse has millions of items, an inefficient search algorithm ($O(N)$) could cause unacceptable delays. Selecting the appropriate data structures ensures operations can be executed in minimal time and resource space.

## Chosen Data Structure
For this implementation, we used a `HashMap` in Java to store the products.
- Key: `productId` (String)
- Value: `Product` object

This selection ensures quick access using unique identifiers.

## Time Complexity Analysis
- **Add Product:** $O(1)$ average time complexity. Inserting a key-value pair in a HashMap has constant time complexity.
- **Update Product:** $O(1)$ average time complexity. Retrieving the product using the key takes $O(1)$, and modifying its fields is also $O(1)$.
- **Delete Product:** $O(1)$ average time complexity. Removing a key-value pair from a HashMap is a constant-time operation.

### Comparison with alternative structures:
* If we used an `ArrayList`, adding is $O(1)$ amortized, but updating and deleting requires a search, taking $O(N)$ time.
* If we used a sorted `ArrayList`, search could be optimized to $O(\log N)$ using binary search, but insertion and deletion would still be $O(N)$ due to shifting elements.

## Optimization Discussion
To optimize a HashMap, we must:
1. Ensure a good hash function to minimize hash collisions.
2. Initialize the HashMap with an appropriate initial capacity and load factor to avoid frequent rehashing as the inventory grows.
