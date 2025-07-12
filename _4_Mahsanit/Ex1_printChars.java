package _4_Mahsanit;
import unit4.collectionsLib.Stack;

public class Ex1_printChars {
    // Пропечатать все элементы из стака и восстановить его
    public static void printStack(Stack<Character> st) {
        // Создаем временный стек для хранения элементов
        Stack<Character> tempStack = new Stack<Character>();
        System.out.println("Содержимое стека (сверху вниз):");
        // Перекладываем и печатаем элементы
        while (!st.isEmpty()) {
            Character element = st.pop();
            System.out.println(element);
            tempStack.push(element);
        }
        // Возвращаем элементы обратно
        while (!tempStack.isEmpty()) {
            st.push(tempStack.pop());
        }}

    public static void main(String[] args) {
        Stack<Character> letters = new Stack<>();

        letters.push('a');
        letters.push ( 'b');
        letters.push ( 'c');
        letters.pop ();
        letters.top ();
        letters.pop ();
        letters.push ( 'h');
        letters.push ('k');
        letters.pop ();
        printStack(letters);
        System.out.println(letters.toString());
        System.out.println(letters.toString());
    }


}
