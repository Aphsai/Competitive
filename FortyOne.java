/**
 * Created by Saksham on 2016-03-09.
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
class Pair3 {
    int x;
    int y;
    public Pair3 (int x, int y) {
        this.x = x;
        this.y = y;
    }
}
public class FortyOne {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] token = br.readLine().split(" ");
        int N = Integer.parseInt(token[0]);
        int H = Integer.parseInt(token[1]);
        int [][] map = new int[N][N];
        boolean [][] vis = new boolean[N][N];
        for (int x =0; x < N; x++) {
            token = br.readLine().split(" ");
            for (int y = 0; y < N; y++) {
                map[x][y] = Integer.parseInt(token[y]);
//                System.out.print(map[x][y]);
            }
//            System.out.println();
        }
        Queue<Pair3> q = new ArrayDeque<Pair3>();
        vis[0][0] = true;
        q.add(new Pair3(0, 0));
        while (!q.isEmpty()) {
            Pair3 src = q.poll();
            vis[src.x][src.y] = true;
//            System.out.println(src.x + " " + src.y + " " + map[src.x][src.y]);
            if (src.x == N-1 && src.y == N-1) {
                System.out.println("yes");
                return;
            }

            int x = src.x;
            int y = src.y;
                if (x+1 < N && vis[x + 1][y] == false && Math.abs(map[x+1][y] - map[x][y]) <=H){
//                    System.out.println(src.x + " " + src.y + " " + map[src.x + 1][src.y]);
                    q.add(new Pair3(x + 1, y));
                    vis[x+1][y] = true;
                }
                if (y+1 < N && vis[x][y + 1] == false && Math.abs(map[x][y + 1] - map[x][y]) <=H ) {
//                    System.out.println(src.x + " " + src.y + " " + map[src.x][src.y+1]);
                    q.add(new Pair3(x, y + 1));
                    vis[src.x][src.y + 1] = true;
                }
//                if (x-1 > -1 && vis[x - 1][y] == false && Math.abs(map[x-1][y] - map[x][y]) <=H) {
////                    System.out.println(src.x + " " + src.y + " " + map[src.x-1][src.y]);
//                    q.add(new Pair3(x - 1, y));
//                }
//                if (y - 1 > -1 && vis[x][y - 1] == false && Math.abs(map[x][y-1] - map[x][y]) <=H) {
////                    System.out.println(src.x + " " + src.y + " " + map[src.x][src.y-1]);
//                    q.add(new Pair3(x, y - 1));
//                }
        }
        System.out.println("no");
    }
}
