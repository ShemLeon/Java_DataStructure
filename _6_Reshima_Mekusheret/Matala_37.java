package _6_Reshima_Mekusheret;

import unit4.collectionsLib.Node;

// Authors:
// Evgeny Nemchenko 321404634
// Leonid Shmiakin 336540331
// Class 48-5

/**
 * Class contains functions for working with a sorted linked list of integers,
 * including inserting a new number while maintaining the sorted order.
 */
public class Matala_37 {
    /**
     * Function to insert a number into a sorted linked list while maintaining order
     * @param head head node of the sorted list
     * @param number number to insert
     * @return head node of the list (may change if the new number is less than the first element)
     * Complexity: O(n), where n is the number of nodes in the list
     * Working principle:
     * 1. Create a new node with the given number
     * 2. Check for special cases:
     *    - If the list is empty or the new number is less than the first element,
     *      insert at the beginning of the list
     * 3. Find the correct position for the new node:
     *    - Traverse the list until we find an element greater than or equal to the new number
     * 4. Insert the new node between the current and next elements
     * 5. Return the head of the list
     */
    public static Node<Integer> insertSorted(Node<Integer> head, int number) {
        Node<Integer> newNode = new Node<>(number);
        
        // If the list is empty or the new number is less than the first element
        if (head == null || head.getValue() >= number) {
            newNode.setNext(head);
            return newNode;
        }
        
        // Find the correct position for the new node
        Node<Integer> current = head;
        while (current.getNext() != null && current.getNext().getValue() < number) {
            current = current.getNext();
        }
        
        // Insert the new node
        newNode.setNext(current.getNext());
        current.setNext(newNode);
        
        return head;
    }
    
    /**
     * Function to print the elements of a linked list
     * @param head head node of the list
     * Complexity: O(n), where n is the number of nodes in the list
     * Working principle:
     * 1. Traverse the list from the beginning to the end
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
    
    /**
     * Function to create a test sorted linked list
     * @param values array of values to create the list
     * @return head node of the created list
     * Complexity: O(n^2), where n is the size of the input array
     * Working principle:
     * 1. Initialize an empty list
     * 2. For each value in the array:
     *    - Insert the value into the list while maintaining the sorted order
     * 3. Return the created list
     */
    public static Node<Integer> createTestList(int[] values) {
        Node<Integer> head = null;
        for (int value : values) {
            head = insertSorted(head, value);
        }
        return head;
    }
    
    /**
     * Main function to test the insertSorted function
     * This function creates a test sorted linked list and demonstrates
     * the insertion of new numbers into the list while maintaining order.
     * Complexity: O(n), where n is the number of nodes in the list
     * Working principle:
     * 1. Create an array of test values
     * 2. Create a sorted linked list from the test values
     * 3. Print the original list
     * 4. Insert a new number and print the updated list
     * 5. Repeat for additional test cases
     */
    public static void main(String[] args) {
        // Create a test sorted linked list
        int[] testValues = {1, 3, 5, 7, 9};
        Node<Integer> list = createTestList(testValues);
        System.out.println("Original sorted list:");
        printList(list);

        // Add a new number
        int newNumber = 4;
        list = insertSorted(list, newNumber);
        System.out.println("List after adding number " + newNumber + ":");
        printList(list);

        // Test adding to the beginning of the list
        newNumber = 0;
        list = insertSorted(list, newNumber);
        System.out.println("List after adding number " + newNumber + ":");
        printList(list);

        // Test adding to the end of the list
        newNumber = 10;
        list = insertSorted(list, newNumber);
        System.out.println("List after adding number " + newNumber + ":");
        printList(list);
    }
}