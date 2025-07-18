package _4_Mahsanit;

import unit4.collectionsLib.Stack;

import static _4_Mahsanit.baza_mahsanit.createStackFromArray;
import static _4_Mahsanit.baza_mahsanit.printStackInt;

public class REx_5_BalanceKavuchek {
    public static boolean isBalancedRecursive(Stack<Character> s) {
        // Итоговый результат true, только если рекурсивный подсчет дал 0.
        return countBracketsRecursive(s) == 0;
    }
    // Замена четных чисел на следующие нечетные рекурсивно
    // Замена четных чисел на следующие нечетные рекурсивно
    private static int countBracketsRecursive(Stack<Character> s) {
        // БАЗОВЫЙ СЛУЧАЙ: если стек пуст, баланс равен 0.
        if (s.isEmpty()) {
            return 0;
        }

        // РЕКУРСИВНЫЙ ШАГ:
        // 1. Извлекаем верхний элемент для работы с ним.
        char topChar = s.pop();

        // 2. Рекурсивно вызываем функцию для остальной части стека.
        // Это вычислит баланс для всех элементов под текущим.
        int balanceFromBelow = countBracketsRecursive(s);

        // 3. Возвращаем элемент обратно, чтобы восстановить стек для вызвавшей функции.
        // Это ключевой шаг для сохранения исходного стека.
        s.push(topChar);

        // 4. Вычисляем баланс для текущего уровня и добавляем его к балансу снизу.
        if (topChar == '(') {
            return balanceFromBelow + 1;
        } else if (topChar == ')') {
            return balanceFromBelow - 1;
        } else {
            // Любой другой символ не влияет на баланс.
            return balanceFromBelow;
        }
    }


    public static void main(String[] args) {

    }

}
