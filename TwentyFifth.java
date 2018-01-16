/**
 * Created by Saksham on 2016-02-28.
 *//*

import java.util.*;

*/
/*class Pair {
    int first;
    int second;

    public Pair(int first, int second) {
        this.first = first;
        this.second = second;
    }
} *//*

public class TwentyFifth {

    public static void main(String[] args) {
        Scanner s= new Scanner(System.in);
        int N = s.nextInt();
        Pair[] loc = new Pair[N];
        for (int x = 0; x < N;x++) {
            loc[x] = new Pair(s.nextInt(), s.nextInt());
        }
        Pair source = new Pair(0,0);
        Queue<Pair> q = new ArrayDeque<>();
        int hold = 0;
        int dist = 0;
        int counter = 0;
        boolean[] visited = new boolean[N];
        for (int x = 0; x < N; x++) {
            int len = (loc[x].first - source.first)*(loc[x].first - source.first) + (loc[x].second - source.second) *(loc[x].second - source.second);
            if (len > dist) {
                dist = len;
                hold = x;
            }
        }
        q.offer(loc[hold]);
        visited[hold] = true;
        hold = dist;
        int rem = 0;
        boolean found = false;
        while(!q.isEmpty()) {
            found = false;
            Pair cur = q.poll();
            Pair max = new Pair(0,0);
            dist = 0;
            counter++;
            for (int x = 0; x < N; x++) {
                int len = (loc[x].first - cur.first) * (loc[x].first - cur.first) + (loc[x].second - cur.second) * (loc[x].second - cur.second);
                if (len > dist && len < hold && visited[x] == false) {
                    found = true;
                    dist = len;
                    max = loc[x];
                    rem = x;
                }
            }
            hold = dist;
            if (found) {
                q.add(max);
            }
            visited[rem] = true;

        }
        System.out.println(counter+1);

    }
}
*/
