/**
 * Created by Saksham on 2016-03-22.
 */

import java.util.*;
import java.io.*;
class PairG {
    int x;
    int d;
    public PairG(int X, int D) {
        x = X;
        d = D;
    }

//    public int compareTo(PairG o) {
//        return d-o.d;
//    }
}
public class HelloOfficer {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = s.nextInt();
        int M = s.nextInt();
        int B = s.nextInt();
        int Q = s.nextInt();
        ArrayList<PairG>[] map = new ArrayList[N + 1];
        int[] cache = new int[N + 1];
        for (int x = 0; x < M; x++) {
            int a = s.nextInt();
            int b = s.nextInt();
            int d = s.nextInt();
            if (map[a] == null) {
                map[a] = new ArrayList<>();
            }
            if (map[b] == null) {
                map[b] = new ArrayList<>();
            }
            map[a].add(new PairG(b, d));
            map[b].add(new PairG(a, d));
        }
        int[] queries = new int[Q];
        for (int x = 0; x < Q; x++) {
            queries[x] = s.nextInt();
        }
        for (int x = 0; x < N+1; x++) {
            cache[x] = -1;
        }
        cache[B] = 0;
        Queue<PairG> queue = new ArrayDeque<>();
        queue.add(new PairG(B, 0));
        while (!queue.isEmpty()) {
            PairG cur = queue.poll();
            if (map[cur.x] != null) {
                for (PairG x : map[cur.x]) {
                    if (x != cur && (cache[cur.x] + x.d < cache[x.x] || cache[x.x] == -1)){
                        cache[x.x] = cache[cur.x] + x.d;
                        queue.add(x);
                    }
                }
            }
        }
            for (int x = 0; x < Q; x++) {
                System.out.println(cache[queries[x]]);
            }
        }
    }
