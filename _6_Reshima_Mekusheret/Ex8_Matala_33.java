package _6_Reshima_Mekusheret;

import unit4.collectionsLib.Node;

/**
 * The class contains functions for working with a linked list of floating point numbers,
 * including removing duplicates from the list.
 */
public class Ex8_Matala_33 {
    public static void main(String[] args) {
        Node<Double> list = createList(new double[]{1.2, 3.5, 4.5, 3.5, 6.7, 1.2, 4.0, 4.0}); // Example list with duplicates
        System.out.println("Original list:");
        printList(list);

        Node<Double> uniqueList = removeDuplicates(list);
        System.out.println("List without duplicates:");
        printList(uniqueList);
    }

    /**
     * Function to remove duplicates from a linked list of floating point numbers
     * @param head head node of the linked list
     * @return head node of the list without duplicates
     * Complexity: O(n^2), where n is the number of nodes in the list
     */
    public static Node<Double> removeDuplicates(Node<Double> head) {
        if (head == null) return null; // Empty list
        Node<Double> current = head;
        while (current != null) {
            Node<Double> runner = current; // For checking all subsequent elements
            while (runner.getNext() != null) {
                if (runner.getNext().getValue().equals(current.getValue())) {
                    // Remove duplicate
                    runner.setNext(runner.getNext().getNext());
                } else {
                    runner = runner.getNext();
                }
            }
            current = current.getNext();
        }

        return head; // Return the list without duplicates
    }

    /**
     * Function to create a linked list from an array of floating point numbers
     * @param values array of numbers to convert to a linked list
     * @return head node of the created linked list
     * Complexity: O(n), where n is the size of the input array
     * Working principle:
     * 1. Initialize an empty list
     * 2. Iterate through the array of values
     * 3. For each value, create a new node and add it to the end of the list
     */
    public static Node<Double> createList(double[] values) {
        Node<Double> head = null;
        Node<Double> current = null;

        for (double value : values) {
            if (head == null) {
                head = new Node<>(value);
                current = head;
            } else {
                current.setNext(new Node<>(value));
                current = current.getNext();
            }
        }

        return head;
    }

    /**
     * Function to print the elements of a linked list
     * @param head head node of the linked list
     * Complexity: O(n), where n is the number of nodes in the list
     * Working principle:
     * 1. Iterate through the list from start to end
     * 2. Print the value of each node
     * 3. Add an arrow between elements for clarity
     */
    public static void printList(Node<Double> head) {
        Node<Double> current = head;

        while (current != null) {
            System.out.print(current.getValue());
            if (current.getNext() != null) {
                System.out.print(" -> ");
            }
            current = current.getNext();
        }
        System.out.println();
    }
}
