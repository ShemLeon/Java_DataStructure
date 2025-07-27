package _6_Reshima_Mekusheret;

import unit4.collectionsLib.Node;

public class Ex2_PrintList {
    public static void printListInt(Node<Integer> head) {
        // print the list
        Node<Integer> current = head;
        while (current != null) {
            System.out.print(current.getValue());
            if (current.getNext() != null) {
                System.out.print(" -> ");
            }
            current = current.getNext();
        }
        System.out.println();
    }

    public static void printListDouble(Node<Double> head) {
        Node<Double> current = head;

        while (current != null) {
            System.out.print(current.getValue());
            if (current.getNext() != null) {
                System.out.print(" -> ");
            }
            current = current.getNext();
        }
        System.out.println();
    }
    public static void printStringList(Node<String> list) {
        Node<String> current = list;
        while (current != null) {
            System.out.print(current.getValue());
            if (current.getNext() != null) {
                System.out.print(" -> ");
            }
            current = current.getNext();
        }
        System.out.println();
    }
}
