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
        Node<Integer> myList = createList(arr);
        System.out.println("Original list:");
        printList(myList);
        System.out.println("Измененный list:");
        // Правильный вызов
        myList = reorgList(myList);
        printList(myList);
    }

    public static Node<Integer> reorgList(Node<Integer> head){
        // 1. Случай, когда удалять нужно саму голову (или несколько первых узлов)
        while (head != null
                && head.getValue() % 7 == 0
                && head.getValue() % 3 != 0
        ) {
            head = head.getNext(); // Просто сдвигаем голову на следующий элемент
        }
        // Если после удаления первых узлов список стал пустым
        if (head == null) return null;

        // 2. Теперь голова на месте, идем по остальному списку
        Node<Integer> current = head;
        // Идем по списку, пока у ТЕКУЩЕГО узла есть СЛЕДУЮЩИЙ
        while (current.hasNext()){
            if (current.getNext().getValue()%7==0 && current.getNext().getValue()%3!=0){
                // Удаляем следующий узел, "перепрыгивая" через него.
                // 'current' НЕ сдвигаем, т.к. нужно проверить новый 'current.getNext()'
                current.setNext(current.getNext().getNext());
            } else {
                // Если удалять нечего, просто двигаемся дальше по списку
                current = current.getNext();
            }
        }
        return head;
    }
}
