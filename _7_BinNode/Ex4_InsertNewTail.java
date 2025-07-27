package _7_BinNode;
import unit4.collectionsLib.BinNode;

import static _7_BinNode.Ex1_createFromArray.createList;
import static _7_BinNode.Ex2_Print.printList;


public class Ex4_InsertNewTail {
    // вставку элемента в конец списка
    /* Функция для "вставки нового элемента в конец двусвязного списка"
     * @param head головной узел списка
     * @param num значение для вставки
     * Сложность: O(n), где n - количество узлов в списке
     * Принцип работы:
     * 1. Проверяем, что список не пуст
     * 2. Находим последний узел:
     *    - Проходим вправо до достижения конца (hasRight == false)
     * 3. Создаем новый узел и связываем его:
     *    - Создаем узел с новым значением
     *    - Устанавливаем правую связь последнего узла
     *    - Устанавливаем левую связь нового узла
     */

    public static void insertEndBNlist(BinNode<Integer> head, int num) {
        if (head == null) {
            System.out.println("Список не может быть пустым.");
            return;
        }
        // Находим последний узел
        BinNode<Integer> current = head;
        while (current.hasRight()) {
            current = current.getRight();
        }
        // Создаем и связываем новый узел
        BinNode<Integer> temp = new BinNode<>(num);
        current.setRight(temp);
        temp.setLeft(current);
    }
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 3, 2, 4};

        System.out.println("Original list:");
        BinNode<Integer> bnList = createList(arr);
        printList(bnList);

        System.out.println("After inserting 333 at the end:");
        insertEndBNlist(bnList, 333);
        printList(bnList);
    }

}
