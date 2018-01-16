/**
 * Created by Saksham on 2016-03-10.
 */
import java.util.*;
class Pair4 {
    int first;
    int weight;
    public Pair4(int first, int second) {
        this.first = first;
        this.weight = second;
    }
}
public class FortyThree {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int L = s.nextInt();
        int N = s.nextInt();
        int M = s.nextInt();
        int G = s.nextInt();
        ArrayList<Pair4>[] map = new ArrayList[N + 1];
        int[] gs = new int[G];
        for (int x = 0; x < G; x++) {
            gs[x] = s.nextInt();
        }
        for (int x = 0; x < M; x++) {
            int a = s.nextInt();
            int b = s.nextInt();
            int c = s.nextInt();
            if (c <= L) {
                if (map[a] == null) {
                    map[a] = new ArrayList<>();
                }
                map[a].add(new Pair4(b, c));
            }
        }
        boolean[] vis = new boolean[N + 1];
        vis[0] = true;
        Pair4 src = new Pair4(0, 0);
        int total = 0;
        int hit = 0;
        int index = 0;
        Queue<Pair4> q = new ArrayDeque<>();
        int[] dist = new int[N + 1];
        q.add(src);
        while(!q.isEmpty()) {
            Pair4 cur = q.poll();
            vis[cur.first] = true;
            if(map[cur.first] != null)
            for (int x = 0; x < map[cur.first].size(); x++) {
                if ((dist[map[cur.first].get(x).first] == 0 || dist[map[cur.first].get(x).first] > dist[cur.first] + map[cur.first].get(x).weight)) {
                    dist[map[cur.first].get(x).first] = dist[cur.first] + map[cur.first].get(x).weight;
                        q.add(map[cur.first].get(x));
                }
            }
        }
        int pls = 0;
        int[] max = new int[N+1];
        for (int x= 0; x < G; x++) {
//            for (int y = 1; y < N + 1; y++) {
                if (dist[gs[x]] <= L && dist[gs[x]] != 0) {
//                    System.out.println(dist[gs[x]]);
                    pls++;
                }
//                if (hits[y].contains(gs[x]) || y == gs[x]) {
//                    max[y]++;
//                    if (max[y] > pls)
//                        pls = max[y];
//                }

//            }
        }
            System.out.println(pls);
//        while (true) {
//            int min = Integer.MAX_VALUE;
//            Queue<Pair4> q = new ArrayDeque<>();
//            int[] dist = new int[N + 1];
//            q.add(src);
//            if (map[src.first] == null) {
//                break;
//            }
////            System.out.println("-----------");
//            while (!q.isEmpty()) {
//                Pair4 cur = q.poll();
//                vis[cur.first] = true;
////                System.out.println(cur.first + " " + cur.weight);
//                if (map[cur.first] != null)
//                    for (int x = 0; x < map[cur.first].size(); x++) {
////                    System.out.println(map[cur.first].get(x).first + " " + dist[map[cur.first].get(x).first] + " " + map[cur.first].get(x).weight + " " +  vis[map[cur.first].get(x).first] + "WEIGHT :" + (dist[cur.first] + map[cur.first].get(x).weight));
//                        if (vis[map[cur.first].get(x).first] == false && (dist[map[cur.first].get(x).first] == 0 || dist[map[cur.first].get(x).first] > dist[cur.first] + map[cur.first].get(x).weight)) {
////                        System.out.println("ENTERED");
//                            q.add(map[cur.first].get(x));
//                            dist[map[cur.first].get(x).first] = dist[cur.first] + map[cur.first].get(x).weight;
////                        System.out.println("NEW DIST " + dist[map[cur.first].get(x).first]);
//                        }
//                    }
//            }
////            }System.out.println("-----------------");
//                for (int x = 0; x < G; x++) {
//                    if (gs[x] != -1) {
//                        if (dist[gs[x]] < min && dist[gs[x]] != 0) {
////                        System.out.println(dist[gs[x]]);
//                            min = dist[gs[x]];
//                            src = new Pair4(gs[x], 0);
//                            index = x;
//                        }
//                    }
//                }
//                gs[index] = -1;
//                if (total + min > L) {
//                    break;
//                }
//                hit++;
//                total += min;
//            }
//            System.out.println(hit);
//        Stack<Pair4> stack = new Stack<>();
//        stack.push(new Pair4(0,0));
//        while (!stack.isEmpty()) {
//            Pair4 src = stack.pop();
//            if (map[src.first] != null) {
//                for (int x = 0; x < map[src.first].size(); x++) {
//                    if ((map[map[src.first].get(x).first] == null || map[map[src.first].get(x).first].size() == 0) && gs[map[src.first].get(x).first] == false)
//                        map[src.first].remove(x);
//                    else
//                    stack.push(map[src.first].get(x));
//                }
//            }
//        }


        }
    }
