package _5_Queue;
import unit4.collectionsLib.Queue;

import static _5_Queue.Queue_t1.isNumberInQueue;

public class Queue_t2 {
    public static Queue<Integer> removeDuplicates(Queue<Integer> queue) {
        /**
         * Creates a new queue without duplicates from the original queue
         * @param queue original queue with numbers
         * @return new queue where each number appears only once
         * Complexity: O(n^2) - where n is the number of elements in the queue
         */
        if (queue == null || queue.isEmpty()) {
            System.out.println("Error: queue is empty or not initialized");
            return new Queue<Integer>();
        }

Queue<Integer> result = new Queue<Integer>();
Queue<Integer> temp = new Queue<Integer>();

// Copy elements from the original queue
while (!queue.isEmpty()) {
    temp.insert(queue.remove());
}

// Restore the original queue and create a new one without duplicates
while (!temp.isEmpty()) {
    int current = temp.remove();
    queue.insert(current);
    
    // Add to result only if this number is not already present
    if (!isNumberInQueue(result, current)) {
        result.insert(current);
    }
}

return result;
    }

    public static void main(String[] args) {
        Queue<Integer> q = new Queue<Integer>();
        q.insert(10);
        q.insert(20);
        q.insert(10);  // duplicate
        q.insert(30);
        q.insert(20);  // duplicate
        
        System.out.println("Initial queue: " + q.toString());
        
        Queue<Integer> uniqueQueue = removeDuplicates(q);
        System.out.println("Queue without duplicates: " + uniqueQueue.toString());
        
        // Check that the original queue has not changed
        System.out.println("Original queue after processing: " + q.toString());
    }
}