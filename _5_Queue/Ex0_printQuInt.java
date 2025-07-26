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
    
    public static void main(String[] args) {
        System.out.println("=== Тестирование функции printQueueInt ===\n");
        
        // Тест 1: Обычная очередь с несколькими элементами
        System.out.println("Тест 1: Обычная очередь");
        Queue<Integer> q1 = new Queue<>();
        q1.insert(10);
        q1.insert(20);
        q1.insert(30);
        q1.insert(40);
        
        System.out.print("Печать очереди: ");
        printQueueInt(q1);
        System.out.println();
        
        // Проверяем, что очередь восстановлена
        System.out.println("Проверяем восстановление очереди:");
        System.out.println("Первый элемент (head): " + q1.head());
        System.out.println("Удаляем элемент: " + q1.remove());
        System.out.println("Новый первый элемент: " + q1.head());
        
        // Тест 2: Пустая очередь
        System.out.println("\nТест 2: Пустая очередь");
        Queue<Integer> q2 = new Queue<>();
        System.out.print("Печать пустой очереди: ");
        printQueueInt(q2);
        System.out.println();
        System.out.println("Очередь пуста: " + q2.isEmpty());
        
        // Тест 3: Очередь с одним элементом
        System.out.println("\nТест 3: Очередь с одним элементом");
        Queue<Integer> q3 = new Queue<>();
        q3.insert(999);
        System.out.print("Печать очереди с одним элементом: ");
        printQueueInt(q3);
        System.out.println();
        System.out.println("Элемент сохранён: " + q3.head());
        
        // Тест 4: Очередь с отрицательными числами
        System.out.println("\nТест 4: Очередь с отрицательными числами");
        Queue<Integer> q4 = new Queue<>();
        q4.insert(-5);
        q4.insert(0);
        q4.insert(-10);
        q4.insert(15);
        
        System.out.print("Печать очереди: ");
        printQueueInt(q4);
        System.out.println();
        
        // Тест 5: Большая очередь
        System.out.println("\nТест 5: Большая очередь");
        Queue<Integer> q5 = new Queue<>();
        for (int i = 1; i <= 10; i++) {
            q5.insert(i * 5);
        }
        
        System.out.print("Печать большой очереди: ");
        printQueueInt(q5);
        System.out.println();
        
        // Проверяем корректность восстановления большой очереди
        System.out.println("Проверка порядка элементов после печати:");
        for (int i = 0; i < 3; i++) {
            System.out.println("Элемент " + (i+1) + ": " + q5.remove());
        }
        
        // Тест 6: Очередь с повторяющимися элементами
        System.out.println("\nТест 6: Очередь с повторяющимися элементами");
        Queue<Integer> q6 = new Queue<>();
        q6.insert(7);
        q6.insert(7);
        q6.insert(3);
        q6.insert(7);
        q6.insert(3);
        
        System.out.print("Печать очереди с повторами: ");
        printQueueInt(q6);
        System.out.println();
        
        System.out.println("\n=== Все тесты завершены ===");
    }
}
