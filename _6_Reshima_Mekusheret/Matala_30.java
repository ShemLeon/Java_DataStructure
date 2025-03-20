package _6_Reshima_Mekusheret;

import unit4.collectionsLib.Node;
// Submitters:
// Evgeny Namtchenko 321404634
// Shmyakin Leonid 336540331
// Class 48-5

/**
 * Class contains functions for working with a linked list of integers,
 * including checking if elements are sorted in ascending order.
 */
public class Matala_30 {
    public static void main(String[] args) {
        Node<Integer> list1 = createList(new int[]{1, 2, 3, 4, 5}); // Sorted list
        Node<Integer> list2 = createList(new int[]{1, 3, 0, 4, 5}); // Unsorted list

        System.out.println("List 1 is sorted in ascending order: " + isAscending(list1));
        System.out.println("List 2 is sorted in ascending order: " + isAscending(list2));
    }

    /**
     * Function to check if a linked list is sorted in ascending order
     * @param head head node of the linked list
     * @return true if elements are sorted in ascending order, false otherwise
     * Complexity: O(n), where n is the number of nodes in the list. Each node is visited once
     * Working principle:
     * 1. Check base cases (empty list or list with one element)
     * 2. Traverse the list, comparing each element with the next
     * 3. If a violation of the ascending order is found, return false
     * 4. If reached the end of the list without violations, return true
     */
    public static boolean isAscending(Node<Integer> head) {
        if (head == null || head.getNext() == null) {
            return true; // An empty list or a list with one element is considered sorted
        }

        Node<Integer> current = head;

        while (current.getNext() != null) {
            if (current.getValue() > current.getNext().getValue()) {
                return false; // Found a violation of the ascending order
            }
            current = current.getNext();
        }

        return true; // All elements are sorted in ascending order
    }

    /**
     * Function to create a linked list from an array of integers
     * @param values array of integers to convert into a list
     * @return head node of the created linked list
     * Complexity: O(n) time, where n is the length of the array, O(n) memory
     * Working principle:
     * 1. Create the first node if the array is not empty
     * 2. Add the remaining elements to the end of the list
     * 3. Return the head of the list
     */
    public static Node<Integer> createList(int[] values) {
        Node<Integer> head = null;
        Node<Integer> current = null;
        for (int value : values) {
            // Add to the list
            Node<Integer> newNode = new Node<>(value);
            if (head == null) {
                head = newNode;
                current = head;
            } else {
                current.setNext(newNode);
                current = current.getNext();
            }
        }
        return head;
    }
}
