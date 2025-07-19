package _5_Queue;
import unit4.collectionsLib.Queue;


public class Ex0_printQuInt{
    public static void printQueueInt(Queue<Integer> queue) {
        Queue<Integer> temp = new Queue<>();
        System.out.print("[ ");

        while (!queue.isEmpty()) {
            int value = queue.remove();
            System.out.print(value + " ");
            temp.insert(value);
        }
        System.out.print("]");

        // Восстанавливаем очередь
        while (!temp.isEmpty()) {
            queue.insert(temp.remove());
        }
    }
}



