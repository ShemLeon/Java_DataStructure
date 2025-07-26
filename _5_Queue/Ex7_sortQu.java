package _5_Queue;
import unit4.collectionsLib.Queue;
import static _5_Queue.Ex0_printQuInt.printQueueInt;
import static _5_Queue.Ex6_deleteMinValue.findAndRemoveMinInt;
import static _5_Queue.Ex6_deleteMinValue.findAndRemoveMinString;

public class Ex7_sortQu {
    public static void sortQueueString(Queue<String> queue) {
        Queue<String> sortedQueue = new Queue<>();
        while (!queue.isEmpty()) {
            String min = findAndRemoveMinString(queue);
            sortedQueue.insert(min);
        }
        while (!sortedQueue.isEmpty()) {
            queue.insert(sortedQueue.remove());
        }
    }

    public static void sortQueueInt(Queue<Integer> queue) {
        Queue<Integer> sortedQueue = new Queue<>();
        while (!queue.isEmpty()) {
            int min = findAndRemoveMinInt(queue);
            sortedQueue.insert(min);
        }
        while (!sortedQueue.isEmpty()) {
            queue.insert(sortedQueue.remove());
        }
    }


    public static void main(String[] args) {
        Queue<String> queue = new Queue<>();
        queue.insert("banana");
        queue.insert("apple");
        queue.insert("cherry");
        queue.insert("date");
        System.out.println("Queue before sorting: " + queue);
        sortQueueString(queue);
        System.out.println("Queue after sorting: " + queue);

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
        sortQueueInt(q1);
        System.out.println("");
        printQueueInt(q1);
    }
}