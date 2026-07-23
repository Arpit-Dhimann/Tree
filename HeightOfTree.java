public class HeightOfTree {

    // Node structure for the Binary Tree
    static class Node {
        int data;
        Node left;
        Node right;

        // Constructor to initialize a new node
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

    // Function to find the height of the binary tree
    public static int height(Node root) {
        // Base case: if the tree or subtree is empty, its height is 0
        if(root == null) {
            return 0;
        }

        // Recursively find the height of the left subtree
        int leftHeight = height(root.left);
        // Recursively find the height of the right subtree
        int rightHeight = height(root.right);
        
        // Tree height = maximum height between left and right subtrees + 1 (for the root node)
        return Math.max(leftHeight, rightHeight) + 1;
    }

    public static void main(String[] args) {
        int[] nodes = {1, 2, 4, -1, -1, 5, -1, -1, 3, -1, 6, -1, -1};
        
        // Build the tree and get the root node
        Node root = binaryTreeBuilder.buildTree(nodes);
        
        System.out.print("Pre-Order Traversal : ");
        preorder(root);
        System.out.println();
        
        // Print the height of the binary tree
        System.out.println("Height of the tree is : " + height(root));
    }
}