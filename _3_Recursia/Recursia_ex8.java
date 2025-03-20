package _3_Recursia;

public class Recursia_ex8 {
    /* Function to calculate the dot product of two vectors
     * @param x[] first vector
     * @param y[] second vector
     * @param s vector size
     * @return dot product of the vectors
     * Complexity: O(n), where n is the vector size
     * Working principle:
     * 1. If s == 0 (empty vectors), return 0 (base case)
     * 2. Multiply the last elements of the vectors x[s-1]*y[s-1]
     * 3. Recursively calculate the product for the remaining elements (s-1)
     */
    public static int func(int x[], int y[], int s){
        if(s==0) return 0;
        return x[s-1]*y[s-1]+func(x,y,s-1);
    }

    public static void main(String[] args) {
        int vec1[]={1,2,1,2,1,2,1};
        int vec2[]={1,-2,3,4,5,-6,7};
        System.out.println("RESULT = "+func(vec1,vec2,vec1.length));
    }
}
