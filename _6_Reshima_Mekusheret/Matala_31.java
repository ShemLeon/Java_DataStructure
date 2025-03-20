package _6_Reshima_Mekusheret;

import unit4.collectionsLib.Node;
import java.util.HashSet;
import java.util.Set;

// Submitters:
// Evgeny Namchenko 321404634
// Shmyakin Leonid 336540331
// Class 48-5

/**
 * The class contains functions for working with a linked list of integers,
 * including counting the number of sequences of a given number.
 */
public class Matala_31 {
    public static void main(String[] args) {
        Node<Integer> list = createList(new int[]{2, 7, 5, 3, 2, 2, 1, 1, 2, 2}); // Example list
        printList(list);
        int number = 2; // Target number
        System.out.println("Number of sequences of " + number + ": " + countSequences(list, number));
    }

    /**
     * Function to count the number of sequences of a given number in a linked list
     * @param head head node of the linked list
     * @param target target number for counting sequences
     * @return number of sequences of the target number
     * Complexity: O(n), where n is the number of nodes in the list. The list is traversed once
     * Working principle:
     * 1. Check the base case (empty list)
     * 2. Initialize a counter and a flag for the current sequence
     * 3. Traverse the list:
     *    - If the target number is found and we are not in a sequence,
     *      increment the counter and mark the start of the sequence
     *    - If a different number is found, mark the end of the sequence
     * 4. Return the total number of sequences found
     */
    public static int countSequences(Node<Integer> head, int target) {
        if (head == null) {
            return 0; // Empty list
        }

        int count = 0;
        boolean inSequence = false; // Flag to track the current sequence
        Node<Integer> current = head;

        while (current != null) {
            if (current.getValue() == target) {
                if (!inSequence) {
                    count++; // New sequence found
                    inSequence = true;
                }
            } else {
                inSequence = false; // End of the current sequence
            }
            current = current.getNext();
        }

        return count;
    }

    /**
     * Function to create a linked list from an array of integers
     * @param values array of integers to convert to a linked list
     * @return head node of the created linked list
     * Complexity: O(n), where n is the size of the input array
     * Working principle:
     * 1. Initialize an empty list
     * 2. Traverse the array of values
     * 3. For each value, create a new node and add it to the end of the list
     */
    public static Node<Integer> createList(int[] values) {
        Node<Integer> head = null;
        Node<Integer> current = null;

        for (int value : values) {
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

    /* Function to check if a linked list contains duplicates
     * @param head head node of the linked list
     * @return true if duplicates are found, false otherwise
     * Complexity: O(n) time, where n is the number of nodes in the list
     * Working principle:
     * 1. Create a temporary set to store seen values
     * 2. Traverse the list, checking if each value is in the set
     * 3. If a duplicate is found, return true
     * 4. If the end of the list is reached without finding duplicates, return false
     */
    public static boolean hasDuplicates(Node<Integer> head) {
        Set<Integer> seen = new HashSet<>();
        Node<Integer> current = head;
        while (current != null) {
            if (seen.contains(current.getValue())) {
                return true;
            }
            seen.add(current.getValue());
            current = current.getNext();
        }
        return false;
    }
}
