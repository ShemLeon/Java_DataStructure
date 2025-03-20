package _7_BinNode;
import unit4.collectionsLib.BinNode;

/**
 * Class containing functions for working with a doubly linked list,
 * including inserting an element at the end of the list and printing the list
 * in both directions
 */
public class bn_Matala43 {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 3, 2, 4};

        System.out.println("Original list:");
        BinNode<Integer> bnList = createList(arr);
        printList(bnList);

        System.out.println("After inserting 333 at the end:");
        insertEndBNlist(bnList, 333);
        printList(bnList);
    }

    /* Function for "inserting a new element at the end of a doubly linked list"
     * @param head the head node of the list
     * @param num the value to insert
     * Complexity: O(n), where n is the number of nodes in the list
     * Working principle:
     * 1. Check if the list is not empty
     * 2. Find the last node:
     *    - Traverse right until reaching the end (hasRight == false)
     * 3. Create a new node and link it:
     *    - Create a node with the new value
     *    - Set the right link of the last node
     *    - Set the left link of the new node
     */
    public static void insertEndBNlist(BinNode<Integer> head, int num) {
        if (head == null) {
            System.out.println("The list cannot be empty.");
            return;
        }

        // Find the last node
        BinNode<Integer> current = head;
        while (current.hasRight()) {
            current = current.getRight();
        }

        // Create and link a new node
        BinNode<Integer> temp = new BinNode<>(num);
        current.setRight(temp);
        temp.setLeft(current);
    }

    /* Function for "creating a doubly linked list from an array"
     * @param values the array of values to create the list
     * @return the head node of the created list
     * Complexity: O(n), where n is the size of the input array
     * Working principle:
     * 1. Initialize an empty list
     * 2. For each element in the array:
     *    - Create a new node
     *    - If the list is empty, make the node the head
     *    - Otherwise, link it with the previous node
     * 3. Return the head of the list
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

    /* Function for "printing the list from left to right"
     * @param head the head node of the list
     * Complexity: O(n), where n is the number of nodes in the list
     * Working principle:
     * 1. Start with the first node
     * 2. Until reaching the end of the list:
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

    /* Function for "printing the list from right to left"
     * @param head the head node of the list
     * Complexity: O(n), where n is the number of nodes in the list
     * Working principle:
     * 1. Find the end of the list:
     *    - Traverse right until reaching the last node
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
