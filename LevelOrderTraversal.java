import java.util.*;

public class LevelOrderTraversal {
    static class Node {
        int data;
        Node left;
        Node right;

        Node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    // Helper class to build a binary tree from an array
    static class binaryTreeBuilder {
        static int index = -1; // Pointer to keep track of the array elements

        // Method to recursively build the tree
        public static Node buildTree(int[] nodes) {
            index++;
            // If the value is -1, it means the node is null (no child)
            if (nodes[index] == -1) {
                return null;
            }

            // Create a new node with the current array value
            Node newNode = new Node(nodes[index]);
            // Recursively build left and right subtrees
            newNode.left = buildTree(nodes);
            newNode.right = buildTree(nodes);

            return newNode;
        }   
    }

    // Pre-order Traversal: Root -> Left -> Right
    public static void preorder(Node root) {
        if (root == null) {
            return;
        }
        System.out.print(root.data + " ");
        preorder(root.left);
        preorder(root.right);
    }

    // Level-order Traversal (Breadth-First Search) level by level with new lines
    public static void levelOrder(Node root) {
        if (root == null) {
            return;
        }
            
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        // Marker for the end of the current level
        queue.add(null);

        while (!queue.isEmpty()) {
            Node currNode = queue.remove();
            
            // If we encounter null, it means the current level has ended
            if (currNode == null) {
                // Move to the next line for the next level
                System.out.println();
                if (queue.isEmpty()) {
                    // If queue is empty, traversal is complete
                    break;
                } 
                else {
                    // Add marker for the next level
                    queue.add(null);
                }
            } 
            else {
                // Print the current node's data
                System.out.print(currNode.data + " ");
                
                // Add left child to queue if it exists
                if (currNode.left != null) {
                    queue.add(currNode.left);
                }
                // Add right child to queue if it exists
                if (currNode.right != null) {
                    queue.add(currNode.right);
                }
            }
        }
    }

    public static void main(String[] args) {
        int[] nodes = {1, 2, 4, -1, -1, 5, -1, -1, 3, -1, 6, -1, -1};
        Node root = binaryTreeBuilder.buildTree(nodes);
        System.out.println("Level-order Traversal : ");
        levelOrder(root);
    }
}