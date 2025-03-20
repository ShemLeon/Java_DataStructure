package _3_Recursia;

public class Recursia_ex11 {
    public static int sod(int n, float a[]) {
        if (n == 0) return 0;
        if ((a[n-1] - (int)a[n-1]) == 0) {
            System.out.println(a[n-1]);
            return 1 + sod(n-1, a);
        }
        return sod(n-1, a);
    }

    public static void main(String[] args) {
        float a[] = {1.25f, 72.87f, 3.0f, 4.05f, 0f, 6f, 7.05f, 96.4f, 5f, 41.4f};
        System.out.println("RESULT = " + sod(a.length, a));
    }
}