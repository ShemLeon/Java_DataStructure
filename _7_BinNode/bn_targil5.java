package _7_BinNode;
import unit4.collectionsLib.BinNode;

/**
 * Class containing functions for working with a doubly linked list,
 * including removing a node by a specified index
 */
public class bn_targil5 {
    public static void main(String[] args) {
        int[] arr = {1, 2, 7, 2, 1};

        System.out.println("Original list:");
        BinNode<Integer> golova = createList(arr);
        printList(golova);
        
        System.out.println("After removing the element at index 2:");
        golova = deleteNode(golova, 2);
        printList(golova);
    }

    /* Function to remove a node from a doubly linked list by index
     * @param head the head node of the list
     * @param index the index of the node to remove
     * @return the head node of the modified list
     * Complexity: O(n), where n is the number of nodes in the list
     * Working principle:
     * 1. Check if the list is empty
     * 2. Traverse the list to find the node at the specified index
     * 3. Update the links of neighboring nodes to remove the target node
     * 4. Return the head of the modified list
     */
    public static BinNode<Integer> deleteNode(BinNode<Integer> head, int index) {
        if (head == null) {
            System.out.println("The list cannot be empty.");
            return null;
        }

        BinNode<Integer> current = head;
        BinNode<Integer> target = null;
        BinNode<Integer> prev = null;

        // Find the node at the specified index
        int i = 0;
        while (current != null) {
            if (i == index) {
                target = current;
                break;
            }
            current = current.getRight();
            i++;
        }

        if (target == null) {
            System.out.println("Index is out of range.");
            return head;
        }

        // Get the neighboring nodes
        prev = target.getLeft();
        BinNode<Integer> next = target.getRight();

        // Update the links of neighboring nodes
        if (prev != null) {
            prev.setRight(next);
        } else {
            head = next;  // If removing the head
        }

        if (next != null) {
            next.setLeft(prev);
        }
        
        return head;
    }

    /* Function to create a doubly linked list from an array
     * @param values the array of values to create the list from
     * @return the head node of the created list
     * Complexity: O(n), where n is the size of the input array
     * Working principle:
     * 1. Initialize an empty list
     * 2. For each element in the array:
     *    - Create a new node
     *    - If the list is empty, make the node the head
     *    - Otherwise, link the node to the previous node
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

    /* Function to print the list from left to right
     * @param head the head node of the list
     * Complexity: O(n), where n is the number of nodes in the list
     * Working principle:
     * 1. Start with the first node
     * 2. While not at the end of the list:
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
}
