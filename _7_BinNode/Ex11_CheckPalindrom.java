package _7_BinNode;
import unit4.collectionsLib.BinNode;

public class Ex11_CheckPalindrom {
    /**
     * Функция для "проверки, является ли двусвязный список палиндромом"
     * @param head головной узел списка
     * @return true если список является палиндромом, иначе false
     * Сложность: O(n), где n - количество узлов в списке
     * Принцип работы:
     * 1. Проверяем особые случаи:
     *    - Пустой список или список с одним элементом является палиндромом
     * 2. Находим конец списка
     * 3. Сравниваем значения с обоих концов, двигаясь к центру
     * 4. Если все пары совпадают, список является палиндромом
     */
    public static boolean isPalindrome(BinNode<Character> head) {
        if (head == null || head.getRight() == null) {
            return true;  // Пустой список или список с одним элементом
        }
        
        // Находим конец списка
        BinNode<Character> left = head;
        BinNode<Character> right = head;
        while (right.getRight() != null) {
            right = right.getRight();
        }

        // Сравниваем значения с обоих концов
        while (left != right && left.getLeft() != right) {
            if (!left.getValue().equals(right.getValue())) {
                return false;  // Не палиндром
            }
            left = left.getRight();   // Двигаемся вправо
            right = right.getLeft();  // Двигаемся влево
        }

        return true;  // Палиндром
    }
    
    // Вспомогательный метод для создания списка символов из строки
    public static BinNode<Character> createCharList(String str) {
        if (str.isEmpty()) return null;
        
        BinNode<Character> head = new BinNode<>(str.charAt(0));
        BinNode<Character> current = head;
        
        for (int i = 1; i < str.length(); i++) {
            BinNode<Character> newNode = new BinNode<>(str.charAt(i));
            current.setRight(newNode);
            newNode.setLeft(current);
            current = newNode;
        }
        
        return head;
    }
    
    // Вспомогательный метод для печати списка символов
    public static void printCharList(BinNode<Character> head) {
        BinNode<Character> current = head;
        while (current != null) {
            System.out.print(current.getValue());
            if (current.getRight() != null) {
                System.out.print(" <-> ");
            }
            current = current.getRight();
        }
        System.out.println();
    }
    
    public static void main(String[] args) {
        System.out.println("=== Тестирование проверки на палиндром ===\n");
        
        // Тест 1: Палиндром из нечетного количества символов
        System.out.println("1. Тест с палиндромом 'radar':");
        BinNode<Character> list1 = createCharList("radar");
        System.out.print("Список: ");
        printCharList(list1);
        System.out.println("Является палиндромом: " + isPalindrome(list1));
        
        // Тест 2: Палиндром из четного количества символов
        System.out.println("\n2. Тест с палиндромом 'abba':");
        BinNode<Character> list2 = createCharList("abba");
        System.out.print("Список: ");
        printCharList(list2);
        System.out.println("Является палиндромом: " + isPalindrome(list2));
        
        // Тест 3: Не палиндром
        System.out.println("\n3. Тест с не палиндромом 'hello':");
        BinNode<Character> list3 = createCharList("hello");
        System.out.print("Список: ");
        printCharList(list3);
        System.out.println("Является палиндромом: " + isPalindrome(list3));
        
        // Тест 4: Один символ
        System.out.println("\n4. Тест с одним символом 'a':");
        BinNode<Character> list4 = createCharList("a");
        System.out.print("Список: ");
        printCharList(list4);
        System.out.println("Является палиндромом: " + isPalindrome(list4));
        
        // Тест 5: Пустой список
        System.out.println("\n5. Тест с пустым списком:");
        BinNode<Character> emptyList = null;
        System.out.print("Список: null\n");
        System.out.println("Является палиндромом: " + isPalindrome(emptyList));
        
        // Тест 6: Два одинаковых символа
        System.out.println("\n6. Тест с двумя одинаковыми символами 'aa':");
        BinNode<Character> list6 = createCharList("aa");
        System.out.print("Список: ");
        printCharList(list6);
        System.out.println("Является палиндромом: " + isPalindrome(list6));
    }
}
