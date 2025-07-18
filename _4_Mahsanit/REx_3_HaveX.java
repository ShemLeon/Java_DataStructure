package _4_Mahsanit;

import unit4.collectionsLib.Stack;

import static _4_Mahsanit.baza_mahsanit.createStackFromArray;
import static _4_Mahsanit.baza_mahsanit.printStackInt;

public class REx_3_HaveX {
    //  Проверка наличия Х элемента в стеке рекурсивно
    public static boolean haveX(Stack<Integer> stack, int x) {
        if (stack.isEmpty()) return false;
        int current = stack.pop();   // Извлекаем верхний элемент
        // Проверяем текущий элемент сразу
        if (current == x) {
            stack.push(current); // Восстанавливаем элемент
            return true; // Найден элемент x
        }
        boolean result = haveX(stack, x); // Рекурсивно проверяем оставшиеся элементы
        stack.push(current); // Восстанавливаем элемент обратно в стек
        if (current == x) return true; // Найден элемент x
        return result; // Возвращаем результат проверки оставшихся элементов
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 3};
        Stack<Integer> st = createStackFromArray(arr);
        printStackInt(st);
        System.out.println("Count x=" + haveX(st, 3));
    }

}
