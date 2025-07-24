package _6_Reshima_Mekusheret;
import unit4.collectionsLib.Node;


public class Ex19_NotEven {
    // Ex19: Проверка, что у всех элементов, сумма их цифр не кратна 2.
    public static boolean reorgList(Node<Integer> head){
        Node<Integer> current = head;
        while (current != null) {
            int sum = sumOfDigits(current.getValue());
            if (sum % 2 == 0) return false;
            current = current.getNext();
        }
        return true; // Все элементы прошли проверку
    }
    
    // Вспомогательный метод для вычисления суммы цифр числа
    private static int sumOfDigits(int number) {
        int sum = 0;
        number = Math.abs(number); // Работаем с модулем числа
        while (number > 0) {
            sum += number % 10;
            number /= 10;
        }
        return sum;
    }
}
