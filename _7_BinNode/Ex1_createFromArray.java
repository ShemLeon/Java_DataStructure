package _7_BinNode;

import unit4.collectionsLib.BinNode;

public class Ex1_createFromArray {
    /**
     Создание двусвязного списка из массива
     * @param values array of values
     * @return the head node of the created list
     * Complexity: O(n)
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
}
