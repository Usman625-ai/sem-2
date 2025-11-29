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
public class PreOrderTraversal {
     public static void main(String[] args) {
        PreOrderTraversal POT = new PreOrderTraversal();
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);

        root.left.left = new Node(4);
        root.left.right = new Node(5);

        root.right.right = new Node(6);

        ArrayList<Integer> result = new ArrayList<>();
        POT.preorderTraversal(root, result);

        System.out.println("preorder Traversal:");
        for (int val : result) {
            System.out.print(val + " ");
        }
    }
    public void preorderTraversal(Node root,ArrayList<Integer> result){
        if(root == null) return;
        result.add(root.data);
        preorderTraversal(root.left,result);
        preorderTraversal(root.right,result);
    }
}
