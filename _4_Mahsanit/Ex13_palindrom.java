package _4_Mahsanit;
import unit4.collectionsLib.Stack;

import java.util.Scanner;


public class Ex13_palindrom {
// ф-я получает int n, потом пользователь вводит символы и благодаря 1у махсаниту выводит ответ
    public static void palNum( int n) {
        if (n <= 0) System.out.println("mistake");
        ;
        Scanner scanner = new Scanner(System.in);
        Stack<Character> st = new Stack<>();
        System.out.println("Введите " + n + " символов по одному:");
        for (int i = 0; i < n / 2 && !st.isEmpty(); i++) {
            System.out.print("> ");
            char ch = scanner.next().charAt(0);
            st.push(ch);
        }
        // 2. Если n нечетное, считываем и пропускаем средний символ
        if (n % 2 != 0) {
            System.out.print("> ");
            scanner.next(); // Просто считываем и игнорируем
        }
        // 3. Сравниваем вторую половину символов с данными из стека
        boolean isPal = true;
        for (int i = 0; i < n / 2; i++) {
            System.out.print("> ");
            char ch = scanner.next().charAt(0);
            // Если isPal уже false, мы не должны прерывать цикл,
            // а должны дочитать оставшиеся символы, чтобы не сломать ввод.
            // Но сравнение уже не имеет смысла.
            if (isPal) {
                if (st.isEmpty() || st.pop() != ch) {
                    isPal = false;
                    System.out.println("Не палиндром");
                }
            }

        }
    }
}
