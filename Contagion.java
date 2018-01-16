/**
 * Created by Saksham on 2016-04-18.
 */

import java.util.*;
import java.io.*;
class Pair {
    int x;
    int y;
    public Pair(int X, int Y) {
        x = X;
        y = Y;
    }
}
public class Contagion {
    static BufferedReader br;

    public static void main(String[] args) throws IOException {
        Scanner s = new Scanner(System.in);
        br = new BufferedReader(new InputStreamReader(System.in));
        int N = rInt();
        Pair[] countries = new Pair[N+1];
        for (int x = 1; x < N+1; x++) {
            int[] t = rIntAr();
            countries[x] = new Pair(t[0],t[1]);
        }
        int src = rInt();
        int[][] cache = new int[N+1][N+1];
        for (int x = 1; x < N+1; x++) {
            for (int y = x+1; y < N+1; y++) {
                int d = len(countries[x].x-countries[y].x,countries[x].y-countries[y].y);
                System.out.println(d);
                cache[x][y] = d;
                cache[y][x] = d;
            }
        }
        Queue<Integer> q = new ArrayDeque<>();
        q.add(src);
        int[] dist = new int[N+1];
        while(!q.isEmpty()) {
            int cur = q.poll();
            for (int x  = 1; x < N+1; x++) {
                if (x != cur && x!= src && (dist[x] == 0 || dist[x] > dist[cur] + cache[cur][x])) {
                    dist[x] = dist[cur] + cache[cur][x];
                    q.add(x);
                }
            }
        }
        Arrays.sort(dist);
        int Q = rInt();
        for (int x =0; x < Q; x++) {
            System.out.println();
        }

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
    static int len (int a, int b){
        return sqr(a) + sqr(b);
    }
    static int sqr (int a) {
        return a * a;
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
