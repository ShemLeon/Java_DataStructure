package _6_Reshima_Mekusheret;
import unit4.collectionsLib.Node;

//  Класс содержит функции для удаления последовательных повторяющихся символов
//  из связного списка символов

public class Ex12_Matala_39 {
    public static void main(String[] args) {
        // Тестовые случаи
        String[] tests = {
                "aabbcc",      // Должно стать "abc"
                "aaaa",        // Должно стать "a"
                "abcd",        // Должно остаться "abcd"
                "aabbccaa"     // Должно стать "abca"
        };

        for (int i = 0; i < tests.length; i++) {
            Node<Character> list = createList(tests[i]);
            System.out.println("Исходный список: " + tests[i]);
            System.out.print("Модифицированный список: ");
            printList(removeConsecutiveDuplicates(list));
            System.out.println();
        }
    }

    /**
     * Функция для "удаления последовательных повторяющихся символов из связного списка"
     * @param head начальный узел списка символов
     * @return начальный узел модифицированного списка
     * Complexity: O(n), где n - количество символов в списке
     * Принцип работы:
     * 1. Если список пустой или содержит один элемент - возвращаем его как есть
     * 2. Проходим по списку:
     *    - Если текущий символ равен следующему, пропускаем следующий узел
     *    - Иначе переходим к следующему узлу
     * 3. Возвращаем начало модифицированного списка
     */
    public static Node<Character> removeConsecutiveDuplicates(Node<Character> head) {
        // Если список пустой или содержит один узел
        if (head == null || head.getNext() == null) return head;
        Node<Character> current = head; // создаем указатель
        // Проходим по списку
        while (current != null && current.getNext() != null) {
            // Если текущий символ равен следующему
            if (current.getValue().equals(current.getNext().getValue())) {
                // Пропускаем следующий узел
                current.setNext(current.getNext().getNext());
            } else {
                // Делаем установку к следующему узлу - только если не найден дубликат
                current = current.getNext();
            }
        }
        return head;
    }
    
    /**
     * Вспомогательная функция для "создания связного списка символов из строки"
     * @param str исходная строка
     * @return начальный узел созданного списка
     * Complexity: O(n), где n - длина строки
     * Принцип работы:
     * 1. Если строка пустая - возвращаем null
     * 2. Создаем начальный узел с первым символом
     * 3. Добавляем остальные символы в список
     */
    public static Node<Character> createList(String str) {
        if (str == null || str.isEmpty()) {
            return null;
        }
        
        Node<Character> head = new Node<>(str.charAt(0));
        Node<Character> current = head;
        
        for (int i = 1; i < str.length(); i++) {
            current.setNext(new Node<>(str.charAt(i)));
            current = current.getNext();
        }
        
        return head;
    }
    
    /**
     * Вспомогательная функция для "вывода списка символов"
     * @param head начальный узел списка
     * Complexity: O(n), где n - количество символов в списке
     * Принцип работы:
     * 1. Проходим по списку от начала до конца
     * 2. Выводим каждый символ
     */
    public static void printList(Node<Character> head) {
        Node<Character> current = head;
        while (current != null) {
            System.out.print(current.getValue());
            current = current.getNext();
        }
        System.out.println();
    }
}