package _4_Mahsanit;

import unit4.collectionsLib.Stack;

public class Mahsanit_t22 {
    public static void main(String[] args) {
        Stack<Integer> st = new <Integer>Stack();

        // Input data: number and stack of digits
        int num = 2507;
        st.push(5);
        st.push(0);
        st.push(5);
        st.push(2);
        st.push(7);

        System.out.println("Original stack: " + st);
        System.out.println("Does the stack contain all digits of the number? " + checkNumberStack(st, num));
    }

    /**
     * Function: checkNumberStack
     * Description: Checks if the digits of a given number are present in the stack in any order.
     *          The original stack remains unchanged.
     *
     * @param st  Stack of integers representing digits
     * @param num Positive integer whose digits need to be checked in the stack
     * @return true if all digits of the number are present in any order, otherwise false
     *
     * Time complexity: O(n * d), where:
     * n - stack size
     * d - number of digits in the number
     */
    public static boolean checkNumberStack(Stack<Integer> st, int num) {
        Stack<Integer> temp = new <Integer>Stack(); // Temporary stack to restore the original
        int size = 0;
        int tempNum = num;

        // Count the number of digits in the input number
        while (tempNum != 0) {
            tempNum /= 10;
            size++;
        }

        // Create an array to store the digits of the number
        int[] arrayNumbers = new int[size];

        // Split the number into digits and store them in the array
        for (int i = 0; num != 0; i++) {
            arrayNumbers[i] = num % 10;
            num /= 10;
        }

        // Traverse the stack and check for digit matches
        while (!st.isEmpty()) {
            int current = st.pop();  // Get the top element of the stack
            temp.push(current);      // Save it in the temporary stack
            boolean flag = false;

            // Check if the current element matches any digit in the array
            for (int i = 0; i < size; i++) {
                if (arrayNumbers[i] == current) {
                    flag = true;
                    break; // Exit the loop as soon as a match is found
                }
            }

            // If no match is found, restore the stack and return false
            if (!flag) {
                while (!temp.isEmpty()) {
                    st.push(temp.pop());
                }
                return false;
            }
        }

        // Restore the original stack
        while (!temp.isEmpty()) {
            st.push(temp.pop());
        }

        return true; // All digits of the number are found in the stack
    }
}