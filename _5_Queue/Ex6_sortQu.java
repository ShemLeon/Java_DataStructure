package _5_Queue;
import unit4.collectionsLib.Queue;


public class Ex6_sortQu {

    public static void main(String[] args) {
        Queue<String> queue = new Queue<>();

        // Добавляем строки в очередь
        queue.insert("banana");
        queue.insert("apple");
        queue.insert("cherry");
        queue.insert("date");

        System.out.println("Queue before sorting: " + queue);

        // Сортируем очередь
        sortQueue(queue);

        System.out.println("Queue after sorting: " + queue);
    }

    /* Функция для сортировки очереди строк в порядке возрастания
 * @param queue очередь строк для сортировки
 * Сложность: O(n²) по времени (для каждого из n элементов мы ищем минимум среди оставшихся), O(n) по памяти
 * Принцип работы:
 * 1. Создаем временную очередь для хранения отсортированных элементов
 * 2. Находим и удаляем минимальный элемент из исходной очереди
 * 3. Добавляем минимальный элемент в отсортированную очередь
 * 4. Повторяем шаги 2-3, пока исходная очередь не станет пустой
 * 5. Возвращаем элементы в исходную очередь в отсортированном порядке
 * Очередь до сортировки: [banana,apple,cherry,date]
 * Очередь после сортировки: [apple,banana,cherry,date]
 */
    public static void sortQueue(Queue<String> queue) {
        Queue<String> sortedQueue = new Queue<>(); // Временная очередь для хранения отсортированных элементов

        while (!queue.isEmpty()) {
            String min = findAndRemoveMin(queue); // Находим и удаляем минимальный элемент
            sortedQueue.insert(min); // Добавляем минимальный элемент в отсортированную очередь
        }

        // Перемещаем элементы из отсортированной очереди обратно в исходную
        while (!sortedQueue.isEmpty()) {
            queue.insert(sortedQueue.remove());
        }
    }

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
    private static String findAndRemoveMin(Queue<String> queue) {
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
}