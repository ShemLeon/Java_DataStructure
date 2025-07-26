package _5_Queue;

import unit4.collectionsLib.Queue;

import static _5_Queue.Ex0_printQuInt.printQueueInt;
import static _5_Queue.Ex7_sortQu.sortQueueInt;

public class Ex12_NewDuplicMoreTwoQ_Mahat {
    /**
     * Метод принимает очередь целых чисел и возвращает новую очередь,
     * содержащую только те элементы, которые в исходной очереди встречались более двух раз.
     * СОхранение исходной очередт не важно.
     * @param q исходная очередь целых чисел.
     * @return новая очередь с элементами, по 1у экземпляру каждого, которые встретились более 2 раз
     */
    public static Queue<Integer> newDuplicMoreTwo(Queue<Integer> q) {
        if (q == null || q.isEmpty()) return q;
        sortQueueInt(q);// 1. Сортируем очередь
        Queue<Integer> resultQ = new Queue<Integer>();
        // 2. Проходим по отсортированной очереди и подсчитываем повторения
        while (!q.isEmpty()) {
            int current = q.remove();
            int count = 1;
            // Считаем одинаковые элементы, идущие подряд
            while (!q.isEmpty() && q.head().equals(current)) {
                q.remove();
                count++;
            }
            // Если элемент встречается более двух раз, добавляем его в результат
            if (count > 2) resultQ.insert(current);
        }
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
        System.out.println("Исходная очередь: ");
        printQueueInt(q1);

        Queue<Integer> result1 = newDuplicMoreTwo(q1);

        System.out.println("\nРезультат: ");
        printQueueInt(result1);
        System.out.println("\nОжидаем: 1, 2 (элементы встречающиеся > 2 раз)");
    }    }
