package _6_Reshima_Mekusheret;

import unit4.collectionsLib.Node;
import java.util.Scanner;

// מגישים:
// יבגני נמצ'נקו 321404634
// שמיאקין לאוניד 336540331
// כיתה 48-5

/**
 * Класс содержит функции для создания отсортированного связного списка
 * из пользовательского ввода, используя функцию insertSorted из Matala_37.
 */
public class Matala_38 {
    public static void main(String[] args) {
        Node<Integer> sortedList = createSortedList();
        System.out.println("\nОтсортированный список:");
        Matala_37.printList(sortedList);
    }

    /**
     * Функция для "создания отсортированного связного списка из пользовательского ввода"
     * @return начальный узел отсортированного списка
     * Complexity: O(n²), где n - количество введенных чисел
     * Принцип работы:
     * 1. Инициализируем пустой список
     * 2. В цикле считываем числа от пользователя:
     *    - Если число > 99, завершаем ввод
     *    - Иначе вставляем число в список, сохраняя сортировку
     * 3. Возвращаем созданный отсортированный список
     */
    public static Node<Integer> createSortedList() {
        Scanner scanner = new Scanner(System.in);
        Node<Integer> head = null;
        
        System.out.println("Введите числа (для завершения введите число > 99):");
        
        while (true) {
            int number = scanner.nextInt();
            if (number > 99) {
                break;
            }
            head = Matala_37.insertSorted(head, number);
        }
        
        return head;
    }
}