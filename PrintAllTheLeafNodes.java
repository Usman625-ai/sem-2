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
public class PrintAllTheLeafNodes {
     public static void main(String[] args) {
        PrintAllTheLeafNodes POT = new PrintAllTheLeafNodes();
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);

        root.left.left = new Node(4);
        root.left.right = new Node(5);

        root.right.right = new Node(6);

        ArrayList<Integer> result = new ArrayList<>();
        POT.printAllTheLeafNodes(root, result);

        System.out.println("Leaf Nodes are :");
        for (int val : result) {
            System.out.print(val + " ");
        }
    }
    // leaf node means it neither have left nor right
    public void printAllTheLeafNodes(Node root,ArrayList<Integer> result){
        // imp condition else if root reaches null it will throw null pointer error because you cant go further left or right;
        // trace this by making recursion tree then you will get it
        if(root == null) return;
        // now the recursive condition becomes if node.left and node.right == null then add it because it will be leaf node
        if((root.left == null) && (root.right == null)){
            result.add(root.data);
            return;
        }
        printAllTheLeafNodes(root.left,result);
        printAllTheLeafNodes(root.right,result);
    }
}