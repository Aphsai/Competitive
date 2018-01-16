/**
 * Created by Saksham on 2016-04-10.
 */

import java.util.*;
import java.io.*;
class Cities {
    int x;
    int d;
    public Cities(int X, int D) {
        x = X;
        d = D;
    }
}
public class ChainRule {
    static BufferedReader br;

    public static void main(String[] args) throws IOException {
        Scanner s = new Scanner(System.in);
        br = new BufferedReader(new InputStreamReader(System.in));
        int[] to = rIntAr();
        int N = to[0];
        int M = to[1];
        ArrayList<Cities>[] map = new ArrayList[N];
        for (int x = 0; x < M; x++) {
            to = rIntAr();
            if (map[to[0]] == null ) {
                map[to[0]] = new ArrayList<>();
            }
            if (map[to[1]] == null) {
                map[to[1]] = new ArrayList<>();
            }
            map[to[0]].add(new Cities(to[1], to[2]));
            map[to[1]].add(new Cities(to[0], to[2]));
        }
        Queue<Cities> q = new ArrayDeque<>();
        int[] cache = new int[N];
       // boolean [][] vis = new boolean[N][N];
        q.add(new Cities(0,0));
        while(!q.isEmpty()) {
             Cities src = q.poll();
            int x = src.x;
            int d= src.d;
            for (Cities i: map[x]) {
                if (i != src && i.x !=0 && (cache[i.x] == 0 || cache[i.x] > cache[x] + i.d)) {
                    q.add(i);
                    //vis[x][i.x] = true;
                    cache[i.x] = cache[x] + i.d;
                }
            }
        }
        int [] cache2 = new int[N];
        q.clear();
            q.add(new Cities(N-1,0));
            while (!q.isEmpty()) {
                Cities src = q.poll();
                int X = src.x;
                for (Cities i : map[X]) {
                    if (i != src && (cache2[i.x] == 0 || cache2[i.x] > cache2[X] + i.d)) {
                        q.add(i);
                        cache2[i.x] = cache2[X] + i.d;
                    }
                }
            }
        int max = 0;
        for (int x =0 ; x < N-1; x++) {
            max = Math.max(cache[x] + cache2[x], max);
        }
        System.out.println(max);
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
