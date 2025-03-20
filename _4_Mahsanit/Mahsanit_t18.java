package _4_Mahsanit;

import unit4.collectionsLib.Stack;

public class Mahsanit_t18 {
    public static void main(String[] args) {
        Stack<Integer> st = new <Integer>Stack();
        st.push(50);
        st.push(40);
        st.push(30);
        st.push(20);
        st.push(10);

        System.out.println(st);  // [10,20,30,40,50]
        System.out.println(insertInSortedStackInteger(st,15));  // [10,15,20,30,40,50]
        System.out.println(insertInSortedStackInteger(st,5));   // [5,10,15,20,30,40,50]
        System.out.println(insertInSortedStackInteger(st,20));  // [5,10,15,20,20,30,40,50]

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