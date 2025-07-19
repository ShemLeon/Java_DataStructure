package _5_Queue;
import unit4.collectionsLib.Queue;

import static _5_Queue.Ex0_printQuInt.printQueueInt;


public class Ex8_SumPrevElements {
    // строит из полученной новую очередь, где каждый следующий элемент равен сумме всех предыдущих
    // 1-2-3-4  ->  1-3-6-10
    public static void SumPrevElements(Queue<Integer> queOrigin) {
        if (queOrigin.isEmpty()) return;
        Queue<Integer> temp = new Queue<>();
        int cumulativeSum = 0;
        // Обрабатываем каждый элемент
        while (!queOrigin.isEmpty()) {
            int currentElement = queOrigin.remove();
            cumulativeSum += currentElement;
            temp.insert(cumulativeSum);
        }

        // Возвращаем результат обратно в исходную очередь
        while (!temp.isEmpty()) {
            queOrigin.insert(temp.remove());
        }
}

    public static void main(String[] args) {
        // Создаем тестовую очередь
        Queue<Integer> testQueue = new Queue<>();
        testQueue.insert(1);
        testQueue.insert(2);
        testQueue.insert(3);
        testQueue.insert(4);
        
        System.out.println("=== СИМУЛЯЦИЯ Ex8_SumPrevElements ===");
        System.out.print("Исходная очередь: ");
        printQueueInt(testQueue);
        System.out.println();
        
        System.out.println("\nШаги выполнения (каждый элемент - сумма всех предыдущих из ОРИГИНАЛЬНОЙ очереди):");
        System.out.println("1. Первый элемент (1) -> [1]");
        System.out.println("2. Второй элемент: 1 + 2 = 3 -> [1, 3]");
        System.out.println("3. Третий элемент: 1 + 2 + 3 = 6 -> [1, 3, 6]");
        System.out.println("4. Четвертый элемент: 1 + 2 + 3 + 4 = 10 -> [1, 3, 6, 10]");
        
        // Применяем функцию
        SumPrevElements(testQueue);
        
        System.out.print("\nРезультирующая очередь: ");
        printQueueInt(testQueue);
        System.out.println();
        
        // Дополнительный тест
        System.out.println("\n=== ДОПОЛНИТЕЛЬНЫЙ ТЕСТ ===");
        Queue<Integer> testQueue2 = new Queue<>();
        testQueue2.insert(5);
        testQueue2.insert(10);
        testQueue2.insert(15);
        
        System.out.print("Исходная очередь: ");
        printQueueInt(testQueue2);
        System.out.println();
        
        SumPrevElements(testQueue2);
        
        System.out.print("Результат: ");
        printQueueInt(testQueue2);
        System.out.println();
        System.out.println("Логика: 5 -> 5+10=15 -> 5+10+15=30");
        System.out.println("Ожидаемый результат: [5, 15, 30]");
    }
}