package _4_Mahsanit;

import unit4.collectionsLib.Stack;
public class Mahsanit_t15 {
public static Stack<Integer> moveTheFirstToEnd(Stack<Integer> st) {
    /*
     * Функция перемещает первый элемент стека в его конец
     * Вход: стек целых чисел
     * Выход: возвращает изменённый стек
     */
    Stack<Integer> res = new Stack<Integer>();
    Stack<Integer> temp = new Stack<Integer>();
    
    // Сохраняем первый элемент
    if (!st.isEmpty())
        res.push(st.pop());

    // Перекладываем остальные элементы во временный стек
    while (!st.isEmpty()) {
        temp.push(st.pop());
    }
    
    // Возвращаем элементы в результирующий стек
    while (!temp.isEmpty())
        res.push(temp.pop());
        
    return res;
}


    public static void main(String[] args) {
        Stack<Integer> st = new <Integer>Stack();
        st.push(10);
        st.push(20);
        st.push(30);
        st.push(40);
        System.out.println(st); // [40,30,20,10]
        System.out.println(moveTheFirstToEnd(st)); // [30,20,10,40]

    }
}