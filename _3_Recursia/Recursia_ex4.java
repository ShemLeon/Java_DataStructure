package _3_Recursia;

/* Function complexity (sumOfTheTenDividedNums): O(n), as we traverse the array once */
public class Recursia_ex4 {
    public static void main(String[] args) {
        int[] testArr = {30, 4, 2, 30, 2, 40, 5, 6, 7, 8, -1, 0, -19};
        int size = testArr.length-1;
        System.out.println(sumOfTheTenDividedNums(testArr, size));
    }

    /**
     * Recursive function to calculate the sum of numbers divisible by 10
     * @param arr array of integers
     * @param index array length minus 1
     * @return sum of all numbers divisible by 10
     * Time complexity: O(n)
     */
    public static int sumOfTheTenDividedNums(int[] arr, int index) {
        if (index < 0) return 0; // Base case: reached the start of the array
        if (arr[index] % 10 == 0) {
            return arr[index] + sumOfTheTenDividedNums(arr, index - 1);
        } else {
            return sumOfTheTenDividedNums(arr, index - 1);
        }
    }
}