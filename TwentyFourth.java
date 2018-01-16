/**
 * Created by Saksham on 2016-02-28.
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
public class TwentyFourth {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] token = br.readLine().split(" ");
        int N = Integer.parseInt(token[0]);
        int M = Integer.parseInt(token[1]);
//        HashMap<Integer, Set<Integer>> map = new HashMap<>();
        ArrayList<Integer>[] map = new ArrayList[N+1];
        for (int x =0 ; x < M; x++) {
            token = br.readLine().split(" ");
            int a = Integer.parseInt(token[0]);
            if (map[a] == null) {
                map[a] = new ArrayList<>();
            }
            map[a].add(Integer.parseInt(token[1]));
        }
        token = br.readLine().split(" ");
        int X = Integer.parseInt(token[0])  ;
        int Y = Integer.parseInt(token[1]);
        boolean [] visited = new boolean[N+1];
        Stack <Integer> q = new Stack<Integer>();
        boolean taller = false;
        q.push(X);
        while(!q.isEmpty()) {
            int source = q.pop();
            if (map[source] != null) {
                for (int i : map[source]) {
                    if (i == Y) {
                        System.out.println("yes");
                        return;

                    } else if (visited[i] == false) {
                        q.push(i);
                        visited[i] = true;
                    }
                }
            }
        }
        q = new Stack<>();
        q.push(Y);

        while(!q.isEmpty()) {
            int source = q.pop();
            if (map[source] != null) {
                for (int i : map[source]) {
                    if (i == X) {
                        System.out.println("no");
                        return;

                    } else if (visited[i] == false) {
                        q.push(i);
                        visited[i] = true;
                    }
                }
            }
        }
        System.out.println("unknown");

    }
}