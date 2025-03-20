package _7_BinNode;
import unit4.collectionsLib.BinNode;

/**
 * Class containing functions for working with a doubly linked list,
 * including creating a list in reverse order and removing the first element
 */
public class bn_Matala44 {
    public static void main(String[] args) {
        System.out.println("1. Creating a list from 1 to 5:");
        BinNode<Integer> list = createOkevList(5);
        printList(list);
        
        System.out.println("\n2. Deleting the first element:");
        removeFirstNode(list);
        printList(list);
        
        System.out.println("\n3. Printing in both directions:");
        System.out.print("From left to right:  ");
        printList(list);
        System.out.print("From right to left: ");
        printRightList(list);
    }

    /* Function for "deleting the first element of the list"
     * @param head the head node of the list
     * Complexity: O(1) - working only with the first element
     * Working principle:
     * 1. Check if the list is not empty
     * 2. If there is a second element:
     *    - Nullify its left link
     *    - Make it the new head of the list
     * 3. Otherwise, the list becomes empty
     */
    public static void removeFirstNode(BinNode<Integer> head) {
        if (head == null) {
            System.out.println("The list cannot be empty.");
            return;
        }

        // If there is a second element
        if (head.getRight() != null) {
            head.getRight().setLeft(null);  // Nullify the left link
            head = head.getRight();         // Make the second element the head
        } else {
            head = null;  // List becomes empty
        }
    }

    /* Function for "creating a doubly linked list from 1 to n"
     * @param n the final number for the list
     * @return the starting node of the created list
     * Complexity: O(n), where n is the size of the list
     * Working principle:
     * 1. Initialize an empty list
     * 2. Для каждого числа от 1 до n:
     *    - Создаем новый узел
     *    - Если список пустой, делаем узел головой
     *    - Иначе связываем с предыдущим узлом
     * 3. Возвращаем начало списка
     */
    public static BinNode<Integer> createOkevList(int n) {
        BinNode<Integer> head = null;
        BinNode<Integer> current = null;

        for (int i = 1; i <= n; i++) {
            BinNode<Integer> newNode = new BinNode<>(i);
            if (head == null) {
                head = newNode;
                current = head;
            } else {
                current.setRight(newNode);
                newNode.setLeft(current);
                current = newNode;
            }
        }
        return head;
    }

    /* Function for "printing the list from left to right"
     * @param head the starting node of the list
     * Complexity: O(n), where n is the number of nodes in the list
     * Working principle:
     * 1. Start with the first node
     * 2. While not at the end of the list:
     *    - Print the value of the current node
     *    - If there is a next node, print the separator
     *    - Go to the next node
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

    /* Function for "printing the list from right to left"
     * @param head the starting node of the list
     * Complexity: O(n), where n is the number of nodes in the list
     * Working principle:
     * 1. Find the end of the list:
     *    - Go right until the last node
     * 2. Print the list in reverse order:
     *    - Print the value of the current node
     *    - If there is a previous node, print the separator
     *    - Go to the previous node
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
