package _5_Queue;
import unit4.collectionsLib.Queue;


public class Queue_t4 {
    public static int countElements(Queue<Character> queue) {
        /**
 * Recursive function to count the number of elements in the queue
 *  * @param queue - queue of type Queue<Character>
 *  * @return the number of elements in the queue (int)
 *  * Complexity: * Time complexity: O(n), where n is the number of elements in the queue
 * 
 * Working principle:
 * 1. Base case: if the queue is empty, return 0
 * 2. Recursive case:
 *    - Remove an element using remove()
 *    - Recursively count the remaining elements
 *    - Return the element to the queue using insert()
 *    - Add 1 to the result of the recursion
 */
    if (queue.isEmpty()) return 0;
    
    
    Character element = queue.remove();
    int count = 1 + countElements(queue);
    queue.insert(element);
    
    return count;
}


    public static void main(String[] args) {
         // Test for counting elements
         Queue q = new Queue();
         q.insert('A');
         q.insert('B');
         q.insert('C');
         System.out.println("Number of elements: " + countElements(q));
    }
}