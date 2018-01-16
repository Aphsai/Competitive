/**
 * Created by Saksham on 2016-04-06.
 */

import java.util.*;
import java.io.*;
class Tup {
    int x;
    int y;
    int r;
    public Tup (int X, int Y, int R) {
        x = X;
        y = Y;
        r = R;
    }
}
public class SignalHill {
    static BufferedReader br;
    static int B;
    static Tup[] be;
    static boolean[] vis;
    static boolean [][] bool;
    public static void main(String[] args) throws IOException {
        Scanner s = new Scanner(System.in);
        br = new BufferedReader(new InputStreamReader(System.in));
        int[] t= rIntAr();
        B = t[0];
        int Q = t[1];
       bool = new boolean [B+1][B+1];
        be = new Tup[B+1];
        int[] prev = new int[B+1];

        for (int x = 0; x < B; x++) {
            t = rIntAr();
            be[x+1] = new Tup(t[0],t[1],t[2]);
        }
        for (int x =1; x < B+1; x++) {
            for (int y = 1; y < B+1; y++) {
                if (x!= y) {
                    if (sqr(be[x].x - be[y].x) + sqr(be[x].y - be[y].y) <= sqr(be[x].r)) {
                        bool[x][y] = true;
                    }
                }
            }
        }
        for (int x = 1; x < B+1; x++) {
            Stack<Integer> q = new Stack<>();
            vis = new boolean[B+1];
            q.add(x);
            while(!q.isEmpty()) {
                int src = q.pop();
                for (int y = 1; y < B+1; y++) {
                    if (vis[y] == false && bool[src][y] == true) {
                        q.push(y);
                        bool[x][y] = true;
                        vis[y] = true;
                    }

                }
            }
        }
//        for (int x = 1; x < B+1; x++) {
//            if (vis[x] == false) {
//                recur(x);
//            }
//        }
        for (int x = 0; x < Q; x++) {
            t = rIntAr();
            if (bool[t[0]][t[1]]) {
                System.out.println("YES");
            }
            else {
                System.out.println("NO");
            }
        }
    }
//    static HashSet<Integer>[] recur (int n) {
//        int X = be[n].x;
//        int y = be[n].y;
//        int r = be[n].r;
//        vis[n] = true;
//        for (int x = 1; x < B+1; x++) {
//            if (x != n) {
//                if (sqr(X - be[x].x) + sqr(y - be[x].y) <= sqr(r)) {
//
//                    if (vis[x] == false) {
//                        recur(x);
//                    }
//                    map[n].addAll(map[x]);
//                    map[n].add(x);
//                }
//            }
//        }
//        return map;
//    }
    static int sqr (int a) {
        return a * a;
    }
    static int toInt(String s) {
        return Integer.parseInt(s);
    }

    static String[] split(String s) {
        return s.split(" ");
    }

    static String[] read() throws IOException {
        return split(br.readLine());
    }

    static int rInt() throws IOException {
        return toInt(br.readLine());
    }

    static int[] rIntAr() throws IOException {
        String[] temp = read();
        int[] t = new int[temp.length];
        for (int x = 0; x < temp.length; x++) {
            t[x] = toInt(temp[x]);
        }
        return t;
    }
}
