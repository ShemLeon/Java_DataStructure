package _7_BinNode;
import unit4.collectionsLib.BinNode;


/**
 * Class contains functions for working with a doubly linked list,
    * including inserting a new element at the beginning of the list and printing the list
    * in both directions
 */
public class bn_Matala42 {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 3, 2, 1};

        BinNode<Integer> bnList = createList(arr);
        System.out.println("Original list:");
        printList(createList(arr));

        System.out.println("After inserting 333 at the beginning:");
        insertHeadBNlist(bnList, 333);
        printList(bnList);
    }

    /**
     * Function to "insert a new element at the beginning of a doubly linked list"
     * @param head current starting node of the list
     * @param num value to insert
     * Complexity: O(1), since only operations on the starting node are performed
     * Working principle:
     * 1. Check that the list is not empty
     * 2. Создаем новый узел с текущим значением головы
     * 3. Если у головы есть правый узел:
     *    - Связываем новый узел с правым узлом
     *    - Обновляем левую связь правого узла
     * 4. Обновляем значение головы и её связи:
     *    - Устанавливаем новое значение
     *    - Связываем с новым узлом справа
     *    - Обнуляем левую связь
     */
    public static void insertHeadBNlist(BinNode<Integer> head, int num) {
        if (head == null) {
            System.out.println("Список не может быть пустым.");
            return;
        }

        // Create a new node with the current head value
        BinNode<Integer> temp = new BinNode<>(head.getValue());

        // Check if the head has a right node
        if (head.hasRight()) {
            temp.setRight(head.getRight());
            head.getRight().setLeft(temp);
        }

        // Update the head value and its links
        head.setValue(num);
        head.setRight(temp);
        head.setLeft(null);

        // Set the left link of the new node to the head
        temp.setLeft(head);
    }

    /**
     * Function to "create a doubly linked list from an array"
     * @param values array of values for creating the list
     * @return starting node of the created list
     * Complexity: O(n), where n is the size of the input array
     * Working principle:
     * 1. Initialize an empty list
     * 2. For each element of the array:
     *    - Create a new node
     *    - If the list is empty, make the node the head
     *    - Otherwise, link with the previous node
     * 3. Return the start of the list
     */
    public static BinNode<Integer> createList(int[] values) {
        BinNode<Integer> head = null;
        BinNode<Integer> current = null;

        for (int bafer : values) {
            BinNode<Integer> newBinNode = new BinNode<>(bafer);
            if (head == null) {
                head = newBinNode;
                current = head;
            } else {
                current.setRight(newBinNode);
                newBinNode.setLeft(current);
                current = newBinNode;
            }
        }
        return head;
    }

    /**
     * Function to "print the list from left to right"
     * @param head the head node of the list
     * Complexity: O(n), where n is the number of nodes in the list
     * Working principle:
     * 1. Start with the first node
     * 2. While not reaching the end of the list:
     *    - Print the value of the current node
     *    - If there is a next node, print a separator
     *    - Move to the next node
     */
    public static void printList(BinNode<Integer> head) {
        BinNode<Integer> current = head;
        while (current != null) {
            System.out.print(current.getValue());
            if (current.getRight() != null) {
                System.out.print(" <-> ");
            }
            current = current.getRight();
        }
        System.out.println();
    }

    /**
     * Function to "print the list from right to left"
     * @param head the head node of the list
     * Complexity: O(n), where n is the number of nodes in the list
     * Working principle:
     * 1. Find the end of the list:
     *    - Go to the right until we reach the last node
     * 2. Print the list in reverse order:
     *    - Print the value of the current node
     *    - If there is a previous node, print a separator
     *    - Move to the previous node
     */
    public static void printRightList(BinNode<Integer> head) {
        BinNode<Integer> current = head;

        // Find the end of the list
        while (current.getRight() != null) {
            current = current.getRight();
        }

        // Print the values in reverse order
        while (current != null) {
            System.out.print(current.getValue());
            if (current.getLeft() != null) {
                System.out.print(" <-> ");
            }
            current = current.getLeft();
        }
        System.out.println();
    }
}
