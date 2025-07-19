package _5_Queue;
import unit4.collectionsLib.Queue;

public class baza_queue {
    /*
    Basic methods and techniques for "TOR" / "FIFO" / "QUEUE"
    Example of creating a queue:
    Queue<Integer> qu = new Queue<Integer>();
    --  void qu.insert() - put a value at the end of the queue
    --  qu.remove()      - delete and "give to the user"/return the value from the top of the queue
    --  qu.head()        - view the value at the top of the queue (without deletion)
    --  qu.isEmpty()     - returns TRUE if the queue is empty. Boolean
    --  qu.toString()    - prints the queue.
        System.out.println(q.toString());
    Example of creating queues:
    Queue<Integer> q = new Queue<Integer>();
    Queue<String> t = new Queue<String>();
    */

    public static void printQu(Queue<Integer> queue) {
        // пропечатает очередь и восстановит ее
        if (queue == null) {
            System.out.println("Error: queue is not initialized");
            return;
        }

        if (queue.isEmpty()) {
            System.out.println("Queue is empty");
            return;
        }

        Queue<Integer> tempQueue = new Queue<Integer>();

        System.out.print("Queue contents: ");
        while (!queue.isEmpty()) {
            int element = queue.remove();
            System.out.print(element + " ");
            tempQueue.insert(element);
        }
        System.out.println();

        // Восстанавливаем исходную очередь
        while (!tempQueue.isEmpty()) {
            queue.insert(tempQueue.remove());
        }
    }

    public static int findMax(Queue<Integer> queue) {
        // Check for null
        if (queue == null) {
            System.out.println("Error: queue is not initialized");
            return 0;
        }
        // Check for emptiness
        if (queue.isEmpty()) {
            System.out.println("Error: queue is empty");
            return 0;
        }

        Queue<Integer> tempQueue = new Queue<Integer>();
        int max = queue.head(); // The first element of the queue as the initial maximum

        while (!queue.isEmpty()) {
            int current = queue.remove();
            if (current > max) {
                max = current;
            }
            tempQueue.insert(current);
        }

        // Restore the original queue
        while (!tempQueue.isEmpty()) {
            queue.insert(tempQueue.remove());
        }

        return max; // Return the found maximum
    }
    public static void main(String[] args) {
        // Example 1: Working with numbers
        Queue<Integer> q = new Queue<Integer>();
        q.insert(10);
        q.insert(20);
        q.insert(30);
        System.out.println("Top of the queue: " + q.head()); // outputs 10

        System.out.println(q.toString());

        // Example 2: View the contents
        // But after this action, it would be nice to put them back.
        System.out.println("Queue contents:");
        while (!q.isEmpty()) {
            System.out.println(q.remove());
        } // outputs [10,20,30]

        // Example 3: Working with strings
        Queue<String> words = new Queue<String>();
        words.insert("Hello");
        words.insert("World");
        words.insert("!");
        System.out.println(words);

        // Example 4: Copying a queue
        Queue<String> copyQueue = new Queue<String>();
        Queue<String> tempQueue = new Queue<String>();

        // First, move to a temporary queue
        while (!words.isEmpty()) {
            String value = words.remove();
            tempQueue.insert(value);
        }

        // Now from the temporary queue to both queues
        while (!tempQueue.isEmpty()) {
            String value = tempQueue.remove();
            words.insert(value);
            copyQueue.insert(value);
        }

        // Example 5: Counting elements in a queue
        int count = 0;
        Queue<String> tempCount = new Queue<String>();
        while (!words.isEmpty()) {
            tempCount.insert(words.remove());
            count++;
        }
        // Return elements back
        while (!tempCount.isEmpty()) {
            words.insert(tempCount.remove());
        }
        System.out.println("Number of elements: " + count);

        // Example 6: Finding the maximum element
        Queue<Integer> numbers2 = new Queue<Integer>();
        numbers2.insert(5);
        numbers2.insert(8);
        numbers2.insert(3);
        numbers2.insert(12);
        numbers2.insert(9);

        int max = findMax(numbers2);
        System.out.println("Maximum element: " + max);
    }
}