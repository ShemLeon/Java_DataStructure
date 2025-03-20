package _6_Reshima_Mekusheret;

import unit4.collectionsLib.Node;

// Submitters:
// Evgeny Namtchenko 321404634
// Shmiakin Leonid 336540331
// Class 48-5

/**
 * The class contains functions for working with a linked list of strings,
 * including creating a deep copy of the list.
 */
public class Matala_34 {
   public static void main(String[] args) {
        // Test examples for copyList
        Node<String> list = new Node<>("Hello");
        list.setNext(new Node<>("World"));
        list.getNext().setNext(new Node<>("!"));
        
        System.out.println("Original list:");
        printStringList(list);
        
        Node<String> copiedList = copyList(list);
        System.out.println("\nCopied list:");
        printStringList(copiedList);
        
        // Change the original list to prove that the lists are independent
        list.setValue("Changed");
        System.out.println("\nAfter changing the original list:");
        System.out.println("Original list:");
        printStringList(list);
        System.out.println("Copied list (should remain unchanged):");
        printStringList(copiedList);
    }
    
    /**
     * Function to print elements of a linked list of strings
     * @param list linked list to print
     * Complexity: O(n), where n is the number of nodes in the list
     * Working principle:
     * 1. Traverse the list from start to end
     * 2. Print the value of each node
     * 3. Add an arrow between elements for clarity
     */
    public static void printStringList(Node<String> list) {
        Node<String> current = list;
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
     * Function to create a deep copy of a linked list of strings
     * @param list original list to copy
     * @return new list identical to the original
     * Complexity: O(n), where n is the number of nodes in the list
     * Working principle:
     * 1. Check the base case (empty list)
     * 2. Create a new list with the first element
     * 3. Traverse the original list:
     *    - For each element, create a new node with the same value
     *    - Link the new nodes together
     * 4. Return the copy of the list
     * Note: This is a deep copy - changes to the original list do not affect the copied list
     */
    public static Node<String> copyList(Node<String> list) {
        if (list == null) {
            return null;
        }
        
        Node<String> newList = new Node<String>(list.getValue());
        Node<String> current = newList;
        Node<String> original = list.getNext();
        
        while (original != null) {
            current.setNext(new Node<String>(original.getValue()));
            current = current.getNext();
            original = original.getNext();
        }
        
        return newList;
    }
}