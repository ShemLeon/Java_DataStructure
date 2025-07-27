package _6_Reshima_Mekusheret;
import unit4.collectionsLib.Node;

import static _6_Reshima_Mekusheret.Ex2_PrintList.printStringList;

/**
 * The class contains functions for working with a linked list of strings,
 * including creating a deep copy of the list.
 */
public class Ex9_DeepCopyList {

    /**
     * Function to create a deep copy of a linked list of strings
     * 4. Return the copy of the list
  */
    public static Node<String> copyList(Node<String> list) {
        if (list == null) return null;

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
    

    

}