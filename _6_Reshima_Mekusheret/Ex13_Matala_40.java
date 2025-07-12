package _6_Reshima_Mekusheret;

import unit4.collectionsLib.Node;
import static _6_Reshima_Mekusheret.baza.createList;
import static _6_Reshima_Mekusheret.baza.printList;

// Проверка на наличие последовательности n последовательных чисел  в связном списке целых чисел.
// Последовательность может быть возрастающей или убывающей.
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

    private static boolean checkListSequence(Node<Integer> head, int entryNum) {
        if (head == null || entryNum <= 0) return false;
        if (entryNum == 1) return true; // базовые случаи

        int maxCount = 1;
        int countInc = 1; // Счетчик для возрастающей последовательности
        int countDec = 1; // Счетчик для убывающей последовательности
        Node<Integer> current = head; // create a pointer to the start node

        // Ищем длину самой большой положительной последовательности
        while (current.getNext() != null) {
            int currentVal = current.getValue();
            int nextVal = current.getNext().getValue();
            // Проверка возрастающей последовательности
            if (currentVal + 1 == nextVal) {
                countInc++;
            } else {
                if (countInc > maxCount) maxCount = countInc;
                countInc = 1;
            }
            // Проверка убывающей последовательности
            if (currentVal - 1 == nextVal) {
                countDec++;
            } else {
                if (countDec > maxCount) maxCount = countDec;
                countDec = 1;
            }
            // Переход к следующему узлу
            current = current.getNext();
        }
        // Финальная проверка после окончания цикла (на случай примера [10, 20, 1, 2, 3, 4, 5])
        if (countInc > maxCount) maxCount = countInc;
        if (countDec > maxCount) maxCount = countDec;

        return maxCount >= entryNum;
    }
}