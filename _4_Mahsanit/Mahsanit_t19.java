package _4_Mahsanit;
import java.util.Scanner;
import unit4.collectionsLib.Stack;

public class Mahsanit_t19 {
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

    public static Stack<Integer> insertInSortedStackInteger(Stack<Integer> st, int num) {
        /*
         * Функция для вставки числа в отсортированный стек целых чисел
         * Вход: Стек целых чисел, число для вставки
         * Выход: Возвращает отсортированный стек с вставленным числом
         */
        Stack<Integer> temp = new <Integer>Stack();

        // Перекладываем элементы меньше num во временный стек
        while (!st.isEmpty() && st.top() < num) {
            temp.push(st.pop());
        }

        // Вставляем новое число
        st.push(num);

        // Возвращаем элементы обратно
        while (!temp.isEmpty()) {
            st.push(temp.pop());
        }
        return st;
    }
}