package _4_Mahsanit;
import java.util.Scanner;
import unit4.collectionsLib.Stack;

import static _4_Mahsanit.Ex10_InsertInSort.insertInSortedStackInteger;

public class Ex10_a {
    public static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println(inputUntilUserWillInputMinus999());
    }

    public static Stack<Integer> inputUntilUserWillInputMinus999() {
        /*
         * Временная сложность: O(n²)
         * Функция для ввода чисел от пользователя, пока не будет введено -999
         * Вход: Нет
         * Выход: Возвращает отсортированный стек без -999
         *
         * Сложность O(n²) получается потому, что:
         * - Для n введённых чисел
         * - Каждая вставка числа требует до n операций
         * - Итого: n * n = O(n²)
         */
        System.out.println("Пожалуйста, введите число: ");
        int inputNum = sc.nextInt();
        final int INPUTSTOP = -999;
        Stack<Integer> inputStack = new <Integer>Stack();

        while (inputNum != INPUTSTOP) {
            insertInSortedStackInteger(inputStack, inputNum);
            System.out.println("Пожалуйста, введите число: ");
            inputNum = sc.nextInt();
        }
        return inputStack;
    }

}