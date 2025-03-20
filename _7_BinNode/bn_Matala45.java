package _7_BinNode;
import unit4.collectionsLib.BinNode;

/**
 * Class containing functions for working with a doubly linked list of characters,
 * including checking for palindromes and removing the last element
 */
public class bn_Matala45 {
    public static void main(String[] args) {
        System.out.println("1. Checking for palindrome:");
        // Create a test list that is a palindrome
        BinNode<Character> list1 = createCharList("radar");
        System.out.println("radar --> " + (isPalindrome(list1) ? "is a palindrome" : "is not a palindrome"));
        
        // Create a test list that is not a palindrome
        BinNode<Character> list2 = createCharList("hello");
        System.out.println("hello --> " + (isPalindrome(list2) ? "is a palindrome" : "is not a palindrome"));
        
        System.out.println("\n2. Removing the last element:");
        System.out.print("Before removal:     ");
        printList(list2);
        removeLastNode(list2);
        System.out.print("After removal:      ");
        printList(list2);
    }

    /* Function to "remove the last element from the list"
     * @param head the head node of the list
     * Complexity: O(n), where n is the number of nodes in the list
     * Working principle:
     * 1. Check if the list is empty
     * 2. Find the last node:
     *    - Move right until the end is reached
     * 3. If there is a previous element:
     *    - Set its right link to null
     * 4. Otherwise, the list becomes empty
     */
    public static void removeLastNode(BinNode<Character> head) {
        if (head == null) {
            System.out.println("The list is empty");
            return;
        }

        // If the list has only one element
        if (head.getRight() == null) {
            head = null;
            return;
        }

        // Find the last node
        BinNode<Character> current = head;
        while (current.getRight() != null) {
            current = current.getRight();
        }

        // Set the right link of the second-to-last node to null
        current.getLeft().setRight(null);
    }

    /* Function to "check if a doubly linked list is a palindrome"
     * @param head the head node of the list
     * @return true if the list is a palindrome, otherwise false
     * Complexity: O(n), where n is the number of nodes in the list
     * Working principle:
     * 1. Check special cases:
     *    - An empty list or a list with one element is a palindrome
     * 2. Find the end of the list
     * 3. Compare values from both ends moving towards the center
     * 4. If all pairs match, the list is a palindrome
     */
    public static boolean isPalindrome(BinNode<Character> head) {
        if (head == null || head.getRight() == null) {
            return true;  // An empty list or a list with one element
        }

        // Find the end of the list
        BinNode<Character> left = head;
        BinNode<Character> right = head;
        while (right.getRight() != null) {
            right = right.getRight();
        }

        // Compare values from both ends
        while (left != right && left.getLeft() != right) {
            if (!left.getValue().equals(right.getValue())) {
                return false;  // Not a palindrome
            }
            left = left.getRight();   // Move right
            right = right.getLeft();  // Move left
        }

        return true;  // Palindrome
    }

    /* Function to "create a doubly linked list from a string"
     * @param str the string to convert to a list
     * @return the head node of the created list
     * Complexity: O(n), where n is the length of the string
     * Working principle:
     * 1. Initialize an empty list
     * 2. For each character in the string:
     *    - Create a new node
     *    - If the list is empty, make the node the head
     *    - Otherwise, link it to the previous node
     * 3. Return the head of the list
     */
    public static BinNode<Character> createCharList(String str) {
        BinNode<Character> head = null;
        BinNode<Character> current = null;

        for (char c : str.toCharArray()) {
            BinNode<Character> newNode = new BinNode<>(c);
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

    /* Helper function to print a list of characters
     * @param head the head node of the list
     */
    public static void printList(BinNode<Character> head) {
        BinNode<Character> current = head;
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
