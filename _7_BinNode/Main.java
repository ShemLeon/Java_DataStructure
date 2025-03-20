package _7_BinNode;

import unit4.collectionsLib.BinNode;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void printList(BinNode<Integer> head) {
        // пропечатывание списка
        BinNode<Integer> current = head;
        while (current != null) {
            System.out.print(current.getValue());
            if (current.getRight() != null) { // Check if there is a right node
                System.out.print(" <-> ");
            }
            current = current.getRight(); // Move to the next node
        }
        System.out.println(); // Print a new line after the list
    }
}