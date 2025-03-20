package _2_Sibuhiut;

public class Sib_1 {
    public static void main(String[] args) {

        // 1. Complexity = O(1)
        int x = 1, n = 10;
        for(int i=1; i<=10; i++){ 
            x = x * i;
        }

        // 2. Complexity = O(n)
        for(int i=1; i<=n; i++){
            x = x * i;
        }

        // 3. Complexity = O(n). 3+4*n => o(n)
        x = 1;
        for(int i=n; i >= 1; i--){
            x = x + i;
            System.out.println(x);
        }

        // 4. Complexity = O(n). 3+3*n/2 => o(n)
        x = 1;
        for (int i=1; i<=n/2; i++){
            x = x*i;
        }

        // 4. Complexity = O(n). 3+3*n/2 => o(n)
        x = 1;
        for (int i=1; i<=n; i=i+2){
            x = x * i;
        }

        // 5. Complexity = O(n). 3+3/2*2 => o(n)
        x = 1;
        for (int i=1; i<=n; i=i+2){
            x = x * i;
        }

        // 6. Complexity = O(n)
        x = 1;
        int m = n;
        for (int i=1; i <= m; i=i+2){
            x = x + i;
            m = m - i;
        }
        System.out.println("x");
        System.out.println("m");

        // 7. Complexity = O(log n)
        int k = 1;
        while (k <= n){
            System.out.println("i");
            k = k * 2;
        }

        // 8. Complexity = O(log n)
        k = n;
        while (k >= 1){
            if(k % 2 == 0) {System.out.println("i");}
            else  {System.out.println("**");}
            k = k / 2;
        }

        // 9. Complexity = O(log n)
        k = 1;

        while (k >= 1){
            if(k % 2 == 0) {System.out.println("k");}
            else  {System.out.println("**");}
            k = k / 2;
        }

        // 10. Complexity = O(n).
        x = 1;
        for (int i = 1; i<=n; i++){
            for (int j=1; j<100; j++){
                x = x*j;
                System.out.println(x);
            }
        }

        // 11. Complexity = O(n^2).
        x = 1;
        for (int i = 1; i<=n; i++){
            for (int j=1; j<i; j++){
                x = x*j;
                System.out.println(x);
            }
        }












        //
    }
}
