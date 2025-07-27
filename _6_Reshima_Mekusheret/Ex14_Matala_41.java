package _6_Reshima_Mekusheret;
import unit4.collectionsLib.Node;

import static _6_Reshima_Mekusheret.Ex1_CreateListFromArray.createList;
import static _6_Reshima_Mekusheret.Ex2_PrintList.printListInt;

/**
 * Класс содержит функции для реорганизации связного списка так, чтобы все элементы
 * больше 100 находились в начале списка, а все числа меньше или
 * равные 100 находились в конце списка.
 */

public class Ex14_Matala_41 {

    public static void main(String[] args) {
        // Test cases
        int[] arr = {1, 2, 50, 200, 75, 25, 300, 100};
        Node<Integer> list1 = createList(arr);
        System.out.println("Original list:");
        printListInt(list1);
        rearrangeList(list1);
        System.out.println("After sorting:");
        printListInt(list1);
    }

    /**
     * Function to "move all elements greater than 100 to the beginning of the list"
     * @param head starting node of the list
     * Complexity: O(n), where n is the number of elements in the list
     * Working principle:
     * 1. Create two auxiliary lists:
     *    - For numbers <= 100
     *    - For numbers > 100
     * 2. Go through the original list:
     *    - Numbers > 100 are added to the first list
     *    - Other numbers are added to the second list
     * 3. Combine lists (larger + smaller)
     * 4. Copy values back to the original list
     */
    public static void rearrangeList(Node<Integer> head) {
        if (head == null || head.getNext() == null) return; // empty list or list with one element
            
        Node<Integer> dummyLess = new Node<>(0);    // dummy node for numbers <= 100
        Node<Integer> dummyMore = new Node<>(0);    // dummy node for numbers > 100
        Node<Integer> less = dummyLess;             // pointer for numbers <= 100
        Node<Integer> more = dummyMore;             // pointer for numbers > 100
        Node<Integer> current = head;               // pointer to the current node

        // Creating two new lists
        while (current != null) {
            if (current.getValue() > 100) {
                more.setNext(new Node<>(current.getValue()));
                more = more.getNext();
            } else {
                less.setNext(new Node<>(current.getValue()));
                less = less.getNext();
            }
            current = current.getNext();
        }

        // Combining lists
        more.setNext(dummyLess.getNext());

        // If there are elements greater than 100
        if (dummyMore.getNext() != null) {
            // Copying values to the original list
            current = head;
            Node<Integer> source = dummyMore.getNext();
            while (source != null) {
                current.setValue(source.getValue());
                current = current.getNext();
                source = source.getNext();
            }
        }
    }

}