package _5_Queue;
import unit4.collectionsLib.Queue;

public class Ex6_deleteMinValue {
   // Функция для нахождения и удаления минимального элемента из очереди
    public static String findAndRemoveMinString(Queue<String> queue) {
        Queue<String> tempQueue = new Queue<>();
        String min = queue.remove();
        tempQueue.insert(min);
        // Проходим по очереди, чтобы найти минимальный элемент
        while (!queue.isEmpty()) {
            String current = queue.remove();
            if (current.compareTo(min) < 0) {
                tempQueue.insert(min);
                min = current; // Обновляем минимальный элемент
            } else {
                tempQueue.insert(current);
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

// Функция для нахождения и удаления минимального элемента из очереди целых чисел
public static int findAndRemoveMinInt(Queue<Integer> queue) {
    if (queue.isEmpty()) throw new RuntimeException("Очередь пуста");
    Queue<Integer> tempQueue = new Queue<>();
    int min = queue.head(); // Просто смотрим на первый, не удаляем
    // 1. Находим минимальный элемент, не изменяя очередь
    queue.insert(null); // Вставляем маркер конца
    while (queue.head() != null) {
        int current = queue.remove();
        if (current < min) {
            min = current;
        }
        tempQueue.insert(current);
    }
    queue.remove(); // Удаляем маркер null

    // 2. Восстанавливаем очередь, удаляя ОДНО вхождение min
    boolean minFoundAndRemoved = false;
    while(!tempQueue.isEmpty()){
        int current = tempQueue.remove();
        if(current == min && !minFoundAndRemoved){
            minFoundAndRemoved = true; // Нашли и пропускаем, чтобы "удалить"
        } else {
            queue.insert(current);
        }
    }
    return min;
}


}