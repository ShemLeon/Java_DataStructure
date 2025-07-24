package _5_Queue;
import unit4.collectionsLib.Queue;
import unit4.collectionsLib.Stack;


public class Ex9_QueuePalindromRecursia {
    // Проверка, что очередь палиндромная  {1, 2, 3, 4, 7, 4, 3, 2, 1};
    public static boolean checkPalindrom(Queue<Integer> q) {
        Stack<Integer> s  = new Stack<Integer>();
        Queue<Integer> temp = new Queue<Integer>();
        boolean res = true;

        while (!q.isEmpty()){
            int x = q.remove();
            s.push(x);
            temp.insert(x);
        }

        while (!temp.isEmpty()){
            int x1 = temp.remove();
            int x2 = s.pop();
            if(x1 != x2) res=false;
            q.insert(x1);
        }
        return res;
}


    public static boolean checkPalindromRecursive(Queue<Integer> q) {
        if (q == null) {
            System.out.println("Error: queue is null");
            return false;
        }
        if (q.isEmpty()) return true;
        // Шаг 1: Подготовка - заполняем стек и временную очередь.
        // Исходная очередь q опустошается.
        Stack<Integer> s = new Stack<Integer>();
        Queue<Integer> temp = new Queue<Integer>();
        while (!q.isEmpty()) {
            int x = q.remove();
            s.push(x);
            temp.insert(x);
        }
        return compareAndRestore(temp, s, q);
    }

    private static boolean compareAndRestore(Queue<Integer> temp, Stack<Integer> s, Queue<Integer> q) {
        // Базовый случай: если временная очередь пуста, все элементы были сравнены и совпали.
        if (temp.isEmpty())       return true;
        // Извлекаем элементы для сравнения
        int fromTemp = temp.remove();
        int fromStack = s.pop();
        // Начинаем восстанавливать исходную очередь q
        q.insert(fromTemp);
        boolean restIsPalindrome = compareAndRestore(temp, s, q);
        return (fromTemp == fromStack) && restIsPalindrome;
    }

    public static void main(String[] args) {
        Queue<Integer> q = new Queue<Integer>();
        int[] arr = {1, 2, 3, 4, 7, 4, 3, 2, 1};
        // Заполняем очередь из массива
        for (int i = 0; i < arr.length; i++) {
            q.insert(arr[i]);
        }

        System.out.println("Исходная очередь: " + q);

        // Вызываем вашу функцию для проверки на палиндром
        boolean isPalindrome = checkPalindrom(q);
        System.out.println("Очередь является палиндромом: " + isPalindrome);

        // Проверяем, что очередь восстановилась после проверки
        System.out.println("Очередь после проверки: " + q);

        // --- Дополнительный тест с не-палиндромом ---
        Queue<Integer> q2 = new Queue<Integer>();
        q2.insert(1);
        q2.insert(2);
        q2.insert(3);
        System.out.println("\nИсходная очередь 2: " + q2);
        isPalindrome = checkPalindrom(q2);
        System.out.println("Очередь 2 является палиндромом: " + isPalindrome);
        System.out.println("Очередь 2 после проверки: " + q2);
    }
}