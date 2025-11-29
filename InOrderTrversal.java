import java.util.*;

class Node {
    Node left;
    Node right;
    int data;

    Node(int val) {
        this.data = val;
        left = null;
        right = null;
    }
}

public class InOrderTrversal {

    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);

        root.left.left = new Node(4);
        root.left.right = new Node(5);

        root.right.right = new Node(6);

        ArrayList<Integer> result = new ArrayList<>();
        inorderTraversal(root, result);

        System.out.println("Inorder Traversal:");
        for (int val : result) {
            System.out.print(val + " ");
        }
    }

    // Make method static
    public static void inorderTraversal(Node root, ArrayList<Integer> result) {
        if (root == null) return;
        inorderTraversal(root.left, result);
        result.add(root.data);
        inorderTraversal(root.right, result);
    }
}
