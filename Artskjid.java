/**
 * Created by Saksham on 2016-05-04.
 */

import java.util.*;
import java.io.*;
class PairZ {
    int x = 0;
    int y =0 ;
    public PairZ(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
public class Artskjid {
    static BufferedReader br;
    public static void main(String[] args) throws IOException {
//        Scanner s = new Scanner(System.in);
        br = new BufferedReader(new InputStreamReader(System.in));
        String[] token = read();
        int N = toInt(token[0]);
        int M = toInt(token[1]);
        int[][] map = new int[N][N];
        boolean[][] parents = new boolean[N][N];
        boolean[] roots = new boolean[N];
        for (int x = 0 ;x < M; x++) {
            int[] t = rIntAr();
            if (t[0] != N-1) {
                roots[t[0]] = true;
                map[t[0]][t[1]] = t[2];
                parents[t[1]][t[0]] = true;
            }
        }
        Queue<PairZ> q = new ArrayDeque<>();
        for (int x = 0; x < N-1; x++) {
            if (!roots[x]) {
                for (int y =0 ; y < N; y++) {
                    map[y][x] = 0;
                    if (parents[x][y]) q.add(new PairZ(y, 0));
                }
            }
        }
        while (!q.isEmpty()) {
            int cur = q.poll().x;
         //   System.out.println("CUR: " + cur);
            boolean found = false;
            for (int x =0; x < N; x++) {
                //System.out.println(map[cur][x]);
                if (map[cur][x] != 0) {found = true; break;}
            }
            if (!found) {
            //    System.out.println("NOT FOUND");
                for (int x =0; x < N; x++) {
                    map[x][cur] = 0;
                    if (parents[cur][x]) q.add(new PairZ(x, 0));
                }
            }
        }
//        for (int x = 0; x < N; x++) {
//            for (int y = 0; y < N; y++) {
//                System.out.print(map[x][y] + " " );
//            }
//            System.out.println();
//        }
        q.clear();
        q.add(new PairZ(0, 0));
        int[] dist = new int[N];
//        BitSet[] vis = new BitSet[N];
//        //int[] prev = new int[N];
//        for (int x =0; x < N; x++) {
//            vis[x] = new BitSet();
//        }
        int[] vis = new int[N];
        while(!q.isEmpty()) {
            PairZ cur = q.poll();
          //  System.out.println(cur + " " + vis[cur]);
            for (int x = 1; x < N; x++) {
                if (map[cur.x][x] != 0 && ((cur.y & 1 << x) == 0) && dist[x] < dist[cur.x] + map[cur.x][x]) {
                   // prev[x] = cur;
                    dist[x] = dist[cur.x] +  map[cur.x][x];
                    if (!q.contains(x))
                        q.add(new PairZ(x, (cur.y | (1 << cur.x))));
                }
                   //System.out.println(vis[x]);
            }
        }
//        for (int x =0; x < N; x++) {
////        9 9
////        0 1 1
////        1 5 1?
////        0 2 1
////        2 6 1
////        2 3 1
////        2 4 1
////        3 7 1
////        4 8 1
////        0 6 1
//            System.out.println(x + " " + vis[x]);
//        }
        System.out.println(dist[N-1]);
    }
/*
3 3
0 2 5
0 1 4
1 2 3
 */
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