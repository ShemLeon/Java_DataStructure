package _6_Reshima_Mekusheret;
import unit4.collectionsLib.Node;

import static _6_Reshima_Mekusheret.Ex17_CountTarget.countTarget;
import static _6_Reshima_Mekusheret.baza.createList;
import static _6_Reshima_Mekusheret.baza.printList;

public class Ex18_DelDuplicate {
    // Ex18: удаляет все числа, которые не уникальны из связного списка.
    public static Node<Integer> deleteDuplicates(Node<Integer> head) {
        if (head == null) return null;
        Node<Integer> tempList = null; // временный список для уникальных элементов
        Node<Integer> tempTail = null;

        while (head != null) {
            int value = head.getValue();
            int count = countTarget(head, value);
            if (count == 1) {
                // Элемент уникальный - удаляем из исходного и добавляем в temp
                Node<Integer> uniqueNode = new Node<>(value);
                if (tempList == null) {
                    tempList = uniqueNode;
                    tempTail = uniqueNode;
                } else {
                    tempTail.setNext(uniqueNode);
                    tempTail = uniqueNode;
                }
                // Удаляем из исходного списка
                head = head.getNext();
            } else {
                // Элемент не уникальный - просто переходим дальше
                head = head.getNext();
            }
        }
        return tempList;
    }
    


    public static void main(String[] args) {
        // Тест 1
        Node<Integer> head1 = createList(new int[]{1, 2, 3, 2, 4, 3, 5});
        System.out.println("Исходный список 1:");
        printList(head1);
        
        Node<Integer> result1 = deleteDuplicates(head1);
        System.out.println("Уникальные элементы:");
        printList(result1);
        System.out.println();
        
        // Тест 2
        Node<Integer> head2 = createList(new int[]{1, 1, 2, 2, 3, 3});
        System.out.println("Исходный список 2:");
        printList(head2);
        
        Node<Integer> result2 = deleteDuplicates(head2);
        System.out.println("Уникальные элементы:");
        printList(result2);
        System.out.println();
        
        // Тест 3
        Node<Integer> head3 = createList(new int[]{1, 2, 3, 4, 5});
        System.out.println("Исходный список 3:");
        printList(head3);
        
        Node<Integer> result3 = deleteDuplicates(head3);
        System.out.println("Уникальные элементы:");
        printList(result3);
    }
}
