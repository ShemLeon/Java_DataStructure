package _4_Mahsanit;

import unit4.collectionsLib.Stack;

public class Mahsanit_d2_examples {
    public static void main(String[] args) {
        // Пример 2а: ABCDE -> ABE
        System.out.println("Пример 2а: ABCDE -> ABE");
        Stack<Character> stack1 = new Stack<>();
        stack1.push('A');
        stack1.push('B');
        stack1.push('C');
        stack1.push('D');
        stack1.push('E');
        System.out.println("Начальный стек:");
        printStack(stack1);
        
        // Преобразование ABCDE в ABE
        stack1.pop(); // удаляем E
        stack1.pop(); // удаляем D
        stack1.pop(); // удаляем C
        stack1.push('E'); // добавляем E
        System.out.println("Стек после преобразования:");
        printStack(stack1);
        
        // Пример 2б: ABCG -> BG
        System.out.println("\nПример 2б: ABCG -> BG");
        Stack<Character> stack2 = new Stack<>();
        stack2.push('A');
        stack2.push('B');
        stack2.push('C');
        stack2.push('G');
        System.out.println("Начальный стек:");
        printStack(stack2);
        
        // Преобразование ABCG в BG
        stack2.pop(); // удаляем G
        stack2.pop(); // удаляем C
        stack2.pop(); // удаляем B
        stack2.pop(); // удаляем A
        stack2.push('B'); // добавляем B
        stack2.push('G'); // добавляем G
        System.out.println("Стек после преобразования:");
        printStack(stack2);
        
        // Пример 3: Переворот стека
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
    
    // Метод для печати стека
    public static void printStack(Stack<Character> stack) {
        Stack<Character> tempStack = new Stack<>();
        
        // Перекладываем и печатаем элементы
        while (!stack.isEmpty()) {
            Character element = stack.pop();
            System.out.println(element);
            tempStack.push(element);
        }
        
        // Возвращаем элементы обратно
        while (!tempStack.isEmpty()) {
            stack.push(tempStack.pop());
        }
    }
    
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
}
