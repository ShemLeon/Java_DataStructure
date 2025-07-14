package _4_Mahsanit;

import unit4.collectionsLib.Stack;

public class Ex11_DeleteIntFromStack {
    // функция поиска элемента Int в магазине и удаление его.
    // после этого магазин восстанавливается без удаленного элемента
    public static Stack<Integer>deleteIntFromStack(Stack<Integer> st, int valueToDelete) {
        Stack<Integer> temp = new Stack<Integer>();
        // Перекладываем элементы из исходного стека во временный
        // и ищем первое вхождение элемента для удаления

        while (!st.isEmpty()) {
            int current=st.pop();
            if (current != valueToDelete){
                temp.push(current);
            }else{
                break;
            }
        }

// Восстанавливаем исходный стек и создаем результирующий стек
        while (!temp.isEmpty()) {
            st.push(temp.pop()); // Восстанавливаем исходный стек
        }

        return st;
    }

    public static void main(String[] args) {
        // Создаем стек и заполняем его значениями
        Stack<Integer> st = new Stack<Integer>();
        st.push(10);
        st.push(25);
        st.push(15);
        st.push(30);
        st.push(20);

        System.out.println("Исходный стек: " + st);

        // Удаляем элемент 15 и получаем новый стек
        Stack<Integer> newStack = deleteIntFromStack(st, 15);

        System.out.println("Исходный стек после вызова функции: " + st);
        System.out.println("Новый стек без элемента 15: " + newStack);

        // Попытка удалить несуществующий элемент
        Stack<Integer> newStack2 = deleteIntFromStack(st, 100);

        System.out.println("Исходный стек: " + st);
        System.out.println("Новый стек (элемент 100 не найден): " + newStack2);
    }
}
