package _5_Queue;
import unit4.collectionsLib.Queue;


public class Ex4_recursiaCounting {
    public static int countElements(Queue<Character> queue) {
    // Подсчет количества элементов рекурсивно
   // Complexity: * Time complexity: O(n), where n is the number of elements in the queue
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