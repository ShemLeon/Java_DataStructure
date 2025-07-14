package _4_Mahsanit;
import unit4.collectionsLib.Stack;
import static _4_Mahsanit.Ex11_DeleteIntFromStack.deleteIntFromStack;
import static _4_Mahsanit.Ex1a_Count.countIntElements;
import static _4_Mahsanit.baza_mahsanit.cloneStack;
import static _4_Mahsanit.baza_mahsanit.searchInt;

public class Ex12_train {
// Напишите внешнюю функцию, которая принимает в качестве параметра положительное целое число и стек цифр.
// Вернет true, если все цифры этого числа содержатся в стеке в виде непрерывной последовательности (порядок цифр в этой последовательности не важен), и false в противном случае.
// Стек после выполнения функции должен остаться без изменений.
    public static boolean checkNumbersInStack(Stack<Integer> stOrig, int numb){
        Stack<Integer> tempOrig = cloneStack(stOrig); // клонируем основной стак, чтобы не парится с финальным условием.
        Stack<Integer> stNumber = new Stack<Integer>(); // Стак для чисел входящего номера
        int countN=0;    // Длина последовательности=количеству чисел в номер. и величина магазина, который будем прогонять.

        // разбираем входящий номер на составные и заливаем в его персональный стак
        while (numb > 0) {
            countN++;
            stNumber.push(numb%10);
            numb /= 10;
        }
        // если число было 0 или отрицательным, countN будет 0
        if (countN == 0) return false;

        while (!tempOrig.isEmpty()){
            // FIX: Проверяем, достаточно ли элементов для проверки "окна"
            if (countIntElements(tempOrig) < countN) {
                break;
            }
            // FIX: Вспомогательные стеки должны создаваться для каждой итерации "окна"
            Stack<Integer> tempOrigSave = new Stack<Integer>();
            Stack<Integer> tempNumb = cloneStack(stNumber);

            for (int i=0; i<countN; i++){
                // Элемента нет в числе, это "окно" не подходит, выходим из цикла for.
                if (!searchInt(tempNumb, tempOrig.top())) break;
                // Элемент найден, удаляем его из `tempNumb` и перемещаем в `tempOrigSave`
                deleteIntFromStack(tempNumb, tempOrig.top());
                tempOrigSave.push(tempOrig.pop());
                }
            // если нашли нужную последовательность.
            if (tempNumb.isEmpty()) return true;
            // восстанавливаем проверяющий магазин после неудачного захода вглубь.
            tempNumb = cloneStack(stNumber);
            // восстанавливаем оригинальный магазин после неудачного захода вглубь. но без головы
            while (!tempOrigSave.isEmpty()) {
                tempOrig.push(tempOrigSave.pop());
            }
            // удаляем голову
            tempOrig.pop();
        }
        return false;
    }

    public static void main(String[] args) {
        Stack<Integer> st = new <Integer>Stack();
        // Input data: number and stack of digits
        int num = 2507;
        st.push(5);
        st.push(0);
        st.push(5);
        st.push(2);
        st.push(7);
        System.out.println("Original stack: " + st + "\nNumber: "+num);
        System.out.println("Does the stack contain all digits of the number? "+num +" "+ checkNumbersInStack(st, num));

        Stack<Integer> st1 = new <Integer>Stack();
        // Input data: number and stack of digits
        int num1 = 2507;
        st1.push(5);
        st1.push(0);
        st1.push(0);
        st1.push(5);
        st1.push(2);
        st1.push(2);
        st1.push(7);
        System.out.println("Original stack: " + st1 + "\nNumber: "+num1);
        System.out.println("Does the stack contain all digits of the number? "+num +" "+ checkNumbersInStack(st1, num1));
    }
}