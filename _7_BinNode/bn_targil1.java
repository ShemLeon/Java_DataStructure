package _7_BinNode;
import unit4.collectionsLib.BinNode;

// Write a function that takes an int n and returns a BinNode of consecutive integers
public class bn_targil1 {
    public static void main(String[] args) {
      createOkevList(5);
      printList(createOkevList(5));
    }

    public static BinNode<Integer> createOkevList(int n) {
        // Create a doubly linked list of consecutive integers from 1 to n.
        BinNode<Integer> head = null;
        BinNode<Integer> current = null;

        for (int i = 1; i <= n; i++) {
            BinNode<Integer> newNode = new BinNode<>(i); // Create a new node
            if (head == null) {
                head = newNode; // If this is the first node, it becomes the head
                current = head;
            } else {
                current.setRight(newNode); // Set the next node
                newNode.setLeft(current); // Set the previous node
                current = newNode; // Move to the new node
            }
        }
        return head; // Return the head of the list
    }

    public static void printList(BinNode<Integer> head) {
        // Print the list
        BinNode<Integer> current = head;
        while (current != null) {
            System.out.print(current.getValue());
            if (current.getRight() != null) { // Check for the presence of a right node
                System.out.print(" <-> ");
            }
            current = current.getRight(); // Move to the next node
        }
        System.out.println(); // Print a new line after the list
    }
}
