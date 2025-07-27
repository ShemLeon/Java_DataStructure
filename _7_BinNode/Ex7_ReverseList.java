package _7_BinNode;// Создание списка в обратном порядке
import unit4.collectionsLib.BinNode;

import static _7_BinNode.Ex2_Print.printList;
import static _7_BinNode.Ex6_From1ToN.createOkevList;

public class Ex7_ReverseList {
    /**
     * Функция для обращения двусвязного списка
     * @param head головной узел списка
     * @return новая голова обращенного списка
     * Сложность: O(n), где n - количество узлов в списке
     * Принцип работы:
     * 1. Проходим по всему списку
     * 2. Для каждого узла меняем местами левую и правую ссылки
     * 3. Отслеживаем предыдущий узел, который станет новой головой
     */
    public static BinNode<Integer> reverseList(BinNode<Integer> head) {
        if (head == null) return null; // Пустой список

        BinNode<Integer> current = head;
        BinNode<Integer> previous = null;
        
        // Проходим по всем узлам и меняем направления связей
        while (current != null) {
            // Сохраняем следующий узел
            BinNode<Integer> nextNode = current.getRight();
            
            // Меняем местами левую и правую ссылки
            current.setRight(current.getLeft());
            current.setLeft(nextNode);
            
            // Обновляем previous для следующей итерации
            previous = current;
            
            // Переходим к следующему узлу
            current = nextNode;
        }
        
        // previous теперь указывает на последний обработанный узел (новая голова)
        return previous;
    }
    


    public static void main(String[] args) {
        System.out.println("=== Тестирование обращения списка ===\n");
        
        System.out.println("1. Создание списка от 1 до 5:");
        BinNode<Integer> list = createOkevList(5);
        System.out.print("Исходный список: ");
        printList(list);
        
        System.out.println("\n2. Обращение списка:");
        list = reverseList(list);
        System.out.print("Обращенный список: ");
        printList(list);
        
        System.out.println("\n3. Обращение обратно:");
        list = reverseList(list);
        System.out.print("Список после двойного обращения: ");
        printList(list);
        
        System.out.println("\n4. Тест с одним элементом:");
        BinNode<Integer> singleNode = createOkevList(1);
        System.out.print("Исходный список: ");
        printList(singleNode);
        singleNode = reverseList(singleNode);
        System.out.print("Обращенный список: ");
        printList(singleNode);
        
        System.out.println("\n5. Тест с двумя элементами:");
        BinNode<Integer> twoNodes = createOkevList(2);
        System.out.print("Исходный список: ");
        printList(twoNodes);
        twoNodes = reverseList(twoNodes);
        System.out.print("Обращенный список: ");
        printList(twoNodes);
    }
}
