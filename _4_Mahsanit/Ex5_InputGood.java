package _4_Mahsanit;
import unit4.collectionsLib.Stack;

/*
Алгоритм работает со строкой символов:
1. Читаем символ → ch
2. Пока (ch = 'a'), выполняем:
   2.1. push(ch)
   2.2. Читаем следующий символ → ch
3. Пока (ch = 'b' И стек не пустой), выполняем:
   3.1. ch ← pop()
   3.2. Читаем следующий символ → ch
4. Если достигнут конец ввода И стек пустой, то печатаем "GOOD"
5. Иначе печатаем "NOT GOOD"

Ответ: Алгоритм выведет "GOOD" для строк, где:
1. Сначала идут только символы 'a' (0 или более)
2. Затем идут только символы 'b' (столько же, сколько было 'a')
3. Строка заканчивается

Примеры "GOOD" строк:
- пустая строка
- ab
- aabb
- aaabbb

Примеры "NOT GOOD" строк:
- a (остался символ в стеке)
- b (стек пустой)
- aba (неправильный порядок)
- aab (остался символ в стеке)
- abb (стек пустой)
*/

public class Ex5_InputGood {
    public static void main(String[] args) {
        // Тестируем разные строки
        testString("");      // должно быть GOOD
        testString("ab");    // должно быть GOOD
        testString("aabb");  // должно быть GOOD
        testString("aaabbb"); // должно быть GOOD
        testString("a");     // должно быть NOT GOOD
        testString("b");     // должно быть NOT GOOD
        testString("aba");   // должно быть NOT GOOD
        testString("aab");   // должно быть NOT GOOD
        testString("abb");   // должно быть NOT GOOD
        testString("sss");   // должно быть NOT GOOD
    }

    public static void testString(String input) {
        System.out.println("\nПроверяем строку: \"" + input + "\"");
        
        Stack<Character> stack = new Stack<>();
        int index = 0;
        char ch;

        // Симулируем чтение первого символа
        if (input.length() > 0) {
            ch = input.charAt(index++);
        } else {
            ch = ' '; // пустой ввод
        }

        // Шаг 2: Пока ch = 'a'
        while (index <= input.length() && ch == 'a') {
            stack.push(ch);  // push(ch)
            // Читаем следующий символ
            if (index < input.length()) {
                ch = input.charAt(index++);
            } else {
                break;
            }
        }

        // Шаг 3: Пока ch = 'b' и стек не пустой
        while (index <= input.length() && ch == 'b' && !stack.isEmpty()) {
            stack.pop();  // pop()
            // Читаем следующий символ
            if (index < input.length()) {
                ch = input.charAt(index++);
            } else {
                break;
            }
        }

        // Шаг 4 и 5: Проверяем условие и выводим результат
        if (index >= input.length() && stack.isEmpty()) {
            System.out.println("GOOD");
        } else {
            System.out.println("NOT GOOD");
        }
    }
}
