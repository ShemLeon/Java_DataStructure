package _3_Recursia;

public class Recursia_ex12 {

    public static void main(String[] args) {
        int[] testArr = {1, -5, 10, -2, 4, 6, -7, 8, -9, 3};
        System.out.println(findMaxA(testArr, 0));
        System.out.println(findMaxB(testArr, 0, testArr.length - 1));
    }

    /**
     * Recursive function to find the maximum value in an array.
     * Compares the current element with the maximum of the remaining array.
     * @param arr   array of integers
     * @param index current index being checked
     * Time complexity: O(n), where n is the array size
     */
    public static int findMaxA(int[] arr, int index) {
        // Base case: if this is the last element, return it
        if (index == arr.length - 1) return arr[index];
        // Recursive step: compare the current element with the maximum of the remaining array
        return Math.max(arr[index], findMaxA(arr, index + 1));
    }

    /**
     * Recursive function to find the maximum value in an array.
     * Uses a divide and conquer approach.
     * @param arr   array of integers
     * @param left  left boundary of the search
     * @param right right boundary of the search
     * Time complexity: O(n), where n is the array size
     */
    public static int findMaxB(int[] arr, int left, int right) {
        // Base case: if there is only one element left, return it
        if (left == right) return arr[left];
        // Find the middle of the array
        int mid = (left + right) / 2;
        // Recursively find the maximum in the left and right halves
        int maxLeft = findMaxB(arr, left, mid);
        int maxRight = findMaxB(arr, mid + 1, right);
        // Return the greater of the two values
        return Math.max(maxLeft, maxRight);
    }
}