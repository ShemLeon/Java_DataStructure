package _7_BinNode;
import unit4.collectionsLib.BinNode;

import static _7_BinNode.Ex2_Print.printList;

// функция принимает целое число n и возвращает двусвязный список из последовательных целых чисел
public class Ex6_From1ToN {
    public static void main(String[] args) {
      createOkevList(5);
      printList(createOkevList(8));
    }

    public static BinNode<Integer> createOkevList(int n) {
        // Create a doubly linked list of consecutive integers from 1 to n.
        BinNode<Integer> head = null;
        BinNode<Integer> current = null;

        for (int i = 1; i <= n; i++) {
            BinNode<Integer> newNode = new BinNode<>(i); // Create a new node
            if (head == null) {
                head = newNode; // If this is the first node, it becomes the head
                current = head;
            } else {
                current.setRight(newNode); // Set the next node
                newNode.setLeft(current); // Set the previous node
                current = newNode; // Move to the new node
            }
        }
        return head; // Return the head of the list
    }
}
