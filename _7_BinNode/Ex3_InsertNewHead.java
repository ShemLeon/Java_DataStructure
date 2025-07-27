package _7_BinNode;
import unit4.collectionsLib.BinNode;
import static _7_BinNode.Ex1_createFromArray.createList;
import static _7_BinNode.Ex2_Print.printList;


public class Ex3_InsertNewHead {
    /**
     * Функция "вставки нового элемента в начало двусвязного списка"
     * @param head current starting node of the list
     * @param num value to insert
     * Complexity: O(1), since only operations on the starting node are performed
     * Working principle:
     * 1. Check that the list is not empty
     * 2. Создаем новый узел с текущим значением головы
     * 3. Если у головы есть правый узел:
     *    - Связываем новый узел с правым узлом
     *    - Обновляем левую связь правого узла
     * 4. Обновляем значение головы и её связи:
     *    - Устанавливаем новое значение
     *    - Связываем с новым узлом справа
     *    - Обнуляем левую связь
     */
    public static void insertHeadBNlist(BinNode<Integer> head, int num) {
        if (head == null) {
            System.out.println("Список не может быть пустым.");
            return;
        }
        // Create a new node with the current head value
        BinNode<Integer> temp = new BinNode<>(head.getValue());
        // Check if the head has a right node
        if (head.hasRight()) {
            temp.setRight(head.getRight());
            head.getRight().setLeft(temp);
        }
        // Update the head value and its links
        head.setValue(num);
        head.setRight(temp);
        head.setLeft(null);
        // Set the left link of the new node to the head
        temp.setLeft(head);
    }
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 3, 2, 1};

        BinNode<Integer> bnList = createList(arr);
        System.out.println("Original list:");
        printList(createList(arr));

        System.out.println("After inserting 333 at the beginning:");
        insertHeadBNlist(bnList, 333);
        printList(bnList);
    }
}
