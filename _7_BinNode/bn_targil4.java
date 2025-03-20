package _7_BinNode;

import unit4.collectionsLib.BinNode;

/**
 * Class contains functions for working with a doubly linked list,
 * including inserting a new element after a specified index
 */
public class bn_targil4 {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 3, 2, 1};

        System.out.println("Original list:");
        BinNode<Integer> golova = createList(arr);
        printList(golova);
        
        System.out.println("After inserting 777 after the 3rd element:");
        insertNumList(golova, 3, 777);
        printList(golova);
    }

    /* Function to "insert a new element after a specified index"
     * @param head the head node of the list
     * @param index the index of the element after which to insert
     * @param num the value to insert
     * Complexity: O(n), where n is the number of nodes up to the index
     * Working principle:
     * 1. Check that the list is not empty
     * 2. Find the node by index:
     *    - Go through the list, counting positions
     *    - Stop at the desired index
     * 3. Create a new node and link it:
     *    - Create a node with the new value
     *    - Set its left link to the current node
     *    - Set its right link to the next node
     *    - Update the links of neighboring nodes
     */
    public static void insertNumList(BinNode<Integer> head, int index, int num) {
        if (head == null) {
            System.out.println("The list cannot be empty.");
            return;
        }
        index--;
        BinNode<Integer> target = head;
        while (target != null && index > 0) {
            target = target.getRight();
            index--;
        }
        if (target == null) {
            System.out.println("Index is out of range.");
            return;
        }
        // Create a new node with the specified value
        BinNode<Integer> newNode = new BinNode<>(num);
        // Set links for the new node
        newNode.setLeft(target); // Set the left pointer
        newNode.setRight(target.getRight()); // Set the right pointer
        if (target.getRight() != null) {
            target.getRight().setLeft(newNode); // Set the left pointer of the next node
        }
        target.setRight(newNode); // Set the new node to the right of the current node
    }

    /* Function to "create a doubly linked list from an array"
     * @param values array of values to create the list
     * @return head node of the created list
     * Complexity: O(n), where n is the size of the input array
     * Working principle:
     * 1. Initialize an empty list
     * 2. For each element in the array:
     *    - Create a new node
     *    - If the list is empty, make the node the head
     *    - Otherwise, link it to the previous node
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

    /* Function to "print the list from left to right"
     * @param head the head node of the list
     * Complexity: O(n), where n is the number of nodes in the list
     * Working principle:
     * 1. Start with the first node
     * 2. Until we reach the end of the list:
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

    /* Function to "print the list from right to left"
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
