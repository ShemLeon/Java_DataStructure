package _6_Reshima_Mekusheret;

import unit4.collectionsLib.Node;

public class baza {
    /*
    Basic methods and techniques for "NODE LIST" / "Linked List" / "רשימה מקושרת"
    -- current.getValue() -     get the value of the current node
    -- current.getNext()  -     get the value of the next node
    -- current.setNext(new Node<>(value)) - set the value of the next node
    -- current = current.getNext();   -- Move to the next node

    1 - create a list from array:   public static Node<Integer> createList(int[] values) { return head }
    2 - print the list:      public static void printList(Node<Integer> head){}


    */

    public static void main(String[] args) {
        Node<Integer> list = createList(new int[]{5, 5, 15, 5, 5, 25}); // Example list


        printList(list);
    }


    public static Node<Integer> createList(int[] values) {
        // create a list from arr.
        Node<Integer> head = null;
        Node<Integer> current = null;

        for(int i = 0; i < values.length; i++) {
            if (head == null) {
                head = new Node<>(values[i]);
                current = head;
            } else {
                current.setNext(new Node<>(values[i]));
                current = current.getNext();
            }
        }
        return head;
    }

    public static void printList(Node<Integer> head) {
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
}
