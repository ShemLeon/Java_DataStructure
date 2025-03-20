package _5_Queue;
import unit4.collectionsLib.Queue;

public class Queue_t1 {
    /**
     * Checks if a specified number is present in the queue
     * @param queue  queue of integers to search
     * @param number number to find
     * @return true if the number is found, false if not or queue is empty/null
     * Time complexity: O(n) - where n is the number of elements in the queue
     */
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