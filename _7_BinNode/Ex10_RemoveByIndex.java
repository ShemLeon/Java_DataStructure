package _7_BinNode;
import unit4.collectionsLib.BinNode;

import static _7_BinNode.Ex1_createFromArray.createList;
import static _7_BinNode.Ex2_Print.printList;

// Удаление ноды по указанному индексу
public class Ex10_RemoveByIndex {
    public static BinNode<Integer> deleteNode(BinNode<Integer> head, int index) {
        if (head == null) return null;
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
        if (next != null) next.setLeft(prev);
        return head;
    }
    public static void main(String[] args) {
        int[] arr = {1, 2, 7, 2, 1};

        System.out.println("Original list:");
        BinNode<Integer> golova = createList(arr);
        printList(golova);
        
        System.out.println("After removing the element at index 2:");
        golova = deleteNode(golova, 2);
        printList(golova);
    }
}
