package _4_Mahsanit;

import unit4.collectionsLib.Stack;

public class baza_mahsanit {
    /*

    основные методы и приемы для "MAHSANIT" / "LIFO" / "STACK"

    --  stack.push()    - положить в голову махсанита значение? объект?
    --  stack.pop()     - удалить и "дать пользователю"/вернуть значение с вершины стека
    --  stack.top()     - посмотреть значение на вершине стека (без удаления)
    --  stack.isEmpty() - вернет TRUE если махсанит пустой. Boolean
    --  stack.toString() - пропечатает махсанит.
        System.out.println(stack.toString());
    Пример создания стека:
    Stack<Integer> st = new Stack<Integer>();
    Stack<String> st = new Stack<String>();
    Stack<Integer> st = new <Integer>Stack();
        st.push(10);



    */
    public static void main(String[] args) {
        // Пример 1: Работа с числами
        Stack<Integer> numbers = new Stack<Integer>();
        numbers.push(10);
        numbers.push(20);
        numbers.push(30);
        System.out.println("Вершина стека: " + numbers.top()); // выведет 30

        System.out.println(numbers.toString());

        // Пример 2: Посмотреть содержимое
        // Но после этого действия было бы неплохо их запилить обратно.
        System.out.println("Содержимое стека:");
        while (!numbers.isEmpty()) {
            System.out.println(numbers.pop());
        }


        // Пример 3: Работа со строками
        Stack<String> words = new Stack<String>();
        words.push("Привет");
        words.push("Мир");
        words.push("!");

        // Пример 4: Копирование стека
        Stack<String> copyStack = new Stack<String>();
        Stack<String> tempStack = new Stack<String>();

        // Сначала перекладываем во временный стек
        while (!words.isEmpty()) {
            tempStack.push(words.pop());
        }

        // Теперь из временного стека в оба стека
        while (!tempStack.isEmpty()) {
            String value = tempStack.pop();
            words.push(value);
            copyStack.push(value);
        }

        // Пример 5: Подсчет элементов в стеке
        int count = 0;
        Stack<String> tempCount = new Stack<String>();
        while (!words.isEmpty()) {
            tempCount.push(words.pop());
            count++;
        }
        // Возвращаем элементы обратно
        while (!tempCount.isEmpty()) {
            words.push(tempCount.pop());
        }
        System.out.println("Количество элементов: " + count);

        // Пример 6: Поиск максимального элемента
        Stack<Integer> numbers2 = new Stack<Integer>();
        numbers2.push(5);
        numbers2.push(8);
        numbers2.push(3);
        numbers2.push(12);
        numbers2.push(9);

        int max = findMax(numbers2);
        System.out.println("Максимальный элемент: " + max);
    }

    // Метод для поиска максимального элемента в стеке
    public static int findMax(Stack<Integer> stack) {
        if (stack.isEmpty()) {
            return Integer.MIN_VALUE;
        }

        Stack<Integer> tempStack = new Stack<Integer>();
        int max = stack.top();

        while (!stack.isEmpty()) {
            int current = stack.pop();
            if (current > max) {
                max = current;
            }
            tempStack.push(current);
        }

        // Восстанавливаем исходный стек
        while (!tempStack.isEmpty()) {
            stack.push(tempStack.pop());
        }

        return max;
    }
}