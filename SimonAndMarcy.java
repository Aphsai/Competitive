/**
 * Created by Saksham on 2016-03-20.
 */
import java.util.*;
class PairC  {
    int X;
    int M;
    public PairC(int x, int m) {
        X = x;
        M = m;
    }
}
public class SimonAndMarcy {
    static PairC[] arr;
    static int [][] cache;
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int C = s.nextInt();
        int M = s.nextInt();
        cache = new int[C+1][M+1];
        arr = new PairC[C];
        for (int x =0; x < C; x++) {
            arr[x] = new PairC(s.nextInt(), s.nextInt());
        }

        System.out.println(sam(C,M));
    }
    static int sam(int n, int m) {
        if (n == 0) {
            return 0;
        }
        if (cache[n][m] != 0) {
            return cache[n][m];
        }
        if (m - arr[n-1].M < 0) {
            return cache[n][m] = (sam(n-1,m));
        }
        else
            return cache[n][m] = Math.max(arr[n-1].X + sam(n-1,m-arr[n-1].M), sam(n-1,m));
    }
}
