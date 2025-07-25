package _6_Reshima_Mekusheret;

import unit4.collectionsLib.Node;

/**
 * The class contains functions for working with a linked list of floating point numbers,
 * including checking for the presence of a given number in the list.
 */
public class Ex7_Matala_32 {
    public static void main(String[] args) {
        Node<Double> list = createList(new double[]{1.2, 3.5, 4.0, 6.7}); // Example list
        double number = 4.0; // Target number
        System.out.println("Number " + number + " found in list: " + containsNumber(list, number));

        number = 5.5;
        System.out.println("Number " + number + " found in list: " + containsNumber(list, number));
    }

    public static boolean containsNumber(Node<Double> head, double target) {
        Node<Double> current = head;

        while (current != null) {
            if (current.getValue() == target) {
                return true; // Number found
            }
            current = current.getNext();
        }

        return false; // Number not found
    }

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
     * Function to print elements of a linked list
     * @param head head node of the linked list
     * Complexity: O(n), where n is the number of nodes in the list
     * Working principle:
     * 1. Traverse the list from start to end
     * 2. Print the value of each node
     * 3. Add an arrow between elements for clarity
     */
    public static void printList(Node<Integer> head) {
        Node<Integer> current = head;

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
