package _8_BinaryTree;
import unit4.collectionsLib.BinNode;

/**
 * Basic class with examples of using a doubly linked list BinNode
 * Contains basic methods and their application in practice
 */
public class baza {
    /*
    Basic methods and techniques for working with a "Doubly Linked List" (BinNode)
    
    1. Creating a single node:
       BinNode<T>(T value)
       Constructor creates a new node with value. There are no nodes before or after it.
       Example:
       BinNode<Integer> singleNode = new BinNode<>(10);

    2. Creating a node with neighbors:
       BinNode<T>(BinNode<T> left, T value, BinNode<T> right)
       Constructor creates a new node with value, linked to left and right nodes.
       Example:
       BinNode<Integer> parentNode = new BinNode<>(leftNode, 10, rightNode);

    3. Getting the value of a node:
       T getValue()
       Returns the value of the current node.
       Example:
       int value = node.getValue();

    4. Getting the left neighbor:
       BinNode<T> getLeft()
       Returns a reference to the left node.

    5. Getting the right neighbor:
       BinNode<T> getRight()
       Returns a reference to the right node.

    6. Setting the value of a node:
       void setValue(T value)
       Sets the value of the current node.
       Example:
       node.setValue(333);

    7. Setting the left neighbor:
       void setLeft(BinNode<T> left)
       Creates or changes the link with the left node.
       Example:
       parentNode.setLeft(newLeftNode);

    8. Setting the right neighbor:
       void setRight(BinNode<T> right)
       Creates or changes the link with the right node.
       Example:
       parentNode.setRight(newRightNode);

    9. Checking for the presence of a left neighbor:
       boolean hasLeft()
       Returns true if there is a left node, otherwise false.

    10. Checking for the presence of a right neighbor:
        boolean hasRight()
        Returns true if there is a right node, otherwise false.

    11. String representation of a node:
        String toString()
        Returns a string with information about the node.
    */

    public static void main(String[] args) {
        // 1. Creating a single node
        BinNode<Integer> singleNode = new BinNode<>(10);
        System.out.println("1. Created a node with value: " + singleNode.getValue());

        // 2. Creating a node with two neighbors
        BinNode<Integer> leftNode = new BinNode<>(5);
        BinNode<Integer> rightNode = new BinNode<>(15);
        BinNode<Integer> parentNode = new BinNode<>(leftNode, 10, rightNode);
        System.out.println("2. Created a node with value: " + parentNode.getValue() + 
                         ", left node: " + parentNode.getLeft().getValue() + 
                         ", right node: " + parentNode.getRight().getValue());

        // 3. Getting the value of a node
        System.out.println("3. Value of the parent node: " + parentNode.getValue());

        // 4. Getting the value of the left neighbor
        System.out.println("4. Value of the left neighbor: " + parentNode.getLeft().getValue());

        // 5. Getting the value of the right neighbor
        System.out.println("5. Value of the right neighbor: " + parentNode.getRight().getValue());

        // 6. Setting the value of a node
        parentNode.setValue(333);
        System.out.println("6. New value of the node: " + parentNode.getValue());

        // 7. Setting a new left neighbor
        BinNode<Integer> newLeftNode = new BinNode<>(20);
        parentNode.setLeft(newLeftNode);
        System.out.println("7. Value of the new left neighbor: " + parentNode.getLeft().getValue());

        // 8. Setting a new right neighbor
        BinNode<Integer> newRightNode = new BinNode<>(30);
        parentNode.setRight(newRightNode);
        System.out.println("8. Value of the new right neighbor: " + parentNode.getRight().getValue());

        // 9. Checking for the presence of a left neighbor
        boolean hasLeft = parentNode.hasLeft();
        System.out.println("9. Has a left neighbor: " + hasLeft);

        // 10. Checking for the presence of a right neighbor
        boolean hasRight = parentNode.hasRight();
        System.out.println("10. Has a right neighbor: " + hasRight);

        // 11. Printing information about the node
        System.out.println("11. Information about the node: " + parentNode.toString());

        // 12. Creating a list from an array
        int[] arr = {2, 4, 5, 6, 9};
        BinNode<Integer> list = createList(arr);
        System.out.println("\n12. List from array:");
        printList(list);

        // 13. Creating a sequential list
        BinNode<Integer> sequentialList = createSequentialList(10);
        System.out.println("\n13. Sequential list from 1 to 10:");
        printList(sequentialList);
    }

    /**
     * Function for "creating a doubly linked list from an array"
     * @param values array of values
     * @return the head node of the created list
     * Complexity: O(n), where n is the size of the array
     * Principle of operation:
     * 1. Start with an empty list
     * 2. For each element in the array:
     *    - Create a new node
     *    - If the list is empty, make the node the head
     *    - Otherwise, link the node to the previous node
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
     * Function for "creating a doubly linked list of numbers from 1 to n"
     * @param n the end number
     * @return the head node of the created list
     * Complexity: O(n), where n is the size of the list
     * Principle of operation:
     * 1. If n > 0, start creating the list
     * 2. For each number i from 1 to n:
     *    - If the list is empty, create the first node
     *    - Otherwise, create a new node and link it to the previous node:
     *      * Set the right link from the previous node to the new node
     *      * Set the left link from the new node to the previous node
     * 3. Return the head of the list
     */
    public static BinNode<Integer> createSequentialList(int n) {
        BinNode<Integer> h = null;
        if (n > 0) {
            BinNode<Integer> tmp = null;
            BinNode<Integer> p = null;

            for (int i = 1; i <= n; i++) {
                if (h == null) {
                    h = new BinNode<Integer>(i);
                    tmp = h;
                } else {
                    p = new BinNode<Integer>(i);
                    tmp.setRight(p);
                    p.setLeft(tmp);
                    tmp = p;
                }
            }
        }
        return h;
    }

    /**
     * Function for "printing a doubly linked list"
     * @param head the head node of the list
     * Complexity: O(n), where n is the number of nodes
     * Principle of operation:
     * 1. Start with the first node
     * 2. While not reaching the end:
     *    - Print the value of the current node
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
