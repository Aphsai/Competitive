/**
 * Created by Saksham on 2016-03-30.
 */

import java.util.*;
import java.io.*;
class PairJ {
    int p;
    int c;
    public PairJ(int P, int C) {
        p = P;
        c = C;
    }
}
public class CatGirls {
    static BufferedReader br;
    static PairJ[] st;
    static int[][] cache;
    static int W;
    public static void main(String[] args) throws IOException {
        Scanner s = new Scanner(System.in);
        br = new BufferedReader(new InputStreamReader(System.in));
        String[] token = read();
        int N = toInt(token[0]);
        int W = toInt(token[1]);
        st = new PairJ[500000];
        int ind = 0;
        for (int x = 0; x < N; x++) {
            token = read();
            if (token[0].equals("A")) {
                st[ind] = new PairJ(toInt(token[1]), toInt(token[2]));
                ind++;
                cache = new int[ind+1][W+1];
                System.out.println(bfs(ind, W, 0));
            }
            else
                ind--;
        }
    }
    static int bfs(int n, int w, int c) {
        if (n == 0) {
            return 0;
        }
        if (cache[n][w] != 0) {
            return cache[n][w];
        }
        if (st[n-1].p > w) {
            return cache [n][w] = (bfs(n-1,w, 0));
        }
        else
            return cache[n][w] = Math.max((bfs(n-1,w - st[n-1].p, c + st[n-1].c)), bfs(n-1,w,0));
    }
    static int toInt(String s) { return Integer.parseInt(s); }
    static String[] split(String s) {  return s.split(" "); }
    static String[] read() throws IOException { return split(br.readLine()); }
    static int rInt() throws IOException { return toInt(br.readLine()); }
}
