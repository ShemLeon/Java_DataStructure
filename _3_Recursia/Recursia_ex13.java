package _3_Recursia;

public class Recursia_ex13 {
    public static void main(String[] args) {
        int[] sortArr = {1, 3, 4, 5, 7, 9, 11, 13, 17, 20};
        int target = 9;
        int size = sortArr.length-1;
        int result = binarySearch(sortArr, target, 0, size);
        System.out.println("Index of the target number " + target + " --> " + result);
    }

    /**
     * Recursive function to perform binary search in a sorted array
     * @param arr    sorted array
     * @param target target number
     * @param left   left boundary of the search
     * @param right  right boundary of the search
     * @return index of the target number if found, or -1 if not found
     * Complexity: O(log n), where n is the array size
     */
    public static int binarySearch(int[] arr, int target, int left, int right) {
        // Base case: if the range is invalid, return -1
        if (left > right) return -1;
        // Calculate the middle index
        int mid = left + (right - left) / 2;
        // Check if the middle element is the target
        if (arr[mid] == target) return mid;

        // Recursive step: search in the left or right half
        if (target < arr[mid]) {
            return binarySearch(arr, target, left, mid-1); // Search in the left half
        } else {
            return binarySearch(arr, target, mid+1, right); // Search in the right half
        }
    }
}