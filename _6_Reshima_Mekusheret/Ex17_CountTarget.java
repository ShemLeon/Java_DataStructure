package _6_Reshima_Mekusheret;
import unit4.collectionsLib.Node;

import static _6_Reshima_Mekusheret.baza.createList;
import static _6_Reshima_Mekusheret.baza.printList;

public class Ex17_CountTarget {
    // Подсчитывает количество вхождений значения в списке
    public  static int countTarget(Node<Integer> head, int value) {
        int count = 0;
        Node<Integer> current = head;

        while (current != null) {
            if (current.getValue() == value) {
                count++;
            }
            current = current.getNext();
        }
        return count;
    }
}
