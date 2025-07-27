package _7_BinNode;
import unit4.collectionsLib.BinNode;

import static _7_BinNode.Ex1_createFromArray.createList;
import static _7_BinNode.Ex2_Print.printList;

public class Ex5_AddNode {
    // Вставка нового узла в внутрь двусвязного списка
    public static BinNode<Integer> addNode(BinNode<Integer> h, BinNode<Integer> p, int n) {
        if (h == null) {
            return new BinNode<Integer>(n); // Создаем и возвращаем первый узел
        } else {
            if (p == null) { // Вставка в начало списка
                BinNode<Integer> newNode = new BinNode<Integer>(n); // Создаем новый узел
                newNode.setRight(h);      // Связываем справа с текущей головой
                h.setLeft(newNode);       // Связываем голову слева с новым узлом
                return newNode;           // Возвращаем новую голову
            } else {
                // Создаем новый узел
                BinNode<Integer> newNode = new BinNode<Integer>(n);
                // Сохраняем ссылку на следующий узел после p
                BinNode<Integer> next = p.getRight();
                // Связываем p с новым узлом
                p.setRight(newNode);
                newNode.setLeft(p);
                // Если был следующий узел, связываем его с новым
                if (next != null) {
                    newNode.setRight(next);
                    next.setLeft(newNode);
                }
                return h; // Возвращаем голову списка
            }
        }
    }



    public static void main(String[] args) {
        System.out.println("=== Тестирование метода addNode ===\n");
        
        // Тест 1: Добавление в пустой список
        System.out.println("1. Тест: Добавление в пустой список");
        BinNode<Integer> list1 = null;
        list1 = addNode(list1, null, 100);
        System.out.print("Результат: ");
        printList(list1);
        System.out.println();
        
        // Тест 2: Добавление в начало существующего списка
        System.out.println("2. Тест: Добавление в начало списка");
        int[] arr = {1, 2, 3, 4, 5};
        BinNode<Integer> list2 = createList(arr);
        System.out.print("Исходный список: ");
        printList(list2);
        
        list2 = addNode(list2, null, 0);
        System.out.print("После добавления 0 в начало: ");
        printList(list2);
        System.out.println();
        
        // Тест 3: Добавление в середину списка
        System.out.println("3. Тест: Добавление в середину списка");
        int[] arr2 = {10, 20, 30, 40};
        BinNode<Integer> list3 = createList(arr2);
        System.out.print("Исходный список: ");
        printList(list3);
        
        // Найдем второй элемент (20) и добавим после него 25
        BinNode<Integer> second = list3.getRight(); // переходим ко второму элементу
        list3 = addNode(list3, second, 25);
        System.out.print("После добавления 25 после второго элемента: ");
        printList(list3);
        System.out.println();
        
        // Тест 4: Добавление в конец списка
        System.out.println("4. Тест: Добавление в конец списка");
        int[] arr3 = {7, 8, 9};
        BinNode<Integer> list4 = createList(arr3);
        System.out.print("Исходный список: ");
        printList(list4);
        
        // Найдем последний элемент
        BinNode<Integer> last = list4;
        while (last.getRight() != null) {
            last = last.getRight();
        }
        list4 = addNode(list4, last, 99);
        System.out.print("После добавления 99 в конец: ");
        printList(list4);
        System.out.println();
        
        System.out.println("=== Все тесты завершены ===");
    }
}
