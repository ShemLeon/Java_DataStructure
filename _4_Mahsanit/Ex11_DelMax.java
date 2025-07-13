package _4_Mahsanit;

import unit4.collectionsLib.Stack;

public class Ex11_DelMax {

    public static double whatIsTheLargestDouble(Stack<Double> st) {
        /*  Функция ищет наибольшее вещественное число в стеке и удаляет его
         * Total: O(n) + O(n) = O(2n) = O(n)
         */
        Stack<Double> temp = new <Double>Stack();
        double max = st.top();  // Take the first element as the initial maximum
        double current;

        // Find the maximum and save elements to the temporary stack
        while (!st.isEmpty()) {
            current = st.pop();
            if (current > max) {
                max = current;
            }
            temp.push(current);
        }

        // Restore the stack without the maximum element
        while (!temp.isEmpty())
            if(temp.top() != max)
                st.push(temp.pop());
            else
                temp.pop();

        return max;
    }

    public static void main(String[] args) {
        Stack<Double> st = new <Double>Stack();
        st.push(1.125);
        st.push(1.25);
        st.push(1.5001);
        st.push(1.5);
        st.push(1.0001);


        System.out.println(st);
        System.out.println(whatIsTheLargestDouble(st));
        System.out.println(st);

    }


}