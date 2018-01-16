/**
 * Created by Saksham on 2016-03-21.
 */

import java.util.*;
import java.io.*;

public class PhonomenalReviews {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        //BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = s.nextInt();
        int P = s.nextInt();
        ArrayList<Integer> pho = new ArrayList<>(P);
        boolean[] leaves = new boolean[N];
        for (int x = 0; x < P; x++) {
            pho.add(s.nextInt());
            leaves[pho.get(x)] = true;
        }
        ArrayList<Integer>[] map = new ArrayList[N+1];
        int phoLeaf = 0;
        for (int x = 1; x < N; x++) {
            int a = s.nextInt();
            int b = s.nextInt();
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
        for (int x = 0; x < N; x++) {
            if (map[x].size() == 1) {
//                System.out.println(x);
                if (!pho.contains(x)) {
                    q.add(x);
                }
            }
        }
        int rem = 0;
        boolean[] vis = new boolean[N+1];
//        System.out.println("--------------");
        while(!q.isEmpty()) {
            int cur = q.poll();
//            System.out.println(map[cur] + "CUR: " + cur);
            for (int i: map[cur]) {
                if (!pho.contains(cur)) {
//                    System.out.println(cur + " " + map[cur].size());
                    if (map[cur].size() == 1) {
                        q.add(i);if (!vis[cur])
                            rem++;
                        vis[cur] = true;
//                        System.out.println(cur);
                        map[i].remove((Integer) cur);

                    }
                }
                else
                    phoLeaf = cur;
            }
        }
        q = new ArrayDeque<>();
        q.add(phoLeaf);
        int[] cache = new int[N];
        int max = 0;
        while(!q.isEmpty()) {
            int cur = q.poll();
            if (cache[cur] > max) {
                max = cache[cur];
                phoLeaf = cur;
            }
            for (int i: map[cur]) {
                if (i != cur && (cache[i] == 0 || cache[i] > cache[cur] + 1)) {
                    cache[i] = cache[cur]+1;
                    q.add(i);
                }
            }
        }
        q = new ArrayDeque<>();
        q.add(phoLeaf);
        int[] cache2 = new int[N];
         max = 0;
        while(!q.isEmpty()) {
            int cur = q.poll();
            if (cache2[cur] > max) {
                max = cache2[cur];
            }
            for (int i: map[cur]) {
                if (i != cur && (cache2[i] == 0 || cache2[i] > cache2[cur] + 1)) {
                    cache2[i] = cache2[cur]+1;
                    q.add(i);
                }
            }
        }
//        System.out.println(max);
//        System.out.println(rem);
        int MAX = ((2*((N-rem) - (max+1))) + max);
        System.out.println(MAX==0?1:MAX);

    }
}
