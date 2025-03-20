package _4_Mahsanit;

import unit4.collectionsLib.Stack;

public class Mahsanit_t20 {

    public static double whatIsTheLargestDouble(Stack<Double> st) {
        /*
         * Function to find the largest real number in the stack and remove it
         * Input: Stack of real numbers
         * Output: The largest number in the stack
         * Working principle:
         * 1. Create a temporary stack
         * 2. Traverse the original stack, finding the largest number
         * 3. Remove the largest number and restore the original stack
         *
         * Time complexity: O(n), where n - number of elements in the stack
         * - First loop (finding maximum): O(n)
         * - Second loop (restoring stack): O(n)
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