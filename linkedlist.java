class linkedlist{
    // Node class for Linked List
    static class Node {
        int val;
        Node next;
        Node(){
            this.val = 0;
            this.next = null;
        }
        Node(int val) {
            this.val = val;
            this.next = null;
        }
        Node(int val,Node next){
            this.val = val;
            this.next = next;
        }
    }

    // Function to insert node in sorted order
    static Node insertSorted(Node head, int val) {
        Node newNode = new Node(val);

        // Case 1: Insert at head (empty list or val is smallest)
        if (head == null || val < head.val) {
            newNode.next = head;
            return newNode;
        }

        // Case 2: Insert somewhere in the middle or end
        Node curr = head;
        while (curr.next != null && curr.next.val < val) {
            curr = curr.next;
        }
        newNode.next = curr.next;
        curr.next = newNode;

        return head;
    }

    // Function to print linked list
    static void printList(Node head) {
        Node curr = head;
        while (curr != null) {
            System.out.print(curr.val + " ");
            curr = curr.next;
        }
        System.out.println();
    }

    // Main driver
    public static void main(String[] args) {
        int[] arr = {7, 2, 5, 3, 9, 1};

        Node head = null;
        for (int num : arr) {
            head = insertSorted(head, num);
        }

        // Print the sorted linked list
        printList(head);
    }
}
