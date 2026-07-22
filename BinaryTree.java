// Implementation of a Binary Tree building from a pre-order sequence
public class BinaryTree {
    static class Node {
        int data;
        Node left;
        Node right;

        // Constructor to create a new tree node
        Node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    static class binaryTreeBuilder {
        static int idx = -1;

        // Method to build a binary tree from an array (Pre-order sequence with -1 as null nodes)
        public static Node buildTree(int nodes[]) {
            idx++;
            
            // Base case: if the node value is -1, it represents a null child
            if (nodes[idx] == -1) {
                return null;
            }

            // Create a new node with the current array value
            Node newNode = new Node(nodes[idx]); 
            
            // Recursively build the left and right subtrees
            newNode.left = buildTree(nodes);
            newNode.right = buildTree(nodes);
            
            return newNode;
        }
    }

    public static void main(String args[]) {
        // Pre-order representation of the binary tree (-1 indicates null)
        int nodes[] = {1, 2, 4, -1, -1, 5, -1, -1, 3, -1, 6, -1, -1};
        
        // Building the tree
        Node root = binaryTreeBuilder.buildTree(nodes);
        
        // Printing the root node's data
        System.out.println("Root Node Data : " + root.data);
    }
}