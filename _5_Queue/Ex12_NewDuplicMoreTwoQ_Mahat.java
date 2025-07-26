package _5_Queue;

import unit4.collectionsLib.Queue;

import static _5_Queue.Ex0_printQuInt.printQueueInt;
import static _5_Queue.Ex7_sortQu.sortQueueInt;

public class Ex12_NewDuplicMoreTwoQ_Mahat {
    /**
     * Метод принимает очередь целых чисел и возвращает новую очередь,
     * содержащую только те элементы, которые в исходной очереди встречались более двух раз.
     * Исходная очередь не важна.
     * @param q исходная очередь целых чисел.
     * @return новая очередь с элементами, по 1у экземпляру каждого, котоыре встретились более 2 раз
     */
    public static Queue<Integer> findDuplicates(Queue<Integer> q) {
        if (q == null || q.isEmpty()) return q;
        // 1. Сортируем очередь
        sortQueueInt(q);
        Queue<Integer> resultQ = new Queue<Integer>();
        // 2. Проходим по отсортированной очереди и подсчитываем повторения
        while (!q.isEmpty()) {
            int current = q.remove();
            int count = 1;
            // Считаем одинаковые элементы, идущие подряд
            while (!q.isEmpty() && q.head() == current) {
             q.remove();
             count++;
            }
            // Если элемент встречается более двух раз, добавляем его в результат
            if (count > 2) resultQ.insert(current);
        }
        printQueueInt(resultQ);
        return resultQ;
}

    public static void main(String[] args) {
        // Тест 1: Обычный случай с дубликатами
        System.out.println("=== Тест 1: Обычный случай ===");
        Queue<Integer> q1 = new Queue<Integer>();
        q1.insert(1);
        q1.insert(2);
        q1.insert(1);
        q1.insert(3);
        q1.insert(2);
        q1.insert(1);
        q1.insert(2);
        printQueueInt(q1);
        System.out.println("\nИсходная очередь: 1, 2, 1, 3, 2, 1, 2");
        Queue<Integer> result1 = findDuplicates(q1);
        System.out.print("Результат: ");
        printQueueInt(result1);
        System.out.println("Ожидаем: 1, 2 (элементы встречающиеся > 2 раз)");
        
        // Тест 2: Пустая очередь
        System.out.println("\n=== Тест 2: Пустая очередь ===");
        Queue<Integer> q2 = new Queue<Integer>();
        Queue<Integer> result2 = findDuplicates(q2);
        System.out.print("Результат для пустой очереди: ");
        printQueueInt(result2);
        
        // Тест 3: Нет элементов, встречающихся более 2 раз
        System.out.println("\n=== Тест 3: Нет дубликатов >2 раз ===");
        Queue<Integer> q3 = new Queue<Integer>();
        q3.insert(1);
        q3.insert(2);
        q3.insert(1);
        q3.insert(3);
        q3.insert(2);
        
        System.out.println("Исходная очередь: 1, 2, 1, 3, 2");
        Queue<Integer> result3 = findDuplicates(q3);
        System.out.print("Результат: ");
        printQueueInt(result3);
        System.out.println("Ожидаем: пустую очередь");
        
        // Тест 4: Все элементы одинаковые и встречаются >2 раз
        System.out.println("\n=== Тест 4: Все элементы одинаковые ===");
        Queue<Integer> q4 = new Queue<Integer>();
        q4.insert(5);
        q4.insert(5);
        q4.insert(5);
        q4.insert(5);
        
        System.out.println("Исходная очередь: 5, 5, 5, 5");
        Queue<Integer> result4 = findDuplicates(q4);
        System.out.print("Результат: ");
        printQueueInt(result4);
        System.out.println("Ожидаем: 5");
        
        // Тест 5: Смешанный случай
        System.out.println("\n=== Тест 5: Смешанный случай ===");
        Queue<Integer> q5 = new Queue<Integer>();
        q5.insert(7);
        q5.insert(8);
        q5.insert(7);
        q5.insert(9);
        q5.insert(7);
        q5.insert(8);
        q5.insert(10);
        q5.insert(7);
        
        System.out.println("Исходная очередь: 7, 8, 7, 9, 7, 8, 10, 7");
        Queue<Integer> result5 = findDuplicates(q5);
        System.out.print("Результат: ");
        printQueueInt(result5);
        System.out.println("Ожидаем: 7 (только 7 встречается >2 раз)");
    }
    

    }

