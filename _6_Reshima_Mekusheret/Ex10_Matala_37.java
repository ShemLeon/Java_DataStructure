package _6_Reshima_Mekusheret;
import unit4.collectionsLib.Node;


/**
 * Class contains functions for working with a sorted linked list of integers,
 * including inserting a new number while maintaining the sorted order.
 */
public class Ex10_Matala_37 {

    public static Node<Integer> insertSorted(Node<Integer> head, int number) {
        Node<Integer> newNode = new Node<>(number);
        // Если список пуст или новое число меньше первого элемента
        if (head == null || head.getValue() >= number) {
            newNode.setNext(head);
            return newNode;
        }
        
        // Поиск правильной позиции для новой ноды
        Node<Integer> current = head;

        while (current.getNext() != null) {
            if (current.getNext().getValue() >= number)  break;
            current = current.getNext();
        }
        
        // Insert the new node
        newNode.setNext(current.getNext());
        current.setNext(newNode);
        
        return head;
    }




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