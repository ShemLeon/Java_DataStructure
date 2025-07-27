package _7_BinNode;
import unit4.collectionsLib.BinNode;

import static _7_BinNode.Ex2_Print.printList;
import static _7_BinNode.Ex2_Print.printToLeft;
import static _7_BinNode.Ex6_From1ToN.createOkevList;


public class Ex8_RemoveFirst {
    // удаление первого элемента
    public static BinNode<Integer> removeFirstNode(BinNode<Integer> head) {
        if (head == null) return null;
        BinNode<Integer> newHead = head.getRight();
        if (newHead != null) newHead.setLeft(null);
        return newHead;
    }
    public static void main(String[] args) {
        System.out.println("1. Creating a list from 1 to 5:");
        BinNode<Integer> list = createOkevList(5);
        printList(list);
        System.out.println("\n2. Deleting the first element:");
        list = removeFirstNode(list);
        printList(list);

    }




}
