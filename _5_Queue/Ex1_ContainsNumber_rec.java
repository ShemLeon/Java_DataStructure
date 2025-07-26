package _5_Queue;
import unit4.collectionsLib.Queue;

import static _5_Queue.Ex4_recursiaCounting.countQuIntSize;

public class Ex1_ContainsNumber_rec {
    // проверка наличия номера в очереди
    public static boolean isNumberInQueue(Queue<Integer> queue, int number) {
        if (queue == null || queue.isEmpty()) {     // Check
            System.out.println("Error:");
            return false;
        }
        Queue<Integer> tempQueue = new Queue<Integer>();
        boolean found = false;
        // Check each element
        while (!queue.isEmpty()) {
            int current = queue.remove();
            if (current == number) {
                found = true;
            }
            tempQueue.insert(current);
        }
        // Restore the original queue
        while (!tempQueue.isEmpty()) {
            queue.insert(tempQueue.remove());
        }
        return found;
    }

    // Рекурсивный вариант
    public static boolean isNumberInQueueRecursive(Queue<Integer> queue, int number) {
        if (queue == null || queue.isEmpty()) {
            if (queue == null) {
                System.out.println("Error: queue is null");
            }
            return false;
        }
        // Сначала получаем размер, не изменяя очередь
        int size = countQuIntSize(queue);
        // Вызываем рекурсивного помощника
        return findAndRestore(queue, number, size);
    }

    private static boolean findAndRestore(Queue<Integer> queue, int number, int n) {
        if (n == 0) return false;
        int current = queue.remove();
        queue.insert(current); // "Прокручиваем" очередь
        // Рекурсивный вызов для оставшихся n-1 элементов
        boolean foundInRest = findAndRestore(queue, number, n - 1);
        // Проверяем текущий элемент ПОСЛЕ того, как вся очередь была прокручена
        // и рекурсия вернулась на этот уровень.
        return (current == number) || foundInRest;
    }

    public static void main(String[] args) {
        Queue<Integer> q = new Queue<Integer>();
        q.insert(10);
        q.insert(20);
        q.insert(30);

        // Test function isNumberInQueue
        System.out.println("Queue: " + q.toString());

        int searchNumber = 20;
        boolean found = isNumberInQueue(q, searchNumber);
        System.out.println("Number " + searchNumber + " found: " + found);

        searchNumber = 40;
        found = isNumberInQueue(q, searchNumber);
        System.out.println("Number " + searchNumber + " found: " + found);

        // Check that the queue has not changed
        System.out.println("Queue after search: " + q.toString());

        // Test on empty queue
        Queue<Integer> emptyQueue = new Queue<Integer>();
        found = isNumberInQueue(emptyQueue, 10);

        // Test on null
        found = isNumberInQueue(null, 10);
    }
}