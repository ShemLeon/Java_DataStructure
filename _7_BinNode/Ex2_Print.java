package _7_BinNode;
import unit4.collectionsLib.BinNode;
import static _7_BinNode.Ex1_createFromArray.createList;
import static _7_BinNode.Ex5_AddNode.addNode;

/**
 * Класс содержит базовые функции для работы с двусвязным списком:
 * - Печать списка в обоих направлениях
 * - Добавление узлов в список
 */
public class Ex2_Print {
    // Функция для "вывода списка слева направо"
   public static void printList(BinNode<Integer> head) {
       BinNode<Integer> current = head;
       while (current != null) {
           System.out.print(current.getValue());
           if (current.getRight() != null) System.out.print(" <-> ");
           current = current.getRight();
       }
       System.out.println();

   }

    // Функция для "вывода списка справа налево"
    public static void printToLeft(BinNode<Integer> h) {
        BinNode<Integer> tmp = null;
        // Доходим до конца списка
        for (tmp = h; tmp != null && tmp.getRight() != null; tmp = tmp.getRight());
        // Печатаем значения справа налево
        for (; tmp != null; tmp = tmp.getLeft()) {
            System.out.print(tmp.getValue() + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        // Создаем тестовый список из массива
        int[] arr = {1, 2, 3, 4, 5};
        System.out.println("1. Создаем список из массива:");
        BinNode<Integer> list = createList(arr);
        printList(list);
        
        // Печатаем список в обоих направлениях
        System.out.println("\n2. Печать списка в обоих направлениях:");
        System.out.print("Слева направо:  ");
        printList(list);
        System.out.print("Справа налево: ");
        printToLeft(list);
        
        // Добавляем элементы в разные позиции
        System.out.println("\n3. Добавление элементов:");
        System.out.print("Добавляем 0 в начало:     ");
        addNode(list, null, 0);
        printList(list);
        
        System.out.print("Добавляем 6 после 3-го:   ");
        BinNode<Integer> third = list;
        for(int i = 0; i < 3; i++) third = third.getRight();
        addNode(list, third, 6);
        printList(list);
    }


}
