package _6_Reshima_Mekusheret;
import unit4.collectionsLib.Node;

/**
 проверка или список отсортирован по возрастанию
 */
public class Ex5_Vozrastanie {
    public static void main(String[] args) {
        Node<Integer> list1 = createList(new int[]{1, 2, 3, 4, 5}); // Sorted list
        Node<Integer> list2 = createList(new int[]{1, 3, 0, 4, 5}); // Unsorted list

        System.out.println("List 1 is sorted in ascending order: " + isAscending(list1));
        System.out.println("List 2 is sorted in ascending order: " + isAscending(list2));
    }

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
