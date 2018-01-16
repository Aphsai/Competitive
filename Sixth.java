import java.io.*;
import java.util.*;

public class Sixth {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        HashMap<Integer, Set<Integer>> map = new HashMap<Integer, Set<Integer>>();
        String token = br.readLine();
        int N = Integer.parseInt(token.split(" ")[0]);
        int M = Integer.parseInt(token.split(" ")[1]);
        int[] pho = new int[M];
        String[] rest = br.readLine().split(" ");
        for (int x = 0; x < M; x++) {
            pho[x] = Integer.parseInt(rest[x]);
        }
        for (int x = 1; x < N; x++) {
            token = br.readLine();
            int a = Integer.parseInt(token.split(" ")[0]);
            int b = Integer.parseInt(token.split(" ")[1]);
            if (!map.containsKey(a)) {
                map.put(a, new HashSet<Integer>());
            }
            if (!map.containsKey(b)) {
                map.put(b, new HashSet<Integer>());
            }
            map.get(a).add(b);
            map.get(b).add(a);
        }

        ArrayDeque<Integer> q = new ArrayDeque<Integer>();
        q.offer(pho[0]);

        int[] cache = new int[N];
        int curr = 0, max = Integer.MIN_VALUE, furthest = 0;
        while (!q.isEmpty()) {
            curr = q.poll();
            if (cache[curr] > max) {
                max = cache[curr];
                furthest = curr;
            }
            for (int i : map.get(curr)) {
                if (i != pho[0] && (cache[i] == 0 || cache[i] > cache[curr] + 1)) {
                    cache[i] = cache[curr] + 1;
                    q.offer(i);
                }
            }
        }
        furthest= 0;
        for (int x =0 ; x < M; x++) {
            if (furthest < cache[pho[x]])
                furthest = pho[x];
        }
        boolean[] arr = new boolean[N];
        arr[furthest] = true;
        int total = 0;
        fullloop: while(true) {
            boolean checkedall = false;
            q = new ArrayDeque<Integer>();
            cache = new int[N];
            int y = 0;
            curr = 0;
            max = furthest;
            q.offer(furthest);
            outerloop: while (!q.isEmpty()) {
                curr = q.poll();
                System.out.println("CURRENT: " + curr);
                for (int i : map.get(curr)) {
                    if (i != curr && (cache[i] == 0 || cache[i] < cache[curr] + 1)) {
                        System.out.println(i);
                        cache[i] = cache[curr] + 1;
                        q.offer(i);
                        for (int x =0 ; x<M;x ++) {
                            if (i == pho[x] && arr[i] == false) {
                                System.out.println("REACHED: " + i);
                                System.out.println("DIST: " + cache[i]);
                                arr[i] = true;
                                max = i;
                                total += cache[i];
                                furthest = i;
                                break outerloop;

                            }
                        }
                    }

                }

            }
            for (int x =0 ;x  < M; x++) {
                if (arr[pho[x]] == true) {
                    checkedall = true;
                }
                else
                    checkedall = false;
            }
            if (checkedall == true) {
                System.out.println(total);
                break fullloop;
            }



        }

        //System.out.println(cache[x]); ;
    }
}
        //  System.out.println(furthest);




