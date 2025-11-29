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
public class PostOrderTraversal {
     public static void main(String[] args) {
        PostOrderTraversal POT = new PostOrderTraversal();
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);

        root.left.left = new Node(4);
        root.left.right = new Node(5);

        root.right.right = new Node(6);

        ArrayList<Integer> result = new ArrayList<>();
        POT.postorderTraversal(root, result);

        System.out.println("preorder Traversal:");
        for (int val : result) {
            System.out.print(val + " ");
        }
    }
    public void postorderTraversal(Node root,ArrayList<Integer> result){
        if(root == null) return;
        postorderTraversal(root.left,result);
        postorderTraversal(root.right,result);
        result.add(root.data);
    }
}
