public class CountOfNodes {

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

    // Function to count the total number of nodes in the binary tree
    public static int countOfNodes(Node root) {
        // Base case: if the tree or subtree is empty, count is 0
        if (root == null) {
            return 0;
        }

        // Recursively count nodes in the left subtree
        int leftNode = countOfNodes(root.left);
        // Recursively count nodes in the right subtree
        int rightNode = countOfNodes(root.right);
        
        // Total nodes = (nodes in left subtree) + (nodes in right subtree) + (current root node i.e., 1)
        return leftNode + rightNode + 1;
    }

    public static void main(String[] args) {
        int[] nodes = {1, 2, 4, -1, -1, 5, -1, -1, 3, -1, 6, -1, -1};
        
        // Build the tree and get the root node
        Node root = binaryTreeBuilder.buildTree(nodes);
        
        System.out.print("Pre-Order Traversal : ");
        preorder(root);
        System.out.println();
        
        // Print the total count of nodes
        System.out.println("Number of Nodes are : " + countOfNodes(root));
    }
}