package _7_BinNode;

import unit4.collectionsLib.BinNode;

// Write a function that takes a BinNode of ints, a node reference, and an integer num.
// The method should add a new element with the value num to the right of the received node

public class bn_targil3 {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 3, 2, 1};

        BinNode<Integer> golova = createList(arr);
        printList(createList(arr));
        insertNumList(golova, 2, 777);
        printList(golova);
    }

    public static void insertNumList(BinNode<Integer> head, int index, int num) {
        if (head == null) {
            System.out.println("The list cannot be empty.");
            return;
        }

        BinNode<Integer> current = head;
        BinNode<Integer> target = null;
        int i = 0;
        while (current != null) {
            if (i == index) {
                target = current;
                break;
            }
            current = current.getRight();
            i++;
        }

        if (target == null) {
            System.out.println("Index is out of range.");
            return;
        }

        // Create a new node with the specified value
        BinNode<Integer> newNode = new BinNode<>(num);

        // Set links for the new node
        newNode.setLeft(target); // Set the left pointer
        newNode.setRight(target.getRight()); // Set the right pointer

        if (target.getRight() != null) {
            target.getRight().setLeft(newNode); // Set the left pointer of the next node
        }

        target.setRight(newNode); // Set the new node to the right of the current node
    }


    public static BinNode<Integer> createList(int[] values) {
        // Create a doubly linked list from an array.
        BinNode<Integer> head = null;
        BinNode<Integer> current = null;

        for (int bafer : values) {
            BinNode<Integer> newBinNode = new BinNode<>(bafer); // Create a new node
            if (head == null) {
                head = newBinNode; // If this is the first node, it becomes the head
                current = head;
            } else {
                current.setRight(newBinNode); // Set the next node
                newBinNode.setLeft(current);  // Set the previous node ("pairwise binding")
                current = newBinNode; // Move to the new node
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

        // Print values in reverse order
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
