public class DiameterOptimized {

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
    
    // Helper class to store both height and diameter together (O(n) approach)
    static class TreeInfo {
        int ht;
        int diam;

        // Constructor name should match the class name (TreeInfo)
        TreeInfo(int ht, int diam) {
            this.ht = ht;
            this.diam = diam;
        }
    }
    
    // Optimized method to calculate height and diameter in O(n) time complexity
    public static TreeInfo diameter(Node root) {
        if(root == null) {
            return new TreeInfo(0, 0);
        }

        TreeInfo left = diameter(root.left);
        TreeInfo right = diameter(root.right);
        int Height = Math.max(left.ht, right.ht) + 1;

        int diam1 = left.diam;
        int diam2 = right.diam;
        int diam3 = left.ht + right.ht + 1;
        int Diameter = Math.max(Math.max(diam1, diam2), diam3);

        return new TreeInfo(Height, Diameter);
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

        // Print the height and diameter using the TreeInfo object
        System.out.println("Height of Tree are : " + diameter(root).ht);
        System.out.println("Diameter of Tree are : " + diameter(root).diam);
    }
}