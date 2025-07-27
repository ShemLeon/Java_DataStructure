package _6_Reshima_Mekusheret;

import unit4.collectionsLib.Node;
import java.util.Scanner;
import static _6_Reshima_Mekusheret.Ex10_Matala_37.insertSorted;
import static _6_Reshima_Mekusheret.Ex2_PrintList.printListInt;

public class Ex11_Matala_38 {
    public static void main(String[] args) {
        Node<Integer> sortedList = createSortedList();
        System.out.println("\nОтсортированный список:");
        printListInt(sortedList);
    }
    /**
     * Функция для "создания отсортированного связного списка из пользовательского ввода"
     * @return начальный узел отсортированного списка
     * Complexity: O(n²), где n - количество введенных чисел
     * Принцип работы:
     * 1. Инициализируем пустой список
     * 2. В цикле считываем числа от пользователя:
     * 3. Возвращаем созданный отсортированный список
     */
    public static Node<Integer> createSortedList() {
        Scanner scanner = new Scanner(System.in);
        Node<Integer> head = null;
        System.out.println("Введите числа (для завершения введите число > 99):");
        while (true) {
            int number = scanner.nextInt();
            if (number > 99) break;
            head = insertSorted(head, number);
        }
        return head;
    }
}