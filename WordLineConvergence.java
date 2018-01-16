/**
 * Created by Saksham on 2016-03-28.
 */

import java.util.*;
import java.io.*;

public class WordLineConvergence {
    static BufferedReader br;

    public static void main(String[] args) throws IOException {
        Scanner s = new Scanner(System.in);
        br = new BufferedReader(new InputStreamReader(System.in));
        String[] token = null;
        int N = toInt(br.readLine());
        long[] rip = new long[N+1];
        ArrayList<Integer>[] arr = new ArrayList[N+1];
        token = br.readLine().split(" ");
        for (int x = 1; x < N+1; x++) {
            arr[x] = new ArrayList<>(1);
                arr[x].add(toInt(token[x-1]));
        }
        Queue<Integer> q = new ArrayDeque<>();
        token = split(br.readLine());
        for (int x = 0; x < N; x++) {
            rip[x+1] = 1;
            q.add(toInt(token[x]));
        }
        long[] dist = new long[N+1];
        while(!q.isEmpty()) {
            int cur = q.poll();
            dist[cur] = rip[cur];
            for (int x = 0; x < N; x++) {
//                System.out.print("(" + (dist[x+1]) + " " + (rip[x+1]) + ")");
            }
            long incr = rip[cur];
//            System.out.println();
            while(true) {
//                System.out.println(cur + " " + arr[cur].get(0));
                rip[arr[cur].get(0)]+= incr;
                cur = arr[cur].get(0);
                if (cur == 0) {
                    break;
                }
            }

        }
        for (int x = 0; x < N; x++) {
            System.out.print((dist[x + 1]%1000000007) + " ");
        }

    }

    static int toInt(String s) {
        return Integer.parseInt(s);
    }

    static String[] split(String s) {
        return s.split(" ");
    }
}
