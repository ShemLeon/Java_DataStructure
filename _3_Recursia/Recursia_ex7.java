package _3_Recursia;

public class Recursia_ex7 {
    /* Function to check if a number contains an odd digit
     * @param num positive integer
     * @return true if the number contains at least one odd digit, false otherwise
     * Complexity: O(log n), where n is the input number
     * Working principle:
     * 1. If num <= 0, return false (base case)
     * 2. Check if the last digit is odd (num%10%2 !=0)
     * 3. Recursively check the remaining digits (num/10)
     */
    public static  boolean num_func(int num){
        if (num<=0) return false;
        return
                (num%10%2 !=0) || num_func(num/10);
    }

    public static void main(String[] args) {
        int num;
        boolean res;
        res = num_func(123);
        if (res == false) System.out.println("YES");
        else System.out.println("NO");
        //
        res = num_func(82);
        if (res == false) System.out.println("YES");
        else System.out.println("NO");
        //
    }
}
