package _5_Queue;
import unit4.collectionsLib.Queue;


public class Ex4_recursiaCounting {
    public static int countQuCharElements(Queue<Character> queue) {
        // Подсчет количества элементов очереди рекурсивно
        // Complexity: * Time complexity: O(n), where n is the number of elements in the queue
        if (queue.isEmpty()) return 0;
        Character element = queue.remove();
        int count = 1 + countQuCharElements(queue);
        queue.insert(element);
        return count;
    }

    public static int countQuIntSize(Queue<Integer> queue) {
        int size = 0;
        Queue<Integer> temp = new Queue<>();

        while (!queue.isEmpty()) {
            temp.insert(queue.remove());
            size++;
        }

        while (!temp.isEmpty()) {
            queue.insert(temp.remove());
        }

        return size;
    }


    public static void main(String[] args) {
         // Test for counting elements
         Queue q = new Queue();
         q.insert('A');
         q.insert('B');
         q.insert('C');
         System.out.println("Number of elements: " + countQuCharElements(q));
    }
}