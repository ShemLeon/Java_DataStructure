package _4_Mahsanit;

import unit4.collectionsLib.Stack;

public class Mahsanit_d1 {
    public static void main(String[] args) {
        Stack<Character> letters = new Stack<>();

        letters.push('a');
        letters.push ( 'b');
        letters.push ( 'c');
        letters.pop ();
        letters.top ();
        letters.pop ();
        letters.push ( 'h');
        letters.push ('k');
        letters.pop ();
        printStack(letters);
    }
    public static void printStack(Stack<Character> stack) {
        // Создаем временный стек для хранения элементов
        Stack<Character> tempStack = new Stack<Character>();

        System.out.println("Содержимое стека (сверху вниз):");

        // Перекладываем и печатаем элементы
        while (!stack.isEmpty()) {
            Character element = stack.pop();
            System.out.println(element);
            tempStack.push(element);
        }

        // Возвращаем элементы обратно
        while (!tempStack.isEmpty()) {
            stack.push(tempStack.pop());
        }}

}
