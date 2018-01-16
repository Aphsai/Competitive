/**
 * Created by Saksham on 2016-03-31.
 */

import java.util.*;
import java.io.*;
class PairL {
    int x;
    int v;
    public PairL(int X, int V) {
        x = X;
        v = V;
    }
}
public class TruckingTroubles {
    static BufferedReader br;

    public static void main(String[] args) throws IOException {
        Scanner s = new Scanner(System.in);
        br = new BufferedReader(new InputStreamReader(System.in));
        String[] token = read();
        int C = toInt(token[0]);
        int R = toInt(token[1]);
        int D = toInt(token[2]);
        ArrayList<PairL>[] map = new ArrayList[C+1];
        for (int x = 0; x < R; x++) {
            token = read();
            int a = toInt(token[0]);
            int b = toInt(token[1]);
            int c = toInt(token[2]);
            if (map[a] == null) map[a] = new ArrayList<>();
            if (map[b] == null) map[b] = new ArrayList<>();
            map[a].add(new PairL(b,c));
            map[b].add(new PairL(a,c));
        }
        HashSet<Integer> set = new HashSet<>();
        for (int x  =0; x < D; x++) {
            set.add(rInt());
        }
        int[] cache = new int[C+1];
        Queue<PairL> q = new ArrayDeque<>();
        q.add(new PairL(1,Integer.MAX_VALUE));
        while(!q.isEmpty()) {
            PairL cur = q.poll();
            int x = cur.x;
            int v= cur.v;
            if (map[x] != null) {
                for (PairL i : map[x]) {
                    if (cache[i.x] < Math.min(i.v, v)) {
                        cache[i.x] = Math.min(i.v, v);
                        q.add(i);
                    }
                }
            }
        }
        int min = Integer.MAX_VALUE;
        for (int x : set) {
            min = Math.min(min, cache[x]);
        }
        System.out.println(min);

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
}
