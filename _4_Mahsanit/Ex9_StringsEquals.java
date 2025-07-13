package _4_Mahsanit;

import unit4.collectionsLib.Stack;
public class Ex9_StringsEquals {
    // Функция проверяет, равны ли строки в двух стеках
    public static boolean isTheStacksAreEqual(Stack<String> st1, Stack<String> st2) {
        Stack<String> temp1 = new <String>Stack();
        Stack<String> temp2 = new <String>Stack();
        boolean res = true;

        // Сравниваем элементы и сохраняем их во временные стеки
        while (!st1.isEmpty() && !st2.isEmpty()) {
            if (!st1.top().equals(st2.top()))
                res = false;
            temp1.push(st1.pop());
            temp2.push(st2.pop());
        }

        // Восстанавливаем исходные стеки
        while (!temp1.isEmpty() && !temp2.isEmpty()) {
            st1.push(temp1.pop());
            st2.push(temp2.pop());
        }
        return res;
    }
    public static void main(String[] args) {
        Stack<String> st = new <String>Stack();
        st.push("qwerty");
        st.push("Jaja");
        st.push("Ucira");
        st.push("Joja");
        st.push("klads");

        Stack<String> stTrue = new <String>Stack();
        stTrue.push("qwerty");
        stTrue.push("Jaja");
        stTrue.push("Ucira");
        stTrue.push("Joja");
        stTrue.push("klads");

        Stack<String> stFalse = new <String>Stack();
        stFalse.push("qwerty");
        stFalse.push("Jaja");
        stFalse.push("Ucira");
        stFalse.push("Jo1ja");  // Отличается от оригинала
        stFalse.push("klads");

        System.out.println(isTheStacksAreEqual(st, stTrue));  // выведет true
        System.out.println(isTheStacksAreEqual(st, stFalse)); // выведет false

    }


}