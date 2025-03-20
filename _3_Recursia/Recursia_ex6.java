package _3_Recursia;

/* Function complexity: O(n), as we traverse the array once */
public class Recursia_ex6 {
    public static void main(String[] args) {
        int[] testArr = {1, -5, 10, -2, 4, 6, -7, 8, -9, 3};
        int size = testArr.length-1;
        int param_1 = 4, param_2 = 6;
        System.out.println(checkAdjacent(testArr, size, param_1, param_2));
    }

    /**
     * Recursive function to check if two numbers are adjacent in the array
     * The order of the numbers does not matter
     * @param arr array of integers
     * @param size current index being checked
     * @param param_1 first target number
     * @param param_2 second target number
     * @return true if the numbers are adjacent, false otherwise
     * Time complexity: O(n), where n is the array size
     */
    public static boolean checkAdjacent(int[] arr, int size, int param_1, int param_2) {
        if (size <= 0) return false; // Base case: reached the start of the array, adjacent numbers not found
        // Check if the current pair matches the target numbers (in any order)
        if ((arr[size] == param_1 && arr[size-1] == param_2) ||
                (arr[size] == param_2 && arr[size-1] == param_1)) {
            return true;
        }
        // Recursive call to check the next pair
        return checkAdjacent(arr, size-1, param_1, param_2);
    }
}