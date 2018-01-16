/**
 * Created by Saksham on 2016-03-16.
 */
import java.util.*;
public class DungeonCrawling {
    static int[] cache;
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int N = s.nextInt();
        int M = s.nextInt();
        boolean [] E = new boolean[N];
        ArrayList<Integer>[] map = new ArrayList[N];
        for (int x = 0; x < M; x++) {
            int a = s.nextInt();
            int b = s.nextInt();
            E[b] = true;
            if (map[a] == null)
                map[a] = new ArrayList<>();
            map[a].add(b);
        }
        Stack<Integer> stack = new Stack<>();
        for (int x =0; x < N; x++) {
            if (E[x] == false) {
                stack.push(x);
            }
        }
        System.out.println();
        long numPaths =0 ;
        cache = new int[N];
        while(!stack.isEmpty()) {
            Queue<Integer> q =new ArrayDeque<>();
            q.add(stack.pop());
            while(!q.isEmpty()) {
                int cur = q.poll();
                if (map[cur] != null) {
                    for (int x : map[cur]) {
                        if (cache[x] == 0 || cache[x] > cache[cur] + 1) {

                            cache[x] = cache[cur] + 1;                           // System.out.println(cur + " " + x + " " + cache[x]);
                        }
                        q.add(x);
                    }
                }
                else
                    numPaths++;
            }
        }
        System.out.println(numPaths);
        for (int x =0; x < N; x++) {
            if (map[x] == null)
                System.out.print(cache[x]+1  + " ");
        }

    }
}
