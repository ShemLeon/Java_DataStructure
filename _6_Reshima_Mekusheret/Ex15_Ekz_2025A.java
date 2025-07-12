package _6_Reshima_Mekusheret;
import unit4.collectionsLib.Node;

import static _6_Reshima_Mekusheret.baza.createList;
import static _6_Reshima_Mekusheret.baza.printList;

public class Ex15_Ekz_2025A {
    // Ф-я получает связный список из целых чисел и удаляет значения,
    // которые кратны 7, но не кратны 3.


    public static void main(String[] args) {
        // Test cases
        int[] arr = {14, 21, 28, 49, 49, 63, 70, 100};
        Node<Integer> list1 = createList(arr);
        System.out.println("Original list:");
        printList(list1);
        System.out.println(list1.hasNext());
    }

    public static void reorgList(Node<Integer> head){
        Node<Integer> current = head;
        if (head == null) return;
        while (current.hasNext()){
            if (current.getNext().getValue()%7==0
                    && current.getNext().getValue()%3!=0) {
                current.setNext().getNext();
            }
        }

    }
}
