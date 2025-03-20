package _3_Recursia;

/* Function complexity (hasNeighborSumIsTen): O(n), as we traverse the array once */
public class Recursia_ex3 {
    public static void main(String[] args) {
        int[] testArr = {3, 4, 2, 8, 2, 4, 5, 6, 7, 8, -1, 0, -19};
        int size = testArr.length-1;
        System.out.println(hasNeighborSumIsTen(testArr, size));
    }

    /**
     * Recursive function to find two adjacent numbers whose sum is divisible by 10
     * @param arr array of integers
     * @param index array length minus 1
     * @return true if two adjacent numbers with sum divisible by 10 are found, false otherwise
     * Time complexity: O(n)
     */
    public static boolean hasNeighborSumIsTen(int[] arr, int index) {
        if (index <= 0) return false; // Base case: we have reached the beginning of the array
        int sum = arr[index] + arr[index - 1];
        if (sum != 0 && sum % 10 == 0) return true; // Check that the sum is not 0 and is divisible by 10
        return hasNeighborSumIsTen(arr, index - 1);
    }
}