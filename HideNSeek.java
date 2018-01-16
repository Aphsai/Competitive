/**
 * Created by Saksham on 2016-03-20.
 */

import java.util.*;
import java.io.*;
class PairE {
    int X;
    int Y;
    public PairE(int x, int y) {
        X = x;
        Y = y;
    }
}
public class HideNSeek {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = s.nextInt();
        int M = s.nextInt();
        int T = s.nextInt();
        PairE src = null;
        char[][] map = new char[N][M];
        for (int x = 0; x < N; x++) {
            map[x] = s.next().toCharArray();
            for (int y =0; y < M; y++) {
                if (map[x][y] == 'G') {
                    src = new PairE(x,y);
                }
            }
        }
        int total = 0;
        for (int x = 0; x < T; x++) {
            Queue<PairE> q = new ArrayDeque<>();
            q.add(src);
            int[][] dist = new int[N][M];
            dist[src.X][src.Y] = 1;
            while(!q.isEmpty()) {

                PairE cur = q.poll();  // System.out.println(cur.X + " " +  cur.Y);
                int X = cur.X;
                int Y = cur.Y;
                if (map[X][Y] == 'H') {
                    total += dist[X][Y];
                    map[X][Y] = 'T';
                    map[src.X][src.Y] = '.';
                    src = new PairE(X,Y);
                    break;
                }
                if (X!= 0 && dist[X-1][Y] == 0 && map[X-1][Y] != 'X') {
                    dist[X-1][Y] = dist[X][Y] + 1;
                    q.add(new PairE(X-1,Y));
                }
                if (X!= N-1 && dist[X+1][Y] == 0 && map[X+1][Y] != 'X') {
                    dist[X+1][Y] = dist[X][Y] + 1;
                    q.add(new PairE(X+1,Y));
                }
                if (Y!= M-1 && dist[X][Y+1] == 0 && map[X][Y+1] != 'X') {
                    dist[X][Y+1] = dist[X][Y] + 1;
                    q.add(new PairE(X,Y+1));
                }
                if (Y!= 0 && dist[X][Y-1] == 0 && map[X][Y-1] != 'X') {
                    dist[X][Y-1] = dist[X][Y] + 1;
                    q.add(new PairE(X,Y-1));
                }

            }
        }
        System.out.println(total - T);
    }

}
