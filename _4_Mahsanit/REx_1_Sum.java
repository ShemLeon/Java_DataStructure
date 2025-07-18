package _4_Mahsanit;

import unit4.collectionsLib.Stack;

import static _4_Mahsanit.baza_mahsanit.createStackFromArray;
import static _4_Mahsanit.baza_mahsanit.printStackInt;

public class REx_1_Sum {
    // Сумма элементов стека рекурсивно
    public static int sumStRecursia(Stack<Integer> stack) {
        if (stack.isEmpty()) return 0;
        int current = stack.pop();   // Извлекаем верхний элемент
        int remainingSum = sumStRecursia(stack); // Рекурсивно вычисляем сумму оставшихся элементов
        stack.push(current); // Восстанавливаем элемент обратно в стек
        return current + remainingSum;   // Возвращаем сумму текущего элемента и оставшихся
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4};
        Stack<Integer> st = createStackFromArray(arr);
        printStackInt(st);
        System.out.println("Sum " + sumStRecursia(st));
    }

}
