package _6_Reshima_Mekusheret;

import unit4.collectionsLib.Node;
import java.util.HashSet;
import java.util.Set;

import static _6_Reshima_Mekusheret.baza.createList;
import static _6_Reshima_Mekusheret.baza.printList;

/**
 * The class contains functions for working with a linked list of integers,
 * including counting the number of sequences of a given number.
 */
public class Ex6_Matala_31 {
    public static void main(String[] args) {
        Node<Integer> list = createList(new int[]{2, 7, 5, 3, 2, 2, 1, 1, 2, 2}); // Example list
        printList(list);
        int number = 2; // Target number
        System.out.println("Number of sequences of " + number + ": " + countSequences(list, number));
    }

    public static int countSequences(Node<Integer> head, int target) {
        if (head == null) return 0; // Empty list
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
