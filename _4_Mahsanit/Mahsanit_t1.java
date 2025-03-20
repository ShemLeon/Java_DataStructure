package _4_Mahsanit;

import unit4.collectionsLib.Stack;


public class Mahsanit_t1 {
    public static void main(String[] args) {
        Stack<Integer> numbers = new Stack<Integer>();
        numbers.push(10);

        printStack(numbers);

    }

public static void sod(Stack<Integer> s1){
    Stack<Integer> s2 = new
    Stack<Integer>();

    while (! s1.isEmpty()) {
        int x = s1.pop();

        if (!s1.isEmpty()) {
            int y = s1.pop();
            s2.push(y);
        } else {
            s2.push(x);
        }
        s2.push(x);
    }
    while (! s2.isEmpty()) {
        System.out.print(s2.pop() + " ");
    }
}


    public static void printStack(Stack<Integer> stack) {
        // Создаем временный стек для хранения элементов
        Stack<Integer> tempStack = new Stack<Integer>();
        System.out.println("Содержимое стека (сверху вниз):");
        // Перекладываем и печатаем элементы
        while (!stack.isEmpty()) {
            Integer element = stack.pop();
            System.out.println(element);
            tempStack.push(element);
        }

        // Возвращаем элементы обратно
        while (!tempStack.isEmpty()) {
            stack.push(tempStack.pop());
        }}

}
