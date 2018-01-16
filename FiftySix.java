/**
 * Created by Saksham on 2016-03-15.
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
class Pair8 {
    int X;
    int Y;
    public Pair8(int first, int second) {
        this.X = first;
        this.Y = second;
    }
}
public class FiftySix {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[]token = br.readLine().split(" ");
        int C = Integer.parseInt(token[0]);
        int R = Integer.parseInt(token[1]);
        int[][] map = new int[R][C];
        int [][] cache = new int[R][C];
        for (int x = 0; x < R; x++) {
            token = br.readLine().split(" ");
            for (int y =0 ; y < C; y++) {
                map[x][y] = Integer.parseInt(token[y]);
            }
        }
        token = br.readLine().split(" ");
        int length = Integer.parseInt(token[0]);
        int depth = Integer.parseInt(token[1]);
        Pair8 dest = new Pair8(depth, length);
        Queue<Pair8> q = new ArrayDeque<>();
        q.add(new Pair8(0,0));
        cache[0][0] = map[0][0];
        while(!q.isEmpty()) {
            Pair8 cur = q.poll();
//                System.out.println(cache[cur.X][cur.Y] + " " + cur.X + " " + cur.Y);
                if (cur.X != R - 1 && (cache[cur.X + 1][cur.Y] == 0 || cache[cur.X][cur.Y] + map[cur.X + 1][cur.Y] < cache[cur.X + 1][cur.Y])) {
                    cache[cur.X + 1][cur.Y] = cache[cur.X][cur.Y] + map[cur.X + 1][cur.Y];
                    q.add(new Pair8(cur.X + 1, cur.Y));
                }
                if (cur.Y != 0  && (cache[cur.X][cur.Y-1] == 0 || cache[cur.X][cur.Y] + map[cur.X][cur.Y-1] < cache[cur.X][cur.Y-1])) {
//                    System.out.println("ENTERED");
                    cache[cur.X][cur.Y-1] = cache[cur.X][cur.Y] + map[cur.X][cur.Y-1];
                    q.add(new Pair8(cur.X, cur.Y-1));
                }
                if (cur.Y != C - 1 && (cache[cur.X][cur.Y + 1] == 0 || cache[cur.X][cur.Y] + map[cur.X][cur.Y + 1] < cache[cur.X][cur.Y + 1])) {
                    cache[cur.X][cur.Y + 1] = cache[cur.X][cur.Y] + map[cur.X][cur.Y + 1];
                    q.add(new Pair8(cur.X, cur.Y + 1));
                }
        }   System.out.println(cache[dest.X][dest.Y]);

    }
}
