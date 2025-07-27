package _6_Reshima_Mekusheret;

import unit4.collectionsLib.Node;

public class Ex1_CreateListFromArray {
    public static Node<Integer> createList(int[] arr) {
        // create a list from arr.
        Node<Integer> head = null;
        Node<Integer> current = null;
        for(int i = 0; i < arr.length; i++) {
            if (head == null) { // для создания головы.
                head = new Node<>(arr[0]);
                current = head;
            } else {
                current.setNext(new Node<>(arr[i]));
                current = current.getNext();
            }
        }
        return head;
    }

    public static Node<Double> createList(double[] values) {
        Node<Double> head = null;
        Node<Double> current = null;

        for (double value : values) {
            if (head == null) {
                head = new Node<>(value);
                current = head;
            } else {
                current.setNext(new Node<>(value));
                current = current.getNext();
            }
        }

        return head;
    }
}
