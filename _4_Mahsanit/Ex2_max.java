package _4_Mahsanit;
import unit4.collectionsLib.Stack;


public class Ex2_max {
    // Метод для поиска максимального элемента в стеке
    public static int findMax(Stack<Integer> stack) {
        if (stack.isEmpty()) return Integer.MIN_VALUE;
        Stack<Integer> tempStack = new Stack<Integer>();
        int max = stack.top();
        while (!stack.isEmpty()) {
            int current = stack.pop();
            if (current > max)  max = current;
            tempStack.push(current);
        }
        // Восстанавливаем исходный стек
        while (!tempStack.isEmpty()) {
            stack.push(tempStack.pop());
        }
        return max;
    }
    public static void main(String[] args) {    // Пример 6: Поиск максимального элемента
        Stack<Integer> numbers2 = new Stack<Integer>();
        numbers2.push(5);
        numbers2.push(8);
        numbers2.push(3);
        numbers2.push(12);
        numbers2.push(9);
        int max = findMax(numbers2);
        System.out.println("Максимальный элемент: " + max);
        Stack<Integer> test = new Stack<Integer>();
        System.out.println(findMax(test));
    }
}
