/**
 * Created by Saksham on 2016-04-12.
 */

import java.util.*;
import java.io.*;

public class AriadnesThread {
    static BufferedReader br;

    public static void main(String[] args) throws IOException {
        Scanner s = new Scanner(System.in);
        br = new BufferedReader(new InputStreamReader(System.in));
        String[] token = null;
        int N = rInt();
        int[] root = new int[N+1];
        ArrayList<Integer>[] map = new ArrayList[N+1];
        for (int x = 1; x < N+1; x++)
            map[x] = new ArrayList<>();
        for (int x = 1; x < N+1; x++) {
            int[] t = rIntAr();
            for (int y = t[0]; y > 0; y--) {
                map[x].add(t[y]);
                root[t[y]] = x;
            }
        }
        int Q = rInt();
        for (int x = 0; x < Q; x++) {
            int[] t = rIntAr();
            boolean[] vis = new boolean[N+1];
            int dest = t[1];
            int total = -1;
         //   System.out.println("DEST: " + dest);
            Stack<Integer> stack = new Stack<>();
            stack.push(t[0]);
            while (!stack.isEmpty()) {
                int cur = stack.pop();
                total++;
                vis[cur] = true;
              //  System.out.println(t[0] + " " + cur);
                boolean visited = true;
                if (cur == dest) {
                    System.out.println(total);
                    break;
                }
                if (map[cur] != null) {
                    for (int i : map[cur]) {
                        if (vis[i] == false) {
                            visited = false;
                            stack.push(i);
                        }
                    }
                }
                if (visited) {
                  //  if (vis[root[cur]])
                        //total++;
                    stack.add(root[cur]);
                }
            }
        }

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
