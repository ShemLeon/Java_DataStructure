package _1_SortArr;

public class Sorting {

    // Linear Search: חיפוש לינארי: простой перебор
    // Complexity: O(n)
    public static boolean linear_search(int[] arr, int x)
    {
        for (int i=0; i<arr.length; i++){
            if (arr[i]==x) return true;}
        return false;
    }

    // Binary Search: путем деления на 2, вернет номер итема в массиве или -1.
    // Проверить - актуально для уже отсортированного массива
    // Complexity: O(log n):
    public static int binary_search(int[] arr, int x){
        int left = 0, right = arr.length-1;
        while (left <= right){
            int mid = (left+right)/2;
            if (arr[mid]==x) return mid;
            if (arr[mid]<x)
                left = mid+1;
            else
                right = mid-1;
        }
        return -1;
    }

    public static void bubbleSort(int[] arr){
        for (int i=0; i<arr.length-1; i++){
            for (int j=0; j< arr.length-i-1; j++){
                if (arr[i]>arr[j+1]) {
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
        }
    }

    public static void insertionSort(int []arr, int n, int num){
        // просто вставка в отсортированный массив.
        // int []arr - отсортированный массив,
        // n - количество элементов в массиве
        // num - число для вставки
        int i; // ищем индекс для будущей вставки
        for(i=0; i<n && arr[i]<num; i++);
        // сдвигаем элементы
        for (int j=n; j>i;j--){
            arr[j] = arr[j-1];   // каждый элемент копируется в следующую позицию
        }
        arr[i]=num;              // вставляем число в правильную позицию
       /* Алгоритм:
        Сравниваем число с элементами слева
        Сдвигаем большие элементы вправо
        Вставляем число в правильную позицию
        */
    }
    public static void insertionSortFull(int[] arr) {
        // сортировка массива "вставками" -
        // Начинаем со второго элемента (индекс 1)
        for (int i = 1; i < arr.length; i++) {
            // Запоминаем текущий элемент
            int key = arr[i];
            // Начинаем сравнивать со всеми элементами слева
            int j = i - 1;
            // Сдвигаем элементы, которые больше key
            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j--;
            }
            // Вставляем key в правильную позицию
            arr[j + 1] = key;
        }
    }

    public static int [] mergeSortedArrays (int [] arrA, int [] arrB){
        // сортировка слиянием уже отсортированных массивов
        int [] arrC = new int [arrA.length+ arrB.length];
        int i=0, j=0, k=0;
        // i for a, j for b, j for c
        while (i<arrA.length && j<arrB.length){
            if (arrA[i] <= arrB[j]){
                arrC[k]=arrA[i];
                i++;
                k++;
            }
            else { // arrA[i]>arrB[j]
                arrC[k]=arrB[j];
                j++;
                k++;
            }
        }

        while (j<arrB.length){
            // когда кончился массив аrrA, мы заливаем остатки с arrB
            arrC[k] = arrB[j];
            j++;
            k++;
        }

        while (i<arrA.length){
            // когда кончился массив arrB, заливаем остатки arrA
            arrC[k] = arrA[i];
            i++;
            k++;
        }


        return arrC;
    }


    public static void main(String[] args) {
        int[] arr = {-5, -4, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
        System.out.println("Linear search "+linear_search(arr, 5));
        System.out.println("Binary search "+binary_search(arr, 5));
    }
}
