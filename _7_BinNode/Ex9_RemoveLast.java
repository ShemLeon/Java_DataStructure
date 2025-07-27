package _7_BinNode;
import unit4.collectionsLib.BinNode;

import static _7_BinNode.Ex2_Print.printList;
import static _7_BinNode.Ex6_From1ToN.createOkevList;


public class Ex9_RemoveLast {
    // удаление последнего элемента
    public static void removeLastNode(BinNode<Character> head) {
        if (head == null) return;   
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
        current.getLeft().setRight(null);
    }
}
