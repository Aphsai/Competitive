/**
 * Created by Saksham on 2016-03-31.
 */

import java.util.*;
import java.io.*;

public class ColdWarTelecom {
    static BufferedReader br;
    static boolean[] visited;
    static int[] depth;
    static int[] low;
    static int[] parent;
    static ArrayList<Integer> set;
    static ArrayList<Integer>[] map;
    static int child;
    public static void main(String[] args) throws IOException {
        Scanner s = new Scanner(System.in);
        br = new BufferedReader(new InputStreamReader(System.in));
        String[] token = read();
        set = new ArrayList<>();
        int N = toInt(token[0]);
        int M = toInt(token[1]);
        visited = new boolean[N+1];
        depth = new int[N+1];
        low = new int[N+1];
        parent = new int[N+1];

        map = new ArrayList[N+1];
        for (int x = 0;  x< M;x++) {
            token = read();
            int a = toInt(token[0]);
            int b = toInt(token[1]);
            if (map[a] == null) {
                map[a] = new ArrayList<>();
            }
            if (map[b] == null) {
                map[b] = new ArrayList<>();
            }
            map[a].add(b);
            map[b].add(a);
        }
        getArtPoints(1,1);
        System.out.println(set.size());
        Collections.sort(set);
        for (int i: set) {
            System.out.println(i);
        }

    }
    static int getArtPoints(int i, int d) {

        visited[i] = true;
        depth[i] = d;
        low[i] = d;
        child = 0;
      //  System.out.println(i + " " + depth[i] + " " + low[i] + " " + parent[i]);
        boolean isArt = false;
        for (int x: map[i]) {
            if (x == parent[i]) continue;
            if (!visited[x]) {
                parent[x] = i;
                    child++;
                getArtPoints(x, d + 1);
                if (low[x] >= depth[i]) {
                    isArt = true;
                }
                low[i] = Math.min(low[x], low[i]);

            }
            else {
                low[i] = Math.min(low[i],depth[x]);
            }
        }
     //   System.out.println(i + " " + depth[i] + " " + visited[i] + " " + low[i] + " " + parent[i]);
        if (!set.contains(i) && ((parent[i] != 0 && isArt) || (parent[i] == 0 && child > 1))) {
            set.add(i);
        }
        return set.size();
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
