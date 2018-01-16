/**
 * Created by Saksham on 2016-03-17.
 */
import java.util.*;
public class PiDay {
    static int N;
    static int K;
    static int total = 0;
    static int [][][] cache;
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        N = s.nextInt();
        K = s.nextInt();
        //System.out.println(N + " " + K);
        cache = new int[N+1][K+1][N+1];
        recurse(N, K, 1);
        if (K ==1) total = 1;
        System.out.println(total);
    }
    static int recurse(int n, int k, int t) {
        if (cache[n][k][t] != 0) return cache[n][k][t];

        if (k == 1) {
           // System.out.println("N: " + n);
            if (n != 0)
            return cache[n][k][t] = 1;
                return cache[n][k][t] = 0;
        }
        total = 0;
        for (int x = t; x < (n/k)+1; x++) {
            total += recurse(n - x, k - 1,x);
          //  System.out.println(str);
        }
        return cache[n][k][t] = total;
    }
}
