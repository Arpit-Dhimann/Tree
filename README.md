# 🌳 Tree Data Structures & Algorithms

A comprehensive Java repository dedicated to mastering hierarchical data structures, structural manipulation, and tree traversal algorithms. This project serves as a structured implementation guide, moving from foundational binary trees to complex algorithmic patterns.

## 🚀 Repository Architecture & Implementations

| Category / File | Description | Algorithmic Paradigm / Focus |
| :--- | :--- | :--- |
| **`BinaryTree.java`** | Core blueprint for tree nodes and array-based deserialization. | Recursive pre-order construction using sentinel values (`-1` for null nodes). |
| **`PreorderTraversal.java`** | Depth-First Search variant visiting nodes in sequence. | **Root $\rightarrow$ Left $\rightarrow$ Right** traversal pattern. |
| **`InorderTraversal.java`** | Sorted-order traversal implementation for binary search structures. | **Left $\rightarrow$ Root $\rightarrow$ Right** sequence logic. |
| **`PostorderTraversal.java`** | Bottom-up processing strategy for structural clean-up and evaluation. | **Left $\rightarrow$ Right $\rightarrow$ Root** execution flow. |

---

## 🛠 Core Concepts & Theoretical Foundations

- **Hierarchical Modeling:** Understanding parent-child relationships, node degrees, heights, depths, and subtrees without linear constraints.
- **Recursive Deserialization:** Reconstructing multi-branch architecture from flattened serialized arrays using stateful index tracking (`static int idx`).
- **Depth-First Search (DFS) Variants:** 
  - *Pre-order:* Ideal for cloning trees or serializing structural hierarchies.
  - *In-order:* Yields sorted elements when applied to Binary Search Trees (BST).
  - *Post-order:* Essential for bottom-up computational tasks like deleting nodes or calculating subtree sizes/heights.

---
*Learning in public - Arpit Dhiman*