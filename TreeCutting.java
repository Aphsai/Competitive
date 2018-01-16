/**
 * Created by Saksham on 2016-03-28.
 */

import java.util.*;
import java.io.*;
class PairQ {
    int x;
    int y;

    public PairQ(int X, int Y) {
        x = X;
        y = Y;
    }
}
public class TreeCutting {
    static BufferedReader br;
    static int R;
    static int C;
    public static void main(String[] args) throws IOException {
        Scanner s = new Scanner(System.in);
        br = new BufferedReader(new InputStreamReader(System.in));
        String[] token = split(br.readLine());
        R = toInt(token[0]);
        C = toInt(token[1]);
        int[][] map = new int[R][C];
        PairQ[][] dist= new PairQ[R][C];
        PairQ src = null;
        int max = 0;
        for (int x = 0; x < R; x++) {
            token = split(br.readLine());
            for (int y = 0; y < C; y++) {
                dist[x][y] = new PairQ(0x3f3f3f3f,0x3f3f3f3f);
                if (token[y].equals(".")) {
                    map[x][y] = 0;
                }
                else if (token[y].equals("X")) {
                    src = new PairQ(x,y);
                    dist[x][y] = new PairQ(0,0);
                }
                else {
                    map[x][y] = toInt(token[y]);
                }
                max = Math.max(map[x][y], max);

            }
        }
        PairQ dest = null;
        int distance = Integer.MAX_VALUE;
        for (int x = 0; x < R; x++) {
            for (int y = 0; y < C; y++) {
                if (map[x][y] == max) {
                    int len = sqr(src.x-x, src.y-y);
                    if (len < distance) {
                        distance = len;
                        dest = new PairQ(x,y);
                    }
                }
            }
        }
        Queue<PairQ> q = new ArrayDeque<>();
        boolean [][] vis = new boolean[R][C];
        PairQ[] mov = new PairQ[4];
        mov[0] = new PairQ(0,1);
        mov[1] = new PairQ(1,0);
        mov[2] = new PairQ(0,-1);
        mov[3] = new PairQ(-1,0);
        q.add(src);
        while(!q.isEmpty()) {
            PairQ cur = q.poll();
            int x = cur.x;
            int y= cur.y;
          //  System.out.println(x + " " + y + " " + dist[x][y].x + " " + dist[x][y].y);
            vis[x][y] = true;
            for (PairQ z : mov) {
                int xi = z.x;
                int yi = z.y;
                if (valid(x + xi, y + yi)) {
                    if (vis[x+xi][y+yi] == false || dist[x + xi][y + yi].x > dist[x][y].x + map[x + xi][y + yi] || ((dist[x + z.x][y + z.y].x == dist[x][y].x + map[x + z.x][y + z.y]) && (dist[x + z.x][y + z.y].y > dist[x][y].y + 1))) {
                        vis[x + z.x][y + z.y] = true;
                        if (map[x + xi][y + yi] != 0) {
                            if (dist[x + xi][y + yi].x > dist[x][y].x + map[x + xi][y + yi]) {
                                dist[x + xi][y + yi].y = dist[x][y].y + 1;
                            }
                            else {
                                dist[x + xi][y + yi].y = Math.min(dist[x + xi][y + yi].y, dist[x][y].y + 1);
                            }
                        }
                        else {
                            if (dist[x + xi][y + yi].x > dist[x][y].x + map[x + xi][y + yi]) {
                                dist[x + xi][y + yi].y = dist[x][y].y;
                            }
                            else {
                                dist[x + xi][y + yi].y = Math.min(dist[x + xi][y + yi].y, dist[x][y].y);
                            }
                        }
                        dist[x + z.x][y + z.y].x = dist[x][y].x + map[x + z.x][y + z.y];
                        q.add( new PairQ(x + xi, y + yi));
                    }


                }
//                if (valid(x + z.x, y + z.y)) {
//                    if (vis[x + z.x][y + z.y] == false || dist[x + z.x][y + z.y].x > dist[x][y].x + map[x + z.x][y + z.y] || ((dist[x + z.x][y + z.y].x == dist[x][y].x + map[x + z.x][y + z.y]) && (dist[x + z.x][y + z.y].y > dist[x][y].y + 1))) {
//                        vis[x + z.x][y + z.y] = true;
//                        if (dist[x + z.x][y + z.y].x == dist[x][y].x + map[x + z.x][y + z.y]) {
//                            dist[x + z.x][y + z.y].y = Math.min(dist[x + z.x][y + z.y].y, dist[x][y].y + 1);
//                        } else {
//                            dist[x + z.x][y + z.y].x = dist[x][y].x + map[x + z.x][y + z.y];
//                            if (map[x + z.x][y + z.y] != 0) {
//                                dist[x + z.x][y + z.y].y = dist[x][y].y + 1;
//                            } else {
//                                dist[x + z.x][y + z.y].y = dist[x][y].y;
//                            }
//                        }
//                    }
//                    q.add(new PairQ(x + z.x, y + z.y));
//                }
            }

        }
        System.out.println(dist[dest.x][dest.y].y - 1);

    }
    static int sqr (int a, int b) {
        return a * a + b* b;
    }
    static boolean valid(int x, int y) {
        return (x > -1 && y > -1 && x < R && y < C);
    }

    static int toInt(String s) {
        return Integer.parseInt(s);
    }
    static String[] split(String s) { return s.split(" "); }
}
