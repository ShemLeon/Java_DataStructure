package _6_Reshima_Mekusheret;
import unit4.collectionsLib.Node;

import static _6_Reshima_Mekusheret.baza.createList;
import static _6_Reshima_Mekusheret.baza.printList;

// в решима мекушерет надо каждые 3 узла проверить и оставить только максимальный из них
public class Ex16_3maximum {
    public static Node<Integer> reorgList(Node<Integer> head){
        if (head == null) return null;
        
        Node<Integer> newHead = null;
        Node<Integer> newTail = null;
        Node<Integer> current = head;
        
        // Обрабатываем группы по 3 узла
        while (current != null) {
            int maxValue = current.getValue();
            Node<Integer> temp = current;
            int count = 1;
            
            // Находим максимум среди следующих 3 узлов (или меньше, если список закончился)
            while (temp != null && count <= 3) {
                if (temp.getValue() > maxValue) {
                    maxValue = temp.getValue();
                }
                temp = temp.getNext();
                count++;
            }
            
            // Создаем новый узел с максимальным значением
            Node<Integer> newNode = new Node<>(maxValue);
            
            // Добавляем узел в новый список
            if (newHead == null) {
                newHead = newNode;
                newTail = newNode;
            } else {
                newTail.setNext(newNode);
                newTail = newNode;
            }
            
            // Переходим к следующей группе из 3 узлов
            for (int i = 0; i < 3 && current != null; i++) {
                current = current.getNext();
            }
        }
        
        return newHead;
    }

    public static void main(String[] args){
        Node<Integer> head = createList(new int[]{22, 21, 14, 13, 8, 4, 6, 7, 9});
        System.out.println("Исходный список:");
        printList(head);
        
        head = reorgList(head);
        
        System.out.println("После реорганизации:");
        printList(head);
    }
}
