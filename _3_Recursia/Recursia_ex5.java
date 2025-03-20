package _3_Recursia;

/* Function complexity: O(n), as we traverse the array once */
public class Recursia_ex5 {
    public static void main(String[] args) {
        int[] testArr = {1, -5, 10, -2, 4, 6, -7, 8, -9, 3};
        int size = testArr.length-1;
        printNumbersNegativeNumberPositive(testArr, size);
    }

    /**
     * Recursive function to find numbers with a negative number on the left and a positive number on the right
     * @param arr array of integers
     * @param size array length minus 1
     * Time complexity: O(n)
     */
    public static void printNumbersNegativeNumberPositive(int[] arr, int size) {
        if (size < 3) return;   // Base case: if the array has fewer than 3 elements, nothing to check
        int index = size - 2;   // Calculate the current index to check

        if (arr[index - 1] < 0 && arr[index + 1] > 0) {
            System.out.println("Number " + arr[index] + " satisfies the condition: left = " + arr[index - 1] + ", right = " + arr[index + 1]);
        }
        printNumbersNegativeNumberPositive(arr, size - 1);
    }
}