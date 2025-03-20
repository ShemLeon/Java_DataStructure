package _3_Recursia;

/* Сложность функции: O(n), так как мы проходим по массиву один раз */
public class Recursia_ex2 {
    public static void main(String[] args) {
        int[] testArr = {3, 4, 2, 3, 2, 4, 5, 6, 7, 8, -1, 0, -19};
        biggerNeighbors(testArr, 1);
    }

    /**
     * Рекурсивная функция для вывода элементов, которые больше своих соседей
     * @param arr   массив целых чисел
     * @param index индекс текущего проверяемого элемента
     * Сложность по времени: O(n)
     */
    public static void biggerNeighbors(int[] arr, int index) {
        if (index >= arr.length - 1) return; // Базовый случай: достигли конца массива
        if (arr[index] > arr[index + 1] && arr[index] > arr[index - 1]) {
            System.out.println(arr[index]);
        }
        biggerNeighbors(arr, index + 1);
    }
}