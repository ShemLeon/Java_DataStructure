package _4_Mahsanit;// import unit4.collectionsLib.Node;

import unit4.collectionsLib.Stack;

public class Ex1a_Count {
    public static int countIntElements(Stack<Integer> stack) {
        int count = 0;
        Stack<Integer> tempStack = new Stack<Integer>();
        // Перекладываем все элементы во временный стек и считаем их
        while (!stack.isEmpty()) {
            tempStack.push(stack.pop());
            count++;
        }

        // Восстанавливаем исходный стек
        while (!tempStack.isEmpty()) {
            stack.push(tempStack.pop());
        }
        return count;
    }

    public static void main(String[] args) {
        // Создаем тестовый стек
        Stack<Integer> numbers = new Stack<Integer>();
        numbers.push(10);
        numbers.push(20);
        numbers.push(30);
        numbers.push(40);
        numbers.push(50);

        System.out.println("Исходный стек: " + numbers);

        // Подсчитываем элементы
        int count = countIntElements(numbers);

        System.out.println("Количество элементов: " + count);
        System.out.println("Стек после подсчета: " + numbers);

        // Тест с пустым стеком
        Stack<Integer> emptyStack = new Stack<Integer>();
        System.out.println("Количество элементов в пустом стеке: " + countIntElements(emptyStack));
    }

}
