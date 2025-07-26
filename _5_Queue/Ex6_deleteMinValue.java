package _5_Queue;
import unit4.collectionsLib.Queue;


public class Ex6_deleteMinValue {
   /* Функция для нахождения и удаления минимального элемента из очереди
 * @param queue очередь строк для поиска минимума
 * @return минимальная строка из очереди
 * Сложность: O(n) по времени, O(n) по памяти
 * Принцип работы:
 * 1. Принимаем первый элемент за минимум
 * 2. Проходим по всем элементам очереди
 * 3. Если находим элемент меньше текущего минимума - обновляем минимум
 * 4. Возвращаем все элементы, кроме минимального, в исходную очередь
 */
    public static String findAndRemoveMinString(Queue<String> queue) {
        Queue<String> tempQueue = new Queue<>(); // Временная очередь для хранения элементов
        String min = queue.remove(); // Предполагаем, что первый элемент - минимальный
        tempQueue.insert(min); // Сохраняем первый элемент во временной очереди

        // Проходим по очереди, чтобы найти минимальный элемент
        while (!queue.isEmpty()) {
            String current = queue.remove();
            if (current.compareTo(min) < 0) {
                tempQueue.insert(min); // Перемещаем предыдущий минимум во временную очередь
                min = current; // Обновляем минимальный элемент
            } else {
                tempQueue.insert(current); // Перемещаем текущий элемент во временную очередь
            }
        }

        // Перемещаем все элементы обратно в исходную очередь, кроме минимального
        while (!tempQueue.isEmpty()) {
            String temp = tempQueue.remove();
            if (!temp.equals(min)) { // Пропускаем минимальный элемент
                queue.insert(temp);
            }
        }

        return min; // Возвращаем минимальный элемент
    }

/**
 * Функция для нахождения и удаления минимального элемента из очереди целых чисел
 * @param queue очередь целых чисел для поиска минимума
 * @return минимальный элемент из очереди
 * Сложность: O(n) по времени, O(n) по памяти
 * Принцип работы:
 * 1. Принимаем первый элемент за минимум
 * 2. Проходим по всем элементам очереди
 * 3. Если находим элемент меньше текущего минимума - обновляем минимум
 * 4. Возвращаем все элементы, кроме минимального, в исходную очередь
 */
static int findAndRemoveMinInt(Queue<Integer> queue) {
    if (queue.isEmpty()) {
        throw new RuntimeException("Очередь пуста");
    }

    Queue<Integer> tempQueue = new Queue<>(); // Временная очередь для хранения элементов
    int min = queue.remove(); // Предполагаем, что первый элемент - минимальный
    tempQueue.insert(min); // Сохраняем первый элемент во временной очереди

    // Проходим по очереди, чтобы найти минимальный элемент
    while (!queue.isEmpty()) {
        int current = queue.remove();
        if (current < min) {
            tempQueue.insert(min); // Перемещаем предыдущий минимум во временную очередь
            min = current; // Обновляем минимальный элемент
        } else {
            tempQueue.insert(current); // Перемещаем текущий элемент во временную очередь
        }
    }

    // Перемещаем все элементы обратно в исходную очередь, кроме минимального
    while (!tempQueue.isEmpty()) {
        int temp = tempQueue.remove();
        if (temp != min) { // Пропускаем минимальный элемент
            queue.insert(temp);
        }
    }

    return min; // Возвращаем минимальный элемент
}
}