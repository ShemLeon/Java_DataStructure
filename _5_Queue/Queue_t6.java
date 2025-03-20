package _5_Queue;
import unit4.collectionsLib.Queue;


public class Queue_t6 {
    public static void main(String[] args) {
        Queue<String> queue = new Queue<>();

        // Adding strings to the queue
        queue.insert("banana");
        queue.insert("apple");
        queue.insert("cherry");
        queue.insert("date");

        System.out.println("Queue before sorting: " + queue);

        // Sorting the queue
        sortQueue(queue);

        System.out.println("Queue after sorting: " + queue);
    }

    /* Function to sort a queue of strings in ascending order
 * @param queue queue of strings to sort
 * Complexity: O(n²) time (for each of the n elements, we search for the minimum among the remaining), O(n) memory
 * Working principle:
 * 1. Create a temporary queue to hold sorted elements
 * 2. Find and remove the minimum element from the original queue
 * 3. Add the minimum element to the sorted queue
 * 4. Repeat steps 2-3 until the original queue is empty
 * 5. Return elements to the original queue in sorted order
 * Queue before sorting: [banana,apple,cherry,date]
 * Queue after sorting: [apple,banana,cherry,date]
 */
    public static void sortQueue(Queue<String> queue) {
        Queue<String> sortedQueue = new Queue<>(); // Temporary queue to hold sorted elements

        while (!queue.isEmpty()) {
            String min = findAndRemoveMin(queue); // Find and remove the minimum element
            sortedQueue.insert(min); // Add the minimum element to the sorted queue
        }

        // Move elements from the sorted queue back to the original queue
        while (!sortedQueue.isEmpty()) {
            queue.insert(sortedQueue.remove());
        }
    }

   /* Function to find and remove the minimum element from the queue
 * @param queue queue of strings to find the minimum
 * @return minimum string from the queue
 * Complexity: O(n) time, O(n) memory
 * Working principle:
 * 1. Take the first element as the minimum
 * 2. Iterate through all elements of the queue
 * 3. If we find an element smaller than the current minimum - update the minimum
 * 4. Return all elements except the minimum to the original queue
 */
    private static String findAndRemoveMin(Queue<String> queue) {
        Queue<String> tempQueue = new Queue<>(); // Temporary queue to hold elements
        String min = queue.remove(); // Assume the first element is the minimum
        tempQueue.insert(min); // Store the first element in the temporary queue

        // Iterate through the queue to find the minimum element
        while (!queue.isEmpty()) {
            String current = queue.remove();
            if (current.compareTo(min) < 0) {
                tempQueue.insert(min); // Move the previous minimum to the temporary queue
                min = current; // Update the minimum element
            } else {
                tempQueue.insert(current); // Move the current element to the temporary queue
            }
        }

        // Move all elements back to the original queue except the minimum element
        while (!tempQueue.isEmpty()) {
            String temp = tempQueue.remove();
            if (!temp.equals(min)) { // Skip the minimum element
                queue.insert(temp);
            }
        }

        return min; // Return the minimum element
    }
}