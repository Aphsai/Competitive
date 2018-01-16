/**
 * Created by Saksham on 2016-03-14.
 */
import java.io.*;
import java.util.*;
public class Fiftieth {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        ArrayList<Integer>[] map = new ArrayList[N+1];
        for (int x = 1; x < N; x++) {
            String[] token = br.readLine().split(" ");
            int a = Integer.parseInt(token[0]);
            int b = Integer.parseInt(token[1]);
            if (map[a] == null) {
                map[a] = new ArrayList<>();
            }
            if (map[b] == null) {
                map[b] = new ArrayList<>();
            }
            map[a].add(b);
            map[b].add(a);
        }
        Queue<Integer> q = new ArrayDeque<>();
        q.add(1);
        int total = 0;
        long [] cache = new long[N+1];
        boolean [] vis = new boolean[N+1];
        int furthest = 0;
        long max = 0;
        while (!q.isEmpty()) {
            int cur = q.poll();
            if (cache[cur] > max) {
                max = cache[cur];
                furthest = cur;
            }
            for (int i: map[cur]) {
                if (i != 1 && (cache[i] > cache[cur] + 1 || cache[i] == 0)) {
                    cache[i] = cache[cur] + 1;
                    q.add(i);
                }
            }
        }

        for (int x =1 ; x < N+1; x++) {
//            System.out.print(cache[x] + " ");
            if (cache[furthest] == cache[x]) {
                total++;
            }
        }
//        System.out.println(furthest);
        q = new ArrayDeque<>();
        max = Integer.MIN_VALUE;
        q.add(furthest);
        int src = furthest;
        cache = new long[N+1];
        vis = new boolean[N+1];
        while (!q.isEmpty()) {
            int cur = q.poll();
            if (cache[cur] > max) {
                max = cache[cur];
                furthest = cur;
            }
//            System.out.println(cur);
            for (int i: map[cur]) {
                if (i != src && (cache[i] > cache[cur] + 1 || cache[i] == 0)) {
                    cache[i] = cache[cur] + 1;
                    q.add(i);
                }
            }
        }
//        System.out.println("FURTHEST: " + furthest);

        for (int x =1 ; x < N+1; x++) {
//            System.out.print(cache[x] + " ");
            if (cache[furthest] == cache[x]) {
                total++;
            }
        }
        System.out.println((cache[furthest] + 1) + " " + total);

    }
}
