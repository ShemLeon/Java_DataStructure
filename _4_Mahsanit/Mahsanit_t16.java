package _4_Mahsanit;

/*
 *
 */

import unit4.collectionsLib.Stack;

public class Mahsanit_t16 {

    public static Stack<Integer> moveTheLastToTop (Stack < Integer > st) {
        /*
         * Функция перемещает последний элемент стека на его вершину
         * Вход: Стек целых чисел
         * Выход: измененный стек
         *  Временная сложность
         * Общее время O(n) --> Сумма двух циклов O(n)+O(n)=O(n)
         */
        Stack<Integer> res = new <Integer>Stack();
        Stack<Integer> temp = new <Integer>Stack();
        int lastEl;

        // Перекладываем все элементы во временный стек (они окажутся в обратном порядке)
        while (!st.isEmpty()) {
            temp.push(st.pop());
        }

        // Сохраняем последний элемент исходного стека (он теперь первый в temp)
        lastEl = temp.pop();

        // Перекладываем оставшиеся элементы в результирующий стек
        while (!temp.isEmpty())
            res.push(temp.pop());

        // Кладём сохранённый элемент на вершину
        res.push(lastEl);
        return res;
    }
    public static void main(String[] args) {
        Stack<Integer> st = new <Integer>Stack();
        st.push(10);
        st.push(20);
        st.push(30);
        st.push(40);
        st.push(50);

        System.out.println(st);
        System.out.println(moveTheLastToTop(st));

    }

}