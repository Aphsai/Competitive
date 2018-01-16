/**
 * Created by Saksham on 2016-03-17.
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
public class BreakingTheFriendChain {
    public static void main(String[] args) throws IOException {
        //Scanner s = new Scanner(System.in);
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] t = br.readLine().split(" ");
        int N = Integer.parseInt(t[0]);
        int M = Integer.parseInt(t[1]);
        HashSet<Integer>[] arr = new HashSet[N+1];
        for (int x =0; x < M; x++) {
            int a = 0;
            int b = 0;
            t = br.readLine().split(" ");
            a = Integer.parseInt(t[0]);
            b = Integer.parseInt(t[1]);
            if (arr[a] == null) arr[a] = new HashSet<>();
            if (arr[b] == null) arr[b] = new HashSet<>();
            arr[a].add(b);
            arr[b].add(a);
        }
        t = br.readLine().split(" ");
        int src = Integer.parseInt(t[0]);
        int dest = Integer.parseInt(t[1]);
        Stack<Integer> stack = new Stack<>();
        boolean[] vis = new boolean[N+1];
        stack.add(src);
        while(!stack.isEmpty()) {
            int cur = stack.pop();
            vis[cur] = true;
            if (cur == dest) {
                System.out.println(1);
                return;
            }
            if (arr[cur] != null)
            for (int x: arr[cur]) {
                if (!vis[x]) {
                    stack.add(x);
                    vis[x] = true;
                }
            }
        }
        System.out.println(0);

    }
}
