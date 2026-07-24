import java.util.LinkedList;
import java.util.Queue;

public class SumAtKthLevel {

    // Representation of a single Node in the Binary Tree
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

    // Method to calculate the sum of nodes at the Kth level
    public static int sumAtKthLevel(Node root, int K) {
        if (root == null) {
            return 0;
        }

        Queue<Node> q = new LinkedList<>();
        q.add(root);
        q.add(null);

        int currentLevel = 1;
        int sum = 0;

        while (!q.isEmpty()) {
            Node currNode = q.remove();

            if (currNode == null) {
                // If we reach the end of the current level
                if (q.isEmpty()) {
                    break;
                } else {
                    // Mark the end of the next level
                    q.add(null); 
                    currentLevel++;
                }
            } else {
                // If we are at the target level K, add node data to sum
                if (currentLevel == K) {
                    sum += currNode.data;
                }

                // Add left child to queue if exists
                if (currNode.left != null) {
                    q.add(currNode.left);
                }

                // Add right child to queue if exists
                if (currNode.right != null) {
                    q.add(currNode.right);
                }
            }
        }

        return sum;
    }

    // Main execution method
    public static void main(String[] args) {
        // Pre-order
        int nodes[] = {1, 2, 4, -1, -1, 5, -1, -1, 3, -1, 6, -1, -1};
        
        Node root = BinaryTreeBuilder.treeBuilder(nodes);

        int K = 2;
        int result = sumAtKthLevel(root, K);

        System.out.println("Sum of nodes at level " + K + " is: " + result);
    }
}