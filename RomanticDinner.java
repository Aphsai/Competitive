/**
 * Created by Saksham on 2016-03-26.
 */

import java.util.*;
import java.io.*;
class Rest {
    int V;
    int T;
    int F;
    public Rest(int v, int t, int f) {
        V = v;
        T = t;
        F = f;
    }
}
public class RomanticDinner {
    static BufferedReader br;
    static Rest[] rest;
    static int M;
    static int U;
    static int R;
    static int[][][] cache;
    public static void main(String[] args) throws IOException {

//        Scanner s = new Scanner(System.in);
        br = new BufferedReader(new InputStreamReader(System.in));
        String[] token = br.readLine().split(" ");
        M = toInt(token[0]);
        U = toInt(token[1]);
        R = toInt(token[2]);
        cache = new int[R+1][M+1][U+1];
        rest = new Rest[R];
        for (int x = 0; x < R; x++) {
            token = br.readLine().split(" ");
            rest[x] = new Rest(toInt(token[0]), toInt(token[1]), toInt(token[2]));
        }
        System.out.println(bfs(R,M,U));
    }
    static int bfs(int n, int m, int u) {
        if (n==0) {
            return 0;
        }
        if (cache[n][m][u] != 0) {
            return cache[n][m][u];
        }
        if (m - rest[n-1].T < 0 || u - rest[n-1].F < 0) {
            return cache[n][m][u] = (bfs(n-1,m,u));
        }
        else
            return cache[n][m][u] = Math.max(rest[n-1].V + bfs(n-1,m-rest[n-1].T,u-rest[n-1].F), bfs(n-1,m,u));
    }

    static int toInt(String s) {
        return Integer.parseInt(s);
    }
}
