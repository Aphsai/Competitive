/**
 * Created by Saksham on 2016-03-29.
 */

import java.util.*;
import java.io.*;
class PairI {
    int t;
    int e;
    public PairI(int T, int E) {
        t = T;
        e = E;
    }
}
public class GettingGoodAtProgramming {
    static BufferedReader br;
    static int T;
    static int N;
    static ArrayList<PairI> []level;
    static int[][][] cache;
    public static void main(String[] args) throws IOException {
        Scanner s = new Scanner(System.in);
        br = new BufferedReader(new InputStreamReader(System.in));
        String[] token = split(br.readLine());
        N = toInt(token[0]);
        T = toInt(token[1]);
        cache = new int[N+1][T+1][100];
        level = new ArrayList[N];
        for (int x = 0; x < N; x++) {
            level[x] = new ArrayList<>();
            token = split(br.readLine());
            int n = toInt(token[0]);
            for (int y = 0; y < n*2; y+=2) {
                level[x].add(new PairI(toInt(token[y+1]), toInt(token[y+2])));
            }
        }
        System.out.println(bfs(N,T,0));
    }
    static int bfs (int n, int t, int ind) {
        if (n == 0) {
            return 0;
        }
        if (cache[n][t][ind] != 0) {
            return cache[n][t][ind];
        }
        if (ind == level[n-1].size() || t -level[n-1].get(ind).t < 0) {
            return cache[n][t][ind] = (bfs(n-1,t,0));
        }
        else
            return cache[n][t][ind] = Math.max(level[n-1].get(ind).e + bfs(n, t- level[n-1].get(ind).t, ind+1), bfs(n-1,t,0));
    }

    static int toInt(String s) {
        return Integer.parseInt(s);
    }

    static String[] split(String s) {
        return s.split(" ");
    }


}
//import java.io.*;
//
//public class MEC_16_P3_GETTING_GOOD_AT_PROGRAMMING {
//
//    static int [][] profit, weight;
//    static int [][][] cache;
//
//    public static int solve (int T, int S, int L) {
//        if (cache [T][S][L] == 0 && !(T == 0 || S == profit.length || L == profit [S].length)) {
//            if (T < weight [S][L]) {
//                cache [T][S][L] = solve (T, S + 1, 0);
//            }
//            else {
//                cache [T][S][L] = Math.max (profit [S][L] + solve (T - weight [S][L], (L + 1) % profit [S].length == (L + 1) ? S : S + 1, (L + 1) % profit [S].length), solve (T, S + 1, 0));
//            }
//        }
//
//        return cache [T][S][L];
//    }
//
//    public static void main (String [] t) throws IOException {
//        BufferedReader in = new BufferedReader (new InputStreamReader (System.in));
//        t = in.readLine ().split (" ");
//
//        int N = Integer.parseInt (t [0]), T = Integer.parseInt (t [1]), L;
//
//        profit = new int [N][];
//        weight = new int [N][];
//        cache = new int [T + 1][N + 1][];
//
//        for (int n = 0; n < N; n++) {
//            t = in.readLine ().split (" ");
//            L = Integer.parseInt (t [0]);
//
//            profit [n] = new int [L];
//            weight [n] = new int [L];
//
//            for (int i = 0; i <= T; i++) {
//                cache [i][n] = new int [L + 1];
//                cache [i][N] = new int [L + 1];//really inefficient...
//            }
//
//            for (int l = 0; l < L; l++) {
//                profit [n][l] = Integer.parseInt (t [l * 2 + 2]);
//                weight [n][l] = Integer.parseInt (t [l * 2 + 1]);
//            }
//        }
//
//        System.out.println (solve (T, 0, 0));
//    }
//}