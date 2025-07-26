package _5_Queue;

import java.util.Queue;

public class Ex11_CountElem {
    /**
     * Вспомогательный метод для подсчета количества вхождений элемента в очереди.
     * @return количество вхождений.
     */
    public static int countOccurrences(Queue<Integer> q, int value) {
        int count = 0;
        int originalSize = q.size();
        for (int i = 0; i < originalSize; i++) {
            int element = q.remove();
            if (element == value) count++;
            q.add(element); // Возвращаем элемент в конец очереди, чтобы сохранить ее
        }
        return count;
    }


}
