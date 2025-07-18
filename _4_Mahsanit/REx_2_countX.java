package _4_Mahsanit;

import unit4.collectionsLib.Stack;

import static _4_Mahsanit.baza_mahsanit.createStackFromArray;
import static _4_Mahsanit.baza_mahsanit.printStackInt;

public class REx_2_countX {
    // Количество Х элементов в стеке рекурсивно
    public static int countXRecursia(Stack<Integer> stack, int x) {
        if (stack.isEmpty()) return 0;
        int current = stack.pop();   // Извлекаем верхний элемент
        int remainingCount = countXRecursia(stack, x); // Рекурсивно вычисляем сумму оставшихся элементов
        stack.push(current); // Восстанавливаем элемент обратно в стек
        if (current==x) return 1 + remainingCount;   // Возвращаем сумму текущего элемента и оставшихся
        else return remainingCount;
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 3};
        Stack<Integer> st = createStackFromArray(arr);
        printStackInt(st);
        System.out.println("Count x=" + countXRecursia(st, 3));
    }

}
