package _4_Mahsanit;
import unit4.collectionsLib.Stack;

import static _4_Mahsanit.baza_mahsanit.printStack;

public class Ex3_reverse {
    // Метод для переворота стека
    public static void reverseStack(Stack<Character> stack) {
        Stack<Character> tempStack = new Stack<>();
        // Перекладываем все элементы во временный стек
        while (!stack.isEmpty()) {
            tempStack.push(stack.pop());
        }
        // Копируем обратно (теперь в обратном порядке)
        while (!tempStack.isEmpty()) {
            stack.push(tempStack.pop());
        }
    }
    public static void main(String[] args) {
        // Переворот стека
        System.out.println("\nПример 3: Переворот стека");
        Stack<Character> stack3 = new Stack<>();
        stack3.push('A');
        stack3.push('B');
        stack3.push('C');
        stack3.push('D');
        System.out.println("Начальный стек:");
        printStack(stack3);
        reverseStack(stack3);
        System.out.println("Стек после переворота:");
        printStack(stack3);
    }
}
    


