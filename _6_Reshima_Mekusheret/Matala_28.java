package _6_Reshima_Mekusheret;
import unit4.collectionsLib.Node;


public class Matala_28 {
    public static void main(String[] args) {
        Node<Integer> list = createList(new int[]{5, 5, 15, 5, 5, 25}); // Example list
        System.out.println("Sum of list elements: " + sumOfList(list));
        printList(list);
        System.out.println(list.toString());
    }

    /* Function to calculate the sum of all elements in a linked list
     * @param head head node of the linked list
     * @return sum of all integers in the list
     * Complexity: O(n) time, where n is the number of nodes, O(1) memory
     * Working principle:
     * 1. Start with the first node
     * 2. Traverse all nodes, adding the value of each to the sum
     * 3. Return the total sum
     */
    public static int sumOfList(Node<Integer> head) {
        int sum = 0;
        Node<Integer> current = head;

        while (current != null) {
            sum += current.getValue();
            current = current.getNext();
        }

        return sum;
    }

    /* Function to create a linked list from an array of integers
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

    /* Function to print all elements of a linked list
     * @param head head node of the linked list
     * Complexity: O(n) time, where n is the number of nodes, O(1) memory
     * Working principle:
     * 1. Traverse all nodes in the list
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