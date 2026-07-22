// Implementation of In-order Traversal in a Binary Tree
public class InorderTraversal {

    // Implementation of a Binary Tree building from a pre-order sequence
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

    // In-order Traversal: Left Subtree -> Root -> Right Subtree (Without printing -1)
    public static void inorder(Node root) {
        if (root == null) {
            return;
        }
        inorder(root.left);
        System.out.print(root.data + " ");
        inorder(root.right);
    }

    public static void main(String args[]) {
        // Pre-order representation of the binary tree (-1 indicates null)
        int nodes[] = {1, 2, 4, -1, -1, 5, -1, -1, 3, -1, 6, -1, -1};
        
        // Building the tree
        Node root = binaryTreeBuilder.buildTree(nodes);
        
        // Printing the in-order traversal sequence of the tree
        System.out.print("In-order Traversal : ");
        inorder(root);
    }
}