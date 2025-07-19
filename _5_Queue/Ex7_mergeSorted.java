package _5_Queue;
import unit4.collectionsLib.Queue;


public class Ex7_mergeSorted {
    // объединение двух отсортированных очередей в одну отсортированную
    public static Queue<String> mergeSortedQueues(Queue<String> queue1, Queue<String> queue2) {
        Queue<String> mergedQueue = new Queue<>();

        // Merging two queues
        while (!queue1.isEmpty() && !queue2.isEmpty()) {
            // Compare elements at the head of each queue
            if (queue1.head().compareTo(queue2.head()) <= 0) {
                mergedQueue.insert(queue1.remove()); // Take from the first queue
            } else {
                mergedQueue.insert(queue2.remove()); // Take from the second queue
            }
        }

        // Add remaining elements from the first queue (if any)
        while (!queue1.isEmpty()) {
            mergedQueue.insert(queue1.remove());
        }

        // Add remaining elements from the second queue (if any)
        while (!queue2.isEmpty()) {
            mergedQueue.insert(queue2.remove());
        }

        return mergedQueue;
    }
    public static void main(String[] args) {
        // Create two sorted queues
        Queue<String> queue1 = new Queue<>();
        Queue<String> queue2 = new Queue<>();

        // Fill the first queue
        queue1.insert("Alice");
        queue1.insert("Charlie");
        queue1.insert("Emily");

        // Fill the second queue
        queue2.insert("Bob");
        queue2.insert("David");
        queue2.insert("Frank");

        // Print the original queues
        System.out.println("Первая очередь: " + queue1);
        System.out.println("Вторая очередь: " + queue2);

        // Merge the queues
        Queue<String> mergedQueue = mergeSortedQueues(queue1, queue2);

        // Print the result
        System.out.println("Объединённая очередь: " + mergedQueue);
    }


}