/**
 * Created by Saksham on 2016-03-20.
 */
import java.util.*;
class PairD implements Comparable<PairD>{
    int X;
    int W;
    public PairD(int x, int w) {
        X = x;
        W = w;
    }
    public int compareTo(PairD a) {
        return this.X - a.X;
    }

}
public class KittansDilemma {
    static PairD [] arr;
    static int N;
    static int M;
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        N = s.nextInt();
        M = s.nextInt();
//        cache = new int[N+1][M+1];
        ArrayList<PairD> good = new ArrayList<>(N/2);
        ArrayList<PairD> bad = new ArrayList<>(N/2);

        for (int x  =0; x < N; x++) {
            int a = s.nextInt();
            int b = s.nextInt();
            if (b == 1) {
                bad.add(new PairD(a,b));
            }
            else
                good.add(new PairD(a,b));
        }
        Collections.sort(bad);
        Collections.sort(good);
        System.out.println(good);
        int gInd = 0;
        int bInd = 0;
//        while (true) {
//            int bSize = bad.size();
//            int gSize = good.size();
//            int temp = 0;
//            if (bSize >= 2) {
//                temp = bad.get(bInd).X + bad.get(bInd+1).X;
//            }
//            if (bSize >= 2 && temp < good.get(gInd).X && temp != 0 && M - temp > 0) {
//                bInd+=2;
//                M -= temp;
//                continue;
//            }
//            else if ()
//
//        }
//        System.out.println(bfs(N,M));
    }
//    static int bfs(int n, int m) {
//        if (n == 0) {
//            return 0;
//        }
////        if (cache[n][m] != 0) {
////            return cache[n][m];
////        }
//        if ( m - arr[n-1].X < 0) {
//            return bfs(n-1,m);
//        }
//        else
//            return Math.max(arr[n-1].W + (bfs(n-1,m-arr[n-1].X)), bfs(n-1,m));
//    }
}
