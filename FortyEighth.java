/**
 * Created by Saksham on 2016-03-13.
 */
import java.util.*;
public class FortyEighth {
    static int K;
    static int N;
    static int [] rest;
    static int t;
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int N = s.nextInt();
        int K = s.nextInt();
        rest = new int[K];
        System.out.println(recurse(N,K,1));
    }
    static int recurse(int n, int index, int minimum) {
        if (index == N+1)
            return 0;
        for (int x = minimum; x < n/index+1; x++ ) {
            t += recurse (n-x, index-1, x);
        }
        return t;
    }

}
