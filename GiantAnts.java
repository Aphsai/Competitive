/**
 * Created by Saksham on 2016-05-25.
 */

import java.util.*;
import java.io.*;

public class GiantAnts {
    static BufferedReader br;

    public static void main(String[] args) throws IOException {
        Scanner s = new Scanner(System.in);
        br = new BufferedReader(new InputStreamReader(System.in));
        String[] token = read();
        int N = toInt(token[0]);
        int M = toInt(token[1]);
        ArrayList<Integer>[] map = new ArrayList[N+1];
        for (int x =0; x < M; x++) {
            token = read();
            int a = Integer.parseInt(token[0]), b = Integer.parseInt(token[1]);
            if (map[a] == null) map[a] = new ArrayList<>();
            if (map[b] == null) map[b] = new ArrayList<>();
            map[a].add(b);
            map[b].add(a);
        }
        int W = Integer.parseInt(br.readLine());
        Queue<Integer> q = new ArrayDeque<>();
        boolean[] vis = new boolean[N+1];
        int[] antDistance = new int[N+1];
        int[] travelDistance = new int[N+1];
        for (int x = 0; x < W; x++) {
            int a = Integer.parseInt(br.readLine());
            vis[a] = true;
            q.add(a);
        }
        while(!q.isEmpty()) {
            int cur = q.poll();
            if (map[cur] != null)
            for (int x : map[cur]) {
                if (!vis[x]) {
                    vis[x] = true;
                    antDistance[x] = antDistance[cur] + 4;
                    q.add(x);
                }
            }
        }
        vis = new boolean[N+1];
        q.clear();
        q.add(1);
        while(!q.isEmpty()) {
            int cur = q.poll();
            if (map[cur] != null)
            for (int x : map[cur]) {
                if (!vis[x] && antDistance[x] > travelDistance[cur] + 1) {
                    vis[x] = true;
                    travelDistance[x] = travelDistance[cur] + 1;
                    q.add(x);
                }
            }
        }
        if (travelDistance[N] == 0) System.out.println("sacrifice bobhob314");
        else System.out.println(travelDistance[N]);
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
