package _7_BinNode;
import unit4.collectionsLib.BinNode;

import static _7_BinNode.Ex1_createFromArray.createList;


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



    /* Function for "creating a doubly linked list from an array"
     * @param values the array of values to create the list
     * @return the head node of the created list
     * Complexity: O(n), where n is the size of the input array
     * Working principle:
     * 1. Initialize an empty list
     * 2. For each element in the array:
     *    - Create a new node
     *    - If the list is empty, make the node the head
     *    - Otherwise, link it with the previous node
     * 3. Return the head of the list
     */

    public static void printList(BinNode<Integer> head) {
        BinNode<Integer> current = head;
        while (current != null) {
            System.out.print(current.getValue());
            if (current.getRight() != null) {
                System.out.print(" <-> ");
            }
            current = current.getRight();
        }
        System.out.println();
    }

    /* Function for "printing the list from right to left"
     * @param head the head node of the list
     * Complexity: O(n), where n is the number of nodes in the list
     * Working principle:
     * 1. Find the end of the list:
     *    - Traverse right until reaching the last node
     * 2. Print the list in reverse order:
     *    - Print the value of the current node
     *    - If there is a previous node, print a separator
     *    - Move to the previous node
     */
    public static void printRightList(BinNode<Integer> head) {
        BinNode<Integer> current = head;

        // Find the end of the list
        while (current.getRight() != null) {
            current = current.getRight();
        }

        // Print the values in reverse order
        while (current != null) {
            System.out.print(current.getValue());
            if (current.getLeft() != null) {
                System.out.print(" <-> ");
            }
            current = current.getLeft();
        }
        System.out.println();
    }
}
