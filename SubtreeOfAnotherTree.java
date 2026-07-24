public class SubtreeOfAnotherTree {

    // Definition for a binary tree node.
    static class Node {
        int val;
        Node left;
        Node right;

        Node(int val) {
            this.val = val;
            this.left = null;
            this.right = null;
        }
    }

    // Helper class to build a Binary Tree from a pre-order sequence array
    static class BinaryTreeBuilder {
        static int idx = -1;

        public static Node treeBuilder(int nodes[]) {
            idx++;
            if (nodes[idx] == -1) {
                return null;
            }

            Node newNode = new Node(nodes[idx]);
            newNode.left = treeBuilder(nodes);
            newNode.right = treeBuilder(nodes);

            return newNode;
        }
    }

    // Method to check if two trees are identical
    public static boolean isIdentical(Node root, Node subRoot) {
        if (subRoot == null && root == null) {
            return true;
        }
        if (root == null || subRoot == null) {
            return false;
        }
        if (root.val == subRoot.val) {
            return isIdentical(root.left, subRoot.left) && isIdentical(root.right, subRoot.right);
        }
        return false;
    }

    // Method to check if subRoot is a subtree of root
    public static boolean isSubtree(Node root, Node subRoot) {
        if (subRoot == null) {
            return true;
        }
        if (root == null) {
            return false;
        }
        if (isIdentical(root, subRoot)) {
            return true;
        }
        return isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot);
    }

    // Method to perform In-Order traversal and print tree nodes
    public static void inOrder(Node root) {
        if (root == null) {
            return;
        }

        inOrder(root.left);
        System.out.print(root.val + " ");
        inOrder(root.right);
    }

    // Main execution method
    public static void main(String[] args) {
        // Main Tree nodes array (Pre-order format, -1 means null)
        int nodes[] = {3, 4, 1, -1, -1, 2, -1, -1, 5, -1, -1};
        
        // Subtree nodes array
        int subNodes[] = {4, 1, -1, -1, 2, -1, -1};

        // Building the main tree
        Node root = BinaryTreeBuilder.treeBuilder(nodes);
        
        // Reset index back to -1 before building the second tree
        BinaryTreeBuilder.idx = -1; 
        
        // Building the subroot tree
        Node subRoot = BinaryTreeBuilder.treeBuilder(subNodes);

        // Printing main tree using In-Order traversal
        System.out.print("Main Tree (In-Order)     : ");
        inOrder(root);
        System.out.println();

        // Printing subroot tree using In-Order traversal
        System.out.print("Subroot Tree (In-Order)  : ");
        inOrder(subRoot);
        System.out.println();

        // Checking whether subRoot is a subtree of root
        System.out.println("Is subRoot a subtree of root? : " + isSubtree(root, subRoot));
    }
}