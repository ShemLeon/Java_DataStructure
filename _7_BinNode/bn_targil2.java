package _7_BinNode;

import unit4.collectionsLib.BinNode;

// Write a function that takes a BinNode of ints and prints them from left to right
// Second function prints from right to left

public class bn_targil2 {
    public static void main(String[] args) {
      createOkevList(5);
      printList(createOkevList(5));
      printRightList(createOkevList(5));
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
            if (current.getRight() != null) { // Check if there is a right node
                System.out.print(" <-> ");
            }
            current = current.getRight(); // Move to the next node
        }
        System.out.println(); // Print a new line after the list
    }

    public static void printRightList(BinNode<Integer> head) {

        // Find the end of the list
        BinNode<Integer> current = head;        // Create a pointer
        while (current.getRight() != null) {    // Find the last node
            current = current.getRight();
        }

        // Print the values in reverse order
        while (current != null) { // Print from end to start
            System.out.print(current.getValue());
            if (current.getLeft() != null) { // Check if there is a left node
                System.out.print(" <-> ");
            }
            current = current.getLeft();
        }
        System.out.println(); // Print a new line after the list
    }
}
