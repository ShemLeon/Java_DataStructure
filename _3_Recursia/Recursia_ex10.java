package _3_Recursia;

public class Recursia_ex10 {
    /* Function to calculate the value of a polynomial using Horner's method
     * @param n degree of the polynomial
     * @param a[] coefficients of the polynomial
     * @param p intermediate value (initial = 1)
     * @param x value of the argument
     * @return value of the polynomial at point x
     * Complexity: O(n), where n is the degree of the polynomial
     * Working principle:
     * 1. If n == 0 (no coefficients), return 0 (base case)
     * 2. Calculate the current term: a[n-1]*p
     * 3. Recursively calculate for the next term with updated p = p*x
     */
    public static double sod (int n, double a[], double p, double x)
    {
        if (n==0) return 0;
        return a[n-1]*p+ sod(n-1,a,p*x,x);
    }

    public static void main(String[] args) {
        double a[]={1,2,3,4,0,6,0,0,5,4};
        System.out.println("RESULT = "+ sod(4,a,1,2));
    }
}
