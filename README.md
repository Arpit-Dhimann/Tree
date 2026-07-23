# 🌳 Tree Data Structures & Algorithms

A comprehensive Java repository dedicated to mastering hierarchical data structures, structural manipulation, and tree traversal algorithms. This project serves as a structured implementation guide, moving from foundational binary trees to complex algorithmic patterns.

## 🚀 Repository Architecture & Implementations

| Category / File | Description | Algorithmic Paradigm / Focus |
| :--- | :--- | :--- |
| **`BinaryTree.java`** | Core blueprint for tree nodes and array-based deserialization. | Recursive pre-order construction using sentinel values (`-1` for null nodes). |
| **`PreorderTraversal.java`** | Depth-First Search variant visiting nodes in sequence. | **Root $\rightarrow$ Left $\rightarrow$ Right** traversal pattern. |
| **`InorderTraversal.java`** | Sorted-order traversal implementation for binary search structures. | **Left $\rightarrow$ Root $\rightarrow$ Right** sequence logic. |
| **`PostorderTraversal.java`** | Bottom-up processing strategy for structural clean-up and evaluation. | **Left $\rightarrow$ Right $\rightarrow$ Root** execution flow. |
| **`LevelOrderTraversal.java`** | Breadth-First Search (BFS) level-by-level traversal variant using a Queue. | **Queue-based FIFO processing with level separation markers (`null`)**. |
| **`CountOfNodes.java`** | Recursive node counting algorithm for binary trees. | **Bottom-up structural summation (`leftCount + rightCount + 1`)**. |
| **`SumOfNodes.java`** | Cumulative value summation strategy across all tree nodes. | **Recursive data accumulation (`leftSum + rightSum + root.data`)**. |
| **`HeightOfTree.java`** | Depth and maximum level calculation implementation. | **Max-depth evaluation via `Math.max(leftHeight, rightHeight) + 1`**. |

---

## 🛠 Core Concepts & Theoretical Foundations

- **Hierarchical Modeling:** Understanding parent-child relationships, node degrees, heights, depths, and subtrees without linear constraints.
- **Recursive Deserialization:** Reconstructing multi-branch architecture from flattened serialized arrays using stateful index tracking (`static int idx`).
- **Depth-First Search (DFS) Variants:** 
  - *Pre-order:* Ideal for cloning trees or serializing structural hierarchies.
  - *In-order:* Yields sorted elements when applied to Binary Search Trees (BST).
  - *Post-order:* Essential for bottom-up computational tasks like deleting nodes or calculating subtree sizes/heights.
- **Breadth-First Search (BFS) Variants:**
  - *Level-Order:* Traverses the tree level by level using a Queue, highly useful for finding shortest paths or printing hierarchical levels.

---
*Learning in public - Arpit Dhiman*