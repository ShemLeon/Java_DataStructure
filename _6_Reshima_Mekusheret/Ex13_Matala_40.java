package _6_Reshima_Mekusheret;

import unit4.collectionsLib.Node;

/**
 *  поиск последовательности n последовательных чисел  в связном списке целых чисел.
 *  Последовательность может быть возрастающей или убывающей.
 */
public class Ex13_Matala_40 {

    public static void main(String[] args) {
        int testArr[] = {1, 2, 3, 4, 77, 5, 6, 7, 0, 9, 10};
        Node<Integer> list = createList(testArr);
        printList(list);
        int num = 5;
        System.out.println("There is a sequence of length " + num + ": " + checkListSequence(list, num));
        num = 4;
        System.out.println("There is a sequence of length " + num + ": " + checkListSequence(list, num));
        System.out.println();
    }

    /**
     * Функция для поиска последовательности из n последовательных чисел в связном списке целых чисел.
     * @param head головной узел списка
     * @param n длина искомой последовательности
     * @return true, если найдена последовательность длины n
     * Сложность: O(n²), где n - количество элементов в списке.
     * Принцип работы:
     * 1. Проверка граничных случаев (пустой список, n <= 0, n = 1)
     * 2. Итерация по списку:
     *    - Для каждого узла проверяется возрастающая последовательность
     *    - Для каждого узла проверяется убывающая последовательность
     * 3. Возвращается true, если найдена хотя бы одна последовательность
     */
    public static boolean checkListSequence(Node<Integer> head, int n) {
        if (head == null || n <= 0) return false; // проверка на пустой список и отрицательное n
        if (n == 1) return true; // check for sequence of one number

        Node<Integer> current = head;
        while (current != null && current.getNext() != null) {
            // Check for increasing sequence
            if (checkSequence(current, n, true)) return true;
            // Check for decreasing sequence
            if (checkSequence(current, n, false)) return true;
            current = current.getNext();
        }
        return false;
    }

    /**
     * Auxiliary function for "checking a sequence starting from the current node"
     * @param start start node
     * @param num required length of the sequence
     * @param ascending true for increasing, false for decreasing sequence
     * @return true if the sequence is found
     * Complexity: O(n), where n is the required length of the sequence
     * Working principle:
     * 1. Check for empty list
     * 2. Start with the first node and count the length of the sequence:
     *    - For increasing: each subsequent number must be 1 more
     *    - For decreasing: each subsequent number must be 1 less
     * 3. Return true if a sequence of the required length is found
     */
    private static boolean checkSequence(Node<Integer> start, int num, boolean ascending) {
        if (start == null) return false; // check for empty list

        Node<Integer> current = start; // create a pointer to the start node
        int count = 1;
        int prev = current.getValue();

        while (current.getNext() != null && count < num) {
            current = current.getNext();
            int curr = current.getValue();

            if (ascending && curr == prev + 1) {
                count++;
                prev = curr;
            } else if (!ascending && curr == prev - 1) {
                count++;
                prev = curr;
            } else {
                break;
            }
        }

        return count == num;
    }

    /**
     * Auxiliary function for "creating a linked list from an array"
     * @param arr original array
     * @return start node of the created list
     * Complexity: O(n), where n is the length of the array
     * Working principle:
     * 1. Check for empty array
     * 2. Create the start node with the first element
     * 3. Add the remaining elements to the list
     */
    public static Node<Integer> createList(int[] arr) {
        if (arr == null || arr.length == 0) {
            return null;
        }

        Node<Integer> head = new Node<>(arr[0]);
        Node<Integer> current = head;

        for (int i = 1; i < arr.length; i++) {
            current.setNext(new Node<>(arr[i]));
            current = current.getNext();
        }

        return head;
    }

    /**
     * Auxiliary function for "printing the list"
     * @param head start node of the list
     * Complexity: O(n), where n is the number of elements in the list
     * Working principle:
     * 1. Traverse the list from start to end
     * 2. Print each element
     */
    public static void printList(Node<Integer> head) {
        Node<Integer> current = head;
        while (current != null) {
            System.out.print(current.getValue() + " ");
            current = current.getNext();
        }
        System.out.println();
    }
}