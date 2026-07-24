public class DiameterOfTree {

    // Representation of a single Node in the Binary Tree
    static class Node {
        int data;
        Node left;
        Node right;

        // Constructor to initialize a node with data
        Node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    // Helper class to build a Binary Tree from a pre-order sequence array
    static class BinaryTreeBuilder {
        static int idx = -1;

        // Method to recursively build the tree
        public static Node treeBuilder(int nodes[]) {
            idx++;
            
            // Base case: if the current value is -1, it represents a null node
            if (nodes[idx] == -1) {
                return null;
            }

            // Create a new node with the current array value
            Node newNode = new Node(nodes[idx]);
            
            // Recursively build the left and right subtrees
            newNode.left = treeBuilder(nodes);
            newNode.right = treeBuilder(nodes);
            return newNode;
        }
    }

    // Method to perform In-Order traversal (Left -> Root -> Right) and print nodes
    public static void inOrder(Node root) {
        if (root == null) {
            return;
        }

        inOrder(root.left);
        System.out.print(root.data + " ");
        inOrder(root.right);
    }

    // Method to calculate the height of the Binary Tree
    public static int heightOfTree(Node root) {
        if (root == null) {
            return 0; 
        }

        int leftHeight = heightOfTree(root.left);
        int rightHeight = heightOfTree(root.right);
        int Height = Math.max(leftHeight, rightHeight) + 1;
        return Height;
    }
    
    // Method to calculate the diameter of the Binary Tree (max path length between any two nodes)
    public static int diameterOfTree(Node root) {
        if (root == null) {
            return 0;
        }

        // Case 1: Diameter lies entirely in the left subtree
        int diam1 = diameterOfTree(root.left);
        
        // Case 2: Diameter lies entirely in the right subtree
        int diam2 = diameterOfTree(root.right);
        
        // Case 3: Diameter passes through the current root node
        int diam3 = heightOfTree(root.left) + heightOfTree(root.right) + 1; 
        
        // Return the maximum of all three cases
        return Math.max(diam3, Math.max(diam1, diam2));
    }

    // Main execution method
    public static void main(String[] args) {
        // Pre-order representation of the binary tree (-1 indicates a null/empty node)
        int nodes[] = {1, 2, 4, -1, -1, 5, -1, -1, 3, -1, 6, -1, -1};
        
        // Build the binary tree and get the root node
        Node root = BinaryTreeBuilder.treeBuilder(nodes);
        
        // Print the In-Order traversal of the tree
        System.out.print("Tree are : ");
        inOrder(root);
        System.out.println();

        // Print the height of the tree
        System.out.print("Height of Tree are : " + heightOfTree(root));
        System.out.println();

        // Print the diameter of the tree
        System.out.print("Diamater of Tree are : " + diameterOfTree(root));
    }
}