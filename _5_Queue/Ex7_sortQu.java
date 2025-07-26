package _5_Queue;
import unit4.collectionsLib.Queue;

import static _5_Queue.Ex6_deleteMinValue.findAndRemoveMinInt;
import static _5_Queue.Ex6_deleteMinValue.findAndRemoveMinString;


public class Ex7_sortQu {



    /* Функция для сортировки очереди строк в порядке возрастания
 * @param queue очередь строк для сортировки
 * Сложность: O(n²) по времени (для каждого из n элементов мы ищем минимум среди оставшихся), O(n) по памяти
 * Принцип работы:
 * 1. Создаем временную очередь для хранения отсортированных элементов
 * 2. Находим и удаляем минимальный элемент из исходной очереди
 * 3. Добавляем минимальный элемент в отсортированную очередь
 * 4. Повторяем шаги 2-3, пока исходная очередь не станет пустой
 * 5. Возвращаем элементы в исходную очередь в отсортированном порядке
 * Очередь до сортировки: [banana,apple,cherry,date]
 * Очередь после сортировки: [apple,banana,cherry,date]
 */
    public static void sortQueueString(Queue<String> queue) {
        Queue<String> sortedQueue = new Queue<>(); // Временная очередь для хранения отсортированных элементов
        while (!queue.isEmpty()) {
            String min = findAndRemoveMinString(queue); // Находим и удаляем минимальный элемент
            sortedQueue.insert(min); // Добавляем минимальный элемент в отсортированную очередь
        }
        // Перемещаем элементы из отсортированной очереди обратно в исходную
        while (!sortedQueue.isEmpty()) {
            queue.insert(sortedQueue.remove());
        }
    }

    public static void sortQueueInt(Queue<Integer> queue) {
        Queue<Integer> sortedQueue = new Queue<>(); // Временная очередь для хранения отсортированных элементов
        while (!queue.isEmpty()) {
            int min = findAndRemoveMinInt(queue); // Находим и удаляем минимальный элемент
            sortedQueue.insert(min); // Добавляем минимальный элемент в отсортированную очередь
        }
        // Перемещаем элементы из отсортированной очереди обратно в исходную
        while (!sortedQueue.isEmpty()) {
            queue.insert(sortedQueue.remove());
        }
    }






    public static void main(String[] args) {
        Queue<String> queue = new Queue<>();

        // Добавляем строки в очередь
        queue.insert("banana");
        queue.insert("apple");
        queue.insert("cherry");
        queue.insert("date");

        System.out.println("Queue before sorting: " + queue);

        // Сортируем очередь
        sortQueueString(queue);

        System.out.println("Queue after sorting: " + queue);
    }

public static Queue<Integer> findDuplicates(Queue<Integer> q) {
    if (q == null || q.isEmpty()) {
        return new Queue<Integer>();
    }
    
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
        
        // Если элемент встречается более двух раз, добавляем все его вхождения в результат
        if (count > 2) {
            for (int i = 0; i < count; i++) {
                resultQ.insert(current);
            }
        }
    }
    
    return resultQ;
}
}