package _4_Mahsanit;
import unit4.collectionsLib.Stack;

import static _4_Mahsanit.baza_mahsanit.cloneStack;

// Напишите внешнюю функцию, которая принимает в качестве параметра положительное целое число и стек цифр.
// Вернет true, если все цифры этого числа содержатся в стеке в виде непрерывной последовательности (порядок цифр в этой последовательности не важен), и false в противном случае.
// Стек после выполнения функции должен остаться без изменений.
public class Ex12_AllNumbersInStack {
    public static boolean checkNumbersInStack(Stack<Integer> stOrig, int numb){
        Stack<Integer> tempOrig = cloneStack(stOrig); // клонируем основной стак, чтобы не парится с финальным условием.
        Stack<Integer> tempOrigSave = new Stack<Integer>(); // Временный стак для восстановления основы

        Stack<Integer> stNumber = new Stack<Integer>(); // Стак для чисел входящего номера
        Stack<Integer> tempNumb = new Stack<Integer>(); // Временный стак для восстановления чисел номера
        int countNumb=0;    // Длина последовательности=количеству чисел в номер.
        int count=0;        // Для текущей последовательности

        // разбираем входящий номер на составные и заливаем в его персональный стак
        while (numb > 0) {
            countNumb++;
            stNumber.push(numb%10);
            numb /= 10;
        }
        tempNumb = cloneStack(stNumber); // клонируем стак с номерами, чтобы не парится восстановлением.

        while (!tempOrig.isEmpty()){
            // доходим до числа из номера. остальное выбрасываем
            if(tempOrig.top() != stNumber.top()) tempOrig.pop();
            // чекаем совпадение
            boolean flag = false;
            while (!tempNumb.isEmpty()){
                if (tempOrig.top()==tempNumb.top()){
                    count++;
                    flag = true;
                } else tempNumb.pop();
            }
        }

        // заливаем числа, которые на данных момент не совпадают с головой .
        while (!stNumber.isEmpty()){

            if (stNumber.top()!=stNumber.top()) tempNumb.push(stNumber.pop());
            // TODO: если нет совпадения надо вернуть фолс и восстановить оригинальный стак.
        }


        return true;
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
        System.out.println("Num = "+num+"\nOriginal stack: " + st);
    }
}