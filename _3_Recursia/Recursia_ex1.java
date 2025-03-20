package _3_Recursia;

public class Recursia_ex1 {
           public static void main(String[] args) {
            int[] testArr = {1, 2, 3, 4, 5, 6, 7, 8, 9, 0};
            int size = testArr.length-1;
            System.out.println(sumEvenElements(testArr, size));
        }
        /**
         * Функция считает сумму чётных чисел в массиве
         * Вход: массив целых чисел
         * Выход: сумма чётных чисел
         * Сложность по времени: O(n)
         */
        public static int sumEvenElements(int[] arr, int index) {
            if (index < 0) return 0; // Базовый случай: дошли до начала массива
            if (arr[index] % 2 == 0) {
                return arr[index] + sumEvenElements(arr, index - 1);
            } else {
                return sumEvenElements(arr, index - 1);
            }
        }
    }