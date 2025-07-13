package _4_Mahsanit;

import unit4.collectionsLib.Stack;


public class Ex6_vozrastanie {
    // Функция проверяет, расположены ли все числа в стеке по убыванию
    public static boolean ifStackIsInDescendingOrder(Stack<Integer> st) {
        Stack<Integer> temp = new Stack<>();
        boolean res = true;
        int first;

        while (!st.isEmpty()) {
            first = st.pop();
            temp.push(first);
            // Меняем условие: если следующий элемент существует и текущий НЕ БОЛЬШЕ его
            if (!st.isEmpty() && first <= st.top()) {
                res = false;  // Порядок нарушен, так как текущий элемент не больше следующего
            }
        }

        // Восстанавливаем исходный стек
        while (!temp.isEmpty()) {
            st.push(temp.pop());
        }
        return res;
    }


    public static void main(String[] args) {
        // Test 1
        Stack<Integer> test1 = new Stack<>();
        test1.push(4);
        test1.push(8);
        test1.push(10);
        System.out.println(ifStackIsInDescendingOrder(test1)); // true

        // Test 2
        Stack<Integer> test2 = new Stack<>();
        test2.push(10);
        test2.push(8);
        test2.push(7);
        System.out.println(ifStackIsInDescendingOrder(test2)); // false
    }
}