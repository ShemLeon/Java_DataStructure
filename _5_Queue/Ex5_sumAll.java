package _5_Queue;
import unit4.collectionsLib.Queue;

// сумма всех элементов
public class Ex5_sumAll {
    public static int sumQueue(Queue<Integer> queue) {
        Queue<Integer> tempQueue = new Queue<>();
        int sum = 0, value;
        while (!queue.isEmpty()) {
            value = queue.remove();
            sum += value;
            tempQueue.insert(value);
        }
        while (!tempQueue.isEmpty()) {
            queue.insert(tempQueue.remove());
        }
        return sum;
    }
    public static void main(String[] args) {
        Queue<Integer> queue = new Queue<>();
        queue.insert(1);
        queue.insert(2);
        queue.insert(3);
        queue.insert(4);
        queue.insert(5);

        System.out.println("Sum of elements: " + sumQueue(queue));

        System.out.print("Initial queue: ");
        while (!queue.isEmpty()) {
            System.out.print(queue.remove() + " ");
        }
    }
}