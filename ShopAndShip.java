/**
 * Created by Saksham on 2016-03-16.
 */
import java.io.*;
import java.util.*;

public class ShopAndShip {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = toInt(br.readLine());
        int T = toInt(br.readLine());
        int[][] map = new int[N+1][N+1];
        for (int x = 0; x < T; x++) {
            String[] token = br.readLine().split(" ");
            int a = toInt(token[0]);
            int b = toInt(token[1]);
            int c = toInt(token[2]);
            if (map[a][b] == 0 || (map[a][b] > c)) {
                map[a][b] = c;
                map[b][a] = c;
            }
        }
        int P = toInt(br.readLine());
        int [] pen = new int[N+1];
        for (int x =0; x < P; x++) {
            String[] token = br.readLine().split(" ");
            pen[toInt(token[0])] = toInt(token[1]);
        }
        int min = Integer.MAX_VALUE;
        int D = toInt(br.readLine());
        if (pen[D] != 0) {
            min = pen[D];
        }
        Queue<Integer> q = new ArrayDeque<>();
        int[] cache = new int[N+1];
        q.add(D);
        while(!q.isEmpty()) {
            int cur = q.poll();
            for (int x = 1; x < N+1; x++) {
                if (map[cur][x] != 0 && (cache[x] == 0 || cache[x] > cache[cur] + map[cur][x])) {
                    cache[x] = cache[cur] + map[cur][x];
                    if (pen[x] != 0) {
                        min = Math.min(min, cache[x] + pen[x]);
                    }
                    if (cache[x] < min)
                     q.add(x);

                }
            }
        }

        System.out.println(min);

    }
    public static int toInt(String s) {
        return Integer.parseInt(s);
    }
}
