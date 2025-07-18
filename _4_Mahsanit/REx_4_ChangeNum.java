package _4_Mahsanit;

import unit4.collectionsLib.Stack;

import static _4_Mahsanit.baza_mahsanit.createStackFromArray;
import static _4_Mahsanit.baza_mahsanit.printStackInt;

public class REx_4_ChangeNum {
    // Замена четных чисел на следующие нечетные рекурсивно
    public static void replaceEvenWithOdd(Stack<Integer> stack) {
        if (stack.isEmpty()) return; // Базовый случай: стек пуст
        int current = stack.pop(); // Извлекаем верхний элемент
        replaceEvenWithOdd(stack); // Рекурсивно обрабатываем оставшиеся элементы
        // Если число четное, заменяем на следующее нечетное
        if (current % 2 == 0) {
            stack.push(current + 1); // Четное число + 1 = нечетное число
        } else {
            stack.push(current); // Нечетное число оставляем без изменений
        }
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 3};
        Stack<Integer> st = createStackFromArray(arr);
        printStackInt(st);
        replaceEvenWithOdd(st);
    }

}
