class linkedlist{
    // Node class for Linked List
    static class Node {
        int val;
        Node next;
        // these are constructors when i will just call Node() it will auto take val = null and next = null
        Node(){
            this.val = 0;
            this.next = null;
        }
        // when i will call Node(val) it will take val = given val and next = null
        Node(int val) {
            this.val = val;
            this.next = null;
        }
        // when i will call Node(val,next) it will take val = given val and next = the next element
        Node(int val,Node next){
            this.val = val;
            this.next = next;
        }
    }

    // Function to insert node in sorted order
    static Node insertSorted(Node head, int val) {
        Node newNode = new Node(val);

        // Insert at head
        if (head == null || val < head.val) {
            newNode.next = head;
            return newNode;
        }

        // Insert somewhere in the middle or end
        Node curr = head;
        while (curr.next != null && curr.next.val < newNode.val) {
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

    // main call function
    public static void main(String[] args) {
        int[] arr = {7, 2, 5, 3, 9, 1};

        Node head = null;
        for (int num : arr) {
            head = insertSorted(head, num);
        }
        // when the loop will finish the will be containing 1 becz it is the smallest val;
        // then it will call another function to print linklist from its head(1) to tail(7)
        // 1->2->3->5->7->9 it will be like this

        // Print the sorted linked list
        printList(head);
    }
}
